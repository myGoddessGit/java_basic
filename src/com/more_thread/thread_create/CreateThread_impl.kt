package com.more_thread.thread_create

/**
 * Author by MyGoddess on 2020/11/9
 */
object CreateThread_impl {

    @JvmStatic
    fun main(args : Array<String>){
        val tA = Thread(MyThread(), "Runnable 线程-A")
        val tB = Thread(MyThread(), "Runnable 线程-B")
        val tC = Thread(MyThread(), "Runnable 线程-C")
        tA.start()
        tB.start()
        tC.start()
    }

    class MyThread : Runnable {

        private var ticket = 5

        override fun run() {
            while (ticket > 0){
                println(Thread.currentThread().name + "卖出了第${ticket}张票")
                ticket--
            }
        }
    }
}