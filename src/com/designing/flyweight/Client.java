package com.designing.flyweight;

/**
 * 设计模式  -> 享元模式
 *
 * 通过技术共享有效的支持大量细粒度的对象
 *
 */

public class Client {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        Flyweight fly1 = factory.factory(new String("辣椒炒肉"));
        fly1.operation("faker点菜");

        Flyweight fly2 = factory.factory(new String("牛肉"));
        fly2.operation("uzi点菜");

        Flyweight fly3 = factory.factory(new String("辣椒炒肉"));
        fly3.operation("faker点菜");

        System.out.println(fly1 == fly3);
        System.out.println("被点不同的菜的个数" + factory.getFlyWeightSize());
    }
}
