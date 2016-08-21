package event.enums;

/**
 * The enum Service type.
 */
public enum ServiceType {
    /**
     * The New account.
     */
    NEW_ACCOUNT("new account"),
    /**
     * Payment service type.
     */
    PAYMENT("payment"),
    /**
     * Delivery service type.
     */
    DELIVERY("delivery");

    private String name;

    ServiceType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
