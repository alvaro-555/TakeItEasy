package model.Actividad;

public class Parcial extends Actividad {

    private static int contador = 0;
    private String id;

    private int numPreguntas;
    private String tiempo;

    public Parcial() {
        super(0, "", "", false, 0);
        contador++;
        this.id = "P" + contador;
    }

    public Parcial(int calificacion,
                   String fechaEntrega,
                   String horaEntrega,
                   boolean grupal,
                   int importancia,
                   int numPreguntas,
                   String tiempo) {

        super(calificacion, fechaEntrega, horaEntrega, grupal, importancia);

        contador++;
        this.id = "P" + contador;

        this.numPreguntas = numPreguntas;
        this.tiempo = tiempo;
    }

    public String getId() { return id; }

    public int getNumPreguntas() { return numPreguntas; }
    public void setNumPreguntas(int numPreguntas) { this.numPreguntas = numPreguntas; }

    public String getTiempo() { return tiempo; }
    public void setTiempo(String tiempo) { this.tiempo = tiempo; }

    @Override
    public String toString() {
        return "Parcial{" +
                "id='" + id + '\'' +
                ", importancia=" + getImportancia() +
                '}';
    }
}