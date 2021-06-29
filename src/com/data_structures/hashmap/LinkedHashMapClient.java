package com.data_structures.hashmap;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Author by MyGoddess on 2020/10/26
 *
 * LinkedHashMap是有序的
 */
public class LinkedHashMapClient {

    private static final int MAXIMUM_CAPACITY = 1 << 30;

    private static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public static void main(String[] args) {
        System.out.println(tableSizeFor(6));
//        System.out.println(6 >>> 1 | 6);
    }
}
