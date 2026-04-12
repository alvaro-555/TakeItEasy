package model.Calendario;
import java.util.List;

public class Calendario {
    private List<Anio> anios;

    public Calendario() {}

    public Calendario(List<Anio> anios) {
        this.anios = anios;
    }

    public List<Anio> getAnios() { return anios; }
    public void setAnios(List<Anio> anios) { this.anios = anios; }

    @Override
    public String toString() {
        return "Calendario{" +
                "años=" + anios +
                '}';
    }
}