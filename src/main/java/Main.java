import event.generators.EventGenerator;
import event.observer.Observer;
import event.observer.ObserverEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Николай on 20.08.2016.
 */
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws IOException {
        if (args.length == 2) {
            Integer countOfEvents = Integer.valueOf(args[0]);
            Integer countPerSecond = Integer.valueOf(args[1]);
            Timer timer = new Timer();
            FileWriter writer = new FileWriter(new File("file.json"), true);
            ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(countOfEvents);
            Observer observer = new ObserverEvent(writer);
            for (int events = 1, delay = 1; events <= countOfEvents; events++) {
                EventGenerator eventGenerator = new EventGenerator();
                eventGenerator.registerObserver(observer);
                scheduledExecutorService.schedule(eventGenerator, delay, TimeUnit.SECONDS);
                logger.error("Thread started " + events + " delay " + delay+TimeUnit.SECONDS);
                System.out.println("Thread started " + events + " delay " + delay+TimeUnit.SECONDS );
                if(events%countPerSecond == 0) {
                    delay++;
                }
            }
            scheduledExecutorService.shutdown();
        } else {

            Observer observer = new ObserverEvent(new FileWriter(new File("file.json"),true));
            List<EventGenerator> eventGenerators = new ArrayList<>();
            for (int i = 0; i < 1000; i++) {
                EventGenerator eventGenerator = new EventGenerator();
                eventGenerator.registerObserver(observer);
                eventGenerators.add(eventGenerator);
            }
            for (EventGenerator eventGenerator : eventGenerators) {
                Thread thread = new Thread(eventGenerator);
                thread.start();
            }
        }

    }
}
