package com.tian.concurrent.executors;

import java.util.concurrent.ThreadFactory;

/**
 * @author tianweichang
 * @date 2018-08-27 13:53
 **/
public class MyThreadFactory implements ThreadFactory {

    private String poolName;
    @Override
    public Thread newThread(Runnable r) {
        return null;
    }

    public MyThreadFactory(String poolName) {
        this.poolName = poolName;
    }

    public MyThreadFactory() {
    }
}
