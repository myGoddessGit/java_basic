package com.designing.factory;

/**
 * 工厂模式
 *  ->
 *  一个工厂根据传入的参量决定创建出哪一种产品类的实例
 *
 *  工厂方法 : 定义一个创建对象的接口  让子类决定实例化哪一个类
 *
 */

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
         *  ->
         *  创建相关或者依赖对象的家族  而不需要明确指定具体类
         */
        Water_Factory factory = new Water_Factory();
        System.out.println(factory.getIceDew().getWater());
    }
}
