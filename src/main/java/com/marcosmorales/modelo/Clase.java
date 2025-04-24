package com.marcosmorales.modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class Clase {
    private String id;
    private LocalDate fecha;
    private LocalTime horario;


    private Clase(LocalDate fecha, LocalTime horario) {
        if (fecha == null || horario == null) {
            throw new IllegalArgumentException("Fecha o Horario no pueden ser nulos!");
        }

        if (fecha.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha ingresada es anterior a la actual!");
        }

        if (fecha.isEqual(LocalDate.now()) && horario.isBefore(LocalTime.now())) {
            throw new IllegalArgumentException("El horario ingresado es anterior al actual!");
        }

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
        if (fecha.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha ingresada es anterior a la actual!");
        }
        this.fecha = fecha;
    }

    public void setHorario(LocalTime horario) {
        if (horario.isBefore(LocalTime.now())) {
            throw new IllegalArgumentException("El horario ingresado es anterior al actual!");
        }
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
