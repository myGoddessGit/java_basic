package com.designing.builder;

/**
 * 设计模式  -> 生成器模式
 */
public class Client {
    public static void main(String[] args) {
        Director director = new Director(new FourDaysBuilder("2020-10-31"));
        director.construct();
    }
}
