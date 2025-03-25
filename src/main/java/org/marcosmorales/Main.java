package org.marcosmorales;

import org.marcosmorales.modelo.Carnet;
import org.marcosmorales.modelo.Empleado;
import org.marcosmorales.modelo.Socio;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Socio socio1 = Socio.crearSocio("bautista", "gonzalez", "bautista_gonzalez@gmail.com", "1155443322");
        System.out.println(socio1);
        socio1.reservarClase(LocalDate.of(2025,3,24), LocalTime.of(15, 00));
        socio1.reservarClase(LocalDate.of(2025,3,25), LocalTime.of(11, 00));
        socio1.obtenerHistorialClases();
        System.out.println(socio1);

//        Empleado empleado1 = Empleado.crearEmpleado("ramiro", "marcos", "ramiro@gmail.com", "1143545623", "profesores");
//        System.out.println(empleado1);
    }
}