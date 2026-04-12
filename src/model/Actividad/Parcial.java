package model.Actividad;

public class Parcial extends Actividad {
    private int numPreguntas;
    private String tiempo;

    public Parcial() {}

    public Parcial(int numPreguntas, String tiempo) {
        this.numPreguntas = numPreguntas;
        this.tiempo = tiempo;
    }

    public int getNumPreguntas() { return numPreguntas; }
    public void setNumPreguntas(int numPreguntas) { this.numPreguntas = numPreguntas; }

    public String getTiempo() { return tiempo; }
    public void setTiempo(String tiempo) { this.tiempo = tiempo; }

    @Override
    public String toString() {
        return "Parcial{" +
                "preguntas=" + numPreguntas +
                '}';
    }
}
