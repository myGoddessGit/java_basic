package com.designing.appearance;

/**
 * 外观模式
 *
 * 提供统一的方法来访问子系统的一群接口
 */
public class Client {
    public static void main(String[] args) {
        Facade facade = new FacadeImpl();
        facade.methodA();
        facade.methodB();
        facade.methodC();
    }
}
