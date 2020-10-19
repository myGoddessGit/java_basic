package com.designing.strategy;

public class StrategyContext {
    private Strategy strategy;
    public StrategyContext(Strategy strategy){
        this.strategy = strategy;
    }

    public void execute(){
        System.out.println("------");
        String result = strategy.run();
        System.out.println(result);
        System.out.println("-------");
    }
}
