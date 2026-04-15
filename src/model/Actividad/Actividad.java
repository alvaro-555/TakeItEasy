package model.Actividad;

public abstract class Actividad {

    private int calificacion;
    private String fechaEntrega;
    private String horaEntrega;
    private boolean grupal;
    private int importancia;

    public Actividad() {}

    public Actividad(int calificacion,
                     String fechaEntrega,
                     String horaEntrega,
                     boolean grupal,
                     int importancia) {

        this.calificacion = calificacion;
        this.fechaEntrega = fechaEntrega;
        this.horaEntrega = horaEntrega;
        this.grupal = grupal;
        this.importancia = importancia;
    }

    public int getCalificacion() { return calificacion; }
    public void setCalificacion(int calificacion) { this.calificacion = calificacion; }

    public String getFechaEntrega() { return fechaEntrega; }
    public void setFechaEntrega(String fechaEntrega) { this.fechaEntrega = fechaEntrega; }

    public String getHoraEntrega() { return horaEntrega; }
    public void setHoraEntrega(String horaEntrega) { this.horaEntrega = horaEntrega; }

    public boolean isGrupal() { return grupal; }
    public void setGrupal(boolean grupal) { this.grupal = grupal; }

    public int getImportancia() { return importancia; }
    public void setImportancia(int importancia) { this.importancia = importancia; }

    @Override
    public String toString() {
        return "Actividad | importancia=" + importancia + " | nota=" + calificacion;
    }
}