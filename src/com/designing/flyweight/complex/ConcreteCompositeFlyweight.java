package com.designing.flyweight.complex;

import java.util.HashMap;
import java.util.Map;

public class ConcreteCompositeFlyweight implements Flyweights{
    private Map<String, Flyweights> files = new HashMap<>();

    /**
     * 外蕴一个新的单纯享元对象到聚集中
     * @param intrinsicState
     * @param flys
     */
    public void add(String intrinsicState, Flyweights flys){
        files.put(intrinsicState, flys);
    }

    /**
     * 外蕴状态作为参数传入到方法中
     * @param state
     */
    @Override
    public void operation(String state) {
        Flyweights flys = null;
        for (String intrinsicState : files.keySet()){
            flys = files.get(intrinsicState);
            flys.operation(state);
        }
    }
}
