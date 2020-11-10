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

    /**
     * java Thread 方法
     *
     * 1. run() -> 线程的执行体
     *
     * 2. start() -> 线程的启动方法
     *
     * 3. currentThread() -> 返回当前正在执行的线程对象的应用
     *
     * 4. setName() -> 设置线程名称
     *
     * 5. getName() -> 获取线程名称
     *
     * 6. setPriority() -> 设置线程优先级(java 中的线程优先级的范围是[0, 10]  一般
     *  来说 高优先级的线程在运行时会具有优先权 可以通过thread.setPriority(Thread.MAX_PRIORITY)的方法设置 默认优先级为5)
     *
     * 7. setDaemon() -> 设置线程为守护线程
     *
     * 8. isDaemon() -> 判断线程是否为守护线程
     *
     * 9. isAlive() -> 判断线程是否启动
     *
     * 10. interrupt -> 中断另一个线程的运行状态
     *
     * 11. interrupted() -> 测试当前线程是否已中断
     *
     * 12. join() -> 可以使一个线程强制运行 线程强制运行期间 其他线程无法运行 必须等待此线程完成之后才可以继续执行
     *
     * 13. sleep() -> 静态方法 将当前正在执行的线程休眠
     *
     * 14. yield() -> 静态方法 将当前正在执行的线程暂停 让其他线程执行
     */

    public static void main(String[] args) {
        System.out.println(~(-100));
    }

}
