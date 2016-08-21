package event;


/**
 * The interface Listener.
 */
public interface Listener {

    /**
     * Write event to json.
     *
     * @param event the event
     */
    public void writeEventToJSON(Event event);
}
