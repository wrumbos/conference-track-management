package com.wcode.conference.data.match;

import static com.wcode.conference.constant.ConferenceConstant.*;

public class NumberCheck extends DataMatchMiddleware {

    private DataMatchController dataMatchController;

    public NumberCheck(DataMatchController dataMatchController){
        this.dataMatchController = dataMatchController;
    }

    @Override
    public boolean check(String tittle, String time, String typeTime){
        boolean hasNumberTitlle;
        int numberTime;
        try {
             hasNumberTitlle = tittle.matches(PATTERNS_NOT_NUMBERS);
            numberTime = Integer.parseInt(time);
             if(hasNumberTitlle || dataMatchController.isValidateTime(numberTime)){
                 return false;
             }
        }catch (Exception e){
            return false;
        }
        return checkNext(tittle, time, typeTime);
    }
}
