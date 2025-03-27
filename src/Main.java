import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salidaMenu = false;
        int numeroDeEstudiante;
        int opcion;
        int cantidadEstudiante;
        int contadorEstudiante;
        int edadNuevo;
        double notaNuevo;
        String nombreNuevo;
        String apellidoNuevo;
        String nombre;
        String apellido;
        ArrayList<Estudiantes> numeroEstudiantes = new ArrayList<>();
        numeroEstudiantes.add(new Estudiantes("Tomas", "Diaz", 18, 8.7));
        numeroEstudiantes.add(new Estudiantes("Juan", "Perez", 16, 10));
        numeroEstudiantes.add(new Estudiantes("Mariano", "Sotelo", 15, 4.2));
        numeroEstudiantes.add(new Estudiantes("Roberto", "Moreno", 19, 7.6));
        System.out.println("Bienvenido al sistema de calificaciones escolar, ¡que desea hacer?...");
        do {
            System.out.println("1.Ver Estudiantes");
            System.out.println("2.Añadir Estudiantes");
            System.out.println("3.Cambiar notas");
            System.out.println("4.Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Que desea hacer?");
                    System.out.println("1. Ver un Estudiante en especifico");
                    System.out.println("2. Ver todos los Estudiantes");//funcion 2 pregunta doble
                    if (sc.nextInt() == 1) {
                        numeroDeEstudiante = preguntarDatos(numeroEstudiantes);
                        if (numeroDeEstudiante == -1) {
                            System.out.println("Estudiante no encontrado");
                        } else {
                            System.out.println(numeroEstudiantes.get(numeroDeEstudiante).toString());
                        }
                    } else if (sc.nextInt() == 2) {
                        for (int i = 0; i < numeroEstudiantes.size(); i++) {
                            System.out.println(numeroEstudiantes.get(i).toString());
                        }
                    }
                    break;
                case 2:
                    System.out.println("cuantos estudiantes desea añadir");
                    cantidadEstudiante = sc.nextInt();
                    sc.nextLine();
                    contadorEstudiante = 0;
                    do {
                        System.out.print("Nombre: ");
                        nombreNuevo = sc.nextLine();
                        System.out.print("Apellido: ");
                        apellidoNuevo = sc.nextLine();
                        System.out.print("Edad: ");
                        edadNuevo = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nota: ");
                        notaNuevo = sc.nextDouble(); // error por la coma
                        System.out.println(notaNuevo);
                        numeroEstudiantes.add(new Estudiantes(nombreNuevo, apellidoNuevo, edadNuevo, notaNuevo));
                        contadorEstudiante++;
                    } while (contadorEstudiante < cantidadEstudiante);
                    break;
                case 3:
                    System.out.println("cuantos estudiantes desea cambiar");
                    System.out.println("1. Cambiar un Estudiante en especifico");
                    System.out.println("2. Cambiar todos");
                    if (sc.nextInt() == 2) {
                        for (int i = 0; i < numeroEstudiantes.size(); i++) {
                            numeroEstudiantes.get(i).setNota(sc.nextDouble());
                        }
                    } else if (sc.nextInt() == 1) {
                        numeroDeEstudiante = preguntarDatos(numeroEstudiantes);
                        System.out.println("Escriba la nueva nota");
                        numeroEstudiantes.get(numeroDeEstudiante).setNota(sc.nextDouble());
                    }
                case 4:
                    System.out.println("Adios");
                    salidaMenu = true;
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (!salidaMenu);
    }

    public static int preguntarDatos(ArrayList<Estudiantes> estudiantes) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese el nombre del estudiante");//tostring
        String nombre = sc.next();
        System.out.println("ingrese el apellido del estudiante");
        String apellido = sc.next();
        return buscadorEstudiante(nombre, apellido, estudiantes);
    }

    public static int buscadorEstudiante(String nombreEstudiante, String apellidoEstudiante, ArrayList<Estudiantes> estudiantes) {
        boolean encontrado = false;
        int i = 0;
        do {
            if (nombreEstudiante.equals(estudiantes.get(i).getNombre()) &&
                    apellidoEstudiante.equals(estudiantes.get(i).getApellido())) {
                System.out.println("Estudiante encontrado: " + estudiantes.get(i).getNombre() + " " + estudiantes.get(i).getApellido());
                encontrado = true;
            } else {
                i++;
            }
        } while (i < estudiantes.size() && !encontrado);
        if (!encontrado) {
            i = -1;
        }
        return i;
    }
}
