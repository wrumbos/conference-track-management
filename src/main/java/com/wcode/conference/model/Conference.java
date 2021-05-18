package com.wcode.conference.model;

import java.util.List;

public class Conference {

    public final int MINI_TIME_CONFERENCE = 360;
    public final int MAXI_TIME_CONFERENCE = 840;
    public final int MAX_TIME_TALKS = 60;
    public final int MAX_COUNT_TRACKS = 2;

    private List<Track> tracks;
    private String tittle;

    public Conference(List<Track> tracks, String tittle) {
        this.tracks = tracks;
        this.tittle = tittle;
    }

    public Conference() {
    }

    public int getMINI_TIME_CONFERENCE() {
        return MINI_TIME_CONFERENCE;
    }

    public int getMAXI_TIME_CONFERENCE() {
        return MAXI_TIME_CONFERENCE;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }
}
