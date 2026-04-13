package principal;
import model.InicioSesion.Usuario;
import model.Materia.Materia;
import model.Persona.Estudiante;
import model.Actividad.Actividad;
import model.Calendario.*;
import Servicio.GenerarCalendario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import Servicio.ValidacionIniSesi;
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Usuario> usuarios = new ArrayList<>();
        ValidacionIniSesi auth = new ValidacionIniSesi();

        int opcion;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesión");
            System.out.println("0. Salir");
            System.out.print("Seleccione: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {

                case 1:
                    // REGISTRO
                    System.out.println("\n--- REGISTRO ---");

                    System.out.print("Nombres: ");
                    String nombres = sc.nextLine();

                    System.out.print("Apellidos: ");
                    String apellidos = sc.nextLine();

                    System.out.print("Correo: ");
                    String correo = sc.nextLine();

                    System.out.print("Tipo documento: ");
                    String tipoDoc = sc.nextLine();

                    System.out.print("Edad: ");
                    int edad = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Carrera: ");
                    String carrera = sc.nextLine();

                    System.out.print("Semestre: ");
                    int semestre = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Username: ");
                    String username = sc.nextLine();

                    System.out.print("Password: ");
                    String password = sc.nextLine();

                    // Crear estudiante
                    Estudiante est = new Estudiante();
                    est.setNombres(nombres);
                    est.setApellidos(apellidos);
                    est.setCorreoElectronico(correo);
                    est.setTipoDoc(tipoDoc);
                    est.setEdad(edad);
                    est.setCarrera(carrera);
                    est.setSemestre(semestre);

                    // Crear usuario
                    Usuario user = new Usuario(username, password, est);

                    usuarios.add(user);

                    System.out.println("Usuario registrado con éxito");
                    break;

                case 2:
                    // LOGIN
                    System.out.println("\n--- Iniciar Sesion ---");

                    System.out.print("Username: ");
                    String userLogin = sc.nextLine();

                    System.out.print("Password: ");
                    String passLogin = sc.nextLine();

                    Usuario logueado = auth.login(userLogin, passLogin, usuarios);

                    if (logueado != null) {
                        System.out.println("Bienvenido " +
                                logueado.getPersona().getNombres());
                    } else {
                        System.out.println("Credenciales incorrectas");
                    }
                    if (logueado != null) {
                    

    // Obtener estudiante
    Estudiante E1 = (Estudiante) logueado.getPersona();

    GenerarCalendario generador = new GenerarCalendario();
    Calendario calendario = generador.generarCalendario();

    int opcionInterna;

    do {
        System.out.println("\n===== MENU USUARIO =====");
        System.out.println("1. Agregar materia");
        System.out.println("2. Ver calendario");
        System.out.println("3. Ver materias");
        System.out.println("4. Ver actividades pendientes");
        System.out.println("5. Ver actividades calificadas");
        System.out.println("0. Cerrar sesión");
        System.out.print("Seleccione: ");
        
        opcionInterna = sc.nextInt();
        sc.nextLine();

        switch (opcionInterna) {

            case 1:
                System.out.println("\n--- AGREGAR MATERIA ---");

                System.out.print("Nombre de la materia: ");
                String nombreMateria = sc.nextLine();

                System.out.print("Horario: ");
                String horario = sc.nextLine();

    
                Materia materia = new Materia(nombreMateria, new ArrayList<>(), horario, null);

        
                if (E1.getMateriasCursando() == null) {
                E1.setMateriasCursando(new java.util.ArrayList<>());
                }

                E1.getMateriasCursando().add(materia);

                System.out.println("Materia agregada");
                break;

            case 2:
                System.out.println("\n--- CALENDARIO ---");

                Anio anio = calendario.getAnios().get(0);

                 System.out.println("Seleccione un mes:");

                for (int i = 0; i < anio.getMeses().size(); i++) {
                    System.out.println((i + 1) + ". " + anio.getMeses().get(i).getNombre());
                }

                System.out.print("Opción: ");
                int opcionMes = sc.nextInt();
                sc.nextLine();

                if (opcionMes >= 1 && opcionMes <= 12) {

                Mes mesSeleccionado = anio.getMeses().get(opcionMes - 1);

                System.out.println("\nMes: " + mesSeleccionado.getNombre());

                for (Dia d : mesSeleccionado.getDias()) {
                System.out.print(d.getNumero() + " ");
                }

                System.out.println(); // salto de línea

                } else {
                    System.out.println("Mes inválido");
                    }

                break;
                case 3:
                    System.out.println("\n--- MATERIAS ---");

                    if (E1.getMateriasCursando() == null || E1.getMateriasCursando().isEmpty()) {
                    System.out.println("No hay materias registradas");
                } else {
                for (Materia m : E1.getMateriasCursando()) {
                System.out.println("- " + m.getNombre() + " | ID: " + m.getId());
                }
                }

                break;
                case 4:
                System.out.println("\n--- ACTIVIDADES PENDIENTES ---");

                if (E1.getMateriasCursando() == null) {
                System.out.println("No hay materias");
                break;
                }

                for (Materia m : E1.getMateriasCursando()) {

                if (m.getActividades() != null) {
                for (Actividad a : m.getActividades()) {

                if (a.getCalificacion() == 0) {
                    System.out.println("Materia: " + m.getNombre());
                    System.out.println("Actividad: " + a);
                    System.out.println("-------------------");
                }
            }
        }
    }

                break;
                case 5:
                System.out.println("\n--- ACTIVIDADES CALIFICADAS ---");

                if (E1.getMateriasCursando() == null) {
                System.out.println("No hay materias");
                break;
                }

                for (Materia m : E1.getMateriasCursando()) {

                if (m.getActividades() != null) {
                for (Actividad a : m.getActividades()) {

                if (a.getCalificacion() > 0) {
                    System.out.println("Materia: " + m.getNombre());
                    System.out.println("Actividad: " + a);
                    System.out.println("Calificación: " + a.getCalificacion());
                    System.out.println("-------------------");
                }
            }
        }
    }

    break;
            case 0:
                System.out.println("Cerrando sesión...");
                break;

            default:
                System.out.println("Opción inválida");
        }

    } while (opcionInterna != 0);

} else {
    System.out.println("Credenciales incorrectas");
}
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 0);

        sc.close();
    }
}

