package event;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import event.json.NullStringToEmptyAdapterFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by Николай on 21.08.2016.
 */
public class ListenerEvent implements Listener {
    @Override
    public synchronized void event(Event event) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory()).create();
        gson.toJson(event);
        try {
            Writer writer = new FileWriter(new File("file.json"),true);
            writer.write(gson.toJson(event));
            writer.write("\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}