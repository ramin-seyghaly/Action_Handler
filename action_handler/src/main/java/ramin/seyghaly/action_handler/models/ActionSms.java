package ramin.seyghaly.action_handler.models;

import ramin.seyghaly.action_handler.type.ActionType;

public class ActionSms extends Action {

    private String number;
    private String body;

    public ActionSms() {
        super(ActionType.SMS);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
