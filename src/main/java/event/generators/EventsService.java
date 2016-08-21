package event.generators;

import event.observer.Observer;
import event.observer.ObserverEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
 * The type Events service.
 */
public class EventsService {
    private static final Logger logger = LogManager.getLogger(EventsService.class);
    private FileWriter writer;
    private Integer countOfEvents;
    private Integer countPerSecond;

    /**
     * Instantiates a new Events service.
     *
     * @param writer         the writer
     * @param countOfEvents  the count of events
     * @param countPerSecond the count per second
     */
    public EventsService(FileWriter writer, Integer countOfEvents, Integer countPerSecond) {
        this.writer = writer;
        this.countOfEvents = countOfEvents;
        this.countPerSecond = countPerSecond;
    }

    /**
     * Instantiates a new Events service.
     *
     * @param file           the file
     * @param countOfEvents  the count of events
     * @param countPerSecond the count per second
     * @throws IOException the io exception
     */
    public EventsService(File file, Integer countOfEvents, Integer countPerSecond) throws IOException {
        this(new FileWriter(file), countOfEvents, countPerSecond);
    }

    /**
     * Instantiates a new Events service.
     *
     * @param fileName       the file name
     * @param countOfEvents  the count of events
     * @param countPerSecond the count per second
     * @throws IOException the io exception
     */
    public EventsService(String fileName, Integer countOfEvents, Integer countPerSecond) throws IOException {
        this(new FileWriter(new File(fileName)), countOfEvents, countPerSecond);
    }

    /**
     * Generate eventGenerators.
     */
    public void start(){
        Observer observer = new ObserverEvent(writer);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(countOfEvents);
        for (int events = 1, delay = 1; events <= countOfEvents; events++) {
            EventGenerator eventGenerator = new EventGenerator();
            eventGenerator.registerObserver(observer);
            scheduledExecutorService.schedule(eventGenerator, delay, TimeUnit.SECONDS);
            logger.info("Thread started " + events + " delay " + delay+TimeUnit.SECONDS);
            if(events%countPerSecond == 0) {
                delay++;
            }
        }
        scheduledExecutorService.shutdown();
    }
}
