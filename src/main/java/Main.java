import event.generators.EventsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

/**
 * Created by Николай on 20.08.2016.
 */
public class Main {
    private static final Logger logger = LogManager.getLogger(EventsService.class);
    private static final String error = "You have to add two arguments\n " +
            "\tN - Number of interactions to generate events for.\n" +
            "\tR - Rate of generation “start” events per second (how many new interactions must be generated per every second).";

    public static void main(String[] args) {
        if (args.length == 2) {
            Integer countOfEvents = null;
            Integer countPerSecond = null;
            try {
                countOfEvents = Integer.valueOf(args[0]);
                countPerSecond = Integer.valueOf(args[1]);
                File file = new File("file.txt");
                EventsService eventsService = new EventsService(file, countOfEvents, countPerSecond);
                eventsService.start();
            } catch (NumberFormatException e) {
                System.out.println("Arguments have to be a Integer");
            } catch (IOException e) {
                logger.error(e);
            }
        } else {
            System.out.println(error);

        }
    }
}
