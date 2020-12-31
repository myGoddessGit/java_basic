package com.more_thread

import java.io.IOException
import java.io.PipedInputStream
import java.io.PipedOutputStream

/**
 * Author by MyGoddess on 2020/12/1
 */
object PipelineComms {

    @JvmStatic
    fun main(args : Array<String>){
        val pos = PipedOutputStream()
        val pis = PipedInputStream()
        try {
            pis.connect(pos)
        } catch (e : IOException){
            e.printStackTrace()
        }
        MyProducer(pos).start()
        MyConsumer(pis).start()
    }

    /**
     * 生产者
     */
    class MyProducer(private val outputStream: PipedOutputStream) : Thread() {
        private var index = 0
        override fun run() {
            while (true){
                try {
                    for (i in 0..4){
                       outputStream.write(index++)
                    }
                } catch (e : IOException){
                    e.printStackTrace()
                }
                try {
                    sleep(5 * 1000L)
                } catch (e :InterruptedException){
                    e.printStackTrace()
                }
            }
        }
    }

    class MyConsumer(private val inputStream : PipedInputStream) : Thread(){
        override fun run() {
            while (true){
                try {
                    sleep(5 * 100L)
                } catch (e : InterruptedException){
                    e.printStackTrace()
                }
                try {
                    val count = inputStream.available()
                    if (count > 0){
                        println("reset product count: $count")
                        println("get product: ${inputStream.read()}")
                    }
                } catch (e1 : IOException){
                    e1.printStackTrace()
                }
            }
        }
    }
}