package com.jdk8.default_interface;

import java.lang.reflect.Field;

/**
 * Author by MyGoddess on 2020/11/14
 */
public class Client {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class cache = Integer.class.getDeclaredClasses()[0];
        Field field = cache.getDeclaredField("cache");
        field.setAccessible(true);
        Integer[] array = (Integer[]) field.get(cache);
        array[130] = array[129];
        array[131] = array[129];
        Integer a = 1;
        if (a == (Integer) 1 && a == (Integer) 2 && a == (Integer)3){
            System.out.println("success!!!");
        }
    }
}
