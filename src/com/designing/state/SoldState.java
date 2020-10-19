package com.designing.state;

/**
 * 售出状态
 */
public class SoldState implements State{

    private CandyMachine mCandyMachine;
    public SoldState(CandyMachine candyMachine){
        this.mCandyMachine = candyMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("请等待, 我们将会给你一个糖果");
    }

    @Override
    public void returnCoin() {
        System.out.println("你还没有插入硬币");
    }

    @Override
    public void turnCrank() {
        System.out.println("我们已经给你一个糖果, 转动曲柄得不到更多了");
    }

    @Override
    public void dispense() {
        mCandyMachine.releaseCandy();
        if (mCandyMachine.getCount() > 0){
            mCandyMachine.setState(mCandyMachine.mOnReadyState);
        } else {
            System.out.println("没有糖果了");
            mCandyMachine.setState(mCandyMachine.mSoldOutState);
        }
    }

    @Override
    public void printState() {
        System.out.println("---SoldState---");
    }
}
