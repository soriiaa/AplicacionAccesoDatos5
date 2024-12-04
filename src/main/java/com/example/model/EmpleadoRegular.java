package com.example.model;

import javax.persistence.Entity;

@Entity
public class EmpleadoRegular extends Empleado {

    private double salarioAnual;

    public EmpleadoRegular() {}

    public EmpleadoRegular(String nombre, String puesto, double salarioAnual) {
        super(nombre, puesto);
        this.salarioAnual = salarioAnual;
    }

    public double getSalarioAnual() {
        return salarioAnual;
    }

    public void setSalarioAnual(double salarioAnual) {
        this.salarioAnual = salarioAnual;
    }

    @Override
    public String toString() {
        return "EmpleadoRegular{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", puesto='" + getPuesto() + '\'' +
                ", salarioAnual=" + salarioAnual +
                '}';
    }
}
