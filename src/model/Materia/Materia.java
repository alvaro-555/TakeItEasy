package model.Materia;
import Servicio.ComparadorFechas;
import Servicio.ArbolAVL.*;
import model.Actividad.*;
import model.Persona.*;
import Servicio.ListaEnlazada.*;

public class Materia {

    private static int contador = 0;

    private String nombre;
    private ListaEnlazada<Actividad> actividades;
    private String horario;
    private String id;
    private Profesor instructor;

    public Materia() {
        actividades = new ListaEnlazada<>();
        contador++;
        this.id = "M" + contador;
    }

    public Materia(String nombre, String horario, Profesor instructor) {
        this.nombre = nombre;
        this.horario = horario;
        this.instructor = instructor;
        this.actividades = new ListaEnlazada<>();
        contador++;
        this.id = "M" + contador;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public ListaEnlazada<Actividad> getActividades() { return actividades; }
    public void setActividades(ListaEnlazada<Actividad> actividades) { this.actividades = actividades; }

    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }

    public String getId() { return id; }

    public Profesor getInstructor() { return instructor; }
    public void setInstructor(Profesor instructor) { this.instructor = instructor; }

    public void agregarActividad(Actividad a) {
        actividades.agregar(a);
    }

    public double calcularPromedio() {
        int suma = 0, count = 0;
        Nodo<Actividad> aux = actividades.getCabeza();

        while (aux != null) {
            suma += aux.getDato().getCalificacion();
            count++;
            aux = aux.getSiguiente();
        }

        return count == 0 ? 0 : (double) suma / count;
    }
    public void ordenarPorPrioridad() {

    if (actividades == null || actividades.getCabeza() == null) return;

    boolean swapped;

    do {
        swapped = false;

        Nodo<Actividad> actual = actividades.getCabeza();

        while (actual != null && actual.getSiguiente() != null) {

            Actividad a1 = actual.getDato();
            Actividad a2 = actual.getSiguiente().getDato();

            if (a1.getImportancia() < a2.getImportancia()) {

                Actividad temp = actual.getDato();
                actual.setDato(actual.getSiguiente().getDato());  
                actual.getSiguiente().setDato(temp);

                swapped = true;
            }

            actual = actual.getSiguiente();
        }

    } while (swapped);
}
public void mostrarActividadesOrdenadas() {

    if (actividades == null || actividades.getCabeza() == null) {
        System.out.println("No hay actividades");
        return;
    }

    Nodo<Actividad> i = actividades.getCabeza();

    while (i != null) {
        Nodo<Actividad> j = i.getSiguiente();

        while (j != null) {

            if (i.getDato().getImportancia() < j.getDato().getImportancia()) {
                Actividad temp = i.getDato();
                i.setDato(j.getDato());
                j.setDato(temp);
            }

            j = j.getSiguiente();
        }

        i = i.getSiguiente();
    }

  
    Nodo<Actividad> aux = actividades.getCabeza();

    while (aux != null) {
        System.out.println(aux.getDato());
        aux = aux.getSiguiente();
    }
}
public void mostrarCronograma() {

    Nodo<Actividad> i = actividades.getCabeza();

    while (i != null) {
        Nodo<Actividad> j = i.getSiguiente();

        while (j != null) {

            Actividad a1 = i.getDato();
            Actividad a2 = j.getDato();

            if (ComparadorFechas.esMenor(a2.getFechaEntrega(), a1.getFechaEntrega())) {

                Actividad temp = i.getDato();
                i.setDato(j.getDato());
                j.setDato(temp);
            }

            j = j.getSiguiente();
        }

        i = i.getSiguiente();
    }

    Nodo<Actividad> aux = actividades.getCabeza();

    while (aux != null) {

        Actividad a = aux.getDato();

        System.out.println(
            a.getFechaEntrega() + " - " +
            a.getHoraEntrega() + " | " +
            a.toString()
        );

        aux = aux.getSiguiente();
    }
}
    @Override
    public String toString() {
        return "Materia: " + nombre + " (" + id + ")";
    }
}