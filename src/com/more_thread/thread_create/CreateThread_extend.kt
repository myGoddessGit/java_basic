package com.more_thread.thread_create

/**
 * Author by MyGoddess on 2020/11/9
 *
 * 定义Thread 类的子类 并覆盖该类的run方法
 * run 方法的方法体就代表了线程要完成的任务 => run方法为执行体
 *
 * 创建Thread 子类的实例 即创建了线程对象
 *
 * 调用线程对象的start方法来启动线程
 */
object CreateThread_extend {
    @JvmStatic
    fun main(args : Array<String>){
        val tA = MyThread("Thread 线程-A")
        val tB = MyThread("Thread 线程-B")
        tA.start()
        tB.start()
    }

    class MyThread(name : String) : Thread(name) {

        private var ticket = 5;

        override fun run() {
            while (ticket > 0){
                println(Thread.currentThread().name + "卖出了第${ticket}张票")
                ticket--
            }
        }
    }
}