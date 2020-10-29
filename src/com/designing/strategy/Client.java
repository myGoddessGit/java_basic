package com.designing.strategy;

/**
 * 策略模式
 * Runnable -> Thread
 * 缺点 客户端需要知道所有策略模式的实现类
 * 用途 优化代码结构 优化大量的 if else 和 switch代码
 * 将命令请求封装为一个对象  使得可用不同的请求来进行参数化
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
