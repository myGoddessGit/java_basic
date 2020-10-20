package com.data_structures.enumeration;

import java.util.Enumeration;
import java.util.Vector;

/**
 * java 数据结构 -> 枚举接口 (不属于数据结构的范畴 但还是在使用)
 *  boolean hasMoreElements()
 *  测试此枚举类否包含更多的元素
 *
 *  Object nextElement()
 *  如果此枚举对象至少还有一个可提供的元素 则返回此枚举的下一个元素
 */
public class EnumerationTester {

    public static void main(String[] args) {
        Enumeration<String> days;
        Vector<String> dayNames = new Vector<>();
        dayNames.add("Sunday");
        dayNames.add("Monday");
        dayNames.add("Tuesday");
        dayNames.add("Wednesday");
        dayNames.add("Thursday");
        dayNames.add("Friday");
        dayNames.add("Saturday");
        days = dayNames.elements();
        while (days.hasMoreElements()){
            System.out.println(days.nextElement());
        }
    }
}
