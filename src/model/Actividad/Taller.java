package model.Actividad;

public class Taller extends Actividad {

    private static int contador = 0;
    private String id;

    private String tipoEntrega;
    private String descripcion;

    public Taller() {
        super(0, "", "", false, 0);
        contador++;
        this.id = "T" + contador;
    }

    public Taller(int calificacion,
                  String fechaEntrega,
                  String horaEntrega,
                  boolean grupal,
                  int importancia,
                  String tipoEntrega,
                  String descripcion) {

        super(calificacion, fechaEntrega, horaEntrega, grupal, importancia);

        contador++;
        this.id = "T" + contador;

        this.tipoEntrega = tipoEntrega;
        this.descripcion = descripcion;
    }

    public String getId() { return id; }

    public String getTipoEntrega() { return tipoEntrega; }
    public void setTipoEntrega(String tipoEntrega) { this.tipoEntrega = tipoEntrega; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    @Override
    public String toString() {
        return "Taller{" +
                "id='" + id + '\'' +
                ", importancia=" + getImportancia() +
                '}';
    }
}