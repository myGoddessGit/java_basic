package com.designing.memento;

/**
 * 设计模式 -> 备忘录模式
 */
public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        originator.setState("State One");
        originator.setState("State Two");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("State Three");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("State Four");

        System.out.println("Current State: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("First saved State: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("Second saved State: " + originator.getState());
    }
}
