package org.marcosmorales.modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Socio extends Usuario implements Registrable {
    private Carnet carnet;
    private List clases;


    private Socio(String nombre, String apellido, String email, String telefono) {
        super(nombre, apellido, email, telefono);
        this.carnet = Carnet.generarCarnet();
        this.clases = new ArrayList();
    }

    // Metodo para crear Socio
    protected static Socio crearSocio(String nombre, String apellido, String email, String telefono) {
        return new Socio(nombre, apellido, email, telefono);
    }

    @Override
    public void registrar() {
        // aquí iria la logica
        System.out.println("Socio registrado" + getNombre() + "" + getApellido());
    }

    public Carnet getCarnet() {
        return carnet;
    }

    public List getClases() {
        return clases;
    }

    public void reservarClase(LocalDate fecha, LocalTime horario) {
        if (carnet.verificarValidez()) {
            clases.add(Clase.crearClase(fecha, horario));
            System.out.println("Clase reservada correctamente el " + fecha + " a las " + horario);
        } else {
            System.out.println("Error! Tu membresia está inactiva!");
        }
    }

//    public void cancelarClase(Integer num) {
//        clases.remove(num);
//    }

    public void obtenerHistorialClases() {
        for (int i = 0; i < clases.size(); i++) {
            System.out.println(clases.get(i));
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", carnet='" + carnet + ", clases=" + clases + "'" + "}";
    }
}
