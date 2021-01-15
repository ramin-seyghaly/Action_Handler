package ramin.seyghaly.action_handler.models;

import ramin.seyghaly.action_handler.type.ActionType;

public class ActionDeviceBrowser extends Action {

    private String url;

    public ActionDeviceBrowser() {
        super(ActionType.DEVICE_BROWSER);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
