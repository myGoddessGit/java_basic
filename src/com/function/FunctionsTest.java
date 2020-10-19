package com.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author cyl
 * @date 2020/9/30
 */

public class FunctionsTest {

    public static void main(String[] args) {
        // Consumer 消费型接口
        happy(1000, (m) -> System.out.println(m + ""));

        // 供给型接口
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        for (Integer num : numList){
            System.out.println(num);
        }
    }

    private static void happy(double money, Consumer<Double> consumer){
        consumer.accept(money);
    }

    private static List<Integer> getNumList(int num, Supplier<Integer> sup){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++){
            Integer n = sup.get();
            list.add(n);
        }
        return list;
    }
}
