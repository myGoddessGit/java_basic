package com.designing.state;

/**
 * 状态模式
 * 与策略模式的区别
 * 策略模式是在求解同一个问题的多种解法，这些不同解法之间毫无关联；
 * 状态模式则不同，状态模式要求各个状态之间有所关联，以便实现状态转移。
 */
public class StateClient {
    public static void main(String[] args) {
        CandyMachine mCandyMachine = new CandyMachine(6);
        mCandyMachine.printState();
        mCandyMachine.insertCoin();
        mCandyMachine.printState();
        mCandyMachine.turnCrank();
        mCandyMachine.printState();
        mCandyMachine.insertCoin();
        mCandyMachine.printState();
        mCandyMachine.turnCrank();
        mCandyMachine.printState();
    }
}
