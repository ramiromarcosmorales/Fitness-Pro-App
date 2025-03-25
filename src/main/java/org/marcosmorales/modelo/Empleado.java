package org.marcosmorales.modelo;

public class Empleado extends Usuario implements Registrable {
    private String sector;

    // Constructor sin parámetros
    public Empleado() {
        super();
        this.sector = null;
    }

    // Constructor con parámetros
    private Empleado(String nombre, String apellido, String email, String telefono, String sector) {
        super(nombre, apellido, email, telefono);
        this.sector = sector;
    }

    // Getter y Setter
    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    // Metodo para crear Empleado
    public static Empleado crearEmpleado(String nombre, String apellido, String email, String telefono, String sector) {
        return new Empleado(nombre, apellido, email, telefono, sector);
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
    public void registrar() {
        System.out.println("Empleado registrado: " + getNombre() + " " + getApellido());
    }

    @Override
    public String toString() {
        return super.toString() + ", sector='" + sector + "'" + "}";
    }
}
