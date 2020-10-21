package com.designing.flyweight;

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
