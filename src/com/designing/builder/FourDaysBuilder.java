package com.designing.builder;

public class FourDaysBuilder implements Builder{

    private Vacation vacation;
    public FourDaysBuilder(String date){
        vacation = new Vacation(date);
    }

    @Override
    public void buildVacation() {
        addTicket("机票");
        addHotel("如家");
        addEvent("住宿");
        addEvent("晚餐");
        vacation.addDay();
        addTicket("公园门票");
        addEvent("游城市公园");
        addTicket("水族馆门票");
        addEvent("游水族馆");
        addHotel("希尔顿酒店");
        vacation.addDay();
        addEvent("中央公园");
        addTicket("观光bus");
        addHotel("万达酒店");
        vacation.addDay();
        addTicket("机票");
        addEvent("回家");
    }

    @Override
    public void buildDay(int i) {
        vacation.setVacation(i);
    }

    @Override
    public void addHotel(String hotel) {
        vacation.setHotel(hotel);
    }

    @Override
    public void addTicket(String ticket) {
        vacation.setTicket(ticket);
    }

    @Override
    public void addEvent(String event) {
        vacation.setEvent(event);
    }

    @Override
    public Vacation getVacation() {
        return vacation;
    }
}
