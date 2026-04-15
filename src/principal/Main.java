package principal;

import Servicio.ListaEnlazada.*;
import model.InicioSesion.*;
import Servicio.ValidacionIniSesi;
import Servicio.GenerarCalendario;
import model.Persona.*;
import model.Calendario.*;
import model.Materia.*;
import model.Actividad.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ListaEnlazada<Usuario> usuarios = new ListaEnlazada<>();
        ValidacionIniSesi auth = new ValidacionIniSesi();

        int opcion;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesión");
            System.out.println("0. Salir");
            System.out.print("Seleccione: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1: {

                    System.out.println("\n--- REGISTRO ---");

                    Estudiante est = new Estudiante();

                    System.out.print("Nombres: ");
                    est.setNombres(sc.nextLine());

                    System.out.print("Apellidos: ");
                    est.setApellidos(sc.nextLine());

                    System.out.print("Correo: ");
                    est.setCorreoElectronico(sc.nextLine());

                    System.out.print("Tipo documento: ");
                    est.setTipoDoc(sc.nextLine());

                    System.out.print("Edad: ");
                    est.setEdad(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Carrera: ");
                    est.setCarrera(sc.nextLine());

                    System.out.print("Semestre: ");
                    est.setSemestre(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Username: ");
                    String username = sc.nextLine();

                    System.out.print("Password: ");
                    String password = sc.nextLine();

                    Usuario user = new Usuario(username, password, est);

                    usuarios.agregar(user);

                    System.out.println("Usuario registrado con éxito");

                    break;
                }

                case 2: {

                    System.out.println("\n--- LOGIN ---");

                    System.out.print("Username: ");
                    String userLogin = sc.nextLine();

                    System.out.print("Password: ");
                    String passLogin = sc.nextLine();

                    Usuario logueado = auth.login(userLogin, passLogin, usuarios);

                    if (logueado == null) {
                        System.out.println("Credenciales incorrectas");
                        break;
                    }

                    Estudiante E1 = (Estudiante) logueado.getPersona();

                    GenerarCalendario generador = new GenerarCalendario();
                    Calendario calendario = generador.generarCalendario();

                    int opcionInterna;

                    do {

                        System.out.println("\n===== MENU USUARIO =====");
                        System.out.println("1. Agregar materia");
                        System.out.println("2. Ver calendario");
                        System.out.println("3. Ver materias");
                        System.out.println("4. Ver actividades pendientes (por prioridad)");
                        System.out.println("5. Ver actividades calificadas");
                        System.out.println("6. Crear actividad");
                        System.out.println("0. Cerrar sesión");
                        System.out.print("Seleccione: ");

                        opcionInterna = sc.nextInt();
                        sc.nextLine();

                        switch (opcionInterna) {

                            case 1: {

                                System.out.println("\n--- AGREGAR MATERIA ---");

                                System.out.print("Nombre materia: ");
                                String nombreMateria = sc.nextLine();

                                System.out.print("Horario: ");
                                String horario = sc.nextLine();

                                System.out.print("Nombre profesor: ");
                                String nombreProfesor = sc.nextLine();

                                Profesor profesor = new Profesor();
                                profesor.setNombres(nombreProfesor);

                                Materia materia = new Materia(nombreMateria, horario, profesor);

                                if (E1.getMateriasCursando() == null) {
                                    E1.setMateriasCursando(new ListaEnlazada<>());
                                }

                                E1.getMateriasCursando().agregar(materia);

                                System.out.println("Materia agregada con ID: " + materia.getId());

                                break;
                            }

                            case 2: {

                                System.out.println("\n--- CALENDARIO ---");

                                Nodo<Anio> nodoAnio = calendario.getAnios().getCabeza();
                                Anio anio = nodoAnio.getDato();

                                Nodo<Mes> nodoMes = anio.getMeses().getCabeza();

                                int i = 1;
                                System.out.println("Seleccione un mes:");

                                while (nodoMes != null) {
                                    System.out.println(i + ". " + nodoMes.getDato().getNombre());
                                    nodoMes = nodoMes.getSiguiente();
                                    i++;
                                }

                                System.out.print("Opción: ");
                                int opcionMes = sc.nextInt();
                                sc.nextLine();

                                nodoMes = anio.getMeses().getCabeza();
                                int c = 1;

                                while (c < opcionMes) {
                                    nodoMes = nodoMes.getSiguiente();
                                    c++;
                                }

                                Mes mes = nodoMes.getDato();

                                System.out.println("\nMes: " + mes.getNombre());

                                Nodo<Dia> nodoDia = mes.getDias().getCabeza();

                                while (nodoDia != null) {
                                    System.out.print(nodoDia.getDato().getNumero() + " ");
                                    nodoDia = nodoDia.getSiguiente();
                                }

                                System.out.println();

                                break;
                            }

                            case 3: {

                                System.out.println("\n--- MATERIAS ---");

                                Nodo<Materia> aux = E1.getMateriasCursando().getCabeza();

                                while (aux != null) {

                                    Materia m = aux.getDato();

                                    String profe = (m.getInstructor() != null)
                                            ? m.getInstructor().getNombres()
                                            : "Sin profesor";

                                    System.out.println("- " + m.getNombre() +
                                            " | " + m.getId() +
                                            " | " + m.getHorario() +
                                            " | Profesor: " + profe);

                                    aux = aux.getSiguiente();
                                }

                                break;
                            }

                            case 4: {

                                System.out.println("\n--- ACTIVIDADES PENDIENTES (POR PRIORIDAD) ---");

                                Nodo<Materia> aux = E1.getMateriasCursando().getCabeza();

                                while (aux != null) {

                                    Materia m = aux.getDato();

                                    System.out.println("\nMateria: " + m.getNombre());

                                    m.ordenarPorPrioridad();

                                    m.mostrarActividadesOrdenadas();

                                    aux = aux.getSiguiente();
                                }

                                break;
                            }

                            case 5: {

                                System.out.println("\n--- ACTIVIDADES CALIFICADAS ---");

                                Nodo<Materia> aux = E1.getMateriasCursando().getCabeza();

                                while (aux != null) {

                                    Materia m = aux.getDato();
                                    Nodo<Actividad> act = m.getActividades().getCabeza();

                                    while (act != null) {

                                        Actividad a = act.getDato();

                                        if (a.getCalificacion() > 0) {
                                            System.out.println("Materia: " + m.getNombre());
                                            System.out.println("Actividad: " + a);
                                            System.out.println("------------------");
                                        }

                                        act = act.getSiguiente();
                                    }

                                    aux = aux.getSiguiente();
                                }

                                break;
                            }

                            case 6: {

                                System.out.println("\n--- CREAR ACTIVIDAD ---");

                                Nodo<Materia> aux = E1.getMateriasCursando().getCabeza();

                                int index = 1;
                                System.out.println("Seleccione una materia:");

                                while (aux != null) {
                                    System.out.println(index + ". " + aux.getDato().getNombre());
                                    aux = aux.getSiguiente();
                                    index++;
                                }

                                System.out.print("Opción: ");
                                int opcionMateria = sc.nextInt();
                                sc.nextLine();

                                aux = E1.getMateriasCursando().getCabeza();
                                int contador = 1;

                                while (contador < opcionMateria) {
                                    aux = aux.getSiguiente();
                                    contador++;
                                }

                                Materia materiaSeleccionada = aux.getDato();

                                System.out.println("\nTipo de actividad:");
                                System.out.println("1. Parcial");
                                System.out.println("2. Quiz");
                                System.out.println("3. Taller");
                                System.out.print("Seleccione: ");

                                int tipo = sc.nextInt();
                                sc.nextLine();

                                System.out.print("Fecha entrega: ");
                                String fechaEntrega = sc.nextLine();

                                System.out.print("Hora entrega: ");
                                String horaEntrega = sc.nextLine();

                                System.out.print("¿Es grupal? (true/false): ");
                                boolean grupal = sc.nextBoolean();
                                sc.nextLine();

                                System.out.print("Grado de importancia (1-10): ");
                                int importancia = sc.nextInt();
                                sc.nextLine();

                                Actividad actividad = null;

                                switch (tipo) {

                                    case 1: {

                                        System.out.print("Número de preguntas: ");
                                        int numPreguntas = sc.nextInt();
                                        sc.nextLine();

                                        System.out.print("Tiempo: ");
                                        String tiempo = sc.nextLine();

                                        actividad = new Parcial(
                                                0, fechaEntrega, horaEntrega,
                                                grupal, importancia,
                                                numPreguntas, tiempo
                                        );
                                        break;
                                    }

                                    case 2: {

                                        System.out.print("Número de quiz: ");
                                        int numQuiz = sc.nextInt();

                                        System.out.print("Número de preguntas: ");
                                        int numPreguntas = sc.nextInt();
                                        sc.nextLine();

                                        System.out.print("Tiempo: ");
                                        String tiempo = sc.nextLine();

                                        actividad = new Quiz(
                                                0, fechaEntrega, horaEntrega,
                                                grupal, importancia,
                                                numQuiz, numPreguntas, tiempo
                                        );
                                        break;
                                    }

                                    case 3: {

                                        System.out.print("Tipo de entrega: ");
                                        String tipoEntrega = sc.nextLine();

                                        System.out.print("Descripción: ");
                                        String descripcion = sc.nextLine();

                                        actividad = new Taller(
                                                0, fechaEntrega, horaEntrega,
                                                grupal, importancia,
                                                tipoEntrega, descripcion
                                        );
                                        break;
                                    }
                                }

                                if (actividad != null) {
                                    materiaSeleccionada.agregarActividad(actividad);
                                    System.out.println("Actividad creada correctamente");
                                }

                                break;
                            }
                        }

                    } while (opcionInterna != 0);

                    break;
                }

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