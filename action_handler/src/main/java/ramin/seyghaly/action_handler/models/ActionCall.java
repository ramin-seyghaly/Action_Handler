package ramin.seyghaly.action_handler.models;

import ramin.seyghaly.action_handler.type.ActionType;

public class ActionCall extends Action{

    private String number;

    public ActionCall() {
        super(ActionType.CALL);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
