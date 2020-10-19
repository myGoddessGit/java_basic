package com.designing.appearce;

/**
 * 接口调用子系统的具体实现
 */
public class FacadeImpl implements Facade {

    private SubSystem.SubSystemA subSystemA;
    private SubSystem.SubSystemB subSystemB;
    private SubSystem.SubSystemC subSystemC;

    public FacadeImpl(){
        subSystemA = new SubSystem.SubSystemA();
        subSystemB = new SubSystem.SubSystemB();
        subSystemC = new SubSystem.SubSystemC();
    }

    @Override
    public void methodA() {
        System.out.println("methodA");
        subSystemA.functionA();
    }

    @Override
    public void methodB() {
        System.out.println("methodB");
        subSystemB.functionB();
    }

    @Override
    public void methodC() {
        System.out.println("methodC");
        subSystemC.functionC();
    }
}
