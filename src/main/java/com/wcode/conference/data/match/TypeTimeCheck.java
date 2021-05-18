package com.wcode.conference.data.match;


public class TypeTimeCheck extends DataMatchMiddleware {

    private DataMatchController dataMatchController;

    public TypeTimeCheck(DataMatchController dataMatchController) {
        this.dataMatchController = dataMatchController;
    }

    @Override
    public boolean check(String tittle, String time, String typeTime) {
        if(!dataMatchController.isValidationTypeTime(typeTime)){
            return false;
        }
        return checkNext(tittle, time, typeTime);
    }
}
