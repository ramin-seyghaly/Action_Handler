package ramin.seyghaly.action_handler.models;

import ramin.seyghaly.action_handler.type.ActionType;

public class Action {
    private ActionType actionType;

    public Action(ActionType actionType) {
        this.actionType = actionType;
    }

    public ActionType getActionType() {
        return actionType;
    }

}
