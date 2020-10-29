package com.data_structures.queue;


/**
 * 队列
 *
 * 队列是元素的集合，其包含了两个基本操作：入队（enqueue） 操作可以用于将元素插入到队列中，而出队（dequeue）操作则是将元素从队列中移除。
 *
 * 遵循先入先出原则 (FIFO)。
 *
 * 时间复杂度：
 *
 * 索引: O(n)
 * 搜索: O(n)
 * 插入: O(1)
 * 移除: O(1)
 */
public class Client {
    public static void main(String[] args) {
        /**
         * 这里暂时只开一个窗口
         */
        TaskQueue taskQueue = new TaskQueue(1);
        taskQueue.clear();
        // 开始工作
        taskQueue.start();
        // 为了显示出优先级效果，我们预添加3个在前面堵着，让后面的优先级效果更明显。

        for (int i = 0; i < 10; i++){ // 从第0个人开始
            PrintTask task = new PrintTask(i);
            if (1 == i){
                task.setPriority(Priority.LOW); // 让第2个进来的人最后办事
            } else if (8 == i){
                task.setPriority(Priority.HIGH); // 让第9个进来的人第二个办事
            } else if (9 == i){
                task.setPriority(Priority.Immediately); // 让第10个进来的人立即办事
            }
            // 其他进来的人按顺序办事
            taskQueue.add(task);
        }
        taskQueue.add(new PrintTask(111));
        taskQueue.add(new PrintTask(112));
        taskQueue.add(new PrintTask(113));
    }
}
