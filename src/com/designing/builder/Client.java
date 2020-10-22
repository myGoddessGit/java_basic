package com.designing.builder;

/**
 * 设计模式  -> 生成器模式
 *
 * 封装一个复杂对象的构建过程  并可以按步骤构造
 */
public class Client {
    public static void main(String[] args) {
        Director director = new Director(new FourDaysBuilder("2020-10-31"));
        director.construct();
    }
}
