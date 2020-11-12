package com.data_structures.binary_tree;

/**
 * Author by MyGoddess on 2020/11/12
 */
public class BinarySortTreeClient {

    public static void main(String[] args) {
        BSTTools bstTools = new BSTTools();
        // 构建的二叉树没有相同元素
        int[] num = {4,7,2,1,10,6,9,3,8,11,2, 0, -2};
        for (int i = 0; i < num.length; i++){
            bstTools.insertNode(num[i]);
        }
        bstTools.sort();
        bstTools.delete(4);
        System.out.println("------------");
        bstTools.sort();
    }

    void test(){

    }
}
