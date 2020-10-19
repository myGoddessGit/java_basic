package com.designing.combination;

/**
 * 部门类 叶子节点
 */
public class DepartmentOne implements Company {

    private String name;

    public DepartmentOne(String name){
        this.name = name;
    }

    @Override
    public void add(Company company) {

    }

    @Override
    public void remove(Company company) {

    }

    @Override
    public void disPlay(int depth) {
        StringBuffer stringBuffer = new StringBuffer("-");
        for (int i = 0; i < depth; i++){
            stringBuffer.append("-");
        }
        System.out.println(stringBuffer.append(name));
    }

    @Override
    public void duty() {
        System.out.println(name + "负责研发产品");
    }
}
