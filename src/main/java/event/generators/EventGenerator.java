package event.generators;

import event.Event;
import event.Listener;
import event.enums.*;

import java.util.Date;
import java.util.Random;
import java.util.TimerTask;

/**
 * Created by Николай on 21.08.2016.
 */
public class EventGenerator extends TimerTask implements Runnable {
    private Random random = new Random();
    Listener listener;

    public EventGenerator(Listener listener) {
        this.listener = listener;
    }

    @Override
    public void run() {
        Event event = new Event(listener);
        event.setEventType(EventType.START.getName());
        event.setEventTimeStamp(event.getCreateTime());
        event.setServiceType(randomServiceType().getName());
        event.setOriginationPage(randomOriginationPage().getName());
        event.setOriginationChannel(randomOriginationChannel().getName());
        event.notifyListener();
        try {
            long millis = randomTimeSleep(3, 10);
            System.out.println("Thread "+Thread.currentThread().getName()+"Join Sleep "+millis/1000);
            Thread.sleep(millis);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        event.setEventType(EventType.JOIN.getName());
        event.setEventTimeStamp(new Date());
        event.setDeliveryTime(event.getEventTimeStamp());
        event.setAgentId(randomAgentId());
        event.notifyListener();
        try {
            long millis = randomTimeSleep(15, 20);
            System.out.print("END Sleep "+millis/1000);
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        event.setEventType(EventType.END.getName());
        event.setEventTimeStamp(new Date());
        event.setEndTime(event.getEventTimeStamp());
        event.setEndReason(randomEndReason().getName());
        event.notifyListener();
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
        return (random.nextInt(maxSS - minSS) + 1)*1000L;
    }
    private String randomAgentId(){
        return String.format("Agent_%03d",random.nextInt(999) + 1);
    }
}
