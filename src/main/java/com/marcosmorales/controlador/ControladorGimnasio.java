package com.marcosmorales.controlador;

import com.marcosmorales.excepciones.ExcepcionDuplicado;
import com.marcosmorales.modelo.*;

import java.time.LocalDate;
import java.util.List;

public class ControladorGimnasio {
    private Gimnasio gym;

    public ControladorGimnasio() {
        this.gym = new Gimnasio();
    }

    public boolean contratarEmpleado(String nombre, String apellido, String email, String telefono, Sector sector) {
        try {
        Empleado empleado = Empleado.crearEmpleado(nombre, apellido, email, telefono, sector);
        return gym.contratarEmpleado(empleado);
        } catch (ExcepcionDuplicado e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public boolean registrarSocio(String nombre, String apellido, String email, String telefono) {
        try {
            Socio socio = Socio.crearSocio(nombre, apellido, email, telefono);
            return gym.registrarSocio(socio);
        } catch (ExcepcionDuplicado e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public boolean registrarMaquina(TipoMaquina tipo, LocalDate ultMantenimiento) {
        try {
            Maquina nuevaMaquina = Maquina.crearMaquina(tipo, ultMantenimiento);
            return gym.registrarMaquina(nuevaMaquina);
        } catch (ExcepcionDuplicado e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public Maquina proximaMaquinaParaMantenimiento() {
        return gym.getProximaMaquinaMantenimiento();
    }

    public List<Empleado> getEmpleados() {
        return gym.getEmpleados();
    }

    public List<Socio> getSocios() {
        return gym.getSocios();
    }

    public Gimnasio getGym() {
        return this.gym;
    }
}
