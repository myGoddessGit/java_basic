package com.designing.observer.jdk_observer;

/**
 * @Author by chenYl on 2021/6/7 15:55
 * @Description :
 * @VERSION :
 * @TITLE :
 */


import java.util.Observable;
import java.util.Observer;

/**
 * 被观察者
 */
public class Viewer implements Observer {

    private int seatNo;

    public Viewer(){

    }

    public Viewer(int seatNo){
        this.seatNo = seatNo;
    }

    public int getSeatNo() {
        return seatNo;
    }

    @Override
    public void update(Observable o, Object arg) {
        Integer state = (Integer) arg;
        if (state != null){
            switch (state){
                case Clown.PERFORM_GOOD:
                    System.out.println("座位号" + getSeatNo() + "观众鼓掌了");
                    break;
                case Clown.PERFORM_BAD:
                    System.out.println("座位号" + getSeatNo() + "观众喝倒彩了");
                    break;
                case Clown.PERFORM_COMPLETE:
                    System.out.println("座位号" + getSeatNo() + "观众退场了");
                default:break;
            }
        }
    }
}
