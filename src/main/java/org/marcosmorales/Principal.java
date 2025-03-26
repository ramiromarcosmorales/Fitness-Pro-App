package org.marcosmorales;

import org.marcosmorales.modelo.Empleado;
import org.marcosmorales.modelo.Socio;

import java.time.LocalDate;
import java.time.LocalTime;

public class Principal extends Socio {
    public static void main(String[] args) {
        /*
        Test para la clase Socio

        Socio socio = Socio.crearSocio("Ramiro", "Marcos", "ramiro.marcos@mail.com", "1125487542");
        System.out.println(socio);
        socio.reservarClase(LocalDate.of(2025, 03, 23), LocalTime.of(15, 30)); // fecha ya pasada
        socio.reservarClase(LocalDate.of(2025, 03, 28), LocalTime.of(11, 30)); // fecha futura
        socio.reservarClase(LocalDate.of(2025, 03, 28), LocalTime.of(11, 30));
        System.out.println(socio);
        socio.getCarnet().setFechaVencimiento(LocalDate.of(2024, 03, 02));
        System.out.println(socio);
        System.out.println(socio.getCarnet().verificarValidez());
        socio.reservarClase(LocalDate.of(2025, 03, 26), LocalTime.of(11, 00));
        System.out.println(socio);
         */

        /*
        Test para la clase Empleado

        Socio socio = Socio.crearSocio("Ramiro", "Marcos", "ramiro.marcos@mail.com", "1125487542");
        Empleado empleado = Empleado.crearEmpleado("Bautista", "Garcia", "bautista.garcia@mail.com", "1132453421", "profesor");
        System.out.println(empleado);
        empleado.registrar();
        socio.reservarClase(LocalDate.of(2025, 03, 26), LocalTime.of(11, 00));
        empleado.gestionarSocios(socio);
         */
    }
}
