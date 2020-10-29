package com.designing.iterator;

/**
 * 容器角色
 */
public interface Aggregate {
    void add(Object obj);
    void remove(Object obj);
    Iterator iterator();
}
