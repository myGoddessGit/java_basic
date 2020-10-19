package com.designing.proxy.staticproxy;

/**
 * 代理模式
 * 静态代理
 * 优点 : 不修改目标对象的功能前提下  对目标功能进行扩展
 * 缺点 : 接口增加方法  目标对象与代理对象都要维护
 */
public class TestClient {
    public static void main(String[] args) {
        UserDao target = new UserDao(); // 目标对象
        UserDaoProxy proxy = new UserDaoProxy(target); // 代理对象
        proxy.save(); // 执行的是代理的方法
    }
}
