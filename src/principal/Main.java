package principal;

import Servicio.ListaEnlazada.*;
import model.InicioSesion.*;
import Servicio.ValidacionIniSesi;
import Servicio.ArbolAVL.AVLActividad;
import Servicio.ComparadorFechas;
import Servicio.GenerarCalendario;
import Servicio.SistemaNotificaciones.*;
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

                    Estudiante est = (Estudiante) logueado.getPersona();

                    EmailService email = new EmailService();

                    String mensajeLogin =
                            "Hola " + est.getNombres() + " 👋\n\n" +
                            "Te has logueado correctamente.\n\n" +
                            "📚 Carrera: " + est.getCarrera() + "\n" +
                            "🎓 Semestre: " + est.getSemestre() + "\n" +
                            "📧 Correo: " + est.getCorreoElectronico() + "\n\n" +
                            "Disfruta del orden académico 🚀\n" +
                            "Take it easy 😎";

                    email.enviarCorreo(
                            est.getCorreoElectronico(),
                            "Login exitoso ✔",
                            mensajeLogin
                    );

                    GenerarCalendario generador = new GenerarCalendario();
                    Calendario calendario = generador.generarCalendario();

                    int opcionInterna;

                    do {

                        System.out.println("\n===== MENU USUARIO =====");
                        System.out.println("1. Agregar materia");
                        System.out.println("2. Ver cronograma");
                        System.out.println("3. Ver materias");
                        System.out.println("4. Actividades pendientes (Taller)");
                        System.out.println("5. Próximas evaluaciones (Parcial y Quiz)");
                        System.out.println("6. Crear actividad");
                        System.out.println("7. Marcar actividad como completada");
                        System.out.println("8. Enviar notificación (PRUEBA)");
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

                                if (est.getMateriasCursando() == null) {
                                    est.setMateriasCursando(new ListaEnlazada<>());
                                }

                                est.getMateriasCursando().agregar(materia);

                                System.out.println("Materia agregada");

                                break;
                            }

                            case 2: {

                                    System.out.println("\n--- CRONOGRAMA ---");

                                    ListaEnlazada<Actividad> todas = new ListaEnlazada<>();

                                    Nodo<Materia> aux = est.getMateriasCursando().getCabeza();

                                    while (aux != null) {

                                    Nodo<Actividad> act = aux.getDato().getActividades().getCabeza();

                                    while (act != null) {
                                    todas.agregar(act.getDato());
                                    act = act.getSiguiente();
                                    }

                                    aux = aux.getSiguiente();
                                    }

    
                                    Nodo<Actividad> i = todas.getCabeza();

                                    while (i != null) {

                                    Nodo<Actividad> j = i.getSiguiente();

                                    while (j != null) {

                                    Actividad a1 = i.getDato();
                                    Actividad a2 = j.getDato();

                                     if (ComparadorFechas.esMenor(a2.getFechaEntrega(), a1.getFechaEntrega())) {

                                    Actividad temp = i.getDato();
                                    i.setDato(j.getDato());
                                    j.setDato(temp);
                                    }

                                    j = j.getSiguiente();
                                    }

                                    i = i.getSiguiente();
                                    }

                                    Nodo<Actividad> p = todas.getCabeza();

                                    while (p != null) {
                                    System.out.println(p.getDato());
                                    p = p.getSiguiente();
                                    }

                                    break;
                                    }
                            case 3: {

                                System.out.println("\n--- MATERIAS ---");

                                Nodo<Materia> aux = est.getMateriasCursando().getCabeza();

                                while (aux != null) {
                                    System.out.println(aux.getDato());
                                    aux = aux.getSiguiente();
                                }

                                break;
                            }

                           case 4: {

                            System.out.println("\n--- ACTIVIDADES PENDIENTES (TALLER ORDENADO POR IMPORTANCIA) ---");

                            Nodo<Materia> aux = est.getMateriasCursando().getCabeza();

                            AVLActividad arbol = new AVLActividad();

                            while (aux != null) {

                            Materia m = aux.getDato();
                            Nodo<Actividad> act = m.getActividades().getCabeza();

                            System.out.println("\nMateria: " + m.getNombre());

                            while (act != null) {

                            Actividad a = act.getDato();

           
                            if (a instanceof Taller && a.getCalificacion() == 0) {
                            arbol.insertar(a);
                            }

                            act = act.getSiguiente();
                            }

                            aux = aux.getSiguiente();
                            }

    
                            arbol.inOrder();

                            break;
                            }
                            case 5: {

                                System.out.println("\n--- PRÓXIMAS EVALUACIONES (PARCIAL / QUIZ) ---");

                                Nodo<Materia> aux = est.getMateriasCursando().getCabeza();

                                while (aux != null) {

                                    Materia m = aux.getDato();
                                    Nodo<Actividad> act = m.getActividades().getCabeza();

                                    System.out.println("\nMateria: " + m.getNombre());

                                    while (act != null) {

                                        Actividad a = act.getDato();

                                        if ((a instanceof Parcial || a instanceof Quiz)
                                                && a.getCalificacion() == 0) {
                                            System.out.println(a);
                                        }

                                        act = act.getSiguiente();
                                    }

                                    aux = aux.getSiguiente();
                                }

                                break;
                            }

                            case 6: {

                                System.out.println("\n--- CREAR ACTIVIDAD ---");

                                Nodo<Materia> aux = est.getMateriasCursando().getCabeza();

                                int index = 1;

                                while (aux != null) {
                                    System.out.println(index + ". " + aux.getDato().getNombre());
                                    aux = aux.getSiguiente();
                                    index++;
                                }

                                System.out.print("Opción: ");
                                int opcionMateria = sc.nextInt();
                                sc.nextLine();

                                aux = est.getMateriasCursando().getCabeza();
                                int contador = 1;

                                while (contador < opcionMateria) {
                                    aux = aux.getSiguiente();
                                    contador++;
                                }

                                Materia materiaSeleccionada = aux.getDato();

                                System.out.println("\nTipo:");
                                System.out.println("1. Parcial");
                                System.out.println("2. Quiz");
                                System.out.println("3. Taller");

                                int tipo = sc.nextInt();
                                sc.nextLine();

                                System.out.print("Fecha (dd/MM/yyyy): ");
                                String fecha = sc.nextLine();

                                System.out.print("Hora (HH:mm): ");
                                String hora = sc.nextLine();

                                System.out.print("Importancia: ");
                                int imp = sc.nextInt();
                                sc.nextLine();

                                System.out.print("¿Es grupal? (true/false): ");
                                boolean grupal = sc.nextBoolean();
                                sc.nextLine();

                                Actividad actividad = null;

                                if (tipo == 1) {

                                    System.out.print("Número de preguntas: ");
                                    int numPreguntas = sc.nextInt();
                                    sc.nextLine();

                                    System.out.print("Tiempo: ");
                                    String tiempo = sc.nextLine();

                                    actividad = new Parcial(0, fecha, hora, grupal, imp, numPreguntas, tiempo);

                                } else if (tipo == 2) {

                                    System.out.print("Número de quiz: ");
                                    int numQuiz = sc.nextInt();

                                    System.out.print("Número de preguntas: ");
                                    int numPreguntas = sc.nextInt();
                                    sc.nextLine();

                                    System.out.print("Tiempo: ");
                                    String tiempo = sc.nextLine();

                                    actividad = new Quiz(0, fecha, hora, grupal, imp, numQuiz, numPreguntas, tiempo);

                                } else if (tipo == 3) {

                                    System.out.print("Tipo de entrega: ");
                                    String tipoEntrega = sc.nextLine();

                                    System.out.print("Descripción: ");
                                    String descripcion = sc.nextLine();

                                    actividad = new Taller(0, fecha, hora, grupal, imp, tipoEntrega, descripcion);
                                }

                                if (actividad != null) {
                                    materiaSeleccionada.agregarActividad(actividad);
                                    System.out.println("Actividad creada");
                                }

                                break;
                            }

                            case 7: {

                                System.out.println("\n--- COMPLETAR ACTIVIDAD ---");

                                Nodo<Materia> aux = est.getMateriasCursando().getCabeza();

                                int c = 1;

                                while (aux != null) {

                                    Nodo<Actividad> act = aux.getDato().getActividades().getCabeza();

                                    while (act != null) {
                                        System.out.println(c + ". " + act.getDato());
                                        c++;
                                        act = act.getSiguiente();
                                    }

                                    aux = aux.getSiguiente();
                                }

                                System.out.print("Seleccione: ");
                                int op = sc.nextInt();
                                sc.nextLine();

                                int cont = 1;
                                aux = est.getMateriasCursando().getCabeza();

                                boolean done = false;

                                while (aux != null && !done) {

                                    Nodo<Actividad> act = aux.getDato().getActividades().getCabeza();

                                    while (act != null) {

                                        if (cont == op) {
                                            act.getDato().setEstado("C");
                                            System.out.println("Completada");
                                            done = true;
                                            break;
                                        }

                                        cont++;
                                        act = act.getSiguiente();
                                    }

                                    aux = aux.getSiguiente();
                                }

                                break;
                            }

                            case 8: { 
                                System.out.println("\n--- NOTIFICACIÓN ---"); 
                                EmailService email2 = new EmailService(); 
                                String mensaje = NotificationBuilder.construirResumen(est); 
                                email2.enviarCorreo( est.getCorreoElectronico(), "📌 Resumen académico", mensaje ); 
                                System.out.println("Enviada"); 
                                break; } }

                    } while (opcionInterna != 0);

                    break;
                }

                case 0:
                    System.out.println("Saliendo...");
                    break;
            }

        } while (opcion != 0);

        sc.close();
    }
}