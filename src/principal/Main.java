package principal;
import model.*;
import model.InicioSesion.Usuario;
import model.Persona.Estudiante;

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

                    System.out.print("ID: ");
                    String id = sc.nextLine();

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
                    est.setNumIdentificacion(id);
                    est.setTipoDoc(tipoDoc);
                    est.setEdad(edad);
                    est.setCarrera(carrera);
                    est.setSemestre(semestre);

                    // Crear usuario
                    Usuario user = new Usuario(username, password, est);

                    usuarios.add(user);

                    System.out.println("✅ Usuario registrado con éxito");
                    break;

                case 2:
                    // LOGIN
                    System.out.println("\n--- LOGIN ---");

                    System.out.print("Username: ");
                    String userLogin = sc.nextLine();

                    System.out.print("Password: ");
                    String passLogin = sc.nextLine();

                    Usuario logueado = auth.login(userLogin, passLogin, usuarios);

                    if (logueado != null) {
                        System.out.println("✅ Bienvenido " +
                                logueado.getPersona().getNombres());
                    } else {
                        System.out.println("❌ Credenciales incorrectas");
                    }

                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("❌ Opción inválida");
            }

        } while (opcion != 0);

        sc.close();
    }
}

