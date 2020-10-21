package com.designing.flyweight.complex;

import com.designing.flyweight.Flyweight;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 享元工厂角色类
 */
public class FlyweightFactorys {
    private Map<String, Flyweights> files = new HashMap<>();

    /**
     * 复合享元工厂方法
     * @param compositeState
     * @return
     */
    public Flyweights factory(List<String> compositeState) {
        ConcreteCompositeFlyweight compositeFly = new ConcreteCompositeFlyweight();
        for (String intrinsicState : compositeState){
            compositeFly.add(intrinsicState, this.factory(intrinsicState));
        }
        return compositeFly;
    }

    /**
     * 单纯享元工厂方法
     * @param intrinsicState
     * @return
     */
    public Flyweights factory(String intrinsicState){
        // 先从缓存中查找对象
        Flyweights flys = files.get(intrinsicState);
        if (flys == null){
            flys = new ConcreteFlyweights(intrinsicState);
            files.put(intrinsicState, flys);
        }
        return flys;
    }
    // 得到存对象的集合长度
    public int getFlyWeightSize(){
        return files.size();
    }
}
