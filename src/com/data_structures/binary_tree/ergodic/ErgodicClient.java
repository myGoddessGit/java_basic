package com.data_structures.binary_tree.ergodic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Author by MyGoddess on 2020/11/12
 *
 *
 * 二叉树的前中后序遍历
 */
public class ErgodicClient {


    /**
     *  中 左 右
     * 前序遍历 (递归)
     * @param root
     */
    public static void preOrder(TreeNode root){
        if (root != null){
            System.out.println(root.val + "\t");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    /**
     * 采用栈的方式 没有完全应用栈的思想 采用循环过程中输出的方式
     * 前序遍历 (非递归)
     */
    public static void preOrderNo(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                System.out.println(root.val + "\t"); // 在while循环中打印节点
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()){
                root = stack.pop();
                root = root.right;
            }
        }
    }

    /**
     * 左 中 右
     * 中序遍历 (递归)
     * @param root
     */
    public static void inOrder(TreeNode root){
        if (root != null){
            inOrder(root.left);
            System.out.println(root.val + "\t");
            inOrder(root.right);
        }
    }

    /**
     * 左 中 右
     * 中序遍历 (非递归)
     * @param root
     */
    public static void inOrderNo(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()){
                root = stack.pop();
                System.out.println(root.val + "/t"); // 在循环外打印 左中右
                root = root.right;
            }
        }
    }

    /**
     * 左 右 中
     * 后序遍历 (递归)
     * @param root
     */
    public static void postOrder(TreeNode root){
        if (root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.val + "\t");
        }
    }

    /**
     * 后序遍历 (非递归)
     * 方法一 : 用一个栈实现
     * @param head
     *
     * 用一个指针cur标记当前退出的节点是what
     */
    public static void postOrderNo(TreeNode head){
        if (head == null){
            return;
        }
        TreeNode cur = head;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()){
            TreeNode peek = stack.peek();
            if (peek.left != null && peek.left != cur && peek.right != cur){
                stack.push(peek.left);
            } else if (peek.right != null && peek.right != cur){
                stack.push(peek.right);
            } else {
                System.out.print(stack.pop().val + " ");
                cur = peek;
            }
        }
    }

    /**
     * 后序遍历 (非递归)
     * 方法二 : 用两个栈实现
     * @param head
     *
     * 参考前序遍历的过程是 中左右
     * 将其转化为中右左 -> 压栈的过程中优先压入左子树 在压入右子树
     * 然后将这个结果返回回来 -> 利用栈的先进后出倒序打印
     */
    public static void postOrderNo2(TreeNode head){
        if (head == null){
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(head);
        while (!stack1.isEmpty()){
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null){
                stack1.push(node.left);
            }
            if (node.right != null){
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()){ // 将打印顺序反向
            System.out.print(stack2.pop().val + " ");
        }
    }

    /**
     * 层序遍历
     * 1> 每一层都按从左到右的顺序打印节点
     */
    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root){
            if (root == null){
                return new ArrayList<List<Integer>>();
            }
            List<List<Integer>> list = new ArrayList<>();
            LinkedList<TreeNode> queue = new LinkedList<>(); // 先进先出队列
            queue.add(root);
            while (queue.size() != 0){
                ArrayList<Integer> temp = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++){
                    TreeNode node = queue.remove();
                    temp.add(node.val);
                    if (node.left != null){
                        queue.add(node.left);
                    }
                    if (node.right != null){
                        queue.add(node.right);
                    }
                }
                list.add(temp);
            }
            return list;
        }
    }
}
