package Servicio.SistemaNotificaciones;

import model.Materia.*;
import model.Actividad.*;
import Servicio.ListaEnlazada.*;

import java.util.Timer;
import java.util.TimerTask;

public class NotificadorBot {

    private EmailService emailService = new EmailService();

    public void iniciar(String correoDestino, ListaEnlazada<Materia> materias, long intervaloMs) {

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                String mensaje = generarMensaje(materias);

                if (!mensaje.isEmpty()) {

                    emailService.enviarCorreo(
                            correoDestino,
                            "📚 Recordatorio de actividades",
                            mensaje
                    );
                }
            }
        }, 0, intervaloMs);
    }

    private String generarMensaje(ListaEnlazada<Materia> materias) {

        StringBuilder sb = new StringBuilder();

        sb.append("Hola 👋, aquí tienes tus recordatorios:\n\n");

        Nodo<Materia> aux = materias.getCabeza();

        while (aux != null) {

            Materia m = aux.getDato();

            Nodo<Actividad> act = m.getActividades().getCabeza();

            boolean tienePendientes = false;
            String bloque = "";

            while (act != null) {

                Actividad a = act.getDato();

                if (a.getCalificacion() == 0) {
                    tienePendientes = true;
                    bloque += "- " + m.getNombre() + " | " + a + "\n";
                }

                act = act.getSiguiente();
            }

            if (tienePendientes) {
                sb.append("📌 Materia: ").append(m.getNombre()).append("\n");
                sb.append(bloque).append("\n");
            }

            aux = aux.getSiguiente();
        }

        return sb.toString();
    }
}

