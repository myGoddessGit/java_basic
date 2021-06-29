package com.more_thread.pool;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author by chenYl on 2021/4/28 15:45
 * @Description :
 * @VERSION :
 * @TITLE :
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        System.out.println("主线程开始执行。。。");
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        /**
         * 第一个线程开始执行
         */
        executorService1.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("子线程："+Thread.currentThread().getName()+"执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            }
        });
        executorService1.shutdown();
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        executorService2.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("子线程："+Thread.currentThread().getName()+"执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            }
        });
        executorService2.shutdown();
        System.out.println("等待两个线程执行完毕。。。");
        try {
            countDownLatch.await();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("两个子线程执行完毕... 主线程继续执行");
    }
}
