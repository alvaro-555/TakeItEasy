package model.Actividad;

public class Quiz extends Actividad {
    private int numQuiz;
    private int numPreguntas;
    private String tiempo;

    public Quiz() {}

    public Quiz(int numQuiz, int numPreguntas, String tiempo) {
        this.numQuiz = numQuiz;
        this.numPreguntas = numPreguntas;
        this.tiempo = tiempo;
    }

    public int getNumQuiz() { return numQuiz; }
    public void setNumQuiz(int numQuiz) { this.numQuiz = numQuiz; }

    public int getNumPreguntas() { return numPreguntas; }
    public void setNumPreguntas(int numPreguntas) { this.numPreguntas = numPreguntas; }

    public String getTiempo() { return tiempo; }
    public void setTiempo(String tiempo) { this.tiempo = tiempo; }

    @Override
    public String toString() {
        return "Quiz{" +
                "quiz=" + numQuiz +
                '}';
    }
}
