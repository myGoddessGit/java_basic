package com.more_thread.thread_create

/**
 * Author by MyGoddess on 2020/11/9
 *
 * 线程休眠 (不会让出资源)
 */
object SleepDemo {

    @JvmStatic
    fun main(args : Array<String>){

        Thread(MyThread("线程A", 500)).start()
        Thread(MyThread("线程B", 1000)).start()
        Thread(MyThread("线程C", 1500)).start()
    }

    /**
     * name 线程名称
     * time 休眠时间
     */
    class MyThread(private val name: String, private val time :Int) : Runnable {

        override fun run() {
            try {
                Thread.sleep(time.toLong())
            } catch (e : InterruptedException){
                e.printStackTrace()
            }
            println(name +"休眠${time}毫秒")
        }
    }
}