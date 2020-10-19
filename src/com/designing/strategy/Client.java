package com.designing.strategy;

/**
 * 策略模式
 * Runnable -> Thread
 * 缺点 客户端需要知道所有策略模式的实现类
 * 用途 优化代码结构 优化大量的 if else 和 switch代码
 */
public class Client {
    public static void main(String[] args) {
        Strategy strategy = new ConcreteStrategyOne();
        StrategyContext strategyContext = new StrategyContext(strategy);
        strategyContext.execute();

        strategy = new ConcreteStrategyTwo();
        strategyContext = new StrategyContext(strategy);
        strategyContext.execute();
    }
}
