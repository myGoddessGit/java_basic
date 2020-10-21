package com.designing.flyweight.complex;

import java.util.ArrayList;
import java.util.List;

/**
 * 复合享元模式
 */
public class ComplexClient {
    public static void main(String[] args) {
        List<String> compositeState = new ArrayList<>();
        compositeState.add("辣椒炒肉");
        compositeState.add("牛肉");
        compositeState.add("鸡肉");
        compositeState.add("辣椒炒肉");
        compositeState.add("牛肉");

        FlyweightFactorys flyweights = new FlyweightFactorys();
        Flyweights comFly1 = flyweights.factory(compositeState);
        Flyweights comFly2 = flyweights.factory(compositeState);
        comFly1.operation("faker点菜");// 外蕴状态是同一个
        System.out.println();
        comFly2.operation("uzi点菜");

        System.out.println("---------------------------");
        System.out.println("复合享元模式是否共享对象: " + (comFly1 == comFly2));

        String state = "牛肉";
        Flyweights flys1 = flyweights.factory(state);
        Flyweights flys2 = flyweights.factory(state);

        System.out.println("单纯享元模式是可以共享对象: " + (flys1 == flys2));
    }
}
