package event.generators;

import event.Event;
import event.observer.ObservableEvent;
import event.observer.Observer;
import event.enums.*;

import java.util.*;


/**
 * The type Event generator.
 */
public class EventGenerator extends TimerTask implements Runnable, ObservableEvent {
    private Random random = new Random();
    /**
     * The Observer.
     */
    private List<Observer> observers = new ArrayList<>();

    public EventGenerator() {
    }


    /**
     * Instantiates a new Event generator.
     *
     * @param observers the observers
     */
    public EventGenerator(List<Observer> observers) {
        this.observers = observers;
    }

    @Override
    public void run() {
        Event event = new Event();
        event.setEventType(EventType.START.getName());
        event.setEventTimeStamp(event.getCreateTime());
        event.setServiceType(randomServiceType().getName());
        event.setOriginationPage(randomOriginationPage().getName());
        event.setOriginationChannel(randomOriginationChannel().getName());
        notifyObservers(event);
        try {
            long millis = randomTimeSleep(3, 10);
            System.out.println("Thread " + Thread.currentThread().getName()+ " id "+Thread.currentThread().getId() + " Join Sleep " + millis / 1000);
            Thread.sleep(millis);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        event.setEventType(EventType.JOIN.getName());
        event.setEventTimeStamp(new Date());
        event.setDeliveryTime(event.getEventTimeStamp());
        event.setAgentId(randomAgentId());
        notifyObservers(event);
        try {
            long millis = randomTimeSleep(15, 20);
            System.out.println("Thread " + Thread.currentThread().getName()+ " id "+Thread.currentThread().getId() + " END Sleep " + millis / 1000);
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        event.setEventType(EventType.END.getName());
        event.setEventTimeStamp(new Date());
        event.setEndTime(event.getEventTimeStamp());
        event.setEndReason(randomEndReason().getName());
        notifyObservers(event);
        System.out.println("Thread " + Thread.currentThread().getName()+ " id "+Thread.currentThread().getId() + " finished");
    }

    private ServiceType randomServiceType() {
        ServiceType[] values = ServiceType.values();
        return values[random.nextInt(values.length)];
    }

    private OriginationPage randomOriginationPage() {
        OriginationPage[] values = OriginationPage.values();
        return values[random.nextInt(values.length)];
    }

    private OriginationChannel randomOriginationChannel() {
        OriginationChannel[] values = OriginationChannel.values();
        return values[random.nextInt(values.length)];
    }

    private EndReason randomEndReason() {
        EndReason[] values = EndReason.values();
        return values[random.nextInt(values.length)];
    }

    private long randomTimeSleep(int minSS, int maxSS) {
        return (random.nextInt(maxSS - minSS) + 1) * 1000L;
    }

    private String randomAgentId() {
        return String.format("Agent_%03d", random.nextInt(999) + 1);
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(Event event) {
        for (Observer observer : observers) {
            observer.writeEventToJSON(event);
        }
    }
}
