import event.Listener;
import event.ListenerEvent;
import event.generators.EventGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Николай on 20.08.2016.
 */
public class Main {
    public static void main(String[] args) {
        Listener listener = new ListenerEvent();
        List<EventGenerator> eventGenerators = new ArrayList<>();
        for (int i = 0; i <10; i++) {
            eventGenerators.add(new EventGenerator(listener));
        }
        for (EventGenerator eventGenerator : eventGenerators) {
            Thread thread = new Thread(eventGenerator);
            thread.start();
        }

    }
}
