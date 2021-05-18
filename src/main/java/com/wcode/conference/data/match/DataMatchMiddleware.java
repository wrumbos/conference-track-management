package com.wcode.conference.data.match;

public abstract class DataMatchMiddleware {

    private DataMatchMiddleware next;

    public DataMatchMiddleware linkWith(DataMatchMiddleware next){
        this.next = next;
        return next;
    }

    public abstract boolean check(String tittle, String time, String typeTime);

    protected boolean checkNext(String tittle, String time, String typeTime){
        if(next == null){
            return true;
        }
        return next.check(tittle, time, typeTime);
    }

}
