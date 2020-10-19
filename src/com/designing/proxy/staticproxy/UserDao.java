package com.designing.proxy.staticproxy;

/**
 * 接口实现
 * 目标对象
 */
public class UserDao implements IUserDao{
    @Override
    public void save() {
        System.out.println("保存数据!!!");
    }
}
