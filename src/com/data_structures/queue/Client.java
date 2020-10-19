package com.data_structures.queue;

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
