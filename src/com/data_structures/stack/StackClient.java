package com.data_structures.stack;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * 数据结构  ->  堆栈
 * 常用方法
 * Object peek() 查看堆栈顶部的对象  但不从堆栈中移除它
 * Object pop() 移除堆栈顶部的对象 并作为此函数的值返回该对象
 * Object push(Object element) 把项压入堆栈顶部
 * int search(Object element) 返回对象在堆栈中的位置 以1为基准
 */
public class StackClient {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        System.out.println("stack: " + st);
        showPush(st, 42);
        showPush(st, 66);
        showPush(st, 99);
        showPop(st);
        showPop(st);
        showPop(st);
        try {
            showPop(st);
        } catch (EmptyStackException e){
            System.out.println("empty stack");
        }
    }
    static void showPush(Stack<Integer> st, int a){
        st.push(new Integer(a));
        System.out.println("push(" + a +")");
        System.out.println("stack: " + st);
    }

    static void showPop(Stack<Integer> st){
        System.out.println("pop ->");
        Integer a = (Integer) st.pop();
        System.out.println(a);
        System.out.println("stack: " + st);
    }
}
