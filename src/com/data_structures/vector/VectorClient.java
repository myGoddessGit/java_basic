package com.data_structures.vector;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 数据结构  ->  向量
 *
 * 动态数组 类似于ArrayList
 * 不同:
 * Vector 是同步访问的
 */
public class VectorClient {
    public static void main(String[] args) {
        Vector v = new Vector(3, 2);
        System.out.println("Initial size: " + v.size());
        System.out.println("Initial capacity: " + v.capacity());
        v.addElement(new Integer(1));
        v.addElement(new Integer(2));
        v.addElement(new Integer(3));
        v.addElement(new Integer(4));
        System.out.println("Capacity after four additions: " + v.capacity());
        v.addElement(new Double(5.45));
        System.out.println("Current capacity: " + v.capacity());
        v.addElement(new Double(6.08));
        v.addElement(new Integer(7));
        System.out.println("Current capacity: " + v.capacity());
        v.addElement(new Float(9.4));
        v.addElement(new Integer(10));
        System.out.println("Current capacity: " + v.capacity());
        v.addElement(new Integer(11));
        v.addElement(new Integer(12));
        System.out.println("First element: " + (Integer)v.firstElement());
        System.out.println("Last element: " + (Integer)v.lastElement());
        if (v.contains(new Integer(3))){
            System.out.println("Vector contains 3");
        }
        Enumeration vEnum = v.elements();
        System.out.println("\nElements in vector:");
        while (vEnum.hasMoreElements()){
            System.out.println(vEnum.nextElement() + " ");
        }
        System.out.println();
    }
}
