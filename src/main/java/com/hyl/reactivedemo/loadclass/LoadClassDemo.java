package com.hyl.reactivedemo.loadclass;

import org.springframework.util.FileCopyUtils;
import org.springframework.util.FileSystemUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * <p> </p>
 *
 * @author hyl.c
 * @date {2023/3/29}
 */
public class LoadClassDemo extends ClassLoader {

    public static void main(String[] args) {
        LoadClassDemo demo = new LoadClassDemo();
        try {
            Class<?> aClass = demo.loadClass("com.hyl.reactivedemo.User");
            // 有参构造
            Constructor<?> constructor = aClass.getDeclaredConstructor(String.class, String.class);
            // 构造器实例化
            Object o = constructor.newInstance("1", "1");
            ClassLoader loader = o.getClass().getClassLoader();
            System.out.println(loader);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 打破双亲委派机制
     *
     * @param name
     * @return
     * @throws ClassNotFoundException
     */

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String root = "F:\\project\\java\\reactive-demo\\temp";
        String fileName = root +
                File.separatorChar + name.replace('.', File.separatorChar)
                + ".class";
        // 获取二进制流
        byte[] fileByte = null;
        try {
            fileByte = FileCopyUtils.copyToByteArray(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Class<?> aClass = defineClass(name, fileByte, 0, fileByte.length);
        return aClass;
    }
}
