package com.designing.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib子类代理工厂
 * 对UserDao在内存中动态构建一个子类对象
 */
public class ProxyFactoryC implements MethodInterceptor {
    // 维护目标对象
    private Object target;

    public ProxyFactoryC(Object target){
        this.target = target;
    }
    // 给目标对象创建一个代理对象
    public Object getProxyInstance(){
        // 工具类
        Enhancer en = new Enhancer();
        // 设置父类
        en.setSuperclass(target.getClass());
        // 设置回调函数
        en.setCallback(this);
        // 创建子类(代理对象)
        return en.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始事务....");
        // 执行目标对象的方法
        Object returnValue = method.invoke(target, objects);
        System.out.println("提交事务....");
        return returnValue;
    }
}
