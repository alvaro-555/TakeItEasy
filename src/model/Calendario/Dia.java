package model.Calendario;
import Servicio.ListaEnlazada.*;

public class Dia {

    private int numero;
    private ListaEnlazada<Recordatorio> recordatorios;

    public Dia() {
        recordatorios = new ListaEnlazada<>();
    }

    public Dia(int numero) {
        this.numero = numero;
        this.recordatorios = new ListaEnlazada<>();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public ListaEnlazada<Recordatorio> getRecordatorios() {
        return recordatorios;
    }

    public void setRecordatorios(ListaEnlazada<Recordatorio> recordatorios) {
        this.recordatorios = recordatorios;
    }

    public void agregarRecordatorio(Recordatorio r) {
        recordatorios.agregar(r);
    }

    @Override
    public String toString() {
        return "Dia{" +
                "numero=" + numero +
                ", recordatorios=\n" + recordatorios +
                '}';
    }
}