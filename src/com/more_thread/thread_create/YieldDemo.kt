package com.more_thread.thread_create

import kotlin.concurrent.thread

/**
 * Author by MyGoddess on 2020/11/9
 *
 * 线程礼让
 * Thread.yield => 声明当前线程已经完成了生命周期中最重要的一部分
 * 可以切换给其他线程来执行】
 * 该方法仅是对线程调度器的一个建议  => 建议具有相同优先级的其他线程可以运行
 */

object YieldDemo {

    @JvmStatic
    fun main(args : Array<String>){
        val t = MyThread()
        Thread(t, "线程1").start()
        Thread(t, "线程2").start()
    }

    class MyThread : Runnable {
        override fun run() {
           for (i in 0 until 5){
              try {
                  Thread.sleep(1000)
              } catch (e : Exception){
                  e.printStackTrace()
              }
               println(Thread.currentThread().name + "运行, i = $i")
               if (i == 2){
                   println("线程礼让")
                   Thread.yield()
               }
           }
        }
    }
}