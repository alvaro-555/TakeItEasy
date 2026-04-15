package Servicio.SistemaNotificaciones;
import model.Materia.*;
import model.Actividad.*;
import Servicio.ListaEnlazada.*;
import model.Persona.Estudiante;
public class NotificationBuilder {


    public static String construirResumen(Estudiante est) {

        StringBuilder sb = new StringBuilder();

        sb.append("Hola ").append(est.getNombres()).append(" 👋\n\n");

        sb.append("📌 ACTIVIDADES PENDIENTES:\n");

        if (est.getMateriasCursando() == null || est.getMateriasCursando().getCabeza() == null) {
            sb.append("No tienes materias registradas.\n");
            return sb.toString();
        }

        Nodo<Materia> aux = est.getMateriasCursando().getCabeza();

        while (aux != null) {

            Materia m = aux.getDato();

            Nodo<Actividad> act = m.getActividades().getCabeza();

            sb.append("\n📚 ").append(m.getNombre()).append(":\n");

            boolean hay = false;

            while (act != null) {

                Actividad a = act.getDato();

                if (a.getCalificacion() == 0) {
                    sb.append(" - ").append(a.getClass().getSimpleName())
                      .append(" | Fecha: ").append(a.getFechaEntrega())
                      .append(" | Hora: ").append(a.getHoraEntrega())
                      .append("\n");
                    hay = true;
                }

                act = act.getSiguiente();
            }

            if (!hay) {
                sb.append(" - Sin pendientes\n");
            }

            aux = aux.getSiguiente();
        }

        sb.append("\n⚡ Recuerda: Take it easy 😎");

        return sb.toString();
    }
}