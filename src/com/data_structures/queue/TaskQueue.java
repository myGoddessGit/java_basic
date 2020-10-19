package com.data_structures.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 某机构
 */
public class TaskQueue {

    private AtomicInteger mAtomicInteger = new AtomicInteger();

    /**
     * 某机构排的队 队里面是办事的人
     */
    private BlockingQueue<ITask> mTaskQueue;
    /**
     * 很多窗口
     */
    private TaskExecutor[] mTaskExecutors;

    /**
     * 在开发者new 队列的时候 需要指定数量
     * @param size
     */
    public TaskQueue(int size){
        mTaskQueue = new PriorityBlockingQueue<>();
        mTaskExecutors = new TaskExecutor[size];
    }

    /**
     * 开始上班
     */
    public void start(){
        stop();
        /**
         * 把每个窗口都打开 让窗口开始上班
         */
        for (int i = 0; i < mTaskExecutors.length; i++){
            mTaskExecutors[i] = new TaskExecutor(mTaskQueue);
            mTaskExecutors[i].start();
        }
    }

    /**
     * 统一每个窗口下班
     */
    public void stop(){
        if (mTaskExecutors != null){
            for (TaskExecutor taskExecutor : mTaskExecutors){
                if (taskExecutor != null){
                    taskExecutor.quit();
                }
            }
        }
    }

    /**
     * 开一个门  让办事的人能进来
     * @param task
     * @param <T>
     * @return
     */
    public <T extends ITask> int add(T task){
        if (!mTaskQueue.contains(task)){
            task.setSequence(mAtomicInteger.incrementAndGet());
            mTaskQueue.add(task);
        }
        // 返回排队的人数 公开透明 让外面的人看的到有多少人在等着办事
        return mTaskQueue.size();
    }

    public void clear(){
        if (mTaskQueue != null){
            mTaskQueue.clear();
        }
    }

}
