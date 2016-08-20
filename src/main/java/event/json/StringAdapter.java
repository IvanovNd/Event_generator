package event.json;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Created by Николай on 20.08.2016.
 */
public class StringAdapter extends TypeAdapter<String> {
    public String read(JsonReader reader) throws IOException {
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
            return "";
        }
        return reader.nextString();
    }
    public void write(JsonWriter writer, String value) throws IOException {
        if (value == null) {
            writer.value("undefined");
            return;
        }
        writer.value(value);
    }
}