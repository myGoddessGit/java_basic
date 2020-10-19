package com.designing.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体公司  树枝节点
 */
public class ConcreteCompany implements Company{

    private List<Company> companyList = new ArrayList<>();

    private String name;

    public ConcreteCompany(String name){
        this.name = name;
    }


    @Override
    public void add(Company company) {
        companyList.add(company);
    }

    @Override
    public void remove(Company company) {
        if (companyList != null){
            companyList.remove(company);
        }
    }

    @Override
    public void disPlay(int depth) {
        StringBuffer stringBuffer = new StringBuffer("-");
        for (int i = 0; i < depth; i++){
            stringBuffer.append("-");
        }
        System.out.println(stringBuffer.append(name));
        for (Company company : companyList){
            company.disPlay(depth + 2);
        }
    }

    @Override
    public void duty() {
        for(Company company : companyList){
            company.duty();
        }
    }
}
