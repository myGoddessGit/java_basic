package com.data_structures.linkedlist;

/**
 * Author by MyGoddess on 2020/10/29
 *
 * 链表 (Linked List) 是一种线性表 但并不会按照线性顺序存储数据
 * 每个节点里存放到下一个节点的指针(Pointer)
 */
public class LinkedList {
    /**
     * 单链表 =>
     * 单链表中的每个节点不仅包含数据值 还包含一个指针 指向其后继的节点
     * 通过这种方式  单链表将所有的节点按顺序组织起来
     *
     * 通过索引来访问元素 平均要花费O(N)事件 N为链表的长度
     */

    /**
     * 数据结构
     */
    static class ListNode<E>{
        E value;
        ListNode<E> next; // 指向后继节点
        ListNode<E> head;
        public ListNode(E head, E next) {

        }

        /**
         * 基本操作
         */

        /**
         * 头插法
         * @param value
         */
        void addHead(E value){
            ListNode<E> newNode = new ListNode<>(value, null);
            newNode.next = this.head.next;
            this.head.next = newNode;
        }

        /**
         * 尾插法
         * @param value
         */
        void addTail(E value){
           ListNode<E> newNode = new ListNode<>(value, null);
           ListNode<E> node = this.head;
           while (node.next != null){
               node = node.next;
           }
           node.next = newNode;
        }
        /**
         * 删除节点
         * 找到要删除元素的前驱节点，将前驱节点的 next 指针指向下一个节点
         */
        void remove(E value){
            ListNode<E> prev = this.head;
            while (prev.next != null){
                ListNode<E> curr = prev.next;
                if (curr.value.equals(value)){
                    prev.next = curr.next;
                    break;
                }
                prev = prev.next;
            }
        }

        /**
         * 从头开始查找，一旦发现有数值与查找值相等的节点，直接返回此节点。如果遍历结束，表明未找到节点，返回 null
         * @param value
         * @return
         */
        ListNode<E> find(E value){
            ListNode<E> node = this.head.next;
            while (node != null){
                if (node.value.equals(value)){
                    return node;
                }
                node = node.next;
            }
            return null;
        }
    }

    static class SingleLinkList<E>{
        private ListNode<E> head;  // 头节点
    }

    /**
     * 双链表
     * 双链表中的每个结点不仅包含数据值，还包含两个指针，分别指向指向其前驱节点和后继节点
     */

    static class DListNode<E> {
        E value;
        DListNode<E> prev; // 指向
        DListNode<E> next;

        public DListNode(E head, E value, E next) {

        }

    }

    /**
     * 基本操作
     * @param <E>
     */
    public class DoubleLinkedList<E>{
        /** 头节点*/
        private DListNode<E> head;
        /** 尾节点*/
        private DListNode<E> tail;

        /**
         * 头插法
         * @param value
         */
        void addHead(E value){
            DListNode<E> newNode = new DListNode<>(null, value, null);
            // 新节点 => 头节点的下一个节点的前驱
            this.head.next.prev = newNode;
            // 头节点的下一个节点 => 新节点的下一个节点
            newNode.next = this.head.next;
            this.head.next = newNode;
            newNode.prev = this.head;
        }

        /**
         * 尾插法
         * @param value
         */
        void addTail(E value){
            DListNode<E> newNode = new DListNode<>(null, value, null);
            this.tail.prev.next = newNode;
            newNode.prev = this.tail.prev;
            this.tail.prev = newNode;
            newNode.next = this.tail;
        }

        /**
         * 删除节点
         * @param value
         */
        void remove(E value){
            DListNode<E> prev = this.head;
            while (prev.next != this.tail){
                DListNode<E> curr = prev.next;
                if (curr.value.equals(value)){
                    prev.next = curr.next;
                    curr.next.prev = prev;
                    curr.next = null;
                    curr.prev = null;
                    break;
                }
                prev = prev.next;
            }
        }

        /**
         * 查找节点
         * @param value
         * @return
         */
        DListNode<E> find(E value){
            DListNode<E> node = this.head.next;
            while (node != this.tail){
                if (node.value.equals(value)){
                    return node;
                }
                node = node.next;
            }
            return null;
        }
    }
}
