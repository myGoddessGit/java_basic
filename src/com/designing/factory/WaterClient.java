package com.designing.factory;


import com.designing.factory.abstract_f.Water_Factory;
import com.designing.factory.simple.WaterFactory;
import com.designing.factory.simple.YiBaoFactory;

public class WaterClient {

    public static void main(String[] args) {
        System.out.println(new WaterImpl.IceDew().getWater());
        /**
         * 简单工厂模式
         * 缺点 违反高内聚责任分配原则
         */
        WaterFactory waterFactory = new WaterFactory();
        System.out.println(waterFactory.getWater("怡宝").getWater());
        System.out.println(new YiBaoFactory().getWater().getWater());
        /**
         * 抽象工厂模式
         */
        Water_Factory factory = new Water_Factory();
        System.out.println(factory.getIceDew().getWater());
    }
}
