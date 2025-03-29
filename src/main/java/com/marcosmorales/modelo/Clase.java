package com.marcosmorales.modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class Clase {
    private String id;
    private LocalDate fecha;
    private LocalTime horario;

    private Clase(LocalDate fecha, LocalTime horario) {
        this.id = UUID.randomUUID().toString();
        this.fecha = fecha;
        this.horario = horario;
    }

    public static Clase crearClase(LocalDate fecha, LocalTime horario) {
        return new Clase(fecha, horario);
    }

    // Getters

    public String getId() {
        return this.id;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    public LocalTime getHorario() {
        return this.horario;
    }

    // Setters

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Clase{" +
                "id='" + id + '\'' +
                ", fecha=" + fecha +
                ", horario=" + horario +
                '}';
    }
}
