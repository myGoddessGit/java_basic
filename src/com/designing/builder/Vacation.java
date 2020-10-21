package com.designing.builder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * 产品角色
 */
public class Vacation {
    private Date date;
    private ArrayList<VacationDay> vacationDays = null;
    private int days = 0;
    private VacationDay vacationDay;
    public Vacation(String dt){
        vacationDays = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sdf.parse(dt);
            vacationDay = new VacationDay(date);
            vacationDays.add(vacationDay);
            days++;
        } catch (ParseException e){
            e.printStackTrace();
        }
    }

    public void setDate(String dt){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sdf.parse(dt);
        } catch (ParseException e){
            e.printStackTrace();
        }
    }

    public Date getDate() {
        return date;
    }

    /**
     * 获取下一天
     * @param n
     * @return
     */
    private Date nextDate(int n){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, n);
        return cal.getTime();
    }

    /**
     * 假期中的下一天
     */
    public void addDay(){
        vacationDay = new VacationDay(nextDate(days));
        vacationDays.add(vacationDay);
        days++;
    }

    public boolean setVacation(int i){
        if (i > 0 && i < vacationDays.size()){
            vacationDay = vacationDays.get(i);
            return true;
        }
        vacationDay = null;
        return false;
    }

    public void setHotel(String hotel){
        vacationDay.setHotel(hotel);
    }

    public void setEvent(String event){
        vacationDay.addEvents(event);
    }

    public void setTicket(String ticket){
        vacationDay.addTickets(ticket);
    }

    public void showInfo(){
        for (int i = 0; i < vacationDays.size(); i++){
            System.out.println("** " + (i + 1) + " day**");
            System.out.println(vacationDays.get(i).toString());
        }
    }
}
