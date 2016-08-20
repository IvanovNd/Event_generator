package event.enums;

/**
 * Created by Николай on 20.08.2016.
 */
public enum EventType {
    START("start"),
    JOIN("join"),
    END("end");

    private String name;

    EventType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
