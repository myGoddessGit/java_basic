package com.designing.iterator;

public class TestIterable {
    public static void main(String[] args) {
        new TestIterable();
    }
    TestIterable(){
        ScanTest appleTree = new ScanTest();
        System.out.println("采用系统自带的迭代器iterator");
        // 系统自带的迭代器
        for (String str : appleTree){
            System.out.println(str);
        }
        System.out.println("--------------------------");
        System.out.println("采用自己实现的迭代器, 让其相反输出");
        for (String str : appleTree.reverseIterator()){
            System.out.println(str);
        }
    }
}
