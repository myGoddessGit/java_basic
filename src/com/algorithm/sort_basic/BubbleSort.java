package com.algorithm.sort_basic;


import com.data_structures.ArrayUtil;

/**
 * Author by MyGoddess on 2020/10/29
 *
 * 冒泡排序
 * 冒泡排序是一种交换排序
 * 交换排序 两两比较待排序的关键字 并交换不满足次序要求的那对数 直到整个表都满足次序要求为止
 *
 * 时间复杂度 (O(N2) (平均时间复杂度)
 * 数据越接近正序 性能越好
 */
public class BubbleSort {

    private static void bubbleSort(int[] list){
        int temp = 0; // 用来交换的临时数
        // 要遍历的次数
        for (int i = 0; i < list.length - 1; i++){
            // 从后向前依次的比较相邻两个数的大小 遍历一次后 把数组中第i小的数放在第i个位置
           for (int j = list.length - 1; j > i; j--){

               if (list[j - 1] > list[j]){
                   temp = list[j - 1];
                   list[j - 1] = list[j];
                   list[j] = temp;
               }
           }
            System.out.format("第 %d 趟: \t", i + 1);
            ArrayUtil.getArrayString(list, 0, list.length - 1);
        }
    }

    /**
     * 优化冒泡算法
     * @param list
     */
    private static void bubbleSortEx(int[] list){
        int temp = 0; // 用来交换的临时数
        boolean change = false; // 交换标记
        // 要遍历的次数
        for (int i = 0; i < list.length - 1; i++){
            change = false;
            // 从后向前依次的比较相邻两个数的大小 遍历一次后 把数组中第i小的数放在第i个位置
            for (int j = list.length - 1; j > i; j--){
                // 比较相邻的元素 如果前面的数大于后面的数 则交换
                if (list[j - 1] > list[j]){
                    temp = list[j - 1];
                    list[j - 1] = list[j];
                    list[j] = temp;
                    change = true;
                }
            }
            // 如果标记为false 说明本轮遍历没有交换 已经是有序数列 可以结束排序
            if (!change){
                break;
            }
            System.out.format("第 %d 趟: \t", i + 1);
            ArrayUtil.getArrayString(list, 0, list.length - 1);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[10];
        a[0] = 1;
        a[1] = 100;
        a[2] = 44;
        a[3] = 25;
        a[4] = 12;
        a[5] = 13;
        a[6] = 59;
        a[7] = 88;
        a[8] = 99;
        a[9] = 11;
        //bubbleSort(a);
        bubbleSortEx(a);
    }
}
