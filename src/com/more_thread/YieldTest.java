package com.more_thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author by MyGoddess on 2020/11/5
 *
 * 认识  Thread.yield()
 */
public class YieldTest {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Worker(), "thread1");
        Thread thread2 = new Thread(new Worker(), "thread2");
        Thread thread3 = new Thread(new Worker(), "thread3");

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(thread1);
        executorService.execute(thread2);
        executorService.execute(thread3);
    }

    static class Worker implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i <= 10; i++){
                System.out.println("threadName=" + Thread.currentThread().getName() + ", index=" + i);
                if (i == 5){
                    Thread.yield();
                    System.out.println("threadName=" + Thread.currentThread().getName() + "执行 yield 方法, 让出 cpu 时间片");
                }
            }
        }
    }
}
