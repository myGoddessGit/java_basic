package com.algorithm.sort_basic;

import java.util.Arrays;

/**
 * Author by MyGoddess on 2020/11/2
 *
 * 简单选择排序
 *
 * 简单选择排序是一种选择排序
 * 每一趟从待排序的记录中选择关键字最小的记录 顺序放在已排序的记录序列末尾
 * 直到全部排序结束
 *
 * 平均复杂度 O(n2)
 * 空间复杂度 O(1)
 *
 * 不稳定
 *
 * 简单(复杂性)
 */
public class SimpleChooseSort {
    public static void main(String[] args) {
        int[] a = {10, 5, 7, 8, 4, 3, 6, 1, 2, 9};
        System.out.println("简单选择排序");
        System.out.println("排序前: " + Arrays.toString(a));
        sort(a);
        System.out.println("排序后: " + Arrays.toString(a));
    }

    private static void sort(int[] arr){
        // 需要遍历获得最小值的次数
        // 注意  当要排序N个数 已经经过N - 1次遍历后 已经是有序数列
        for (int i = 0; i < arr.length - 1; i++){
            int min = i; // 用来保存最小值的所索引
            // 寻找第 i 个小的数值
            for (int j = i + 1; j < arr.length; j++){
                if (arr[min] > arr[j]){
                    min = j;
                }
            }
            // 若min有变化 就将找到的第i个小的数值与第i个位置的数值交换
            if (min != i){
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
