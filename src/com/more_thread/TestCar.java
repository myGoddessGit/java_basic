package com.more_thread;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * @Author by chenYl on 2021/6/28 17:24
 * @Description : Semaphore  案例
 * @VERSION :
 * @TITLE :
 */
public class TestCar {

    private static Semaphore semaphore = new Semaphore(10); // 同时容纳10辆车

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("====" + Thread.currentThread().getName() + "来到停车场");
                        if (semaphore.availablePermits() == 0){
                            System.out.println("车位不足, 请耐心等待");
                        }
                        semaphore.acquire(); // 获取令牌尝试进入停车场
                        System.out.println(Thread.currentThread().getName() + "成功进入停车场");
                        Thread.sleep(new Random().nextInt(10 * 1000));
                        System.out.println(Thread.currentThread().getName() + "驶出停车场");
                        semaphore.release(); // 释放令牌 腾出停车场车位
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }, i + "号车");
            thread.start();
        }
    }
}

