package com.keyword;

/**
 * Author by MyGoddess on 2020/11/5
 */
public class JavaKeyword {


    /**
     * transient -> 用于序列化
     * 用该关键字修饰的字段不会被持久化
     */

    /**
     * volatile -> 一种稍弱的同步机制
     * 用该关键字修饰的变量 -> 不会将该变量的操作与其他内存操作一起重排序(禁止指令重排)
     * 比较 -> 在访问volatile变量时不会执行加锁操作 因此就不会使执行线程阻塞
     * 比synchronized 关键字更轻量级的同步机制
     * volatile修饰的变量与普通变量性能消耗几乎相同(写操作稍慢 => 需在本地代码中插入许多内存屏障指令
     * 来保证处理器不发生乱序执行)
     */
}
