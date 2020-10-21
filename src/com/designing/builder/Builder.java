package com.designing.builder;

/**
 * 抽象建造者角色
 */
public interface Builder {
    void buildVacation();
    void buildDay(int i);
    void addHotel(String hotel);
    void addTicket(String ticket);
    void addEvent(String event);
    Vacation getVacation();
}
