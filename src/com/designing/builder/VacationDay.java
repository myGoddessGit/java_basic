package com.designing.builder;

import java.util.ArrayList;
import java.util.Date;

/**
 * 假期中的每一天用该类表示
 */
public class VacationDay {
    private Date date;
    private String hotel;
    private ArrayList<String> events;
    private ArrayList<String> tickets;
    public VacationDay(Date dt){
        date = dt;
        events = new ArrayList<>();
        tickets = new ArrayList<>();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public void addEvents(String event){
        events.add(event);
    }

    public void addTickets(String ticket){
        tickets.add(ticket);
    }

    @Override
    public String toString() {
        return date + "VacationDay>>>>>" +
                "date="  + date +
                ", hotel='" + hotel + '\'' +
                ", events='" + events + '\'' +
                ", tickets='" + tickets;
    }
}
