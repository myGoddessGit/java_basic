package com.designing.proxy.staticproxy;

/**
 * 代理对象
 * 静态代理
 */
public class UserDaoProxy implements IUserDao{
    private IUserDao target;
    public UserDaoProxy(IUserDao target){
        this.target = target;
    }
    @Override
    public void save() {
        System.out.println("开始.....");
        target.save();
        System.out.println("提交事务....");
    }
}
