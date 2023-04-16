package com.hyl.reactivedemo.redission;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p> </p>
 *
 * @author hyl.c
 * @date {2023/4/11}
 */
public class Demo {
    @Autowired
    Redisson redisson;
    private void test(){
        RLock lock = redisson.getLock("test lock");
        lock.lock();
        lock.unlock();
    }

}
