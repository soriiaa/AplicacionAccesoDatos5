package com.example.model;

import javax.persistence.Entity;

@Entity
public class EmpleadoContratado extends Empleado {

    private double tarifaPorHora;
    private int horasTrabajadas;

    public EmpleadoContratado() {}

    public EmpleadoContratado(String nombre, String puesto, double tarifaPorHora, int horasTrabajadas) {
        super(nombre, puesto);
        this.tarifaPorHora = tarifaPorHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    public double getTarifaPorHora() {
        return tarifaPorHora;
    }

    public void setTarifaPorHora(double tarifaPorHora) {
        this.tarifaPorHora = tarifaPorHora;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public double calcularPagoTotal() {
        return tarifaPorHora * horasTrabajadas;
    }

    @Override
    public String toString() {
        return "EmpleadoContratado{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", puesto='" + getPuesto() + '\'' +
                ", tarifaPorHora=" + tarifaPorHora +
                ", horasTrabajadas=" + horasTrabajadas +
                ", pagoTotal=" + calcularPagoTotal() +
                '}';
    }
}
