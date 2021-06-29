package com.os;

/**
 * @Author by chenYl on 2021/2/7 14:10
 * @Description :
 * @VERSION :
 * @TITLE :
 */
public class RunTimeTest {
    public static void main(String[] args) {
        System.out.println(calPrice(1.5,0.65));
    }

    static double calPrice(double a, double b){
        return a / b;
    }
}
