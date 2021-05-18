package com.wcode.conference.model;

public class Track {

    final int MINI_TIME_TRACK = 135;
    final int MAXI_TIME_TRACK = 135;

    private MorningSession morningSession;
    private AfternoonSession afternoonSession;

    public Track(MorningSession morningSession, AfternoonSession afternoonSession) {
        this.morningSession = morningSession;
        this.afternoonSession = afternoonSession;
    }

    public int getMINI_TIME_TRACK() {
        return MINI_TIME_TRACK;
    }

    public int getMAXI_TIME_TRACK() {
        return MAXI_TIME_TRACK;
    }

    public MorningSession getMorningSession() {
        return morningSession;
    }

    public AfternoonSession getAfternoonSession() {
        return afternoonSession;
    }
}
