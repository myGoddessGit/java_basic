package com.more_thread.thread_create

import java.io.IOException
import java.io.PipedReader
import java.io.PipedWriter

/**
 * Author by MyGoddess on 2020/11/10
 *
 * 管道通信 ->
 * 主要作用于线程之间的数据传输
 * 而传输的媒介为内存 管道输入/输出有四种具体实现 : PipedOutputStream PipedInputStream(管道字节流)
 *                                           PipedReader 和 PipedWriter(管道字符流)
 */
object PipedDemo {

    @JvmStatic
    fun main(s : Array<String>){
        val outWriter = PipedWriter()
        val inReader = PipedReader()
        // 将输出流和输入流进行连接 否则在使用时会抛出IOException
        outWriter.connect(inReader)
        val printThread = Thread(Print(inReader), "PrintThread")
        printThread.start()
        var receive = 0
        try {
            receive = System.`in`.read()
            while (receive != -1){
                outWriter.write(receive)
            }
        } finally {
            outWriter.close()
        }
    }

    class Print(private val inReader : PipedReader) : Runnable {

        override fun run() {
            var receive = 0
            try {
                receive = inReader.read()
                while (receive != -1){
                    println(receive.toChar())
                }
            } catch (e : IOException){
                e.printStackTrace()
            }
        }
    }
}