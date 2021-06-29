package com.lock.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author by chenYl on 2021/6/16 14:27
 * @Description :
 * @VERSION :
 * @TITLE :
 */
public class CASTest {
    //声明原子型变量
    private static AtomicInteger atomic1 = new AtomicInteger(100);

    public static void main(String[] args){
        /**
         * compareAndSet(期望值，改变值)
         */
        Thread t1 = new Thread(()->{
            System.out.println("t1: "+ atomic1.compareAndSet(100, 110));
            System.out.println("t1.atomic1: "+ atomic1.get());
        });
        t1.start();

        Thread t2 = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2: "+atomic1.compareAndSet(110, 100));
            System.out.println("t2.atomic1: "+atomic1.get());
        });
        t2.start();

        Thread t3 = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t3: "+atomic1.compareAndSet(100, 120));
            System.out.println("t3.atomic1: "+atomic1.get());
        });
        t3.start();
    }
}
