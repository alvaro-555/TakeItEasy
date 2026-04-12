package model.Actividad;

public class Taller extends Actividad {
    private String tipoEntrega;
    private String descripcion;

    public Taller() {}

    public Taller(String tipoEntrega, String descripcion) {
        this.tipoEntrega = tipoEntrega;
        this.descripcion = descripcion;
    }

    public String getTipoEntrega() { return tipoEntrega; }
    public void setTipoEntrega(String tipoEntrega) { this.tipoEntrega = tipoEntrega; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    @Override
    public String toString() {
        return "Taller{" +
                "tipoEntrega='" + tipoEntrega + '\'' +
                '}';
    }
}
