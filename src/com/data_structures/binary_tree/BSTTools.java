package com.data_structures.binary_tree;

import java.util.Stack;

/**
 * Author by MyGoddess on 2020/11/11
 */
public class BSTTools {
    private static Node root = null; // 创建一个唯一根节点

    /**
     * 插入节点
     * @param key 参数为key
     * @return
     */
    public boolean insertNode(int key){
        Node pNode = root;
        Node prev = null; //插入节点的父节点 设置其为null

        /**
         * 找到插入节点的相应位置
         */
        while (pNode != null){
            prev = pNode;
            if (key < pNode.getValue()){
                pNode = pNode.getLeft();
            } else if (key > pNode.getValue()){
                pNode = pNode.getRight();
            } else {
                return true;
            }
        }
        /**
         * 将节点插入到相应的位置
         */
        if (root == null){
            root = new Node(key);
        } else if (key > prev.getValue()){
            prev.setRight(new Node(key));
        } else {
            prev.setLeft(new Node(key));
        }
        return true;
    }

    public void sort(){
        // 用Stack来存储节点的值 stack 是堆存储 特点 : 先进先出 跟栈类似
        Stack<Node> stack = new Stack<Node>();
        Node node = root;
        // 从根节点开始遍历
        while (node != null || !stack.isEmpty()){
            // 如果根节点不为null 就循环先将左子树节点不断压入堆中
            while (node != null){
                stack.push(node);
                node = node.getLeft();
            }
            // stack.pop() 方法表示移除并返回栈顶元素
            node = stack.pop();
            // 打印栈顶元素的值 即该节点的值
            System.out.println(node.getValue());
            node = node.getRight();
        }
    }

    /**
     * 递归中序遍历二叉树 ->
     * 利用递归方法来遍历 先左子树 后根节点 再右子树
     * @param node
     */
    public static void sort(Node node){
        if (node == null){
            return;
        } else {
            sort(node.getLeft());
            System.out.println(node.getValue());
            sort(node.getRight());
        }
    }

    /**
     * 删除BST中的元素
     *
     * 从根节点开始查找相应的节点并删除
     * @param key
     */
    public void delete(int key){
        delete(root, key);
    }

    /**
     * 在BST 中删除有三种情况
     * 1. 要删除的元素key比根节点小
     * 2. 等于根节点
     * 3. 比根节点大
     *
     * 从指定的节点开始查找相应的节点并删除
     * @param node 节点
     * @param key
     * @return
     */
    public boolean delete(Node node, int key){
        if (node == null){
            return false;
        } else {
            if (key == node.getValue()){
                return deleteBST(node);
            } else if (key < node.getValue()){
                return delete(node.getLeft(), key);
            } else {
                return delete(node.getRight(), key);
            }
        }
    }

    /**
     * 当删除的key和node.getValue 相等时又分为三种情况 假定删除的节点为p
     * 1. 要删除的p节点是叶子节点 只需要修改它的双亲节点的指针为空
     * 2. 若p只有左子树或者右子树 直接用左子树 / 右子树代替p
     * 3. 若p既有左子树 又有右子树 用p左子树中最大的那个值代替p 重接其左子树
     * @param node
     * @return
     */
    private boolean deleteBST(Node node){
        Node temp = null;
        /**
         * 右子树空 只需要重接它的左子树
         * 如果是叶子节点 在此也把叶子节点删除了
         */
        if (node.getRight() == null){
            temp = node;
            node = node.getLeft();
            // 左子树空 重接它的右子树
        } else if (node.getLeft() == null){
            temp = node;
            node = node.getRight();
            // 左右子树均不为空
        } else {
            temp = node;
            Node sNode = node;
            // 转向左子树 然后向右走到“尽头”
            sNode = sNode.getLeft();
            while (sNode.getRight() != null){
                temp = sNode;
                sNode = sNode.getRight();
            }
            // 将左子树最大的值代替被删除节点
            node.setValue(sNode.getValue());
            // 将原来左子树最大值节点的左子树改为该节点父节点的右子树
            temp.setRight(sNode.getLeft());
        }
        return true;
    }

}
