package com.io.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Author by MyGoddess on 2020/11/14
 */
public class StreamClient {
    /**
     * 元素是特定类型的对象 形成一个队列(Java 中的Stream并不会存储元素 而是按需计算)
     *
     * 数据源 流的来源 -> 可以是集合 数组 I/O channel 产生器generator等
     *
     * 聚合操作(类似SQL语句操作 比如filter map reduce find match sorted等)
     *
     * 与Collection操作不同的地方 Stream操作还有两个基础的特征:
     *      Piping : 中间操作都会返回流对象本身 这样多个操作可以串联成一个管道(如同流式风格)
     *      -> 对操作进行优化 => 比如延时执行(laziness) 和 短路(short-circuiting)
     *
     *      内部迭代 : Stream 提供了内部迭代的方式 通过访问者(Visitor)实现
     *

     /**
     * 生成流 :
     *      Stream() -> 为集合创建串行流
     *
     *      parallelStream() -> 为集合创建并行流
     */
    List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
    List<String> filtered = strings.stream().filter(strings -> !strings.isEmpty()).collect(Collectors.toList());

    /**
     * forEach
     * Stream 提供了新的方法"forEach"来迭代流中的每个数据
     */
    Random random = new Random();
    void test(){
        random.ints().limit(10).forEach(System.out::println);
    }

    /**
     * map方法用于通过设置的条件过滤出元素
     */
    void test2(){
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
    }

    /**
     * filter 方法用于通过设置的条件过滤出元素
     */
    void test3(){
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        // 获取空字符串的数量
        long count = strings.stream().filter(string -> string.isEmpty()).count();
    }

    /**
     * limit 方法用于获取指定数量的流
     */
    void test4(){
        random.ints().limit(10).forEach(System.out::println);
    }

    /**
     * sorted 方法用于对流进行排序
     */
    void test5(){
        Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);
    }

    /**
     * 并行程序 (parallel)
     * parallelStream 是流并行处理程序的代替方法
     */
    void test6(){
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        // 获取空字符串的数量
        long count = strings.parallelStream().filter(string -> string.isEmpty()).count();
    }

    void test7(){

    }
}
