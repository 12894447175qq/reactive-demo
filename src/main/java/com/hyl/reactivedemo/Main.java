package com.hyl.reactivedemo;

import com.hyl.reactivedemo.spi.SpiTestInterface;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;

/**
 * <p> </p>
 *
 * @author hyl.c
 * @date {2023/3/16}
 */
public class Main {
    public static void main(String[] args) {
        List<SpiTestInterface> interfaces = SpringFactoriesLoader.loadFactories(SpiTestInterface.class, Main.class.getClassLoader());
        System.out.println(interfaces);
    }
}
