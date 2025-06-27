package com.marcosmorales;
import com.marcosmorales.controlador.ControladorGimnasio;
import com.marcosmorales.controlador.ControladorPersistencia;
import com.marcosmorales.controlador.ControladorSocio;
import com.marcosmorales.excepciones.ExcepcionReserva;
import com.marcosmorales.modelo.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class Principal {
    public static void main(String[] args) throws ExcepcionReserva {
        ControladorPersistencia persistenciaController = new ControladorPersistencia();
        Gimnasio gym = persistenciaController.cargar();
        ControladorGimnasio gymController = new ControladorGimnasio(gym, persistenciaController);

        gymController.registrarSocio(
                "Bautista",
                "Lopez",
                "bautista.ok@gmail.com",
                "5491158785457"
        );

        Socio socioActual = gymController.buscarSocioPorEmail("bautista.ok@gmail.com");

        if (socioActual != null) {
            ControladorSocio socioController = new ControladorSocio(gym, socioActual, persistenciaController);

            LocalDate fechaClase = LocalDate.now().plusWeeks(1); // Para la semana que viene
            LocalTime horaClase = LocalTime.of(19, 0); // A las 19:00

            boolean reservaExitosa = socioController.reservarClase(fechaClase, horaClase);

            if (reservaExitosa){
                System.out.println("Reserva exitosa.");
            } else {
                System.out.println("No se pudo realizar la reserva");
            }

        } else {
            System.out.println("Socio no encontrado.");
        }
    }
}
