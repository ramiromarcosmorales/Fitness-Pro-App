package com.marcosmorales.modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

public class Socio extends Usuario implements IRegistrable {
    private Carnet carnet;
    private LinkedList<Clase> clases;

    // Constructor sin parámetros
    public Socio() {
        super();
        this.carnet = null;
        this.clases = new LinkedList<>();
    }

    // Constructor con parámetros
    private Socio(String nombre, String apellido, String email, String telefono) {
        super(nombre, apellido, email, telefono);
        this.carnet = Carnet.generarCarnet();
        this.clases = new LinkedList<>();
    }

    // Getters
    public Carnet getCarnet() {
        return carnet;
    }

    public List getClases() {
        return clases;
    }

    // Metodo para crear Socio
    public static Socio crearSocio(String nombre, String apellido, String email, String telefono) {
        return new Socio(nombre, apellido, email, telefono);
    }

    public boolean agregarClase(Clase clase) {
        if (!carnet.verificarValidez())
            throw new IllegalArgumentException("Error: Membresia inactiva!");

        for (Clase c : clases) {
            if (c.getFecha().equals(clase.getFecha()) && c.getHorario().equals(clase.getHorario()))
                return false;
        }

        return this.clases.add(clase);
    }


    public boolean eliminarClase(int num) {
        if (num >= 0 && num < this.clases.size()) {
            this.clases.remove(num);
            return true;
        }
        return false;
    }

    public void obtenerHistorialClases() {
        for (Clase clase : clases) {
            System.out.println(clase);
        }
    }

    @Override
    public void registrar() {
        System.out.println("Socio registrado: " + getNombre() + " " + getApellido());
    }

    @Override
    public String toString() {
        return super.toString() + ", carnet='" + carnet + ", clases=" + clases + "'" + "}";
    }
}
