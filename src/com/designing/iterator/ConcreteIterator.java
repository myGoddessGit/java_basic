package com.designing.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体迭代器角色
 */
public class ConcreteIterator implements Iterator{

    private List list =  new ArrayList();
    private int cursor = 0;

    public ConcreteIterator(List list){
        this.list = list;
    }

    @Override
    public Object next() {
        Object object = null;
        if (this.hasNext()){
            object = this.list.get(cursor++);
        }
        return object;
    }

    @Override
    public boolean hasNext() {
        if (cursor == list.size()){
            return false;
        }
        return true;
    }
}
