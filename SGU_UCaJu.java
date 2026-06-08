package sgu_ucaju;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

public class SGU_UCaJu {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        ArrayList<Alumno> alumnos =
                new ArrayList<>();

        int opcion;

        do {

            System.out.println();
            System.out.println("===== SGU-UCaJu =====");
            System.out.println("1. Registrar Alumno");
            System.out.println("2. Mostrar Alumnos");
            System.out.println("3. Buscar Alumno");
            System.out.println("4. Ordenar Alumnos");
            System.out.println("0. Salir");

            System.out.print("Opcion: ");

            try {

                System.out.print("Opcion: ");
                opcion = teclado.nextInt();
                teclado.nextLine();

            } catch (Exception e) {

                System.out.println("Error: debe ingresar un numero.");

                teclado.nextLine(); // limpia el buffer
                opcion = -1;
            }

            switch (opcion) {

                case 1:

                    System.out.print("Nombre: ");
                    String nombre =
                            teclado.nextLine();

                    System.out.print("Apellido: ");
                    String apellido =
                            teclado.nextLine();

                    System.out.print("DNI: ");
                    String dni =
                            teclado.nextLine();

                    System.out.print("Email: ");
                    String email =
                            teclado.nextLine();

                    Alumno alumno =
                            new Alumno(
                                    nombre,
                                    apellido,
                                    dni,
                                    email);

                    alumnos.add(alumno);

                    System.out.println(
                            "Alumno registrado correctamente.");

                    break;

                case 2:

                    if (alumnos.isEmpty()) {

                        System.out.println(
                                "No hay alumnos registrados.");

                    } else {

                        for (Alumno a : alumnos) {

                            a.mostrarDatos();
                        }
                    }

                    break;
                case 3:

                        System.out.print("Ingrese DNI: ");

                        String dniBuscado =
                            teclado.nextLine();
                        boolean encontrado = false;

                        for (Alumno a : alumnos) {
                            

                            if (a.getDni().equals(dniBuscado)) {

                                    a.mostrarDatos();
                                    encontrado = true;
                            }
                        }
                    if (!encontrado) {

                            System.out.println("Alumno no encontrado.");
                    }    
                    
                    break;
                case 4:

                        if (alumnos.isEmpty()) {

                                System.out.println("No hay alumnos para ordenar.");

                        } else {

                            Collections.sort(alumnos, new Comparator<Alumno>() {

                                @Override
                                public int compare(Alumno a1, Alumno a2) {

                                    return a1.getApellido().compareToIgnoreCase(a2.getApellido());
                                }
                            });

                            System.out.println("Alumnos ordenados por apellido.");

                        }

                    break;

                case 0:

                    System.out.println(
                            "Fin del programa.");

                    break;

                default:

                    System.out.println(
                            "Opcion invalida.");
            }

        } while (opcion != 0);

        teclado.close();
    }
}