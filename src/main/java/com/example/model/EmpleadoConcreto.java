package com.example.model;

import javax.persistence.Entity;

@Entity
public class EmpleadoConcreto extends Empleado {

    public EmpleadoConcreto() {
        super(); // Llamada al constructor de la clase padre (Empleado)
    }

    public EmpleadoConcreto(String nombre, String puesto) {
        super(nombre, puesto); // Llamada al constructor de la clase padre (Empleado)
    }

}
