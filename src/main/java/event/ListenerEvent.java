package event;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import event.json.NullStringToEmptyAdapterFactory;

import java.io.IOException;
import java.io.Writer;


/**
 * The type Listener event.
 */
public class ListenerEvent implements Listener {
    private Writer writer;
    private Gson gson;

    /**
     * Instantiates a new Listener event.
     *
     * @param writer the writer
     */
    public ListenerEvent(Writer writer) {
        this.writer = writer;
        this.gson = new GsonBuilder().registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory()).create();
    }

    /**
     * Instantiates a new Listener event.
     *
     * @param writer the writer
     * @param gson   the gson
     */
    public ListenerEvent(Writer writer, Gson gson) {
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
