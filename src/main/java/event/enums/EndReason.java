package event.enums;


/**
 * The enum End reason.
 */
public enum EndReason {
    /**
     * Normal end reason.
     */
    NORMAL("Normal"),
    /**
     * Abnormal end reason.
     */
    ABNORMAL("Abnormal");

    private String name;

    EndReason(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
