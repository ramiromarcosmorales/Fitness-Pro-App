package org.marcosmorales.modelo;

import java.util.UUID;

public class Usuario {
    private String id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    // Constructor Protected (Solo las clases hijas pueden acceder al Constructor)
    protected Usuario(String nombre, String apellido, String email, String telefono) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

    // Metodo para crear Usuario
    protected static Usuario crearUsuario(String nombre, String apellido, String email, String telefono) {
        return new Usuario(nombre, apellido, email, telefono);
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
