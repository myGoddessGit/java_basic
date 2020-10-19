package com.designing.combination;

/**
 * 公司接口
 */
public interface Company {
    void add(Company company);

    void remove(Company company);

    /**
     * 展示树形结构
     * @param depth
     */
    void disPlay(int depth);

    /**
     * 不同部门所具有各自的职责
     */
    void duty();
}
