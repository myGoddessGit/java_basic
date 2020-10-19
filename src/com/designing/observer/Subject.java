package com.designing.observer;

import java.util.LinkedList;
import java.util.List;

/**
 * 被观察者类
 */
public class Subject {
    private List<Observer> observers = new LinkedList<>();

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers){
             observer.upData();
        }
    }
}
