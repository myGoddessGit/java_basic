package com.reflex.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Author by MyGoddess on 2020/11/5
 *
 *
 */
public class InvocationHandlerDemo implements InvocationHandler {

    /**
     * 该对象就是需要代理的真实对象
     */
    private Object subject;

    public InvocationHandlerDemo(Object subject){
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before method");

        System.out.println("Call Method: " + method);

        Object obj = method.invoke(subject, args);

        System.out.println("After method");
        System.out.println();
        return obj;
    }
}
