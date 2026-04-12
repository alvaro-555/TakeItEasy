package model.Persona;
import java.util.List;
import model.*;

public class Profesor extends Persona {
    private List<Materia> materiasACargo;
    private int aniosExperiencia;
    private String especialidad;

    public Profesor() {}

    public Profesor(List<Materia> materiasACargo, int aniosExperiencia, String especialidad) {
        this.materiasACargo = materiasACargo;
        this.aniosExperiencia = aniosExperiencia;
        this.especialidad = especialidad;
    }

    public List<Materia> getMateriasACargo() { return materiasACargo; }
    public void setMateriasACargo(List<Materia> materiasACargo) { this.materiasACargo = materiasACargo; }

    public int getAniosExperiencia() { return aniosExperiencia; }
    public void setAniosExperiencia(int aniosExperiencia) { this.aniosExperiencia = aniosExperiencia; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    @Override
    public String toString() {
        return "Profesor{" +
                "experiencia=" + aniosExperiencia +
                ", especialidad='" + especialidad + '\'' +
                '}';
    }
}