package org.marcosmorales.modelo;

public class Socio extends Usuario {
    private String membresia;

    private Socio(String nombre, String apellido, String email, String telefono) {
        super(nombre, apellido, email, telefono);
        this.membresia = null;
    }

    // Metodo para crear Socio
    protected static Socio crearSocio(String nombre, String apellido, String email, String telefono) {
        return new Socio(nombre, apellido, email, telefono);
    }

    public String getMembresia() {
        return membresia;
    }

    public void reservarClase() {
        System.out.println("Clase reservada correctamente!");
    }
}
