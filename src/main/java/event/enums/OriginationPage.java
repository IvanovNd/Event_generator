package event.enums;


/**
 * The enum Origination page.
 */
public enum OriginationPage {
    /**
     * Login origination page.
     */
    LOGIN("login"),
    /**
     * Balance origination page.
     */
    BALANCE("balance"),
    /**
     * Transfer origination page.
     */
    TRANSFER("transfer");

    private String name;

    OriginationPage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
