package com.designing.singleton.java;

// 饿汉
public class Singleton_EH {
    private static Singleton_EH instance = new Singleton_EH();
    private Singleton_EH(){}
    public static Singleton_EH getInstance(){
        return instance;
    }
}
