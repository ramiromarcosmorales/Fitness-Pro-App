package com.marcosmorales.controlador;

import com.marcosmorales.excepciones.ExcepcionDuplicado;
import com.marcosmorales.modelo.*;

import javax.naming.ldap.Control;
import java.time.LocalDate;
import java.util.List;

public class ControladorGimnasio {
    private Gimnasio gym;
    private ControladorPersistencia persistenciaControlador;

    public ControladorGimnasio(Gimnasio gym, ControladorPersistencia persistenciaControlador) {
        this.gym = gym;
        this.persistenciaControlador = persistenciaControlador;
    }

    public boolean contratarEmpleado(String nombre, String apellido, String email, String telefono, Sector sector) {
        try {
            Empleado empleado = Empleado.crearEmpleado(nombre, apellido, email, telefono, sector);
            boolean result = gym.contratarEmpleado(empleado);
            if (result) persistenciaControlador.guardarData(this.gym);
            return result;
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
            boolean result = gym.registrarSocio(socio);
            if (result) persistenciaControlador.guardarData(this.gym);
            return result;
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
            boolean result = gym.registrarMaquina(nuevaMaquina);
            if (result) persistenciaControlador.guardarData(this.gym);
            return result;
        } catch (ExcepcionDuplicado e) {
            System.out.println(e.getMessage());
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Socio buscarSocioPorEmail(String email) {
        for (Socio socio : gym.getSocios()) {
            if (socio.getEmail().equalsIgnoreCase(email)) {
                return socio;
            }
        }
        return null;
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
