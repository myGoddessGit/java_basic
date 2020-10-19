package com.designing.observer;

/**
 * 当对象存在一对关系时, 使用观察者模式
 */
public class ObserverClient {
    public static void main(String[] args) {
        Subject subject = new Subject();
        new ObserverImpl.BinaryObserver(subject);
        new ObserverImpl.OctalObserver(subject);
        new ObserverImpl.HexObserver(subject);
        System.out.println("把状态改为10后: ");
        subject.setState(10);
    }
}
