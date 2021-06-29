package com.algorithm.sort_basic;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * @Author by chenYl on 2021/6/28 14:17
 * @Description :
 * @VERSION :
 * @TITLE :
 */
public class ForkJoinTest {

    static class SortTask extends RecursiveAction {
        final int[] array;
        final int left;
        final int right;
        private int THRESHOLD = 10000; // 设置序列长度为THRESHOLD时不再新开线程
        public SortTask(int[] array){
            this.array = array;
            this.left = 0;
            this.right = array.length - 1;
        }

        public SortTask(int[] array, int left, int right){
            this.array = array;
            this.left = left;
            this.right = right;
        }

        @Override
        protected void compute() {
            if (right - left < THRESHOLD){
                sequentiallySort(array, left, right);
            } else {
                //System.out.println("多线程。。。");
                int pivot = partition(array, left, right);
                new SortTask(array, left, pivot - 1).fork();
                new SortTask(array, pivot + 1, right).fork();
            }
        }

        private int partition(int[] array, int left, int right){
            int x = array[right];
            int i = left - 1;
            for (int j = left; j < right; j++){
                if (array[j] <= x){
                    i++;
                    swap(array, i, j);
                }
            }
            swap(array, i + 1, right);
            return i + 1;
        }

        private void swap(int[] array, int i, int j){
            if (i != j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        private void sequentiallySort(int[] array, int left, int right){
            Arrays.sort(array, left, right + 1);
        }
    }

    private static final int NARRAY = 1000 * 1000; // 随机生成序列的长度
    private int[] array = new int[NARRAY];
    private Random rand = new Random();
    public void setUp(){
        for (int i = 0; i < array.length; i++){
            array[i] = rand.nextInt(1000 * 1000  * 10);
        }
    }

    private boolean checkSorted(int[] a){
        for (int i = 0; i < a.length - 1; i++){
            if (a[i] > a[i + 1]) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        ForkJoinTest test = new ForkJoinTest();
        test.setUp();
        long startTime = System.currentTimeMillis(); // 获取开始时间
        Arrays.sort(test.array, 0, test.array.length);
        long endTime = System.currentTimeMillis(); // 获取结束时间
        System.out.println("单线程快排总耗时: " + (endTime - startTime) + "ms");

        if (test.checkSorted(test.array)) {
            System.out.println("wright sort.");
        }

        test.setUp();
        startTime = System.currentTimeMillis(); // 获取开始时间
        ForkJoinTask sort = new SortTask(test.array);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(sort);
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(30, TimeUnit.SECONDS);
        endTime = System.currentTimeMillis(); // 获取结束时间
        System.out.println("多线程快排总用时: " + (endTime - startTime) + "ms");
        if (test.checkSorted(test.array)) {
            System.out.println("wright sort.");
        }
    }
}
