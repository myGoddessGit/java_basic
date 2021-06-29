package com.data_structures.heap;

/**
 * @Author by chenYl on 2021/4/15 16:40
 * @Description :  java堆
 * @VERSION :
 * @TITLE : 堆是一颗完全二叉树
 */
public class Heap {

    private Node[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap(int mx){
        maxSize = mx;
        currentSize = 0;
        heapArray = new Node[maxSize];
    }

    public boolean isEmpty(){
        return currentSize == 0;
    }

    public boolean isFull(){
        return currentSize == maxSize;
    }

    public boolean insert(int key){
        if (isEmpty()){
            return false;
        }
        Node newNode = new Node(key);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize++);
        return true;
    }

    /**
     * 向上调整
     * @param index 索引
     */
    public void trickleUp(int index){
        int parent = (index - 1) / 2;// 父节点的索引
        Node bottom = heapArray[index];// 将新加的尾部节点保存在bottom中
        while (index > 0 && heapArray[parent].getKey() < bottom.getKey()){
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent - 1) / 2;
        }
        heapArray[index] = bottom;
    }

    public Node remove(){
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0); // 向下调整
        return root;
    }

    /**
     * 向下调整
     * @param index 索引
     */
    public void trickleDown(int index){
        Node top = heapArray[index];
        int largeChildIndex;
        while (index < currentSize / 2){
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = leftChildIndex + 1;
            if (rightChildIndex < currentSize && heapArray[leftChildIndex].getKey() < heapArray[rightChildIndex].getKey()){
                largeChildIndex = rightChildIndex;
            } else {
                largeChildIndex = leftChildIndex;
            }
            if (top.getKey() >= heapArray[largeChildIndex].getKey()){
                break;
            }
            heapArray[index] = heapArray[largeChildIndex];
            index = largeChildIndex;
        }
        heapArray[index] = top;
    }

    /**
     * 根据索引改变堆中的某个数据
     * @param index
     * @param newValue
     * @return
     */
    public boolean change(int index, int newValue){
        if (index < 0 || index >= currentSize){
            return false;
        }
        int oldValue = heapArray[index].getKey();
        heapArray[index].setKey(newValue);
        if (oldValue < newValue){
            trickleUp(index);
        } else {
            trickleDown(index);
        }
        return true;
    }

    public void displayHeap(){
        System.out.println("heapArray(array format)");
        for (int i = 0; i < currentSize; i++){
            if (heapArray[i] != null){
                System.out.println(heapArray[i].getKey() + " ");
            } else {
                System.out.println("--");
            }
        }
    }

    /**
     * 结点
     */
    static class Node {
        private int iData;
        public Node(int key){
            iData = key;
        }

        public int getKey(){
            return iData;
        }

        public void setKey(int key){
            iData = key;
        }
    }
}
