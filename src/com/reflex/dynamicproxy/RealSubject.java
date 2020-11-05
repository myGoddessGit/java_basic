package com.reflex.dynamicproxy;


/**
 * Author by MyGoddess on 2020/11/5
 *
 * RealSubject 定义Proxy所代表的真实实体
 */
public class RealSubject implements Subject {

    @Override
    public void hello(String str) {
        System.out.println("Hello  " + str);
    }

    @Override
    public String bye() {
        System.out.println("Goodbye");
        return "Over";
    }
}
