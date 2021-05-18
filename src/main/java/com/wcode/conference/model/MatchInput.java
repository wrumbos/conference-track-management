package com.wcode.conference.model;

public class MatchInput {

    private String tittle;
    private int time;

    public MatchInput(String tittle, int time) {
        this.tittle = tittle;
        this.time = time;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "MatchInput{" +
                "tittle='" + tittle + '\'' +
                ", time=" + time +
                '}';
    }
}
