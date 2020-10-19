package com.more_thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 多线程通信
 *  while 轮询 -> 会影响CPU部分性能
 *  线程B一直在判断条件是否成立 一直占用cpu资源(空循环)
 */
public class WhilePolling {
    public static class MyLists{
        private  List<String> list = new ArrayList<>();
        public void add(){
            list.add("elements");
        }

        public int size(){
            return list.size();
        }
    }

    public static class ThreadA extends Thread {
        private MyLists lists;
        public ThreadA(MyLists lists){
            super();
            this.lists = lists;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++){
                    lists.add();
                    System.out.println("添加了" + (i + 1) + "个元素");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public static class ThreadB extends Thread {
        private MyLists lists;
        public ThreadB(MyLists lists){
            super();
            this.lists = lists;
        }

        @Override
        public void run() {
            try {
                //System.out.println("添加了: " + lists.size() + "个元素");
                while (true){
                    if (lists.size() == 5){
                        Thread.sleep(1000);
                        System.out.println("==5 线程b准备退出了");
                        throw new InterruptedException();
                    }
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyLists service = new MyLists();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
    }
}
