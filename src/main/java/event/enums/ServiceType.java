package event.enums;

/**
 * Created by Николай on 20.08.2016.
 */
public enum ServiceType {
    NEW_ACCOUNT("new account"),
    PAYMENT("payment"),
    DELIVERY("delivery");

    private String name;

    ServiceType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
