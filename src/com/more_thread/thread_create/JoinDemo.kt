package com.more_thread.thread_create

/**
 * Author by MyGoddess on 2020/11/10
 *
 * 在线程操作中 可以使用join 方法让一个线程强制运行
 * 线程强制运行期间 其他线程无法运行 必须等待此线程
 * 完成之后才可以继续执行
 */
object JoinDemo {

    @JvmStatic
    fun main(a : Array<String>){
        val mt = MyThread()
        val t = Thread(mt, "myThread") // 实例化Thread对象
        t.start() // 启动线程
        for (i in 0 until 50){
            if (i > 10){
                try {
                    t.join() // 线程强制执行
                } catch (e : InterruptedException){
                    e.printStackTrace()
                }
            }
            println("Main 线程运行 --> $i")
        }
    }

    class MyThread : Runnable {
        override fun run() {
            for (i in 0 until 50){
                println(Thread.currentThread().name + "运行, i = $i") // 获取当前线程的名字
            }
        }
    }
}