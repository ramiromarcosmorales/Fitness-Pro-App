package com.marcosmorales.util;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Este es el "manual" que le dice a GSON cómo manejar LocalDate.
 */
public class LocalDateAdapter extends TypeAdapter<LocalDate> {

    @Override
    public void write(JsonWriter out, LocalDate value) throws IOException {
        // Cómo escribir un LocalDate en JSON: conviértelo a un String.
        out.value(value.toString());
    }

    @Override
    public LocalDate read(JsonReader in) throws IOException {
        // Cómo leer un LocalDate desde JSON: parsea el String.
        return LocalDate.parse(in.nextString());
    }
}