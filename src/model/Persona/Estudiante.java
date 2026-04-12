package model.Persona;
import java.util.List;
import model.*;
import model.Materia.Materia;

public class Estudiante extends Persona {
    private String carrera;
    private int semestre;
    private List<Materia> materiasCursando;

    public Estudiante() {}

    public Estudiante(String carrera, int semestre, List<Materia> materiasCursando) {
        this.carrera = carrera;
        this.semestre = semestre;
        this.materiasCursando = materiasCursando;
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
                "carrera='" + carrera + '\'' +
                ", semestre=" + semestre +
                ", materias=" + materiasCursando +
                '}';
    }
}

