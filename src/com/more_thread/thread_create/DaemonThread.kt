package com.more_thread.thread_create

/**
 * Author by MyGoddess on 2020/11/10
 *
 * 守护线程 ->
 *
 * 在后台执行并且不会阻止JVM终止的线程
 * 当所有非守护线程结束时 程序也就终止
 * 同时会杀死所有守护线程
 *
 * 用户线程 (非守护线程) -> 与守护线程相反
 *
 * 可以使用 isDaemon 方法判断线程是否为守护线程
 *         setDaemon 方法设置线程为守护线程
 *
 * 注意 :
 * 正在运行的用户线程无法设置为守护线程 所以setDaemon 必须在 thread.start方法前设置
 * 否则会排除IllegalThreadStateException 异常
 *
 * 一个守护线程创建的子线程依然是守护线程
 *
 * 不能认为所有的应用都可以分配给守护线程来进行服务来进行服务(比如读写操作或者计算逻辑)
 */
object DaemonThread {

    @JvmStatic
    fun main(args : Array<String>){
        val t = Thread(MyThread(), "线程")
        t.isDaemon = true // 此线程在后台运行
        println("线程 t 是否是守护进程: " + t.isDaemon)
        t.start() // 启动线程
    }

    class MyThread : Runnable {
        override fun run() {
            while (true){
                println(Thread.currentThread().name + " 在运行")
            }
        }
    }
}