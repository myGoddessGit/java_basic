package com.designing.state;

/**
 * 准备状态
 */
public class OnReadyState implements State{

    private CandyMachine mCandyMachine;
    public OnReadyState(CandyMachine candyMachine){
        this.mCandyMachine = candyMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("请插入一个硬币, 在转动曲柄之前");
        mCandyMachine.setState(mCandyMachine.mHasCoin);
    }

    @Override
    public void returnCoin() {
        System.out.println("你还没有插入硬币!");
    }

    @Override
    public void turnCrank() {
        System.out.println("想转动曲柄, 但你还没有插入硬币!");
    }

    @Override
    public void dispense() {

    }

    @Override
    public void printState() {
        System.out.println("---OnReadyState---");
    }
}
