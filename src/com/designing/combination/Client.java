package com.designing.combination;

/**
 * 设计模式  -> 组合模式
 */
public class Client {
    public static void main(String[] args) {
        /**
         * 根节点
         */
        ConcreteCompany root = new ConcreteCompany("总公司");
        root.add(new DepartmentOne("总公司部门1"));
        root.add(new DepartmentTwo("总公司部门2"));

        /**
         * 子节点
         */
        ConcreteCompany comp = new ConcreteCompany("分公司");
        comp.add(new DepartmentOne("分公司部门1"));
        comp.add(new DepartmentTwo("分公司部门2"));
        root.add(comp);

        /**
         * 叶子节点1
         */
        ConcreteCompany comp1 = new ConcreteCompany("办事处1");
        comp1.add(new DepartmentOne("办事处1部门1"));
        comp1.add(new DepartmentTwo("办事处2部门2"));
        comp.add(comp1);

        ConcreteCompany comp2 = new ConcreteCompany("办事处2");
        comp2.add(new DepartmentOne("办事处2部门1"));
        comp2.add(new DepartmentTwo("办事处2部门2"));
        comp.add(comp2);

        root.disPlay(1);
        root.duty();
    }
}
