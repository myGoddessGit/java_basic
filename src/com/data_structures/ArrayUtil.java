package com.data_structures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * Author by MyGoddess on 2020/10/29
 */
public class ArrayUtil {

    public static <T> String getArrayString(T[] list){
        return getArrayString(list, 0, list.length);
    }

    public static <T> String getArrayString(T[] list, int begin, int end){
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (int i = 0; i < begin; i++){
            sb.append("\t");
        }
        int count = 0;
        for (int i = begin; i <= end; i++){
            sb.append(list[i] + "\t");
            if (++count == 10){
                sb.append("\n");
                count = 0;
            }
        }
        return sb.toString();
    }

    public static String getArrayString(int[] list, int begin, int end){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < begin; i++){
            sb.append("\t");
        }
        int count = 0;
        for (int i = begin; i < end; i++){
            sb.append(list[i] + "\t");
            if (++count == 10){
                sb.append("\n");
                count = 0;
            }
        }
        sb.append(list[end]);
        System.out.println(sb.toString());
        return sb.toString();
    }

    /**
     * 随机指定范围内N个不重复的Int数组
     *
     * 在初始化的无重复待选数组中随机产生一个数放在结果中
     *
     * 将待选数组被随机到的数  用待选数组(len - 1)下标对应的数替换
     *
     * 然后从len - 2 里随机产生下一个随机数 以此类推
     * @param min  指定范围最小值
     * @param max  指定范围最大值
     * @param length 随机数个数
     * @return int[] 随机数结果集
     */
    public static int[] randomNoRepeatIntArray(int min, int max, int length){
        int len = max - min + 1;
        if (max < min || length > len){
            return null;
        }
        int[] source = new int[len];
        for (int i = min; i < min + len; i++){
            source[i - min] = i;
        }
        int[] result = new int[length];
        Random rd = new Random();
        int index = 0;
        for (int i = 0; i < result.length; i++){
            // 待选数组0到(len - 2)随机一个下标
            index = Math.abs(rd.nextInt() % len--);
            // 将随机到的数放在结果集
            result[i] = source[index];
            // 将待选数组中被随机到的数  用待选数组(len - 1)下标对应的数替换
            source[index] = source[len];
        }
        return result;
    }

    /**
     * 随机产生N个重复的Int数组
     * @param min  指定范围最小值
     * @param max  指定范围最大值
     * @param length  随机数个数
     * @return 随机数结果集
     */
    public static int[] randomRepeatIntArray(int min, int max, int length){
        int len = max - min + 1;
        if (max < min || length > len){
            return null;
        }
        int[] result = new int[length];
        for (int i = 0; i < result.length; i++){
            result[i] = (int)(Math.random() * max);
        }
        return result;
    }

    /**
     * 随机指定范围内N个不重复的Int数组
     *
     * 在初始化的无重复待选数组中随机产生一个数放在结果中
     *
     * 将待选数组被随机到的数  用待选数组(len - 1)下标对应的数替换
     *
     * 然后从len - 2 里随机产生下一个随机数 以此类推
     * @param min  指定范围最小值
     * @param max  指定范围最大值
     * @param length 随机数个数
     * @return int[] 随机数结果集
     */
    public static Integer[] randomNoRepeatIntegerArray(int min, int max, int length){
        int len = max - min + 1;
        if (max < min || length > len){
            return null;
        }
        // 初始化给定范围的待选数组
        Integer[] source = new Integer[len];
        for (int i = min; i < min + len; i++){
            source[i - min] = i;
        }

        Integer[] result = new Integer[length];
        Random rd = new Random();
        int index = 0;
        for (int i = 0; i < result.length; i++){
            // 待选数组0 到(len - 2)随机一个下标
            index = Math.abs(rd.nextInt() % len--);
            // 将随机到的数放在结果集
            result[i] = source[index];
            // 将待选数组中被随机到的数  用待选数组(len - 1)下标对应的数替换
            source[index] = source[len];
        }
        return result;
    }

    /**
     * 随机产生指定范围的N个重复的Integer数组
     * @param min   指定范围最小值
     * @param max   指定范围最大值
     * @param length 随机数的个数
     * @return 随机结果集
     */
    public static Integer[] randomRepeatIntegerArray(int min, int max, int length){
        int len = max - min + 1;

        if (max < min || length > len){
            return null;
        }

        Integer[] result = new Integer[length];
        for (int i = 0; i < result.length; i++){
            result[i] = (int)(Math.random() * max);
        }
        return result;
    }
}
