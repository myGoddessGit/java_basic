package com.lock;

import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Author by MyGoddess on 2020/11/9
 */
public class UnLockTest {
    public static String obj1 = "obj1";
    public static final Semaphore a1 = new Semaphore(1);
    public static String obj2 = "obj2";
    public static final Semaphore a2 = new Semaphore(2);

    public static void main(String[] args) {
        LockAa la = new LockAa();
        new Thread(la).start();
        LockBb lb = new LockBb();
        new Thread(lb).start();
    }

    static class LockAa implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println(new Date().toString() + " LockA 开始执行");
                while (true){
                    if (UnLockTest.a1.tryAcquire(1, TimeUnit.SECONDS)){
                        System.out.println(new Date().toString() + " LockA 锁住 obj1");
                        if (UnLockTest.a2.tryAcquire(1, TimeUnit.SECONDS)){
                            System.out.println(new Date().toString() + "LockA 锁 obj2 失败");
                            Thread.sleep(60 * 1000);
                        } else {
                            System.out.println(new Date().toString());
                        }
                    } else {
                        System.out.println(new Date().toString() + "LockA 锁 obj1 失败");
                    }
                    UnLockTest.a1.release();
                    UnLockTest.a2.release();
                    Thread.sleep(1000);
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    static class LockBb implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println(new Date().toString() + "LockB 开始执行");
                while (true){
                    if (UnLockTest.a2.tryAcquire(1, TimeUnit.SECONDS)){
                        System.out.println(new Date().toString() + "LockB锁住obj2");
                        if (UnLockTest.a1.tryAcquire(1, TimeUnit.SECONDS)){
                            System.out.println(new Date().toString() + "LockB 锁住 obj1");
                            Thread.sleep(60 * 1000);
                        } else {
                            System.out.println(new Date().toString() + "LockB 锁 obj1 失败");
                        }
                    } else {
                        System.out.println(new Date().toString() + "LockB锁 obj2 失败");
                    }
                    UnLockTest.a1.release(); // 释放
                    UnLockTest.a2.release(); // 释放
                    Thread.sleep(10 * 1000);
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
