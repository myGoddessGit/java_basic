package com.more_thread.thread_create

import java.util.concurrent.Callable
import java.util.concurrent.ExecutionException
import java.util.concurrent.FutureTask

/**
 * Author by MyGoddess on 2020/11/9
 */
object CallableDemo {

    @JvmStatic
    fun main(args : Array<String>){
        val callable = MyThread()
        val future = FutureTask<Long>(callable)
        Thread(future, "Callable线程").start()
        try {
            println("任务耗时: ${future.get() / 1000000}毫秒")
        } catch (e : InterruptedException){

        } catch (e : ExecutionException){

        }
    }

    class MyThread : Callable<Long>{

        private var ticket = 10000

        override fun call(): Long {
            val begin = System.nanoTime()
            while (ticket > 0){
                println(Thread.currentThread().name + "卖出了第${ticket}张票")
                ticket--
            }
            val end = System.nanoTime()
            return (end - begin)
        }

    }
}