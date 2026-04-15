package model.Persona;

import model.Materia.Materia;
import Servicio.ListaEnlazada.*;

public class Profesor extends Persona {

    private static int contador = 0;

    private String id;
    private ListaEnlazada<Materia> materias;
    private int aniosExperiencia;
    private String especialidad;

    public Profesor() {
        contador++;
        this.id = "PRO" + contador;
        materias = new ListaEnlazada<>();
    }

    public Profesor(String nombres, String apellidos, String correo,
                    String identificacion, String tipoDoc, int edad,
                    int aniosExperiencia, String especialidad) {

        super(nombres, apellidos, correo, identificacion, tipoDoc, edad);

        contador++;
        this.id = "PRO" + contador;

        this.aniosExperiencia = aniosExperiencia;
        this.especialidad = especialidad;
        this.materias = new ListaEnlazada<>();
    }

    public String getId() {
        return id;
    }

    public ListaEnlazada<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(ListaEnlazada<Materia> materias) {
        this.materias = materias;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return super.toString() + " - Profesor " + id + " de " + especialidad;
    }
}