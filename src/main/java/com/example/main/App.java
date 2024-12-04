package com.example.main;

import com.example.dao.EmpleadoDAO;
import com.example.model.Empleado;
import com.example.model.EmpleadoConcreto;

import java.util.Scanner;

public class App {
    private static final EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int option;
        do {
            System.out.println("\n--- Menú de Gestión de Empleados ---");
            System.out.println("1. Crear Empleado");
            System.out.println("2. Obtener Empleado");
            System.out.println("3. Actualizar Empleado");
            System.out.println("4. Eliminar Empleado");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    crearEmpleado();
                    break;
                case 2:
                    obtenerEmpleado();
                    break;
                case 3:
                    actualizarEmpleado();
                    break;
                case 4:
                    eliminarEmpleado();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (option != 5);
    }

    private static void crearEmpleado() {
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el puesto del empleado: ");
        String puesto = scanner.nextLine();

        Empleado empleado1 = new EmpleadoConcreto(nombre, puesto);
        Empleado empleado = empleadoDAO.crearEmpleado(empleado1);
        System.out.println("Empleado creado: " + empleado);
    }

    private static void obtenerEmpleado() {
        System.out.print("Ingrese el ID del empleado a buscar: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Limpiar el buffer

        Empleado empleado = empleadoDAO.obtenerEmpleado(id);
        if (empleado != null) {
            System.out.println("Empleado encontrado: " + empleado);
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private static void actualizarEmpleado() {
        System.out.print("Ingrese el ID del empleado a actualizar: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Limpiar el buffer

        Empleado empleadoExistente = empleadoDAO.obtenerEmpleado(id);
        if (empleadoExistente != null) {
            System.out.print("Ingrese el nuevo nombre del empleado: ");
            String nuevoNombre = scanner.nextLine();
            System.out.print("Ingrese el nuevo puesto del empleado: ");
            String nuevoPuesto = scanner.nextLine();

            Empleado empleadoActualizado = empleadoDAO.actualizarEmpleado(id, nuevoNombre, nuevoPuesto);
            System.out.println("Empleado actualizado: " + empleadoActualizado);
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private static void eliminarEmpleado() {
        System.out.print("Ingrese el ID del empleado a eliminar: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Limpiar el buffer

        Empleado empleadoExistente = empleadoDAO.obtenerEmpleado(id);
        if (empleadoExistente != null) {
            empleadoDAO.eliminarEmpleado(id);
            System.out.println("Empleado eliminado correctamente.");
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    
}
