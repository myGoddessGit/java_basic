package com.lock;

/**
 * @Author by chenYl on 2021/6/16 15:21
 * @Description :
 * @VERSION :
 * @TITLE :
 */
public class MyLockTest {
    private MyLock lock = new MyLock();
    private int m = 0;
    public int next(){
        lock.lock(); // 加锁
        try {
            return m++;
        } finally {
            lock.unlock(); // 释放锁
        }
    }

    public static void main(String[] args) {
        MyLockTest test = new MyLockTest();
        Thread[] threads = new Thread[20];
        for (int i = 0; i < threads.length; i++){
            threads[i] = new Thread(() -> System.out.println("m = " + test.next()));
            threads[i].start();
        }
    }
}
