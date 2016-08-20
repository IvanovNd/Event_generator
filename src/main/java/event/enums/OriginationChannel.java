package event.enums;

/**
 * Created by Николай on 20.08.2016.
 */
public enum OriginationChannel {
    WEBCHAT("webchat"),
    SMS("sms"),
    WECHAT("wechat");
    private String name;

    OriginationChannel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
