package com.designing.medium;

/**
 * 设计模式  -> 中介者模式
 */
public class MediumClient {
    public static void main(String[] args) {
        UserImpl.A a = new UserImpl.A();
        UserImpl.B b = new UserImpl.B();
        UserImpl.C c = new UserImpl.C();
        UserImpl.D d = new UserImpl.D();
        QQManager manager = new QQManager();
        manager.addUser(a);
        manager.addUser(b);
        manager.addUser(c);
        manager.addUser(d);

        manager.setMessage(a, b, "你好");
        manager.setMessage(d, a, "干嘛呢?");
        manager.setAllMessage(a, "大家上班啦!");
    }
}
