package com.lock;

import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;
import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 死锁产生的条件
 * 互斥使用
 *
 * 不可抢占
 *
 * 请求和保持
 *
 * 循环等待
 *
 *
 * ReentrantReadWriteLock 典型的共享锁 (锁可以被多个线程持有, 如果一个线程对数据加上共享锁后，其他线程只能
 * 对数据再加上共享锁 获得共享锁的线程只能读数据 不能修改数据)
 */
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
     *
     *
     * 自旋锁  =》 为了让当前线程稍等一下  将当前线程进行自旋  自旋完成之后前面锁定同步资源的线程已经释放了锁
     * 当前线程就可以不必阻塞而是直接获取同步资源  从而避免线程的开销
     * 自旋操作减少CPU切换以及恢复现场导致的资源消耗
     * 缺点  自旋锁本身不能代替阻塞 虽然避免了线程切换的开销  但是需要占用处理器时间 锁占用时间短 自旋锁的性能会比较好
     * 锁占用的时间长 自旋的线程会浪费CPU资源  如果自旋超过了限定次数 (默认是10次 可通过-XX:PreBlockSpin 修改) 没有成功获得锁 就应该挂起线程
     *
     * 适应性自旋锁 => 自旋的次数不在固定  由前一次在同一个锁上的自旋时间及锁的拥有者的状态来决定
     *
     *
     * 无锁  偏向锁  轻量级锁  重量级锁
     *
     * 无锁  ->  对象的hashCode 对象分代年龄  是否为偏向锁           01 (存储内容)
     * 偏向锁  偏向线程ID  偏向时间戳  对象分代年龄  是否是偏向锁    01 (存储内容)
     * 轻量级锁   指向栈中锁记录的指针                               00 (存储内容)
     * 重量级锁  指向互斥锁(重量级锁)的指针                          10 (存储内容)
     *
     *
     *
     * 公平锁  和  非公平锁
     * 公平锁 => 多个线程按照申请锁的顺序来获取锁
     * 优点 是等待锁的线程不会饿死
     * 缺点 整体吞吐效率相对非公平锁要低 等待队列中除了第一个线程以外的所有线程都会阻塞 CPU唤醒阻塞线程的开销
     * 比非公平锁大
     *
     * 非公平锁  => 多个线程加锁时直接尝试获取锁   获取不到的才会到等待队列的队尾等待  但如果此时锁刚好可用
     * 那么这个线程可以无阻塞直接获取到锁  所有的非公平锁都有可能出现申请锁的线程先获取锁的场景
     * 优点 : 可以减少唤起线程的开销  整体的吞吐效率高(线程有几率不阻塞直接获得锁 CPU不必唤醒所有的线程)
     * 缺点 : 处于等待队列中的线程可能会饿死  或者等很久才会获得锁
     *
     *
     *
     * 可重入锁(递归锁)  和  非可重入锁
     * synchronized 和  ReentrantLock 都属于可重入锁
     * 可重入锁优点 => 一定程度避免死锁
     *
     * 非可重入锁 => 可能导致会出现死锁
     *
     * ReentrantLock 传入的都是独享锁
     *
     *
     *
     * 独占锁（exclusive），保证只有一条线程执行，比如 ReentrantLock、AtomicInteger。
     * 共享锁（shared），允许多个线程同时执行，比如 CountDownLatch、Semaphore。
     * 同时实现独占和共享，比如 ReentrantReadWriteLock，允许多个线程同时执行读操作，只允许一条线程执行写操作。
     *
     *
     * tryRelease详细流程 =>
     * 1.调用 tryRelease() 释放共享资源，即 state=0，然后唤醒没有被中断的后驱节点的线程;
     *
     * 2.被唤醒的线程自旋，判断自旋节点的前驱节点是不是头结点，是否已经释放共享资源（即 state=0），
     * 自旋节点是否成功获取共享资源（即 state=1），如果三个条件都成立则自旋节点设置为头节点，
     * 如果不成立则把自旋节点的线程挂起，等待被前驱节点唤醒。
     *
     */

    synchronized void doSomething(){
        System.out.println("方法1执行...");
        doOthers();
    }

    synchronized void doOthers(){
        System.out.println("方法2执行...");
    }

    Integer integer = new Integer(13);

    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Object o1 = new Object();
        synchronized (o1.getClass()){
            System.out.println(ClassLayout.parseInstance(o1).toPrintable());
        }
    }
}
