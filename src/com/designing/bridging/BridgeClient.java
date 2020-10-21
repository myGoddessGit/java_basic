package com.designing.bridging;

/**
 * 设计模式  -> 桥接模式
 */
public class BridgeClient {
    public static void main(String[] args) {
        MessageImplementor implementor = new MessageSMS();

        AbstractMessage message = new CommonMessage(implementor);
        message.sendMessage("加速", "Some");

        implementor = new MessageEmail();
        message = new UrgencyMessage(implementor);
        message.sendMessage("加速", "Some1");
    }
}
