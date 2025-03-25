package org.marcosmorales.modelo;

import java.time.LocalDate;

public class Maquina implements Registrable {
    private String tipo;
    private LocalDate fechaAlta;
    private LocalDate ultMantenimiento;
    private LocalDate proxMantenimiento;

    private Maquina (String tipo, LocalDate ultMantenimiento, LocalDate proxMantenimiento) {
        this.tipo = tipo;
        this.fechaAlta = LocalDate.now();
        this.ultMantenimiento = ultMantenimiento;
        this.proxMantenimiento = proxMantenimiento;
    }

    protected static Maquina crearMaquina(String tipo, LocalDate ultMantenimiento, LocalDate proxMantenimiento) {
        return new Maquina(tipo, ultMantenimiento, proxMantenimiento);
    }

    protected void crearMantenimiento(LocalDate fecha) {
        setProxMantenimiento(fecha);
        System.out.println("El mantenimiento fue creado para el " + fecha);
    }

    // Metodos getters
    public String getTipo() {
        return tipo;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public LocalDate getUltMantenimiento() {
        return ultMantenimiento;
    }

    public LocalDate getProxMantenimiento() {
        return proxMantenimiento;
    }

    // Metodos setters
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public void setUltMantenimiento(LocalDate ultMantenimiento) {
        this.ultMantenimiento = ultMantenimiento;
    }

    public void setProxMantenimiento(LocalDate proxMantenimiento) {
        this.proxMantenimiento = proxMantenimiento;
    }

    @Override
    public void registrar() {
        System.out.println("Maquina registrada: " + getTipo());
    }

    @Override
    public String toString() {
        return "maquina{" +
                "tipo='" + tipo + '\'' +
                ", fechaAlta=" + fechaAlta +
                ", ultMantenimiento=" + ultMantenimiento +
                ", proxMantenimiento=" + proxMantenimiento +
                '}';
    }
}
