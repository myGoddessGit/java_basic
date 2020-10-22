package com.collection;

/**
 * 排序实体类
 */
public class SortB {

    private String name;
    private Integer order;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return "name:" + name + "--order:" + order;
    }
}
