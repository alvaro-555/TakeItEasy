package model.Calendario;
import Servicio.ListaEnlazada.*;

public class Mes {

    private String nombre;
    private ListaEnlazada<Dia> dias;

    public Mes() {
        dias = new ListaEnlazada<>();
    }

    public Mes(String nombre) {
        this.nombre = nombre;
        this.dias = new ListaEnlazada<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaEnlazada<Dia> getDias() {
        return dias;
    }

    public void setDias(ListaEnlazada<Dia> dias) {
        this.dias = dias;
    }

    public void agregarDia(Dia d) {
        dias.agregar(d);
    }

    @Override
    public String toString() {
        return "Mes{" +
                "nombre='" + nombre + '\'' +
                ", dias=\n" + dias +
                '}';
    }
}