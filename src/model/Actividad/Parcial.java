package model.Actividad;

public class Parcial extends Actividad {

    private static int contador = 0;

    private String id;
    private int numPreguntas;
    private String tiempo;

    public Parcial() {
        contador++;
        this.id = "P" + contador;
    }

    public Parcial(int calificacion, String fecha, String hora,
                   String fechaEntrega, String horaEntrega, boolean grupal,
                   int numPreguntas, String tiempo) {

        super(calificacion, fecha, hora, fechaEntrega, horaEntrega, grupal);

        contador++;
        this.id = "P" + contador;

        this.numPreguntas = numPreguntas;
        this.tiempo = tiempo;
    }

    public String getId() {
        return id;
    }

    public int getNumPreguntas() {
        return numPreguntas;
    }

    public void setNumPreguntas(int numPreguntas) {
        this.numPreguntas = numPreguntas;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "Parcial{" +
                "id='" + id + '\'' +
                ", numPreguntas=" + numPreguntas +
                ", tiempo='" + tiempo + '\'' +
                ", calificacion=" + getCalificacion() +
                '}';
    }
}