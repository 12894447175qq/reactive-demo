package com.hyl.reactivedemo.init;

/**
 * <p> </p>
 *
 * @author hyl.c
 * @date {2023/3/29}
 */
public class InitDemo {
    private static String name;
    private static String add = "上海市";
    private String id;
    private final static String gender = "N";


    static {
        System.out.println("static-------------------------1");
        System.out.println(name);
        System.out.println(add);
        System.out.println(gender);
        System.out.println("static-------------------------2");
        name = "洪玉龙";
        System.out.println(name);
        System.out.println(add);
        System.out.println(gender);
        System.out.println("static-------------------------3");
    }

    {
        System.out.println("code-------------------------1");
        System.out.println(name);
        System.out.println(add);
        System.out.println(gender);
        System.out.println(id);
        System.out.println("code-------------------------2");
        id = "001";
        System.out.println(name);
        System.out.println(add);
        System.out.println(gender);
        System.out.println(id);
        System.out.println("code-------------------------3");
    }

    public static void main(String[] args) {
        InitDemo initDemo = new InitDemo("002");
    }

    public InitDemo(String id) {
        System.out.println("init-------------------------1");
        System.out.println(name);
        System.out.println(add);
        System.out.println(gender);
        System.out.println(id);
        System.out.println("init-------------------------2");
        this.id = id;
        System.out.println(name);
        System.out.println(add);
        System.out.println(gender);
        System.out.println(id);
        System.out.println("init-------------------------3");
    }
}
