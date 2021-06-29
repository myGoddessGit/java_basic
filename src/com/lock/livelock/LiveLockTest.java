package com.lock.livelock;

/**
 * @Author by chenYl on 2021/4/23 15:28
 * @Description :
 * @VERSION :
 * @TITLE :  java 活锁例子
 */
public class LiveLockTest {

    /**
     * 定义一个勺子 owner 表示勺子的拥有者
     */
    static class Spoon{
        /**
         * 勺子的拥有者
         */
        private Diner owner;

        /**
         * 获取拥有者
         * @return
         */
        public String getOwnerName() {
            return owner.getName();
        }

        /**
         * 设置拥有者
         * @param owner
         */
        public void setOwner(Diner owner) {
            this.owner = owner;
        }

        public Spoon(Diner diner){
            this.owner = diner;
        }

        public void use(){
            System.out.println(owner.getName() + "持有勺子并准备吃东西");
        }
    }

    /**
     * 定义一个晚餐类
     */
    static class Diner{
        private boolean isHungry; // 是否饥饿
        private String name; // 当前用餐者的名字
        public Diner(boolean isHungry, String name){
            this.isHungry = isHungry;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void eatWith(Diner spouse, Spoon sharedSpoon){
            try {
                synchronized (sharedSpoon){
                    while (isHungry){
                        /**
                         * 当前用餐者和勺子拥有者不是同一个人 则进行等待
                         */
                        while (!sharedSpoon.getOwnerName().equals(name)){
                            sharedSpoon.wait();
                        }
                        /**
                         * spouse此刻饥饿, 把勺子分给他 并通知他可以用餐
                         */
                        if (spouse.isHungry){
                            System.out.println("我是" + name + ", 此时" + spouse.getName() + "饥饿，我把勺子给" + spouse.getName() + "\n");
                            sharedSpoon.setOwner(spouse);
                            sharedSpoon.notifyAll();
                        } else {
                            /**
                             * 用餐
                             */
                            sharedSpoon.use();
                            sharedSpoon.setOwner(spouse);
                            sharedSpoon.notifyAll();
                        }
                        Thread.sleep(500);
                    }
                }
            } catch (InterruptedException e){
                System.out.println(name + " is interrupted");
            }
        }
    }

    public static void main(String[] args) {
        final Diner A = new Diner(true, "A");
        final Diner B = new Diner(true, "B");
        final Spoon sharedSpoon = new Spoon(B); // 创建一个勺子 初始状态B持有
        /**
         * 创建一个线程 由 A 进行用餐
         */
        Thread AThread = new Thread(() -> {
            /**
             * 表示和B用餐 这个过程判断B是否饥饿  如果是 则会把勺子分给B
             */
            A.eatWith(B, sharedSpoon);
        });
        AThread.start();

        Thread BThread = new Thread(() -> {
            /**
             * 表示和B用餐 这个过程判断A是否饥饿  如果是 则会把勺子分给A
             */
            B.eatWith(A, sharedSpoon);
        });
        BThread.start();

        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        AThread.interrupt();
        BThread.interrupt();

        try {
            AThread.join();//join()方法阻塞调用此方法的线程(calling thread)，直到线程t完成，此线程再继续；通常用于在main()主线程内，等待其它线程完成再结束main()主线程。
            BThread.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
