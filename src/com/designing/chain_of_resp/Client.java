package com.designing.chain_of_resp;

/**
 *  设计模式 -> 责任链模式
 */
public class Client {
    public static void main(String[] args) {
        /**
         * 组装责任链
         */
        Handler h1 = new GeneralManager();
        Handler h2 = new DeptManager();
        Handler h3 = new ProjectManager();
        h3.setSuccessor(h2);
        h2.setSuccessor(h1);

        String test1 = h3.handleFreeRequest("small", 300);
        System.out.println("test1= " + test1);

        String test2 = h3.handleFreeRequest("middle", 300);
        System.out.println("test2= " + test2);
        System.out.println("---------------------------------------");

        String test3 = h3.handleFreeRequest("small", 700);
        System.out.println("test1= " + test3);

        String test4 = h3.handleFreeRequest("middle", 700);
        System.out.println("test2= " + test4);
        System.out.println("---------------------------------------");

        String test5 = h3.handleFreeRequest("small", 1500);
        System.out.println("test1= " + test5);

        String test6 = h3.handleFreeRequest("middle", 1500);
        System.out.println("test2= " + test6);
        System.out.println("---------------------------------------");
    }
}
