package com.designing.medium;

/**
 * 创建四个实体类
 */
public class UserImpl {
    public static class A implements User {
        @Override
        public void showMessage(String msg) {
            System.out.print("A" + msg + "\n");
        }
    }

    public static class B implements User {
        @Override
        public void showMessage(String msg) {
            System.out.print("B" + msg + "\n");
        }
    }

    public static class C implements User {
        @Override
        public void showMessage(String msg) {
            System.out.print("C" + msg + "\n");
        }
    }

    public static class D implements User {
        @Override
        public void showMessage(String msg) {
            System.out.print("D" + msg + "\n");
        }
    }
}
