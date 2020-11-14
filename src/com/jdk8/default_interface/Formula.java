package com.jdk8.default_interface;

/**
 * Author by MyGoddess on 2020/11/14
 *
 * 通过使用default 关键字 将非抽象方法实现添加到接口(虚拟扩展方法)
 */
public interface Formula {
    double calculate(int a);
    default double sqrt(int a){
        return Math.sqrt(a);
    }
}
