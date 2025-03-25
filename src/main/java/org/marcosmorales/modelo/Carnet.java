package org.marcosmorales.modelo;

import java.time.LocalDate;
import java.util.UUID;

public class Carnet {
    private String id;
    private LocalDate fechaAlta;
    private LocalDate fechaVencimiento;

    private Carnet() {
        this.id = UUID.randomUUID().toString();
        this.fechaAlta = LocalDate.now();
        this.fechaVencimiento = fechaAlta.plusMonths(1);
    }

    public static Carnet generarCarnet() {
        return new Carnet();
    }

    public boolean verificarValidez() {
        return fechaVencimiento.isAfter(LocalDate.now());
    }

    // Getters
    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    // Setters
    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public String toString() {
        return "Carnet{" +
                "id='" + id + '\'' +
                ", fechaAlta=" + fechaAlta +
                ", fechaVencimiento=" + fechaVencimiento +
                '}';
    }
}
