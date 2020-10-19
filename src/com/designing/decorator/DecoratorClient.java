package com.designing.decorator;

/**
 * 装饰者模式
 *
 * 不改变原类文件
 * 不使用继承
 * 动态扩展
 * 装饰者模式提供比继承更多的灵活性
 */
public class DecoratorClient {
    public static void main(String[] args) {
        Man man = new Man();
        DecoratorImpl.ManDecoratorA mA = new DecoratorImpl.ManDecoratorA();
        DecoratorImpl.ManDecoratorB mB = new DecoratorImpl.ManDecoratorB();
        mA.setPerson(man);
        mB.setPerson(man);
        mA.eat();
        mB.eat();
    }
}
