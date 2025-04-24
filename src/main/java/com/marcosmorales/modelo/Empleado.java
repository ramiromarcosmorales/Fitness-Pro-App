package com.marcosmorales.modelo;

import java.time.LocalDate;
import java.util.Scanner;

public class Empleado extends Usuario implements Registrable {
    private Sector sector;

    Scanner sc = new Scanner(System.in);

    // Constructor sin parámetros
    public Empleado() {
        super();
        this.sector = null;
    }

    // Constructor con parámetros
    private Empleado(String nombre, String apellido, String email, String telefono, Sector sector) {
        super(nombre, apellido, email, telefono);
        this.sector = sector;
    }

    // Getter y Setter
    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    // Metodo para crear Empleado
    public static Empleado crearEmpleado(String nombre, String apellido, String email, String telefono, Sector sector) {
        return new Empleado(nombre, apellido, email, telefono, sector);
    }


    // Deberia crear una clase Gimnasio que almacene todos las maquinas.
    public Maquina registrarMaquina(TipoMaquina tipo, LocalDate ultMantenimiento) {
        return Maquina.crearMaquina(tipo, ultMantenimiento);
    }

//    public void gestionarSocios(Socio socio) {
//        System.out.println("Gestion de socios: Ingrese una opciòn");
//        System.out.println("1 - Obtener su perfil");
//        System.out.println("2 - Obtener historial de clases ");
//        System.out.println("3 - Validar membresía");
//        int opcion = Integer.parseInt(sc.nextLine());
//
//        switch(opcion) {
//            case 1:
//                System.out.println(socio);
//                break;
//            case 2:
//                if (socio.getClases().isEmpty()) {
//                    System.out.println("El socio no posee clases!");
//                } else {
//                    socio.obtenerHistorialClases(0);
//                }
//                break;
//            case 3:
//                if (socio.getCarnet().verificarValidez()) {
//                    System.out.println("El socio tiene un carnet válido con vencimiento el " + socio.getCarnet().getFechaVencimiento());
//                } else {
//                    System.out.println("El socio tiene un carnet inválido!");
//                }
//                break;
//            default:
//                System.out.println("Opcion fuera de rango!");
//                break;
//        }
//    }

    @Override
    public void registrar() {
        System.out.println("Empleado registrado: " + getNombre() + " " + getApellido());
    }

    @Override
    public String toString() {
        return super.toString() + ", sector='" + sector + "'" + "}";
    }
}
