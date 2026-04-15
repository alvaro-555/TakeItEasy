package model.Actividad;

public class Taller extends Actividad {

    private static int contador = 0;

    private String id;
    private String tipoEntrega;
    private String descripcion;

    public Taller() {
        contador++;
        this.id = "T" + contador;
    }

    public Taller(int calificacion, String fecha, String hora,
                  String fechaEntrega, String horaEntrega, boolean grupal,
                  String tipoEntrega, String descripcion) {

        super(calificacion, fecha, hora, fechaEntrega, horaEntrega, grupal);

        contador++;
        this.id = "T" + contador;

        this.tipoEntrega = tipoEntrega;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public String getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(String tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Taller{" +
                "id='" + id + '\'' +
                ", tipoEntrega='" + tipoEntrega + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", calificacion=" + getCalificacion() +
                '}';
    }
}