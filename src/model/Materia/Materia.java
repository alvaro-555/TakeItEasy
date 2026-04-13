package model.Materia;

import model.Actividad.*;
import model.Persona.*;
import java.util.List;

public class Materia {

    private static int contador = 1; 

    private String nombre;
    private List<Actividad> actividades;
    private String horario;
    private String id; 
    private Profesor instructor;

    public Materia() {
        this.id = "M" + contador++;
    }

    public Materia(String nombre, List<Actividad> actividades, String horario, Profesor instructor) {
        this.id = "M" + contador++; 
        this.nombre = nombre;
        this.actividades = actividades;
        this.horario = horario;
        this.instructor = instructor;
    }

    public double calcularPromedio(int calificacion) {
        return calificacion;
    }

    // Getters
    public String getNombre() { return nombre; }
    public List<Actividad> getActividades() { return actividades; }
    public String getHorario() { return horario; }
    public String getId() { return id; }
    public Profesor getInstructor() { return instructor; }

    // Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setActividades(List<Actividad> actividades) { this.actividades = actividades; }
    public void setHorario(String horario) { this.horario = horario; }
    public void setInstructor(Profesor instructor) { this.instructor = instructor; }

    @Override
    public String toString() {
        return "Materia{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}