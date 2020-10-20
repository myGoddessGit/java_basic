package com.designing.bridging;

/**
 * 发送消息的统一接口
 */
public interface MessageImplementor {
    /**
     * 发送消息
     * @param message  消息内容
     * @param toUser   消息的接收者
     */
    void send(String message, String toUser);
}
