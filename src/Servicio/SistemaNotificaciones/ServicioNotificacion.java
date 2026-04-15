package Servicio.SistemaNotificaciones;
import Servicio.ListaEnlazada.*;
import model.Materia.*;
import model.Actividad.*;
import model.Persona.*;
public class ServicioNotificacion {


    private EmailService emailService = new EmailService();

    public void enviarRecordatorio(Estudiante estudiante) {

        StringBuilder talleres = new StringBuilder();
        StringBuilder evaluaciones = new StringBuilder();

        Nodo<Materia> aux = estudiante.getMateriasCursando().getCabeza();

        while (aux != null) {

            Materia m = aux.getDato();
            Nodo<Actividad> act = m.getActividades().getCabeza();

            while (act != null) {

                Actividad a = act.getDato();

                // 🟡 Talleres pendientes
                if (a instanceof Taller && a.getCalificacion() == 0) {
                    talleres.append("- ")
                            .append(m.getNombre())
                            .append(" | ")
                            .append(a)
                            .append("\n");
                }

                // 🔵 Evaluaciones
                if ((a instanceof Parcial || a instanceof Quiz) && a.getCalificacion() == 0) {
                    evaluaciones.append("- ")
                            .append(m.getNombre())
                            .append(" | ")
                            .append(a)
                            .append("\n");
                }

                act = act.getSiguiente();
            }

            aux = aux.getSiguiente();
        }

        String mensaje =
                "Hola " + estudiante.getNombres() + " 👋\n\n" +
                "📌 Tienes actividades pendientes:\n\n" +
                "🧰 Talleres:\n" + (talleres.length() == 0 ? "Ninguno 🎉\n" : talleres) +
                "\n🧪 Próximas evaluaciones:\n" + (evaluaciones.length() == 0 ? "Ninguna 🎉\n" : evaluaciones) +
                "\n\n💡 Te recomendamos estudiar con tiempo.";

        emailService.enviarCorreo(
                estudiante.getCorreoElectronico(),
                "📚 Recordatorio académico",
                mensaje
        );
    }
}

