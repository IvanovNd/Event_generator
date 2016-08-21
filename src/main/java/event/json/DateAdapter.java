package event.json;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


/**
 * The type Date adapter.
 */
public class DateAdapter extends TypeAdapter<Date> {
    /**
     * The Dateformat.
     */
    static final String DATEFORMAT = "yyyy-MM-dd HH:mm:ss";

    public Date read(JsonReader reader) throws IOException {
        throw new UnsupportedOperationException("read is not supported");
    }

    public void write(JsonWriter writer, Date value) throws IOException {
        SimpleDateFormat format = new SimpleDateFormat(DATEFORMAT);
        format.setTimeZone(TimeZone.getTimeZone("UTC"));

        if (value == null) {
            writer.value(format.format(new Date(0L)));
            return;
        }
        writer.value(format.format(value));
    }
}