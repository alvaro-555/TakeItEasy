package model.Actividad;

public class Quiz extends Actividad {

    private static int contador = 0;

    private String id;
    private int numQuiz;
    private int numPreguntas;
    private String tiempo;

    public Quiz() {
        contador++;
        this.id = "Q" + contador;
    }

    public Quiz(int calificacion, String fecha, String hora,
                String fechaEntrega, String horaEntrega, boolean grupal,
                int numQuiz, int numPreguntas, String tiempo) {

        super(calificacion, fecha, hora, fechaEntrega, horaEntrega, grupal);

        contador++;
        this.id = "Q" + contador;

        this.numQuiz = numQuiz;
        this.numPreguntas = numPreguntas;
        this.tiempo = tiempo;
    }

    public String getId() {
        return id;
    }

    public int getNumQuiz() {
        return numQuiz;
    }

    public void setNumQuiz(int numQuiz) {
        this.numQuiz = numQuiz;
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
        return "Quiz{" +
                "id='" + id + '\'' +
                ", numQuiz=" + numQuiz +
                ", numPreguntas=" + numPreguntas +
                ", tiempo='" + tiempo + '\'' +
                ", calificacion=" + getCalificacion() +
                '}';
    }
}