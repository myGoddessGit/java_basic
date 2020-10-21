package com.designing.medium;

/**
 * 创建QQ接口 接口中有一对一聊天方法 创建群接口 和 群发接口消息
 */
public interface QQ {
    void setMessage(User from, User to, String msg);

    void addUser(User user);

    void setAllMessage(User from, String msg);
}
