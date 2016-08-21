package event.observer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import event.Event;
import event.json.NullStringToEmptyAdapterFactory;

import java.io.IOException;
import java.io.Writer;


/**
 * The type Observer event.
 */
public class ObserverEvent implements Observer {
    private Writer writer;
    private Gson gson;

    /**
     * Instantiates a new Observer event.
     *
     * @param writer the writer
     */
    public ObserverEvent(Writer writer) {
        this.writer = writer;
        this.gson = new GsonBuilder().registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory()).create();
    }

    /**
     * Instantiates a new Observer event.
     *
     * @param writer the writer
     * @param gson   the gson
     */
    public ObserverEvent(Writer writer, Gson gson) {
        this.writer = writer;
        this.gson = gson;
    }

    @Override
    public synchronized void writeEventToJSON(Event event) {
        gson.toJson(event);
        try {
            writer.write(gson.toJson(event));
            writer.write("\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
