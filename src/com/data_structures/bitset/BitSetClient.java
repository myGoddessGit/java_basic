package com.data_structures.bitset;

import java.util.BitSet;

/**
 * java 数据结构 位集合
 * 实现了一组可以单独设置和清除的位或标志
 */
public class BitSetClient {
    public static void main(String[] args) {
        BitSet bitSet1 = new BitSet(16);
        BitSet bitSet2 = new BitSet(16);
        for (int i = 0; i < 16; i++){
            if (i % 2 == 0)bitSet1.set(i);
            if (i % 5 != 0)bitSet2.set(i);
        }
        System.out.println("Initial pattern in bitSet1: ");
        System.out.println(bitSet1);
        System.out.println("\nInitial pattern in bitSet2:");
        System.out.println(bitSet2);

        /**
         * And bits
         */
        bitSet2.and(bitSet1);
        System.out.println("\nbitSet2 and bitSet1: ");
        System.out.println(bitSet2);

        /**
         * or  bits
         */
        bitSet2.or(bitSet1);
        System.out.println("\nbitSet2 or bitSet1: ");
        System.out.println(bitSet2);

        /**
         * xor bitSets
         */
        bitSet2.xor(bitSet1);
        System.out.println("\nbitSet2 xor bitSet1: ");
        System.out.println(bitSet2);
    }
}
