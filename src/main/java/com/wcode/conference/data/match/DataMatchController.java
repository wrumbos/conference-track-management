package com.wcode.conference.data.match;

import com.wcode.conference.utils.ConfigProperties;

import static com.wcode.conference.constant.ConferenceConstant.*;

public class DataMatchController {

    private DataMatchMiddleware dataMatchMiddleware;

    String validationTypeTime = ConfigProperties.getProp().getProperty(TYPE_TIME_VALIDATE);
    int maxTime;

    public boolean processData(String tittle, String time, String typeTime, int maxTime){
        this.maxTime = maxTime;
        if(dataMatchMiddleware.check(tittle, time, typeTime)){
            return true;
        }
        return false;
    }

    public boolean isValidationTypeTime(String typeTime) {
        return validationTypeTime.equals(typeTime);
    }

    public boolean isValidateTime(int time) {
        return time > maxTime || time < 5;
    }

    public void setDataValidationMiddleware(DataMatchMiddleware dataMatchMiddleware) {
        this.dataMatchMiddleware = dataMatchMiddleware;
    }

}
