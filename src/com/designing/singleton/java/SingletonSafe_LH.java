package com.designing.singleton.java;

/**
 * 懒汉模式  加锁保证线程安全
 */
public class SingletonSafe_LH {
    private static SingletonSafe_LH instance;
    // 使用同步锁
    public static synchronized SingletonSafe_LH getInstance(){
        if (instance == null){
            instance = new SingletonSafe_LH();
        }
        return instance;
    }
}
