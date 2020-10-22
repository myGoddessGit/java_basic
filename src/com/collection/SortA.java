package com.collection;

/**
 * 排序
 */
public class SortA implements Comparable<SortA>{

    private String name;
    private Integer order;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "name:" + name + "--order:" + order;
    }

    @Override
    public int compareTo(SortA o) {
        return o.getOrder().compareTo(this.order); // 倒序
    }
}
