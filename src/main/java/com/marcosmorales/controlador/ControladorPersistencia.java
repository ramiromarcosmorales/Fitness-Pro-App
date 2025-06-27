package com.marcosmorales.controlador;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.marcosmorales.modelo.Gimnasio;
import com.marcosmorales.util.LocalDateAdapter;
import com.marcosmorales.util.LocalTimeAdapter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class ControladorPersistencia {
    private static final String rutaArchivo = "gimnasio-data.json";
    private Gson gson;

    public ControladorPersistencia() {
        this.gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .registerTypeAdapter(LocalTime.class, new LocalTimeAdapter())
                .setPrettyPrinting()
                .create();
    }

    public void guardarData(Gimnasio gym) {
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            gson.toJson(gym, writer);
            System.out.println("Datos guardados correctamente!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Gimnasio cargar() {
        try (FileReader reader = new FileReader(rutaArchivo)) {
            Gimnasio gym = gson.fromJson(reader, Gimnasio.class);

            if (gym != null) {
                System.out.println("Datos cargados correctamente!");
                return gym;
            }
        } catch (IOException e) {
            System.out.println("No se encontro ningun archivo. Se creará uno nuevo");
        }
        return new Gimnasio();
    }
}
