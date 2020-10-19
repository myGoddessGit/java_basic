package com.more_thread;

/**
 * 多线程同步
 *  synchronized 同步锁方式
 */
public class Sync {

    public static class MyObject {
        synchronized public void mA(){
            System.out.println("A make a");
        }

        synchronized public void mB(){
            System.out.println("B make b");
        }
    }

    public static class ThreadA extends Thread {
        private MyObject object;
        public ThreadA(MyObject object){
            super();
            this.object = object;
        }

        @Override
        public void run() {
            super.run();
            object.mA();
        }
    }

    public static class ThreadB extends Thread {
        private MyObject object;
        public ThreadB(MyObject object){
            super();
            this.object = object;
        }

        @Override
        public void run() {
            super.run();
            object.mB();
        }
    }

    public static void main(String[] args) {
        MyObject object = new MyObject();
        ThreadA a = new ThreadA(object);
        ThreadB b = new ThreadB(object);
        a.start();
        b.start();
    }
}
