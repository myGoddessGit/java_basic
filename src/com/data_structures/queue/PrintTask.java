package com.data_structures.queue;

public class PrintTask extends BasicTask{
    /**
     * id
     */
    private int id;

    public PrintTask(int id){
        this.id = id;
    }

    @Override
    public void run() {
        try {
            /**
             * 模拟窗口的办事速度  这里停顿2s
             */
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e){

        }
        System.out.println("我的id是: " + id);
    }

}
