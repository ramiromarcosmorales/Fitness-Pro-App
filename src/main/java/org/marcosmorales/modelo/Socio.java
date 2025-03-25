package org.marcosmorales.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Socio extends Usuario implements Registrable {
    private Carnet carnet;
    private List<Clase> clases;

    // Constructor sin parámetros
    public Socio() {
        super();
        this.carnet = null;
        this.clases = new ArrayList<>();
    }

    // Constructor con parámetros
    private Socio(String nombre, String apellido, String email, String telefono) {
        super(nombre, apellido, email, telefono);
        this.carnet = Carnet.generarCarnet();
        this.clases = new ArrayList();
    }

    // Getters
    public Carnet getCarnet() {
        return carnet;
    }

    public List getClases() {
        return clases;
    }

    // Metodo para crear Socio
    protected static Socio crearSocio(String nombre, String apellido, String email, String telefono) {
        return new Socio(nombre, apellido, email, telefono);
    }

    public void reservarClase(LocalDate fecha, LocalTime horario) {
        if (carnet.verificarValidez()) {
            LocalDateTime fechaHora = LocalDateTime.of(fecha, horario);
            if (fechaHora.isBefore(LocalDateTime.now())) {
                System.out.println("Error! La fecha o horario no puede ser pasada!");
                return;
            }

            for (Clase clase : clases) {
                if (clase.getFecha().equals(fecha) && clase.getHorario().equals(horario)) {
                    System.out.println("Ya existe una clase reservada en esta fecha y horario!");
                    return;
                }
            }
            clases.add(Clase.crearClase(fecha, horario));
            System.out.println("Clase reservada correctamente el " + fecha + " a las " + horario);
        } else {
            System.out.println("Error! Tu membresia está inactiva!");
        }
    }

    public void eliminarClase(int num) {
        this.clases.remove(num);
    }

    public void obtenerHistorialClases() {
        for (Clase clase : clases) {
            System.out.println(clase);
        }
    }

    @Override
    public void registrar() {
        System.out.println("Socio registrado: " + getNombre() + " " + getApellido());
    }

    @Override
    public String toString() {
        return super.toString() + ", carnet='" + carnet + ", clases=" + clases + "'" + "}";
    }
}
