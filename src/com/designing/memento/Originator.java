package com.designing.memento;

/**
 * 发起人类
 */
public class Originator {

    private String state;

    public void setState(String state){
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento saveStateToMemento(){
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento){
        state = memento.getState();
    }
}