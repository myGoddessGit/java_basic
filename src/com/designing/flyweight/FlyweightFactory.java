package com.designing.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元角色工厂类
 */
public class FlyweightFactory {
    /**
     * 用来存储所有享元对象的集合String 表示对象的键 -> 内蕴状态  Flyweight表示对象值的类型
     */
    private Map<String, Flyweight> files = new HashMap<>();

    public Flyweight factory(String intrinsicState){
        Flyweight fly = files.get(intrinsicState);
        if (fly == null){
            // 如果对象不存在则创建一个新的Flyweight对象
            fly = new ConcreteFlyweight(intrinsicState);
            // 把这个新的Flyweight对象添加到缓存中
            files.put(intrinsicState, fly);
        }
        return fly;
    }

    /**
     * 得到存对象的集合长度
     * @return
     */
    public int getFlyWeightSize(){
        return files.size();
    }
}
