package com.data_structures.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Author by MyGoddess on 2020/10/26
 * HashMap是无序的
 */
public class HashMapClient {

    /**
     * Map.Entry
     */
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");

        /**
         * 1.普遍使用 (由于二次取值 效率会比第二种和第三种慢一倍)
         */
        System.out.println("通过Map.KeySet遍历key和value");
        for (String key : map.keySet()){
            System.out.println("key= " + key + " and value= " + map.get(key));
        }

        /**
         * 2. 采用Iterator把HashMap中数据放到迭代器中 然后用while循环把迭代器中的数据读出来
         */
        System.out.println("通过Map.entrySet使用iterator遍历key和value: ");
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<String, String> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        /**
         * 3. 采用for循环遍历HashMap中的数据 使用方便 (数据量大时非常耗性能)
         */
        System.out.println("通过Map.entrySet遍历key和value");
        for (Map.Entry<String, String> entry : map.entrySet()){
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        /**
         * 4. 只能得到key
         */
        System.out.println("通过Map.values()遍历所有的value, 但不能遍历key");
        for (String v : map.values()){
            System.out.println("value= " + v);
        }
    }
}
