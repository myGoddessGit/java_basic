package com.data_structures.properties;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

/**
 * 数据结构  Properties  (属性集)
 * Properties 继承于Hashtable
 * 属性列表中的每个键及其对应值都是一个字符串
 */
public class PropertiesClient {
    public static void main(String[] args) {
        Properties capitals = new Properties();
        Set states;
        String str;
        capitals.put("Illinois", "Springfield");
        capitals.put("Missouri", "Jefferson City");
        capitals.put("Washington", "Olympia");
        capitals.put("California", "Sacramento");
        capitals.put("Indiana", "Indianapolis");

        states = capitals.keySet();
        Iterator itr = states.iterator();
        while (itr.hasNext()){
            str = (String) itr.next();
            System.out.println("The capital of" + str + "is" + capitals.getProperty(str) + ".");
        }
        System.out.println();
        str = capitals.getProperty("Florida", "Not Found");
        System.out.println("The capital of Florida is" + str + ".");
    }
}
