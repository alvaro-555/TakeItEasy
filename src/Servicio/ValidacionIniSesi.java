package Servicio;
import java.util.List;
import model.InicioSesion.Usuario;

public class ValidacionIniSesi {

    public Usuario login(String username, String password, List<Usuario> usuarios) {
        for (Usuario u : usuarios) {
            if (u.getUsername().equals(username) &&
                u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }
}