package org.openhab.binding.untappd.handler;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class ObjectCheckTypeAdapterFactory implements TypeAdapterFactory {

    @Override
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> type) {
        Class<? super T> rawType = type.getRawType();
        if (List.class.isAssignableFrom(rawType) || rawType.getName().startsWith("java.")) {
            return null;
        }

        final TypeAdapter<T> delegate = gson.getDelegateAdapter(this, type);
        final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
        return new ObjectCheckTypeAdapter<>(delegate, elementAdapter).nullSafe();
    }

    public static class ObjectCheckTypeAdapter<T> extends TypeAdapter<T> {
        private final TypeAdapter<T> delegate;
        private final TypeAdapter<JsonElement> elementAdapter;

        public ObjectCheckTypeAdapter(final TypeAdapter<T> delegate, final TypeAdapter<JsonElement> elementAdapter) {
            this.delegate = delegate;
            this.elementAdapter = elementAdapter;
        }

        @Override
        public void write(final JsonWriter out, final T value) throws IOException {
            this.delegate.write(out, value);
        }

        @Override
        public T read(final JsonReader in) throws IOException {
            JsonElement element = elementAdapter.read(in);
            if (element.isJsonArray()) {
                return null;
            }

            return this.delegate.fromJsonTree(element.getAsJsonObject());
        }
    }

}
