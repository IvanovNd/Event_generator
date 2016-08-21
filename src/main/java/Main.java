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

    public static void main(String[] args) {
        if (args.length == 2) {
            Integer countOfEvents = null;
            Integer countPerSecond = null;
            try {
                countOfEvents = Integer.valueOf(args[0]);
                countPerSecond = Integer.valueOf(args[1]);
            } catch (NumberFormatException e) {
                System.out.print("Arguments have to be a Integer");
            }

            File file = new File("file.txt");
            try {
                EventsService eventsService = new EventsService(file, countOfEvents, countPerSecond);
                eventsService.start();
            } catch (IOException e) {
                logger.error(e);
            }
        }
    }
}
