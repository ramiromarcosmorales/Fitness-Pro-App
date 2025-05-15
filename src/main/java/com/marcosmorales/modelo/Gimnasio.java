package com.marcosmorales.modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Gimnasio {
    private List<Empleado> empleados = new ArrayList<>();
    private List<Socio> socios = new ArrayList<>();
    private List<Clase> clases = new ArrayList<>(); // reemplazar por tad
    private PriorityQueue<Maquina> maquinasPriority;

    public Gimnasio() {
        this.maquinasPriority = new PriorityQueue<>(
                Comparator.comparing(Maquina::getProxMantenimiento)
        );
    }

    public boolean contratarEmpleado(Empleado empleado) {
        if (empleado == null) throw new IllegalArgumentException("El empleado no puede ser nulo!");


        if (empleados.contains(empleado)) return false;

        return empleados.add(empleado);
    }

    public boolean registrarSocio(Socio socio) {
        if (socio == null) throw new IllegalArgumentException("El socio no puede ser nulo!");


        if (socios.contains(socio)) return false;

        return socios.add(socio);
    }

    public boolean registrarMaquina(Maquina maquina) {
        if (maquina == null) throw new IllegalArgumentException("La maquina no puede ser nulo!");

        if (maquinasPriority.contains(maquina)) return false;

        return maquinasPriority.add(maquina);
    }

    public Maquina getProximaMaquinaMantenimiento() {
        return maquinasPriority.peek();
    }

    public boolean reservarClase(Socio socio, LocalDate fecha, LocalTime horario) {
        if (socio == null || fecha == null || horario == null) throw new IllegalArgumentException("Uno de los datos recibidos es nulo!");


        if (!socio.getCarnet().verificarValidez()) throw new IllegalStateException("El carnet del socio no está activo!");


        for (Clase clase : clases) {
            if (clase.getFecha().equals(fecha) && clase.getHorario().equals(horario)) throw new IllegalStateException("Ya existe una clase reservada en esta fecha y horario!");
        }

        Clase clase = Clase.crearClase(fecha, horario);

        if (socio.getClases().add(clase)) {
            return clases.add(clase);
        } else {
            return false;
        }
    }
}
