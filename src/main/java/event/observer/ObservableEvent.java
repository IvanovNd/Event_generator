package event.observer;

import event.Event;

/**
 * The interface ObservableEvent.
 */
public interface ObservableEvent {
    /**
     * Register observer.
     *
     * @param o the o
     */
    void registerObserver(Observer o);

    /**
     * Remove observer.
     *
     * @param o the o
     */
    void removeObserver(Observer o);

    /**
     * Notify observers.
     */
    void notifyObservers(Event event);
}