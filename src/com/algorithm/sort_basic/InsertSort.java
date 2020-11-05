package com.algorithm.sort_basic;

import java.util.Arrays;

/**
 * Author by MyGoddess on 2020/10/30
 *
 * 插入排序
 *
 * 排序方法  直接插入排序
 *
 * 平均时间复杂度O(N2)
 *
 * 空间复杂度 O(1)
 *
 * 数据越接近正序时 直接插入排序的算法性能越好
 *
 * 直接插入排序 不需要改变相等数字元素的位置 故此它是稳定的算法
 */
public class InsertSort {

    public static void main(String[] args) {
//        int[] ints = {2, 3, 5, 1, 23, 6, 78, 34};
//        int[] ints2 = sort(ints);
//        for (int i : ints2){
//            System.out.print(i + "\t");
//        }
        int[] a = { 38,65,97,76,13,27,49 };
        System.out.println("插入排序");
        insertSort(a);
        System.out.println(Arrays.toString(a));
    }

    private static int[] sort(int[] ins){
        for (int i = 1; i < ins.length; i++){
            for (int j = i; j > 0; j--){
                if (ins[j] < ins[j - 1]){
                    int temp = ins[j - 1];
                    ins[j - 1] = ins[j];
                    ins[j] = temp;
                }
            }
        }
        return ins;
    }
    private static void insertSort(int[] a){
        int i, j, insertNode; // 要插入的数据
        for (i = 1; i < a.length; i++){ // 从数组的第二个元素开始循环将数组中的元素插入
            insertNode = a[i]; // 设置数组中的第2个元素为第一次循环要插入的数据
            j = i - 1;
            while (j >=0 && insertNode < a[j]){
                a[j + 1] = a[j]; // 如果要插入的元素小于第j个元素 就将第j个元素向后移动
                j--;
            }
            a[j + 1] = insertNode; // 直到要插入的元素不小于第j个元素 将insertNode插入到数组中
        }
    }
}
