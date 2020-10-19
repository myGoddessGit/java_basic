package com.designing.decorator;

public class DecoratorImpl {
    /**
     * 装饰者A
     */
    public static class ManDecoratorA extends Decorator {
        @Override
        public void eat() {
            super.eat();
            reEat();
            System.out.println("ManDecoratorA类");
        }

        public void reEat(){
            System.out.println("我还要吃一碗");
        }
    }

    /**
     * 装饰者B
     */
    public static class ManDecoratorB extends Decorator {
        @Override
        public void eat() {
            super.eat();
            System.out.println("-------------");
            System.out.println("ManDecoratorB");
        }
    }
}
