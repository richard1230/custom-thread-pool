package com.github.hcsp.multithread;

import java.util.concurrent.*;

public class MyThreadPools {
    // 创建一个线程池，满足以下要求：
    // 同时最多有10个任务在执行
    // 任务等待队列大小为20，如果超过20继续往该线程池中提交任务，这些任务会被悄悄丢弃
    // 线程的名字为"MyThread"
    public static ExecutorService myThreadPool() {
        return new ThreadPoolExecutor(10, 10, 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(20),
                new HasNameThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
    }

    private static class HasNameThreadFactory implements ThreadFactory {
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "MyThread");
        }
    }
}
