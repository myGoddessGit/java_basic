package com.algorithm.sort_basic;

import java.util.*;

/**
 * Author by MyGoddess on 2020/11/2
 *
 * 基数排序
 *
 * 时间复杂度 O(d(n+r))
 *
 * 空间复杂度 O(n+r)
 *
 * 稳定性 => 稳定
 *
 * 比较复杂
 *
 * r为基数 d为位数
 */
public class BaseSort {
    public static void main(String[] args) {
        System.out.println("基数排序");
        int[] arr = { 321, 1234, 543, 324, 24, 960, 540, 672, 783, 1000 };
        radixSort(arr);
    }

    private static void radixSort(int[] arr){
        int digit = getMaxDigit(arr); // 获取最大数是多少位
        for (int i = 0; i < digit; i++){
            bucketSort(arr, i); // 执行digit次bucketSort排序即可
        }
        System.out.print(Arrays.toString(arr));
    }

    private static int getMaxDigit(int[] arr){
        int digit = 1; // 默认只有一位
        int base = 10; // 十进制每多一位 其值 * 10
        for (int i : arr){
            while (i > base){
                digit++;
                base *= 10;
            }
        }
        return digit;
    }

    private static void bucketSort(int[] arr, int digit){
        int base = (int) Math.pow(10, digit);
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < 10; i++){ // 十进制 只有0 - 9 这是个数 需要准备10个桶
            buckets.add(new ArrayList<>());
        }
        // sort
        for (int i : arr){
            int index = i / base % 10;
            buckets.get(index).add(i);
        }
        // output : copy back to arr
        int index = 0;
        for (List<Integer> bucket : buckets){
            for (int i : bucket){
                arr[index++] = i;
            }
        }
    }
}
