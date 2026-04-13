package model.Persona;

import java.util.List;
import model.Materia.Materia;

public class Estudiante extends Persona {

    private static int contador = 1; // contador global

    private String id; 

    private String carrera;
    private int semestre;
    private List<Materia> materiasCursando;

    public Estudiante() {
        this.id = "E" + contador++;
    }

    public Estudiante(String carrera, int semestre, List<Materia> materiasCursando) {
        this.id = "E" + contador++; // generación automática
        this.carrera = carrera;
        this.semestre = semestre;
        this.materiasCursando = materiasCursando;
    }

    
    public String getId() {
        return id;
    }

    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }

    public int getSemestre() { return semestre; }
    public void setSemestre(int semestre) { this.semestre = semestre; }

    public List<Materia> getMateriasCursando() { return materiasCursando; }
    public void setMateriasCursando(List<Materia> materiasCursando) { this.materiasCursando = materiasCursando; }

    @Override
    public String toString() {
        return "Estudiante{" +
                "id='" + id + '\'' + 
                ", carrera='" + carrera + '\'' +
                ", semestre=" + semestre +
                ", materias=" + materiasCursando +
                '}';
    }
}
