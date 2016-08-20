package event.generators;

import event.Event;
import event.enums.*;

import java.util.Date;
import java.util.Random;

/**
 * Created by Николай on 21.08.2016.
 */
public class EventGenerator implements Runnable {
    private Random random = new Random();

    @Override
    public void run() {
        Event event = new Event();
        event.setEventType(EventType.START.getName());
        event.setEventTimeStamp(event.getCreateTime());
        event.setServiceType(randomServiceType().getName());
        event.setOriginationPage(randomOriginationPage().getName());
        event.setOriginationChannel(randomOriginationChannel().getName());
        try {
            Thread.sleep(randomTimeSleep(3,10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        event.setEventType(EventType.JOIN.getName());
        event.setEventTimeStamp(new Date());
        event.setDeliveryTime(event.getEventTimeStamp());
        event.setAgentId(randomAgentId());
        try {
            Thread.sleep(randomTimeSleep(15,60));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        event.setEventType(EventType.END.getName());
        event.setEventTimeStamp(new Date());
        event.setEndReason(randomEndReason().getName());
    }

    private ServiceType randomServiceType() {
        ServiceType[] values = ServiceType.values();
        return values[random.nextInt(values.length + 1)];
    }

    private OriginationPage randomOriginationPage() {
        OriginationPage[] values = OriginationPage.values();
        return values[random.nextInt(values.length + 1)];
    }

    private OriginationChannel randomOriginationChannel() {
        OriginationChannel[] values = OriginationChannel.values();
        return values[random.nextInt(values.length + 1)];
    }
    private EndReason randomEndReason() {
        EndReason[] values = EndReason.values();
        return values[random.nextInt(values.length + 1)];
    }

    private long randomTimeSleep(int minSS, int maxSS) {
        return (random.nextInt(maxSS - minSS) + 1)*1000L;
    }
    private String randomAgentId(){
        return String.format("Agent_%3d",random.nextInt(999) + 1);
    }
}
