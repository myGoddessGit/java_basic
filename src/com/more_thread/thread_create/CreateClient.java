package com.more_thread.thread_create;

import java.util.Date;
import java.util.stream.Stream;

/**
 * Author by MyGoddess on 2020/11/9
 *
 * java 创建线程的三种方式
 * 1. 继承Thread类创建线程类
 * 2. 实现Runnable 接口
 * 3. 通过Callable 和 Future创建
 *
 * 创建线程池的四种方式
 *
 * 1. newCachedThreadPool 创建一个可缓存的线程池 假如线程池长度超过处理需求 可灵活
 * 回收空闲线程 若没有可回收的 则创建线程。
 *
 * 2. newFixedThreadPool 创建一个定长线程池 可控制线程最大的并发数 超过的线程会在
 * 队列中等待
 *
 * 3. newScheduledThreadPool 创建一个定长线程池 支持定时及周期性任务执行
 *
 * 4. newSingleThreadExecutor 创建一个单线程化的线程池 它只会唯一的工作线程来执行任务
 * 保证所有任务按照指定顺序(FIFO(堆栈 -> 先进先出),LIFO(后进先出),优先级)执行
 *
 * 使用线程池的优点 :
 * 1> 重用存在的线程 减少对象、消亡的开销 性能佳
 * 2> 可有效控制最大并发线程数 提高系统资源的使用率 同时避免过多的资源竞争 避免阻塞
 * 3> 提供定时执行 定时执行 单线程 并发数控制
 */
public class CreateClient {

    /**
     * sleep() 和 wait()
     *
     * sleep 是线程的方法 wait 是Object方法
     *
     * sleep 不会释放锁  wait 会释放锁 (只能在同步方法中使用)
     *
     * sleep 不需要被唤醒 wait 需要 (用notify唤醒)
     */

}
