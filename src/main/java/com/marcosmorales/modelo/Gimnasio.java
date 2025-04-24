package com.marcosmorales.modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Gimnasio {
    private List<Empleado> empleados = new ArrayList<>();
    private List<Socio> socios = new ArrayList<>();
    private List<Clase> clases = new ArrayList<>();
    private List<Maquina> maquinas = new ArrayList<>();


    public boolean contratarEmpleado(Empleado empleado) {
        if (empleado == null) {
            throw new IllegalArgumentException("El empleado no puede ser nulo!");
        }

        if (empleados.contains(empleado)) {
            return false;
        }

        empleados.add(empleado);
        return true;
    }

    public boolean registrarSocio(Socio socio) {
        if (socio == null) {
            throw new IllegalArgumentException("El socio no puede ser nulo!");
        }

        if (socios.contains(socio)) {
            return false;
        }

        socios.add(socio);
        return true;
    }

    public boolean registrarMaquina(Maquina maquina) {
        if (maquina == null) {
            throw new IllegalArgumentException("La maquina no puede ser nulo!");
        }

        if (maquinas.contains(maquina)) {
            return false;
        }

        maquinas.add(maquina);
        return true;
    }

    public boolean reservarClase(Socio socio, LocalDate fecha, LocalTime horario) {
        if (socio == null || fecha == null || horario == null) {
            throw new IllegalArgumentException("Uno de los datos recibidos es nulo!");
        }

        if (!socio.getCarnet().verificarValidez()) {
            throw new IllegalStateException("El carnet del socio no está activo!");
        }

        for (Clase clase : clases) {
            if (clase.getFecha().equals(fecha) && clase.getHorario().equals(horario)) {
                throw new IllegalStateException("Ya existe una clase reservada en esta fecha y horario!");
            }
        }

        Clase clase = Clase.crearClase(fecha, horario);

        if (socio.getClases().add(clase)) {
            clases.add(clase);
            return true;
        } else {
            return false;
        }
    }
}
