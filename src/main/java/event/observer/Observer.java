package event.observer;


import event.Event;

/**
 * The interface Observer.
 */
public interface Observer {

    /**
     * Write event to json.
     *
     * @param event the event
     */
    public void writeEventToJSON(Event event);
}
