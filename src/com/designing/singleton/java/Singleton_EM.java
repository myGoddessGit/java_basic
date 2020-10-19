package com.designing.singleton.java;

/**
 * 枚举类
 * 线程安全  效率高  不能延时加载
 *  天然的防止反射和反序列化调用
 */
public enum Singleton_EM {
    /**
     * 定义一个枚举元素
     * 该元素就代表Singleton的一个实例
     */
    uniqueInstance;
    public void singletonOperation(){
        System.out.println("功能处理");
    }
}
