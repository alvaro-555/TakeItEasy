package model.Calendario;
import model.Materia;
import model.Actividad.*;

public class Recordatorio {
    private String informacion;
    private Materia materia;
    private Actividad actividad;

    public Recordatorio() {}

    public Recordatorio(String informacion, Materia materia, Actividad actividad) {
        this.informacion = informacion;
        this.materia = materia;
        this.actividad = actividad;
    }

    public String getInformacion() { return informacion; }
    public void setInformacion(String informacion) { this.informacion = informacion; }

    public Materia getMateria() { return materia; }
    public void setMateria(Materia materia) { this.materia = materia; }

    public Actividad getActividad() { return actividad; }
    public void setActividad(Actividad actividad) { this.actividad = actividad; }

    @Override
    public String toString() {
        return "Recordatorio{" +
                "info='" + informacion + '\'' +
                '}';
    }
}