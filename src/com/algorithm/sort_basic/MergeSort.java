package com.algorithm.sort_basic;


import java.util.Arrays;

/**
 * Author by MyGoddess on 2020/11/2
 *
 * 归并排序
 *
 * 排序方法为归并排序
 *
 * 该算法是建立在归并操作上的一种有效的排序算法 该算法是采用分治法(Divide and Conquer)的一个典型应用
 * 将已有序的子序合并 得到完全有序的序列; 即先使每个子序列段间有序 若两个有序表合并成一个有序表 称为二路归并排序
 *
 * 归并排序的形式就是一颗二叉树 它需要遍历的次数就是二叉树的深度 而根据完全二叉树的特性就可以得出它的时间复制度为O(nlog2n)
 *
 * 时间复杂度均为 O(nlog2n)
 *
 * 空间复杂度 O(n)
 *
 * 稳定(稳定性)
 *
 * 比较复杂
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] ins = {2,3,5,1,23,6,78,34,23,4,5,78,34,65,32,65,76,32,76,1,9};
        sort(ins);
    }

    private static void merge(int[] array, int low, int mid, int high){
        int i = low; // i是第一段序列的下标
        int j = mid + 1; // j是第二段序列的下标
        int k = 0; // k是临时存放合并序列的下标
        int[] array2 = new int[high - low + 1]; // array2是临时合并序列

        // 扫描第一段和第二段序列  直到有一个扫描结束
        while (i <= mid && j <= high){
            // 判断第一段和第二段取出的数哪个更小 将其存入合并序列 并继续向下扫描
            if (array[i] <= array[j]){
                array2[k] = array[i];
                i++;
                k++;
            } else {
                array2[k] = array[j];
                j++;
                k++;
            }
        }
        // 若第一段序列还没扫描完 将其全部复制到合并序列
        while (i <= mid){
            array2[k] = array[i];
            i++;
            k++;
        }
        // 若第二段序列还没有扫描完 将其全部复制到合并序列
        while (j <= high){
            array2[k] = array[j];
            j++;
            k++;
        }
        // 将合并序列复制到原始序列中
        for (k = 0, i = low; i <= high; i++, k++){
            array[i] = array2[k];
        }
    }
    private static void mergePass(int[] array2, int gap, int length){
        int i = 0;
        // 归并gap长度的像个相邻子表
        for (i = 0; i + 2 * gap - 1 < length; i = i + 2 * gap){
            merge(array2, i, i + gap - 1, i + 2 * gap - 1);
        }
        // 余下两个子表 后者长度小于gap
        if (i + gap - 1 < length){
            merge(array2, i, i + gap - 1, length - 1);
        }
    }

    private static int[] sort(int[] list){
        for (int gap = 1; gap < list.length; gap = 2 * gap){
            mergePass(list, gap, list.length);
            System.out.print("gap = " + gap + ":\t");
            System.out.println(Arrays.toString(list));
        }
        return list;
    }
}
