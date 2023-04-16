package com.hyl.reactivedemo.lock;

/**
 * <p> </p>
 *
 * @author hyl.c
 * @date {2023/4/11}
 */
public class Demo {
    public static void main(String[] args) {
        Object lock = new Object();
        Thread a = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                synchronized (lock) {
                    try {
                        lock.notify();
                        System.out.println("A");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        a.start();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                synchronized (lock) {

                    try {
                        lock.notify();
                        System.out.println("B");
                        lock.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }


        }).start();
    }
}
