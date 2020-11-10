package com.more_thread.thread_create

import java.util.concurrent.TimeUnit

/**
 * Author by MyGoddess on 2020/11/9
 *
 * 终止线程
 */
object InterruptDemo {

    @JvmStatic
    fun main(args : Array<String>){
//        val mt = MyThread()   // 实例化Runnable子类对象
//        val t = Thread(mt, "线程") // 实例化Thread对象
//        t.start() // 启动线程
//        try {
//            Thread.sleep(2000) // 将线程休眠2s
//        } catch (e : InterruptedException){
//            println("3 -> 线程被终止")
//        }
//        t.interrupt()  // 中断线程执行
        val task = MyTask2()
        val thread = Thread(task, "MyTask")
        thread.start()
        TimeUnit.MICROSECONDS.sleep(50)
        thread.interrupt()
    }

    /**
     * 当一个线程运行时 另一个线程可以通过interrupt 方法中断其运行状态
     */
    class MyThread : Runnable {

        override fun run() {
            println("1 -> 进入run方法")
            try {
                Thread.sleep(10000) // 将线程休眠10s
                println("2 -> 已经完成了休眠")
            } catch (e : InterruptedException){
                println("3 -> 休眠被终止")
                return
            }
            println("4 -> run()方法正常结束")
        }
    }

    /**
     * 使用volatile 标志位控制线程终止
     */
    class MyTask : Runnable {

        @Volatile
        private var flag = true

        @Volatile
        private var count = 0L
        override fun run() {
            println(Thread.currentThread().name + " 线程启动")
            while (flag){
                println(count++)
            }
            println(Thread.currentThread().name + " 线程终止")
        }

        /**
         * 通过volatile 标志位来控制线程终止
         */
        fun cancel(){
            flag = false
        }
    }

    /**
     * 使用 interrupt 方法和Thread.interrupted 方法配合使用来控制线程终止
     */
    class MyTask2 : Runnable {

        @Volatile
        private var count = 0L

        override fun run() {
            println(Thread.currentThread().name + " 线程启动")
            // 通过 Thread.interrupted 和 interrupt 配合来控制线程终止
            while (!Thread.interrupted()){
                println(count++)
            }
            println(Thread.currentThread().name + " 线程终止")
        }
    }
}