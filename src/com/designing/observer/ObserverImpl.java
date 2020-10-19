package com.designing.observer;

public class ObserverImpl {

    public static class BinaryObserver extends Observer {
        public BinaryObserver(Subject subject){
            this.subject = subject;
            subject.attach(this);
        }
        @Override
        public void upData() {
            System.out.println("BinaryObserver观察到的物体状态更新为: " + subject.getState());
        }
    }

    public static class HexObserver extends Observer {
        public HexObserver(Subject subject){
            this.subject = subject;
            subject.attach(this);
        }
        @Override
        public void upData() {
            System.out.println("HexObserver观察到的物体状态更新为: " + subject.getState());
        }
    }

    public static class OctalObserver extends Observer {
        public OctalObserver(Subject subject){
            this.subject = subject;
            subject.attach(this);
        }
        @Override
        public void upData() {
            System.out.println("OctalObserver观察到的物体状态更新为: " + subject.getState());
        }
    }

}
