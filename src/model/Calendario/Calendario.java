package model.Calendario;
import Servicio.ListaEnlazada.*;

public class Calendario {

    private ListaEnlazada<Anio> anios;

    public Calendario() {
        anios = new ListaEnlazada<>();
    }

    public Calendario(ListaEnlazada<Anio> anios) {
        this.anios = anios;
    }

    public ListaEnlazada<Anio> getAnios() {
        return anios;
    }

    public void setAnios(ListaEnlazada<Anio> anios) {
        this.anios = anios;
    }

    public void agregarAnio(Anio a) {
        anios.agregar(a);
    }

    @Override
    public String toString() {
        return "Calendario{" +
                "anios=\n" + anios +
                '}';
    }
}