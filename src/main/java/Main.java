import event.Listener;
import event.ListenerEvent;
import event.generators.EventGenerator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

/**
 * Created by Николай on 20.08.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length == 2) {
            Integer countOfEvents = Integer.valueOf(args[0]);
            Integer countPerSecond = Integer.valueOf(args[1]);
            Timer timer = new Timer();
            Listener listener = new ListenerEvent(new FileWriter(new File("file.json"),true));
            for (int events = 1; events <= countOfEvents; events++) {
                timer.schedule(new EventGenerator(listener), 1000);
            }
        } else {

            Listener listener = new ListenerEvent(new FileWriter(new File("file.json"),true));
            List<EventGenerator> eventGenerators = new ArrayList<>();
            for (int i = 0; i < 1000; i++) {
                eventGenerators.add(new EventGenerator(listener));
            }
            for (EventGenerator eventGenerator : eventGenerators) {
                Thread thread = new Thread(eventGenerator);
                thread.start();
            }
        }

    }
}
