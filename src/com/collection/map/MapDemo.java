package com.collection.map;

/**
 * Author by MyGoddess on 2020/11/11
 */
public class MapDemo {

    /**
     * Map(接口) ->  不能包含重复的键 每个键最多只能映射到一个值
     *
     * AbstractMap 继承于 Map -> 实现Map中核心API 其他map的实现类可以通过继承AbstractMap减少重复编码
     *
     * SortedMap 继承了Map的接口 -> SortedMap中的内容是排序的键值对 排序的方法是通过实现比较器(Comparator)完成的
     *
     * NavigableMap 继承了SortedMap的接口
     *
     * HashMap 继承于AbstractMap 但没有实现NavigableMap接口 HashMap的主要作用时存储无序的键值对
     */
}
