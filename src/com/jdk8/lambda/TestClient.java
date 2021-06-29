package com.jdk8.lambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Author by MyGoddess on 2020/11/14
 */
public class TestClient {
    private List<String> names = Arrays.asList("faker", "uzi", "smlz", "clearlove");

    void test(){
        // 普通方法
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        // lambda
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });

        Collections.sort(names, (String a, String b) -> b.compareTo(a));

        names.sort((a, b) -> b.compareTo(a));


        names.stream().filter(s -> s.contains("z"))
                .map(String::toLowerCase)
                .sorted()
                .forEach(System.out::println);


        Stream.of("a", "b", "c", "d")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("a");
                });
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 7);

        List<Integer> squareList = numbers.stream()
                .map(i -> i * i)
                .sorted((x, y) -> y - x)
                .collect(Collectors.toList());
        squareList.forEach(num -> {
            num++;
            System.out.println(num);
        });
    }
}
