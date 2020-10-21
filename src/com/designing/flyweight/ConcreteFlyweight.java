package com.designing.flyweight;

/**
 * 具体享元角色类
 */
public class ConcreteFlyweight implements Flyweight {
    private String intrinsicState = null; // 内蕴状态

    public ConcreteFlyweight(String intrinsicState){
        this.intrinsicState = intrinsicState;
    }
    @Override
    public void operation(String state) {
        System.out.println("内蕴状态= " + this.intrinsicState);
        System.out.println("外蕴状态= " + state);
    }
}
