package com.algorithm.sort_basic;

import java.util.Arrays;

/**
 * Author by MyGoddess on 2020/11/2
 *
 * 堆排序
 *
 * 堆排序是一种选择排序
 *
 * 堆是一颗顺序存储的完全二叉树
 *
 * 时间复杂度均为 O(nlog2n)
 *
 * 空间复杂度O(1)
 *
 * 不稳定
 *
 * 比较复杂(复杂性)
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] a = {10, 5, 7, 8, 4, 3, 6, 1, 2, 9};
        System.out.println("堆排序");
        heapSort(a);
    }

    private static void heapAdjust(int[] array2, int parent, int length){
        int temp = array2[parent]; // temp保存当前的父结点
        int child = 2 * parent + 1; // 先获得左孩子
        while (child < length){
            // 如果有右孩子结点 并且右孩子结点的值大于左孩子结点 则选取右孩子结点
            if (child + 1 < length && array2[child] < array2[child + 1]){
                child++;
            }
            // 如果父结点的值已经大于孩子节点的值 则直接结束
            if (temp >= array2[child]){
                break;
            }
            // 把孩子结点的值赋给父结点
            array2[parent] = array2[child];
            // 选取孩子结点的左孩子结点 继续向下筛选
            parent = child;
            child = 2 * child + 1;
        }
        array2[parent] = temp;
    }

    private static void heapSort(int[] list){
        // 循环建立初始堆
        for (int i = list.length / 2; i >= 0; i--){
            heapAdjust(list, i, list.length);
        }

        for (int i = list.length - 1; i > 0; i--){
            // 最后一个元素和第一个元素进行交换
            int temp = list[i];
            list[i] = list[0];
            list[0] = temp;
            // 筛选R[0] 结点  得到i - 1个结点的堆
            heapAdjust(list, 0, i);
            System.out.format("第 %d 趟: \t", list.length - i);
            System.out.println(Arrays.toString(list));
        }
    }
}
