package com.lock.cyclicBarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author by chenYl on 2021/6/24 16:40
 * @Description :  java 同步屏障
 * @VERSION :
 * @TITLE :
 */
public class CyclicBarrierDemo {

    private static class Soldier implements Runnable{

        private String soldier;
        private final CyclicBarrier cyclic;
        public Soldier(CyclicBarrier cyclic, String soldier){
            this.cyclic = cyclic;
            this.soldier = soldier;
        }

        @Override
        public void run() {
            try {
                cyclic.await();
                doWork();
                cyclic.await();
            } catch (InterruptedException | BrokenBarrierException e){
                e.printStackTrace();
            }
        }

        void doWork(){
            try {
                Thread.sleep(new Random().nextInt(10) * 1000);
                System.out.println(soldier + " done!");
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private static class BarrierRun implements Runnable {

        boolean flag = false;
        int N;
        public BarrierRun(boolean flag, int n){
            this.flag = flag;
            this.N = n;
        }

        @Override
        public void run() {
            if (flag){
                System.out.println("soldier" + N + " done!");
            } else {
                System.out.println("soldier" + N + "collected!");
                flag = true;
            }
        }
    }

    public static void main(String[] args) {
        final int N = 10;
        Thread[] all = new Thread[N];
        boolean flag = false;
        CyclicBarrier cyclic = new CyclicBarrier(N, new BarrierRun(flag, N));
        System.out.println("begin gather:");
        for (int i = 0; i < N; i++){
            System.out.println("soldier:" + i + " coming.");
            all[i] = new Thread(new Soldier(cyclic, "soldier" + i));
            all[i].start();
        }
    }
}
