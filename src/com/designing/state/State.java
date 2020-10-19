package com.designing.state;

/**
 * 状态模式
 * 举例 -> 糖果机
 */
public interface State {
    void insertCoin(); // 塞入硬币
    void returnCoin(); // 回退硬币
    void turnCrank();  // 转动曲柄
    void dispense();   // 分配
    void printState(); // 输出状态
}
