package com.data_structures.binary_tree;

/**
 * Author by MyGoddess on 2020/11/11
 *
 * 二叉排序树结点类
 */
public class Node {

    private int value; // 值
    private Node left; // 左子树
    private Node right; // 右子树

    /**
     * 无参构造器
     */
    public Node(){}

    public Node(Node left, Node right, int value){
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public Node(int value){
        this.left = null;
        this.right = null;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }


}
