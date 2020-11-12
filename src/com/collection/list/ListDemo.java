package com.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * Author by MyGoddess on 2020/11/11
 *
 */
public class ListDemo {
    private ArrayList arrayList = null;
    private LinkedList linkedList = null;

    /**
     * ArrayList 和 LinkedList
     *
     * ArrayList 基于动态数组实现 存在容量限制 当元素数超过最大容量时 会自动扩容
     * 特性 -> 随机访问速度较快  随机插入 删除速度较慢 线程不安全
     * ArrayList 删除元素(remove方法)时 -> 调用System.arrayCopy() 将
     * index + 1 后面的元素都复制到index上 (复制的代价很大)
     *
     * LinkedList 基于双向链表实现 不存在容量限制
     * 特性 -> 随机插入 删除速度较快 随机访问速度较慢 线程不安全
     * LinkedList 内部维护了一个双链表
     *
     * Vector 和 Stack 都是线程安全的 (Demo 见 (data_structures.stack 和 vector))
     *
     *
     *
     */


    static void test(){
        int[] a = {1, 2, 3};
        List list = Arrays.stream(a).boxed().collect(Collectors.toList());
        System.out.println(list.size());
    }
    /**
     * LinkedList双向链表
     * @param <E>
     */
    private static class Node<E> {
        E item;  // 具体值
        Node<E> next; // 该节点的下一个结点
        Node<E> prev; // 该结点的前一个结点

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public static void main(String[] args) {
        test();
    }
}
