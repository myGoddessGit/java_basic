package com.designing.flyweight.complex;

/**
 * 具体享元角色类
 */
public class ConcreteFlyweights implements Flyweights{

    private String intrinsicState = null; // 内蕴状态

    public ConcreteFlyweights(String intrinsicState){
        this.intrinsicState = intrinsicState;
    }

    @Override
    public void operation(String state) {
        System.out.println("内蕴状态= " + this.intrinsicState);
        System.out.println("外蕴状态= " + state);
    }
}
