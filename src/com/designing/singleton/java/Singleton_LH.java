package com.designing.singleton.java;

// 懒汉
public class Singleton_LH {
    private static Singleton_LH instance;
    private Singleton_LH(){}
    public static Singleton_LH getInstance(){
        if (instance == null){
            instance = new Singleton_LH();
        }
        return instance;
    }
}
