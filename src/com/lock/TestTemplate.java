package com.lock;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 1秒 = 10 ^ 9纳秒
 */
public abstract class TestTemplate {
    private String id;
    protected int round;
    private int threadNum;
    protected long countValue;
    protected AtomicLong countValueAtomic = new AtomicLong(0L);
    protected int[] preInit;
    protected int index;
    protected AtomicInteger indexAtomic = new AtomicInteger(0);
    Random r = new Random(47);
    // 任务栅栏 同批任务 先到达wait的任务挂起  一起等到全部任务到达指定的wait地点后 才能全部唤醒 继续执行
    private CyclicBarrier cb;
    public TestTemplate(String _id, int _round, int _threadNum, CyclicBarrier _cb){
        this.id = _id;
        this.round = _round;
        this.threadNum = _threadNum;
        cb = _cb;
        preInit = new int[round];
        for (int i = 0; i < preInit.length; i++){
            preInit[i] = r.nextInt(100);
        }
    }
    abstract void sumValue();
    /**
     * 对long的操作时非原子的, 原子操作只针对32位
     * long是64位, 底层操作的时候分2个32位读写 因此不是线程安全
     * @return
     */
    abstract long getValue();

    public void testTime(){
        ExecutorService se = Executors.newCachedThreadPool();
        long start = System.nanoTime();
        // 同时开启 2 * ThreadNum个数的读写线程
        for (int i = 0; i < threadNum; i++){
            se.execute(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < round; i++){
                        sumValue();
                    }
                    try {
                        cb.await();
                    } catch (InterruptedException | BrokenBarrierException e){
                        e.printStackTrace();
                    }
                }
            });
            se.execute(new Runnable() {
                @Override
                public void run() {
                    getValue();
                    try {
                        // 每个线程执行完同步方法后就等待
                        cb.await();
                    } catch (InterruptedException | BrokenBarrierException e){
                        e.printStackTrace();
                    }
                }
            });
        }
        try {
            // 当前统计线程也有wait 所以CyclicBarrier的初始值是threadNum * 2 + 1
            cb.await();
            System.out.println("等待等待。。。");
        } catch (InterruptedException | BrokenBarrierException e){
            e.printStackTrace();
        }
        // 所有线程执行完成之后 才会跑到这一步
        long duration = System.nanoTime() - start;
        System.out.println(id+ " = " + duration);
    }
}
