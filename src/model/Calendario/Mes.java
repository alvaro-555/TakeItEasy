package model.Calendario;

import java.util.List;

public class Mes {
    private String nombre;
    private List<Dia> dias;

    public Mes() {}

    public Mes(String nombre, List<Dia> dias) {
        this.nombre = nombre;
        this.dias = dias;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public List<Dia> getDias() { return dias; }
    public void setDias(List<Dia> dias) { this.dias = dias; }

    @Override
    public String toString() {
        return "Mes{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}