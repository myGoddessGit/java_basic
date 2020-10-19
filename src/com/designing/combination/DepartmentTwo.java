package com.designing.combination;

public class DepartmentTwo implements Company{

    private String name;
    public DepartmentTwo(String name){
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
        System.out.println(name + "负责销售");
    }
}
