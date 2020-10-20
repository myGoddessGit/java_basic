package com.designing.bridging;

/**
 * 抽象消息类
 */
public abstract class AbstractMessage {
    // 持有一个实现部分的对象
    MessageImplementor impl;
    // 构造方法
    public AbstractMessage(MessageImplementor impl){
        this.impl = impl;
    }

    /**
     * 发送消息  委派给实现部分的方法
     * @param message  要发送消息的内容
     * @param toUser   消息的接收者
     */
    public void sendMessage(String message, String toUser){
        this.impl.send(message, toUser);
    }
}
