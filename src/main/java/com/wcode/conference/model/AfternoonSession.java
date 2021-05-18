package com.wcode.conference.model;

import java.util.List;

public class AfternoonSession extends Session {

    public final int MINI_TIME_SESSION = 180;
    public final int MAXI_TIME_SESSION = 240;

    public final String TIME_START_SESSION = "13:00:00";
    List<Talk> talkList;

    public AfternoonSession() {
    }

    public int getMINI_TIME_SESSION() {
        return MINI_TIME_SESSION;
    }

    public int getMAXI_TIME_SESSION() {
        return MAXI_TIME_SESSION;
    }

    public List<Talk> getTalksList() {
        return talkList;
    }

    public void setTalkList(List<Talk> talkList) {
        this.talkList = talkList;
    }

}
