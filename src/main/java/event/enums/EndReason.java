package event.enums;

/**
 * Created by Николай on 20.08.2016.
 */
public enum EndReason {
    NORMAL("Normal"),
    ABNORMAL("Abnormal");

    private String name;

    EndReason(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
