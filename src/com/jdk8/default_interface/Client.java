package com.jdk8.default_interface;

/**
 * Author by MyGoddess on 2020/11/14
 */
public class Client {
    public static void main(String[] args) {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a);
            }
        };
        System.out.println(formula.calculate(100));
        System.out.println(formula.sqrt(16));
    }
}
