package com.lock.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author by chenYl on 2021/6/16 14:36
 * @Description :
 * @VERSION :
 * @TITLE :
 */
public class CASTest2 {
    private static AtomicStampedReference<Integer> asf = new AtomicStampedReference<Integer>(100, 1);

    public static void main(String[] args) {

        /**
         * compareAndSet(期望值，改变值，当前版本号，改变后的版本号)
         */
        Thread t1 = new Thread(()->{
            System.out.println("t1: "+ asf.compareAndSet(100, 110, asf.getStamp(), asf.getStamp() + 1));
            System.out.println("t1.asf: "+ asf.getReference());
        });
        t1.start();

        Thread t2 = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2: "+ asf.compareAndSet(110,100, asf.getStamp(),asf.getStamp() + 1));
            System.out.println("t2.asf: "+ asf.getReference());
        });
        t2.start();

        Thread t3 = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t3: "+asf.compareAndSet(100, 120, asf.getStamp(),asf.getStamp() + 1));
            System.out.println("t3.asf: "+asf.getReference());
        });
        t3.start();
    }
}
