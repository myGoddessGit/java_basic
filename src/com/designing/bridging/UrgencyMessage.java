package com.designing.bridging;

/**
 * 加急消息类
 */
public class UrgencyMessage extends AbstractMessage{

    public UrgencyMessage(MessageImplementor impl) {
        super(impl);
    }

    @Override
    public void sendMessage(String message, String toUser) {
        message = "加急" + message;
        super.sendMessage(message, toUser);
    }

    /**
     * 扩展功能  监控某消息的处理状态
     * @param messageId  被监控的消息编号
     * @return  监控到消息的处理状态
     */
    public Object watch(String messageId){
        return null;
    }
}
