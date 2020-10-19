package com.designing.appearce;

public class Client {
    public static void main(String[] args) {
        Facade facade = new FacadeImpl();
        facade.methodA();
        facade.methodB();
        facade.methodC();
    }
}
