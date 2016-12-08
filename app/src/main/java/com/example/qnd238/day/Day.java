package com.example.qnd238.day;

import static java.lang.Math.abs;

/**
 * Created by qnd238 on 12/8/2016.
 */

public class Day {
    private String day;
    private String[] week = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
    public Day(){
        day = week[0];
    }
    public Day(String day){
        this.day = day;
    }
    public void setDay(String day){
        this.day = day;
    }
    public String getDay(){
        return day;
    }
    public String nextDay(){
        int nextindex = index(day) + 1;
        return week[nextindex];

    }
    public String preDay(){
        int preindex = index(day) - 1;
        return week[preindex];

    }
    public String addDay(int number){
        int index=0;
        if(number>=0) {
             index = (number + index(day)) % 7;
        }
        else {
            index = 7-(abs(number + index(day)) % 7);
        }
        return week[index];

    }
    public int index(String day) {
        int index = 0;
        while (index < 7) {
            if (day.contains(week[index])) {
                break;
            }else {
                index++;
            }
        }
        return index;
    }
    }

