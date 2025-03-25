package org.marcosmorales.modelo;

public class Empleado extends Usuario {
    private String sector;

    private Empleado(String nombre, String apellido, String email, String telefono, String sector) {
        super(nombre, apellido, email, telefono);
        this.sector = sector;
    }

    // Metodo para crear Empleado
    public static Empleado crearEmpleado(String nombre, String apellido, String email, String telefono, String sector) {
        return new Empleado(nombre, apellido, email, telefono, sector);
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public void registrarMaquina() {
        System.out.println("Maquina registrada correctamente!");
    }

    public void gestionarClases() {
        System.out.println("Esto deberia ser como un metodo sobreescrito!");
    }

    public void gestionarSocios() {
        System.out.println("Gestion de socios");
    }

    @Override
    public String toString() {
        return super.toString() + ", sector='" + sector + "'" + "}";
    }
}
