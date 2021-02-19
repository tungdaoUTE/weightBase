package com.example.overweights.data.model.data;

public class DayMission {
    int id;
    String day;
    String ex;
    boolean status;

    public DayMission(int id, String day, String ex, boolean status) {
        this.id = id;
        this.day = day;
        this.ex = ex;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }
}
