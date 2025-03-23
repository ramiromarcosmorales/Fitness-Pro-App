package org.marcosmorales.modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class Clase {
    private String id;
    private LocalDate fecha;
    private LocalTime horario;

    private Clase() {
        this.id = UUID.randomUUID().toString();
    }

    public static Clase crearClase(LocalDate fecha, LocalTime horario) {
        Clase clase = new Clase();
        clase.fecha = fecha;
        clase.horario = horario;
        return clase;
    }

    public String getId() {
        return this.id;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    public LocalTime getHorario() {
        return this.horario;
    }

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
