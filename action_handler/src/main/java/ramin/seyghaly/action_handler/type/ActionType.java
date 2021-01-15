package ramin.seyghaly.action_handler.type;

public enum ActionType {

    NONE(0),
    DEVICE_BROWSER(1),
    INSTAGRAM(2),
    TELEGRAM(3),
    YOUTUBE(4),
    FACEBOOK(5),
    TWITTER(6),
    CUSTOM_BROWSER(7),
    VIDEO(8),
    AUDIO(9),
    PHOTO(10),
    DIALOG(11),
    TOAST(12),
    CALL(13),
    SMS(14),
    SHARE(15),
    MAP(16),
    SETTINGS(17);

    private int value;

    ActionType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ActionType getVal(int val) {
        for (ActionType ac : values()) {
            if (ac.value == val) return ac;
        }
        return NONE;
    }

}
