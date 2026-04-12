package model.Calendario;

import java.util.List;

public class Anio {
    private int numero;
    private List<Mes> meses;

    public Anio() {}

    public Anio(int numero, List<Mes> meses) {
        this.numero = numero;
        this.meses = meses;
    }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public List<Mes> getMeses() { return meses; }
    public void setMeses(List<Mes> meses) { this.meses = meses; }

    @Override
    public String toString() {
        return "Año{" +
                "numero=" + numero +
                '}';
    }
}
