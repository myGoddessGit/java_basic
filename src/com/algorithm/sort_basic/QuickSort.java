package com.algorithm.sort_basic;

import com.data_structures.ArrayUtil;

/**
 * Author by MyGoddess on 2020/10/29
 *
 * 快速排序
 * 快速排序是一种交换排序
 */
public class QuickSort {

    private static int division(int[] list, int left, int right) {
        // 以最左边的数(left)为基准
        int base = list[left];
        while (left < right) {
            // 从序列右端开始 向左遍历 直到找到小于base的数
            while (left < right && list[right] >= base) {
                right--;
            }
            // 找到了比base小的元素 将这个元素放到最左边的位置
            list[left] = list[right];
            // 从序列左端开始 向右遍历 将这个元素放到最右边的位置
            while (left < right && list[left] <= base) {
                left++;
            }
            // 找到了比base大的元素 将这个元素放到最右边的位置
            list[right] = list[left];
        }
        // 最后将base放到left位置 此时 left位置的左侧数值应该都比left小
        // 而left位置的右侧数值应该都比left大
        list[left] = base;
        return left;
    }

    private static void quickSort(int[] list, int left, int right){
        // 左下标一定小于右下标 否则数组越界
        if (left < right){
            int base = division(list, left, right);
            System.out.format("base = %d: \t", list[base]);
            quickSort(list, left, base - 1);
            quickSort(list, base + 1, right);
        }
        ArrayUtil.getArrayString(list, 0, list.length - 1);
    }

    public static void main(String[] args) {
        int[] a = new int[11];
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
        a[10] = 0;
        quickSort(a, 3, 9);
    }
}
