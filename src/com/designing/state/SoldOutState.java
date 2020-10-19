package com.designing.state;

/**
 * 初始状态
 */
public class SoldOutState implements State{
    private CandyMachine mCandyMachine;

    public SoldOutState(CandyMachine candyMachine){
        this.mCandyMachine = candyMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("你不能塞入硬币, 糖果售完了");
    }

    @Override
    public void returnCoin() {
        System.out.println("你不能转动曲柄, 你还没有塞入硬币");
    }

    @Override
    public void turnCrank() {
        System.out.println("转动曲柄, 但是没有糖果了");
    }

    @Override
    public void dispense() {

    }

    @Override
    public void printState() {
        System.out.println("---SoldOutState---");
    }
}
