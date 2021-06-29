package com.more_thread.pool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author by chenYl on 2021/3/31 10:25
 * @Description :
 * @VERSION :
 * @TITLE :
 */
public class ExecutorsDemo {
    private static int corePoolSize = 2; // 核心线程数
    private static int maximumPoolSize = 4; // 最大线程数
    private static long keepAliveTime = 60L;
    private static ThreadFactory threadFactory =
            new ThreadFactoryBuilder().setNameFormat("executor_demo_%d").build();
    private static ThreadPoolExecutor threadPoolExecutor =
            new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, new LinkedBlockingDeque<>(2),
                    threadFactory, new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args){
        for (int i = 0; i < 10; i++){
            threadPoolExecutor.execute(new DemoThread("" + i));
        }
        threadPoolExecutor.shutdown();
    }

    static class DemoThread implements Runnable {
        private String command;

        public DemoThread(String command){
            this.command = command;
        }
        @Override
        public void run() {
            System.out.println(
                    Thread.currentThread().getName() + ": start command=" + command
            );
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e){

            }
        }
    }
}
