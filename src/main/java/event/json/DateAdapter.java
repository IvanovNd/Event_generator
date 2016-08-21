package event.json;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Date;

/**
 * Created by Николай on 20.08.2016.
 */
public class DateAdapter extends TypeAdapter<Date> {
    public Date read(JsonReader reader) throws IOException {
        throw new UnsupportedOperationException("read is not supported");
    }

    public void write(JsonWriter writer, Date value) throws IOException {
        if (value == null) {
            writer.value(new Date(0L).toString());
            return;
        }
        writer.value(value.toString());
    }
}