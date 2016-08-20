package event.json;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

import java.util.Date;

/**
 * Created by Николай on 20.08.2016.
 */
public class NullStringToEmptyAdapterFactory<T> implements TypeAdapterFactory {
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {

        Class<T> rawType = (Class<T>) type.getRawType();
        if (rawType == String.class) {
            return (TypeAdapter<T>) new StringAdapter();
        } else if (rawType == Date.class)
        {
            return (TypeAdapter<T>) new DateAdapter();
        }
            return null;

    }
}
