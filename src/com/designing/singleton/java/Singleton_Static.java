package com.designing.singleton.java;

/**
 * 静态内部类
 *  线程安全 效率高 可延时加载
 */
public class Singleton_Static {
    /**
     * 静态初始化器  由JVM来保证安全
     */
    private static class SingletonHolder {
        private static Singleton_Static instance = new Singleton_Static();
    }
    private Singleton_Static(){
        System.out.println("Singleton has loaded");
    }
    public static Singleton_Static getInstance(){
        return SingletonHolder.instance;
    }
}
