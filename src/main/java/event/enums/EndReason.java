package event.enums;

/**
 * Created by Николай on 20.08.2016.
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

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }
}
