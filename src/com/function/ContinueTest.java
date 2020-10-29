package com.function;

public class ContinueTest {
    public static void main(String[] args) {
        test : for (int x = 0; x < 5; x++){
            for (int y = 5; y > 0; y--){
                if (y == x){
                    continue test;
                }
                System.out.println(x + "," + y);
            }
        }
        System.out.println("Game Over");
    }
}
