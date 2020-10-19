package com.designing.command;

/**
 * 命令模式
 * 使调用者和实现者相关分离
 */
public class CommandClient {

    public static void main(String[] args) {
        Command cmd = new ConcreteCommand();
        Invoker invoker = new Invoker(cmd);
        System.out.println("客户访问调用者的call()方法");
        invoker.call();
    }
}
