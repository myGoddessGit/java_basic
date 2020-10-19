package com.more_thread;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 *  多线程通信
 *  管道通信
 */
public class PipelineComm {
    /**
     * 生产者
     * 以数字代替产品 生产者每过5秒生产5个产品 放入管道
     */
    public static class MyProducer extends Thread {
        private PipedOutputStream outputStream;
        private int index = 0;
        public MyProducer(PipedOutputStream outputStream){
            this.outputStream = outputStream;
        }
        @Override
        public void run() {
            while (true){
                try {
                    for (int i = 0; i < 5; i++ ){
                        outputStream.write(index++);
                    }
                } catch (IOException e){
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(5 * 1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 消费者每0.5秒从管道中取1件产品，并打印剩余产品数量，并打印产品信息（以数字替代）
     */
    public static class MyConsumer extends Thread{
        private PipedInputStream inputStream;
        public MyConsumer(PipedInputStream inputStream){
            this.inputStream = inputStream;
        }

        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(5 * 100);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                try {
                    int count = inputStream.available();
                    if (count > 0){
                        System.out.println("reset product count: " + count);
                        System.out.println("get product: " + inputStream.read());
                    }
                } catch (IOException e1){
                    e1.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream();
        try {
            pis.connect(pos);
        } catch (IOException e){
            e.printStackTrace();
        }
        new MyProducer(pos).start();
        new MyConsumer(pis).start();
    }
}
