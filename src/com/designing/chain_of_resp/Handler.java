package com.designing.chain_of_resp;


/**
 * 抽象处理者角色
 */
public abstract class Handler {

    /**
     * 持有下一个处理请求的对象
     */
    protected Handler successor = null;

    /**
     * 取值方法
     * @return
     */
    public Handler getSuccessor() {
        return successor;
    }

    /**
     * 设置下一个请求的对象
     * @param successor
     */
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    /**
     * 处理聚餐费用的请求
     * @param user  申请人
     * @param free  申请的钱数
     * @return  成功或者失败的通知
     */
    public abstract String handleFreeRequest(String user, double free);
}
