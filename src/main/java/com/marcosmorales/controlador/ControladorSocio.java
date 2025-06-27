package com.marcosmorales.controlador;

import com.marcosmorales.excepciones.ExcepcionReserva;
import com.marcosmorales.modelo.Clase;
import com.marcosmorales.modelo.Gimnasio;
import com.marcosmorales.modelo.Socio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ControladorSocio {
    private Gimnasio gym;
    private Socio socio;
    private ControladorPersistencia persistenciaControlador;

    public ControladorSocio(Gimnasio gym, Socio socio, ControladorPersistencia persistenciaControlador) {
        this.gym = gym;
        this.socio = socio;
        this.persistenciaControlador = persistenciaControlador;
        System.out.println("Controlador personal creado para el socio: " + socio.getNombre());
    }

    public boolean reservarClase(LocalDate fecha, LocalTime horario) throws ExcepcionReserva {
        if (!(socio.getCarnet().verificarValidez())) {
            System.out.println("La membresia de " + socio.getNombre() + " está vencida!");
            return false;
        }
        System.out.println("Controlador: Pidiendo al modelo que reserva la clase para: " + socio.getNombre());

        try {
            boolean result = gym.reservarClase(this.socio, fecha, horario);
            if (result) persistenciaControlador.guardarData(this.gym);
            return result;
        } catch (ExcepcionReserva e) {
            System.out.println(e.getMessage());
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<Clase> getClases() {
        return this.socio.getClases();
    }

    public boolean eliminarClase(int num) {
        boolean result = this.socio.eliminarClase(num);
        if (result) persistenciaControlador.guardarData(this.gym);
        return result;
    }
}
