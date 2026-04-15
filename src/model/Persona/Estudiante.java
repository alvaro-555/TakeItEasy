package model.Persona;
import Servicio.ListaEnlazada.*;
import model.Materia.Materia;

public class Estudiante extends Persona {

    private static int contador = 0;

    private String id;
    private String carrera;
    private int semestre;
    private ListaEnlazada<Materia> materias;

    public Estudiante() {
        contador++;
        this.id = "E" + contador;
        materias = new ListaEnlazada<>();
    }

    public Estudiante(String nombres, String apellidos, String correo,
                      String identificacion, String tipoDoc, int edad,
                      String carrera, int semestre) {

        super(nombres, apellidos, correo, identificacion, tipoDoc, edad);

        contador++;
        this.id = "E" + contador;

        this.carrera = carrera;
        this.semestre = semestre;
        this.materias = new ListaEnlazada<>();
    }

    // 🔥 ID automático
    public String getId() {
        return id;
    }

    // compatibilidad opcional
    public void setId(String id) {
        this.id = id;
    }

    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }

    public int getSemestre() { return semestre; }
    public void setSemestre(int semestre) { this.semestre = semestre; }

    public ListaEnlazada<Materia> getMaterias() { return materias; }
    public void setMateriasCursando(ListaEnlazada<Materia> materias) { this.materias = materias; }

   
    public ListaEnlazada<Materia> getMateriasCursando() {
        return materias;
    }

    public void agregarMateria(Materia m) {
        materias.agregar(m);
    }

    @Override
    public String toString() {
        return super.toString() + " - Estudiante " + id + " de " + carrera;
    }
}