package com.designing.observer.jdk_observer;



/**
 * @Author by chenYl on 2021/6/7 16:02
 * @Description :
 * @VERSION :
 * @TITLE :
 */
public class Test {

    public static void main(String[] args) {
        /**
         * 被观察者
         */
        Clown clown = new Clown();
        /**
         * 一群观察者(观众)
         */
        for (int i = 0; i < 20; i++){
            Viewer viewer = new Viewer(i);
            clown.addObserver(viewer);
            System.out.println("座位号为" + i + "的观众入坐");
        }
        /**
         * (被观察者 -> 表演者)开始表演
         */
        clown.perform();
        /**
         * (被观察者 -> 表演者)退场
         */
        clown.exit();
    }
}
