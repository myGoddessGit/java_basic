package com.designing.interpreter;

/**
 * 抽象表达式角色
 */
public abstract class Expression {
    /**
     * 以环境为准  本方法 解释给定的任何一个表达式
     * @param ctx
     * @return
     */
    public abstract boolean interpret(Context ctx);

    /**
     * 检验两个表达式在结构上是否相同
     * @param obj
     * @return
     */
    public abstract boolean equals(Object obj);

    /**
     * 返回表达式的hash code
     * @return
     */
    public abstract int hashCode();

    /**
     * 将表达式转换成字符串
     * @return
     */
    public abstract String toString();
}
