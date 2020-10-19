package com.designing.proxy.cglib;

import com.designing.proxy.staticproxy.UserDao;

public class CglibTest {
    public static void main(String[] args) {
        // 目标对象
        UserDao target = new UserDao();
        // 代理对象
        UserDao proxy = (UserDao)new ProxyFactoryC(target).getProxyInstance();
        // 执行代理对象的方法
        proxy.save();
    }
}
