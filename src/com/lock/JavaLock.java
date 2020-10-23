package com.lock;

import java.util.Vector;
import java.util.concurrent.locks.ReentrantLock;

public class JavaLock {

    /**
     *  java 主流锁
     *  1. 线程要不要锁住同步资源
     *      1. 锁住  -> 悲观锁
     *      2. 不锁住  -> 乐观锁
     *
     *  2. 锁住同步资源失败, 线程要不要阻塞
     *      1. 阻塞
     *      2. 不阻塞
     *          1. 自旋锁
     *          2. 适应性自旋锁
     *
     *  3. 多个线程竞争同步资源的流程细节的区别
     *      1. 不锁住资源, 多个线程中只有一个能修改资源成功,
     *      其他线程会重试  -> 无锁
     *
     *      2. 同一个线程执行同步资源时自动获取资源 -> 偏向锁
     *
     *      3. 多个线程竞争同步资源时, 没有获取资源的线程自旋等待锁释放  -> 轻量级锁
     *
     *      4. 多个线程竞争同步资源时, 没有获取资源的线程阻塞等待唤醒 -> 重量级锁
     *
     *   4. 多个线程竞争锁时需不需要排队
     *      1. 排队  -> 公平锁
     *      2. 先尝试插队 插队失败再排队  -> 非公平锁
     *
     *   5. 一个线程中的多个流程能不能获取同一把锁
     *      1. 能 -> 可重入锁
     *      2  不能 -> 非可重入锁
     *
     *   6.多个线程能不能共享一把锁
     *      1. 能 -> 共享锁
     *      2  不能 -> 排他锁
     */


    /**
     * 乐观锁 ->
     * java原子类的递增操作就通过CAS自旋实现的
     *
     * 乐观锁与悲观锁对比:
     *  悲观锁适合写操作多的场景  先加锁可以保证写操作时数据正常
     *  乐观锁适合读操作多的场景  不加锁的特点能够使其读操作的性能大幅提升
     */

    /**
     *
     * 无锁  ->  偏向锁  -> 轻量级锁  -> 重量级锁
     * 锁只能升级 不能降级
     */

    ReentrantLock lock = new ReentrantLock();

    void a (){
        synchronized (lock){

        }
    }

    /**
     * Lock 与 synchronized
     *
     * ReentrantLock 拥有 synchronized 相同的并发性和内存语义
     * ReentrantLock 多了 锁投票  定时锁等待 和 中断锁等候
     *
     * 线程A 和 B 都要获取对象O的锁定  假设A获取了对象O的锁,
     * B将等待A释放对O的锁定
     * 如果使用synchronized => 如果A 不释放锁 B将一直等待下去 且不能被中断
     * 如果使用ReentrantLock  如果A不释放 可以使B在等待了足够长的时间以后 中断等待 去处理其他事情
     *
     * ReentrantLock 获取锁的三种方式
     *
     * 1. lock()方法  如果获取了锁立即返回  且别的线程持有锁  当前线程则一直 处于休眠状态  直到获取锁
     * 2. tryLock()方法  如果获取了锁立即返回true  如果别的线程正持有锁  立即返回false
     * 3. tryLock(long timeout, TimeUnit unit) 如果获取了锁定立即返回true, 如果别的线程正持有锁, 会等待参数
     * 给定的时间  在等待过程中  如果获取了锁定  就返回true  如果超时等待  就返回 false
     * 4. lockInterruptibly 如果获取了锁定立即返回  如果没有获取锁定  当前线程处于休眠状态, 直到获取锁定,
     * 或者当前线程被别的线程中断
     *
     *
     * synchronized 是在JVM上实现的  代码执行异常时  JVM会自动释放锁定
     * Lock 为了保证锁一定会被释放   就必须在finally中执行unLock()
     */

    Integer integer = new Integer(13);

    private static Vector<Integer> vector = new Vector<>();
}
