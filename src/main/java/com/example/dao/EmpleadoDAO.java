package com.example.dao;

import com.example.config.HibernateUtil;
import com.example.model.Empleado;
import com.example.model.EmpleadoRegular;
import com.example.model.EmpleadoContratado;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmpleadoDAO {

    // Método genérico para crear empleados de cualquier tipo
    public <T extends Empleado> T crearEmpleado(T empleado) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(empleado);

        transaction.commit();
        session.close();

        return empleado;
    }

    // Método para obtener empleados genéricos
    public Empleado obtenerEmpleado(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Empleado empleado = session.get(Empleado.class, id);
        session.close();
        return empleado;
    }

    // Método para obtener empleados de tipo específico
    public <T extends Empleado> T obtenerEmpleadoPorClase(Long id, Class<T> clase) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        T empleado = session.get(clase, id);
        session.close();
        return empleado;
    }

    // Método para actualizar empleados
    public Empleado actualizarEmpleado(Long id, String nuevoNombre, String nuevoPuesto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Empleado empleado = session.get(Empleado.class, id);
        if (empleado != null) {
            empleado.setNombre(nuevoNombre);
            empleado.setPuesto(nuevoPuesto);
            session.update(empleado);
        }

        transaction.commit();
        session.close();

        return empleado;
    }

    // Método para eliminar empleados
    public void eliminarEmpleado(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Empleado empleado = session.get(Empleado.class, id);
        if (empleado != null) {
            session.delete(empleado);
        }

        transaction.commit();
        session.close();
    }

    // Métodos específicos para subclases (si es necesario)
    public EmpleadoRegular crearEmpleadoRegular(String nombre, String puesto, double salario) {
        EmpleadoRegular empleadoRegular = new EmpleadoRegular(nombre, puesto, salario);
        return crearEmpleado(empleadoRegular);
    }

    public EmpleadoContratado crearEmpleadoContratado(String nombre, String puesto, double tarifaPorHora, int horasTrabajadas) {
        EmpleadoContratado empleadoContratado = new EmpleadoContratado(nombre, puesto, tarifaPorHora, horasTrabajadas);
        return crearEmpleado(empleadoContratado);
    }

}
