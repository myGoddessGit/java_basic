package com.designing.iterator;

/**
 * 设计模式  ->  迭代器模式
 *
 * 一种遍历访问聚合对象中各个元素的方法  不暴露该对象的内部结构
 *
 * 缺点: 增加新的聚合类需要对应增加新的迭代器类  类的个数成对增加 一定程度增加了系统的复杂性
 */
public class TestClient {
    public static void main(String[] args) {
        Aggregate ag = new ConcreteAggregate();
        ag.add("faker");
        ag.add("uzi");
        ag.add("lwx");
        Iterator iterator = ag.iterator();
        while (iterator.hasNext()){
            String str = (String) iterator.next();
            System.out.println(str);
        }
    }
}
