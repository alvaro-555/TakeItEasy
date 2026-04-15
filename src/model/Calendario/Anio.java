package model.Calendario;
import Servicio.ListaEnlazada.*;

public class Anio {

    private int numero;
    private ListaEnlazada<Mes> meses;

    public Anio() {
        meses = new ListaEnlazada<>();
    }

    public Anio(int numero) {
        this.numero = numero;
        this.meses = new ListaEnlazada<>();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public ListaEnlazada<Mes> getMeses() {
        return meses;
    }

    public void setMeses(ListaEnlazada<Mes> meses) {
        this.meses = meses;
    }

    public void agregarMes(Mes m) {
        meses.agregar(m);
    }

    @Override
    public String toString() {
        return "Anio{" +
                "numero=" + numero +
                ", meses=\n" + meses +
                '}';
    }
}