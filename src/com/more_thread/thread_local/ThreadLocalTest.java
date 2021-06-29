package com.more_thread.thread_local;

/**
 * @Author by chenYl on 2021/2/2 17:44
 * @Description :
 * @VERSION :
 * @TITLE :
 */
public class ThreadLocalTest {
    private static ThreadLocal<String> localVar = new ThreadLocal<>();

    private static void print(String str) {
        //打印当前线程中本地内存中本地变量的值
        System.out.println(str + " :" + localVar.get());
        //清除本地内存中的本地变量
        localVar.remove();
    }

    public static void main(String[] args) {
        Thread t1  = new Thread(() -> {
            //设置线程1中本地变量的值
            localVar.set("localVar1");
            //调用打印方法
            print("thread1");
            //打印本地变量
            System.out.println("after remove1 : " + localVar.get());
        });

        Thread t2  = new Thread(() -> {
            //设置线程1中本地变量的值
            localVar.set("localVar2");
            //调用打印方法
            print("thread2");
            //打印本地变量
            System.out.println("after remove2 : " + localVar.get());
        });

        t1.start();
        t2.start();
    }
}
