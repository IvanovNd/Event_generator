package event.enums;


/**
 * The enum Origination channel.
 */
public enum OriginationChannel {
    /**
     * Webchat origination channel.
     */
    WEBCHAT("webchat"),
    /**
     * Sms origination channel.
     */
    SMS("sms"),
    /**
     * Wechat origination channel.
     */
    WECHAT("wechat");
    private String name;

    OriginationChannel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
