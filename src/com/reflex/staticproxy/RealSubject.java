package com.reflex.staticproxy;

/**
 * Author by MyGoddess on 2020/11/5
 *
 * RealSubject 定义Proxy所代表的真实实体
 */
public class RealSubject extends Subject {
    @Override
    public void Request() {
        System.out.println("真实的请求");
    }
}
