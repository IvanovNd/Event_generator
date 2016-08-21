package event.enums;


/**
 * The enum Event type.
 */
public enum EventType {
    /**
     * Start writeEventToJSON type.
     */
    START("start"),
    /**
     * Join writeEventToJSON type.
     */
    JOIN("join"),
    /**
     * End writeEventToJSON type.
     */
    END("end");

    private String name;

    EventType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
