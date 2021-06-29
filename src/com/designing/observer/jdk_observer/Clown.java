package com.designing.observer.jdk_observer;

import java.util.Observable;
import java.util.Random;

/**
 * @Author by chenYl on 2021/6/7 15:45
 * @Description :
 * @VERSION :
 * @TITLE :
 */
public class Clown extends Observable {

    /**
     * 表演精彩
     */
    public static final int PERFORM_GOOD = 0;

    /**
     * 表演糟糕
     */
    public static final int PERFORM_BAD = 1;

    /**
     * 表演完毕
     */
    public static final int PERFORM_COMPLETE = 2;

    public void perform(){
        System.out.println("被观察者(小丑)开始表演");
        int randomState = new Random().nextInt(2);
        switch (randomState){
            case PERFORM_GOOD:
                System.out.println("被观察者(小丑)表演很精彩!!!");
                break;
            case PERFORM_BAD:
                System.out.println("被观察者(小丑)表演除了篓子");
                break;
        }
        setChanged();
        /**
         * 表演好坏通过该参数传递到观众的update方法的第二个参数上
         */
        notifyObservers(randomState);
    }

    public void exit(){
        System.out.println("被观察者(小丑)表演结束, 准备退场");
        setChanged();
        notifyObservers(PERFORM_COMPLETE);
    }
}

