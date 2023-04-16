package com.hyl.reactivedemo.cas;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * <p> </p>
 *
 * @author hyl.c
 * @date {2023/4/11}
 */
public class Demo {
    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger(1);
        integer.compareAndSet(1,2);
        System.out.println(integer.get());

        AtomicStampedReference stampedReference = new AtomicStampedReference(1,1);
        stampedReference.compareAndSet(1,2,1,2);
        Object reference = stampedReference.getReference();
        System.out.println(reference);
    }
}
