package model.Calendario;
import model.*;

import java.util.List;

public class Dia {
    private int numero;
    private List<Recordatorio> recordatorios;

    public Dia() {}

    public Dia(int numero, List<Recordatorio> recordatorios) {
        this.numero = numero;
        this.recordatorios = recordatorios;
    }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public List<Recordatorio> getRecordatorios() { return recordatorios; }
    public void setRecordatorios(List<Recordatorio> recordatorios) { this.recordatorios = recordatorios; }

    @Override
    public String toString() {
        return "Dia{" +
                "numero=" + numero +
                '}';
    }
}