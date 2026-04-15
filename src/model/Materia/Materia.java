package model.Materia;

import model.Actividad.*;
import model.Persona.*;
import Servicio.ListaEnlazada.*;

public class Materia {

    private static int contador = 0;

    private String nombre;
    private ListaEnlazada<Actividad> actividades;
    private String horario;
    private String id;
    private Profesor instructor;

    public Materia() {
        actividades = new ListaEnlazada<>();
        contador++;
        this.id = "M" + contador;
    }

    public Materia(String nombre, String horario, Profesor instructor) {
        this.nombre = nombre;
        this.horario = horario;
        this.instructor = instructor;
        this.actividades = new ListaEnlazada<>();
        contador++;
        this.id = "M" + contador;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public ListaEnlazada<Actividad> getActividades() { return actividades; }
    public void setActividades(ListaEnlazada<Actividad> actividades) { this.actividades = actividades; }

    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }

    public String getId() { return id; }

    public Profesor getInstructor() { return instructor; }
    public void setInstructor(Profesor instructor) { this.instructor = instructor; }

    public void agregarActividad(Actividad a) {
        actividades.agregar(a);
    }

    public double calcularPromedio() {
        int suma = 0, count = 0;
        Nodo<Actividad> aux = actividades.getCabeza();

        while (aux != null) {
            suma += aux.getDato().getCalificacion();
            count++;
            aux = aux.getSiguiente();
        }

        return count == 0 ? 0 : (double) suma / count;
    }

    @Override
    public String toString() {
        return "Materia: " + nombre + " (" + id + ")";
    }
}