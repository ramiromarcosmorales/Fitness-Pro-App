package com.marcosmorales.controlador;

import com.marcosmorales.modelo.Clase;
import com.marcosmorales.modelo.Gimnasio;
import com.marcosmorales.modelo.Socio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ControladorSocio {
    private Gimnasio gym;
    private Socio socio;

    public ControladorSocio(Gimnasio gym, Socio socio) {
        this.gym = gym;
        this.socio = socio;
        System.out.println("Controlador personal creado para el socio: " + socio.getNombre());
    }

    public boolean reservarClase(LocalDate fecha, LocalTime horario) {
        if (!(socio.getCarnet().verificarValidez())) {
            System.out.println("La membresia de " + socio.getNombre() + " está vencida!");
            return false;
        }

        System.out.println("Controlador: Pidiendo al modelo que reserva la clase para: " + socio.getNombre());
        return gym.reservarClase(this.socio, fecha, horario);
    }

    public List<Clase> getClases() {
        return this.socio.getClases();
    }

    public boolean eliminarClase(int num) {
        return this.socio.eliminarClase(num);
    }
}
