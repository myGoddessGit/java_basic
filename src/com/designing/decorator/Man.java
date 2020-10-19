package com.designing.decorator;

/**
 * 具体组件
 */
public class Man implements Person {
    @Override
    public void eat() {
        System.out.println("我在吃饭");
    }
}
