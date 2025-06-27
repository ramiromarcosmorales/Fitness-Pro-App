package com.marcosmorales.modelo;

import com.marcosmorales.excepciones.ExcepcionDuplicado;
import com.marcosmorales.excepciones.ExcepcionReserva;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Gimnasio {
    private List<Empleado> empleados = new ArrayList<>();
    private List<Socio> socios = new ArrayList<>();
    private List<Clase> clases = new ArrayList<>(); // reemplazar por tad
    private PriorityQueue<Maquina> maquinasPriority;

    public Gimnasio() {
        this.maquinasPriority = new PriorityQueue<>(
                Comparator.comparing(Maquina::getProxMantenimiento)
        );
    }

    public boolean contratarEmpleado(Empleado empleado) throws ExcepcionDuplicado {
        if (empleado == null) throw new IllegalArgumentException("El empleado no puede ser nulo!");


        if (empleados.contains(empleado))
            throw new ExcepcionDuplicado("Error Gimnasio: El empleado ya esta registrado.");

        return empleados.add(empleado);
    }

    public boolean registrarSocio(Socio socio) throws ExcepcionDuplicado {
        if (socio == null) throw new IllegalArgumentException("El socio no puede ser nulo!");


        if (socios.contains(socio))
            throw new ExcepcionDuplicado("Error Gimnasio: El socio ya está registrado.");

        return socios.add(socio);
    }

    public boolean registrarMaquina(Maquina maquina) throws ExcepcionDuplicado {
        if (maquina == null) throw new IllegalArgumentException("La maquina no puede ser nulo!");

        if (maquinasPriority.contains(maquina))
            throw new ExcepcionDuplicado("Error Gimnasio: La maquina ya esta registrada.");

        return maquinasPriority.add(maquina);
    }

    public Maquina getProximaMaquinaMantenimiento() {
        return maquinasPriority.peek();
    }

    public boolean reservarClase(Socio socio, LocalDate fecha, LocalTime horario) throws ExcepcionReserva {
        if (socio == null || fecha == null || horario == null)
            throw new IllegalArgumentException("Uno de los datos recibidos es nulo!");

        if (!socio.getCarnet().verificarValidez())
            throw new ExcepcionReserva("Error Socio: La membresia no esta activa.");

        for (Clase clase : clases) {
            if (clase.getFecha().equals(fecha) && clase.getHorario().equals(horario))
                throw new ExcepcionReserva("Error Socio: Ya existe una clase reservada en esta fecha y horario.");
        }

        Clase clase = Clase.crearClase(fecha, horario);

        boolean socioPudoAnadirla = socio.agregarClase(clase);

        if (socioPudoAnadirla) {
            this.clases.add(clase);
            return true;
        }
        throw new ExcepcionReserva("Error Socio: Ya existe una clase!");
    }

    public List<Empleado> getEmpleados() {
        return this.empleados;
    }

    public List<Socio> getSocios() {
        return this.socios;
    }
}
