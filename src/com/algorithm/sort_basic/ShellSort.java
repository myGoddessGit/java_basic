package com.algorithm.sort_basic;

import java.util.Arrays;

/**
 * Author by MyGoddess on 2020/11/2
 *
 * 希尔排序
 *
 * 希尔排序是一种插入排序
 *
 * 不稳定
 *
 * 比较复杂
 *
 * 平均时间复杂度 O(Nlog2N)
 *
 * 希尔排序中最主要的操作时比较 而不是交换
 *
 * 不稳定算法
 *
 * 比较 : 直接插入排序适用于链式存储结构 希尔排序不适用链式结构
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] ins = {2,3,5,1,23,6,78,34,23,4,5,78,34,65,32,65,76,32,76,1,9};
        System.out.println("希尔排序");
        for (int i : sort(ins)){
            System.out.println(i + "\t");
        }
        shellSort(ins);
    }

    private static int[] sort(int[] ins){
        int n = ins.length; // 数组的长度
        int gap = n / 2; // 数组的一半(偶数的一半 奇数减一的一半)
        while (gap > 0){
            for (int j = gap; j < n; j++){
                int i = j;
                while (i >= gap && ins[i - gap] > ins[i]){
                    int temp = ins[i - gap] + ins[i];
                    ins[i - gap] = temp - ins[i - gap];
                    ins[i] = temp - ins[i - gap];
                    i -= gap;
                }
            }
            gap = gap / 2;
        }
        return ins;
    }

    private static void shellSort(int[] list){
        int gap = list.length / 2;
        while (gap >= 1){
            // 把距离为gap的元素编为一个组  扫描所有组
            for (int i = gap; i < list.length; i++){
                int j = 0;
                int temp = list[i];
                // 对距离为gap 的元素进行排序
                for (j = i - gap; j >= 0 && temp < list[j]; j = j - gap){
                    list[j + gap] = list[j];
                }
                list[j + gap] = temp;
            }
            System.out.format("gap = %d:\t", gap);
            System.out.println(Arrays.toString(list));
            gap = gap / 2; // 减小增量
        }
    }
}
