package org.marcosmorales.modelo;

public class Socio extends Usuario {
    private String membresia;

    private Socio(String nombre, String apellido, String email, String telefono, String membresia) {
        super(nombre, apellido, email, telefono);
        this.membresia = membresia;
    }
}
