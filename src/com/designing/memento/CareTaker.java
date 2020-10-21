package com.designing.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * 看守人类
 */
public class CareTaker {

    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento state){
        mementoList.add(state);
    }

    public Memento get(int index){
        return mementoList.get(index);
    }
}
