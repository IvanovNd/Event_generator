import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import event.Event;
import event.json.NullStringToEmptyAdapterFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;
import java.util.UUID;

/**
 * Created by Николай on 20.08.2016.
 */
public class Main {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        System.out.println(UUID.randomUUID());
        System.out.println(UUID.randomUUID());
        Random random = new Random(4);
        random.nextInt();
        System.out.println(UUID.randomUUID());
        Event event = new Event();
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("file.JsonConverter"), event);
        } catch (IOException e) {
            e.printStackTrace();
        }
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory()).create();
        gson.toJson(event);
        try {
            Writer writer = new FileWriter(new File("file.json"));
            writer.write(gson.toJson(event));
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
