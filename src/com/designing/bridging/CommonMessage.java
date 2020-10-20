package com.designing.bridging;

/**
 * 普通消息实现类
 */
public class CommonMessage extends AbstractMessage{

    public CommonMessage(MessageImplementor impl) {
        super(impl);
    }

    /**
     * 对于普通消息  直接调用父类的方法
     * @param message  要发送消息的内容
     * @param toUser   消息的接收者
     */
    @Override
    public void sendMessage(String message, String toUser) {
        super.sendMessage(message, toUser);
    }
}
