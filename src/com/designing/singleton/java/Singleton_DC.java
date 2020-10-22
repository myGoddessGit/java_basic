package com.designing.singleton.java;

/**
 *
 * 单例模式
 * ->
 * 某个类 只能有一个实例 提供一个全局访问点
 *
 * 双重校验锁
 *  线程安全 能延时加载 以时间换空间
 */
public class Singleton_DC {
    private volatile static Singleton_DC instance = null;
    // 私有构造方法  防止外部实例化
    private Singleton_DC(){}
    public static Singleton_DC getInstance(){
        if (instance == null){
            synchronized (Singleton_DC.class){
                if (instance == null){
                    instance = new Singleton_DC();
                }
            }
        }
        return instance;
    }
}
