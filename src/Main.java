import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salidaMenu = false;
        int cantidadEstudiantesBase = 3;
        ArrayList<Estudiantes> numeroEstudiantes = new ArrayList<>();
        numeroEstudiantes.add(new Estudiantes("Tomas", "Diaz", 18, 8.7));
        numeroEstudiantes.add(new Estudiantes("Juan", "Perez", 16, 10));
        numeroEstudiantes.add(new Estudiantes("Mariano", "Sotelo", 15, 4.2));
        numeroEstudiantes.add(new Estudiantes("Roberto", "Moreno", 19, 7.6));
        System.out.println("Bienvenido al sistema de calificaciones escolar, ¡que desea hacer?...");
        do {
            System.out.println("1.Ver Estudiantes");
            System.out.println("2.Añadir Estudiantes");
            System.out.println("3.Buscar Estudiante");
            System.out.println("4.Salir");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Que desea hacer?");
                    System.out.println("1. Ver un Estudiante en especifico");
                    System.out.println("2. Ver todos los Estudiantes");
                    if (sc.nextInt() == 1) {
                        System.out.println("ingrese el nombre del estudiante");
                        String nombre = sc.next();
                        System.out.println("ingrese el apellido del estudiante");
                        String apellido = sc.next();
                        int numeroDeEstudian = buscadorEstudiante(nombre, apellido, numeroEstudiantes);
                        System.out.println();
                        System.out.println(numeroEstudiantes.get(numeroDeEstudian).nombre);
                        System.out.println(numeroEstudiantes.get(numeroDeEstudian).apellido);
                        System.out.println(numeroEstudiantes.get(numeroDeEstudian).edad);
                        System.out.println(numeroEstudiantes.get(numeroDeEstudian).nota);
                    } else if (sc.nextInt() == 2) {
                        for (int i = 0; i < numeroEstudiantes.size(); i++) {
                            System.out.println(numeroEstudiantes.get(i).nombre);
                            System.out.println(numeroEstudiantes.get(i).apellido);
                            System.out.println(numeroEstudiantes.get(i).edad);
                            System.out.println(numeroEstudiantes.get(i).nota);
                        }
                    }
                    break;
                case 2:
                    System.out.println("cuantos estudiantes desea añadir");
                    int cantidadEstudiante = sc.nextInt();
                    sc.nextLine();
                    int contadorEstudiante = 0;
                    do {
                        System.out.print("Nombre: ");
                        String nombreNuevo = sc.nextLine();

                        System.out.print("Apellido: ");
                        String apellidoNuevo = sc.nextLine();

                        System.out.print("Edad: ");
                        int edadNuevo = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nota: ");
                        double notaNuevo = sc.nextDouble();
                        System.out.println(notaNuevo);

                        numeroEstudiantes.add(new Estudiantes(nombreNuevo, apellidoNuevo, edadNuevo, notaNuevo));
                        contadorEstudiante++;
                    } while (contadorEstudiante < cantidadEstudiante);
                    break;
                case 3:

                case 4:
                    System.out.println("Adios");
                    salidaMenu = true;
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (!salidaMenu);


    }

    public static int buscadorEstudiante(String nombreEstudiante, String apellidoEstudiante, ArrayList<Estudiantes> estudiantes) {
        for (int i = 0; i < estudiantes.size(); i++) {
            if (nombreEstudiante.equals(estudiantes.get(i).getNombre()) &&
                    apellidoEstudiante.equals(estudiantes.get(i).getApellido())) {
                System.out.println("Estudiante encontrado: " + estudiantes.get(i).getNombre() + " " + estudiantes.get(i).getApellido());
                return i;
            }
        }
        System.out.println("Estudiante no encontrado");
        return -1;
    }}
