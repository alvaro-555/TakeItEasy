package Servicio;
import Servicio.ListaEnlazada.*;
import model.InicioSesion.Usuario;

public class ValidacionIniSesi {

    public Usuario login(String username, String password, ListaEnlazada<Usuario> usuarios) {

        Nodo<Usuario> aux = usuarios.getCabeza();

          while (aux != null) {
        Usuario u = aux.getDato();

        if (u.getUsername().equals(username) &&
            u.getPassword().equals(password)) {
            System.out.println("Login exitoso");
            return u;
        }

        aux = aux.getSiguiente();
    }

    System.out.println("Usuario o contraseña incorrectos");
    return null;
}
}