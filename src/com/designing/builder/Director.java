package com.designing.builder;

/**
 * 导演角色
 */
public class Director {
    private Builder builder;
    public Director(Builder builder){
        this.builder = builder;
    }

    public void setBuilder(Builder builder){
        this.builder = builder;
    }

    public void construct(){
        builder.buildVacation();
        builder.getVacation().showInfo();
    }
}
