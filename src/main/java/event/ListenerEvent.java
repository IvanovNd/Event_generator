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


    /**
     * Instantiates a new Listener event.
     *
     * @param writer the writer
     */
    public ListenerEvent(Writer writer) {
        this.writer = writer;
    }

    @Override
    public synchronized void writeEventToJSON(Event event) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory()).create();
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
