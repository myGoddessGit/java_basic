package com.reflex.staticproxy;

/**
 * Author by MyGoddess on 2020/11/5
 *
 * Proxy 保存一个引用使得代理可以访问实体 并提供一个Subject接口相同的接口 用代理代替实体类
 */
public class Proxy extends Subject{

    private RealSubject real;

    @Override
    public void Request() {
        if (null == real){
            real = new RealSubject();
        }
        real.Request();
    }
}
