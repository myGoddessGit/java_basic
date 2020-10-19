package com.designing.state;

import java.util.Random;

/**
 * 有硬币
 */
public class HasCoin implements State {
    private CandyMachine mCandyMachine;
    public HasCoin(CandyMachine candyMachine){
        this.mCandyMachine = candyMachine;
    }
    @Override
    public void insertCoin() {
        System.out.println("你不能塞入别的硬币");
    }

    @Override
    public void returnCoin() {
        System.out.println("退出硬币");
    }

    @Override
    public void turnCrank() {
        System.out.println("crank turn...!");
        Random ranWinner = new Random();
        int winner = ranWinner.nextInt(10);
        if (winner == 0){
            mCandyMachine.setState(mCandyMachine.mWinnerState);
        } else {
            mCandyMachine.setState(mCandyMachine.mSoldState);
        }
    }

    @Override
    public void dispense() {

    }

    @Override
    public void printState() {
        System.out.println("---HasCoin---");
    }
}
