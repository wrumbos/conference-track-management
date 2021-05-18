package com.wcode.conference.model;

public class Talk {

    String tittle;
    int duration;

    public Talk(String tittle, int duration) {
        this.tittle = tittle;
        this.duration = duration;
    }

    public String getTittle() {
        return tittle;
    }

    public int getDuration() {
        return duration;
    }
}
