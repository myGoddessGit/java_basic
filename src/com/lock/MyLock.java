package com.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Author by chenYl on 2021/6/16 14:53
 * @Description :  模拟实现锁的方法
 * @VERSION :
 * @TITLE :
 */
public class MyLock implements Lock {

    private Helper helper  = new Helper(); // 实例化帮助器

    private class Helper extends AbstractQueuedSynchronizer{
        /**
         * 以独占的方式获取锁
         * @param arg
         * @return
         */
        @Override
        protected boolean tryAcquire(int arg) {
            /**
             * 调用父类获取状态的方法
             */
            int state = getState();
            /**
             * 如果状态为0 -> 说明可以获取锁
             */
            System.out.println("state的值: " + state);
            if (state == 0){
                System.out.println("this state is 0");
                /**
                 * 利用Cas原理修改state 保证原子性
                 */
                boolean stateFlag = compareAndSetState(0, arg);
                /**
                 * 如果为true 说明当前可以获取锁 进行状态修改
                 */
                if (stateFlag){
                    System.out.println("获取锁成功啦！！！");
                    /**
                     * 设置当前线程占有资源
                     */
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true; // 返回值 说明获取锁成功
                }
                /**
                 * 判断当前占有的线程是不是请求的线程
                 */
            } else if (getExclusiveOwnerThread() == Thread.currentThread()){
                System.out.println("当前线程是请求的线程！！！");
                /**
                 * 增加可重入性功能
                 */
                setState(getState() + arg);
                return true;
            }
            System.out.println("获取锁失败啦啦啦！！！");
            /**
             * 其他情况为false 说明锁获取失败
             */
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            /**
             * 获取当前锁的状态
             */
            int state = getState() - arg;
            /**
             * 设置标志位
             */
            boolean flag = false;
            /**
             * 判断释放当前锁后，状态是否为0
             */
            if (state == 0){ // -> 说明当前锁全部释放
                setExclusiveOwnerThread(null);
                flag = true;
            }
            setState(state);
            return flag;
        }

        /**
         * 条件限制  在某些条件下加锁
         * @return
         */
        public Condition newConditionObject(){
            return new ConditionObject();
        }
    }

    @Override
    public void lock() {
        // 设置锁
        helper.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        // 中断锁
        helper.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return helper.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return helper.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        // 释放锁
        helper.release(1);
    }

    @Override
    public Condition newCondition() {
        // 在特定条件下加锁
        return helper.newConditionObject();
    }
}
