package event.enums;

/**
 * Created by Николай on 20.08.2016.
 */
public enum OriginationPage {
    LOGIN("login"),
    BALANCE("balance"),
    TRANSFER("transfer");

    private String name;

    OriginationPage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
