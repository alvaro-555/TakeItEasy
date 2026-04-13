package model.Actividad;

public abstract class Actividad {
    private int calificacion;
    private String fecha;
    private String hora;
    private String fechaEntrega;
    private String horaEntrega;
    private boolean esGrupal;

    public Actividad() {}

    public Actividad(int calificacion, String fecha, String hora,
                     String fechaEntrega, String horaEntrega, boolean esGrupal) {
        this.calificacion = calificacion;
        this.fecha = fecha;
        this.hora = hora;
        this.fechaEntrega = fechaEntrega;
        this.horaEntrega = horaEntrega;
        this.esGrupal = esGrupal;
    }

    // Getters y Setters
    public int getCalificacion() { return calificacion; }
    public void setCalificacion(int calificacion) { this.calificacion = calificacion; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }

    public String getFechaEntrega() { return fechaEntrega; }
    public void setFechaEntrega(String fechaEntrega) { this.fechaEntrega = fechaEntrega; }

    public String getHoraEntrega() { return horaEntrega; }
    public void setHoraEntrega(String horaEntrega) { this.horaEntrega = horaEntrega; }

    public boolean isEsGrupal() { return esGrupal; }
    public void setEsGrupal(boolean esGrupal) { this.esGrupal = esGrupal; }

    @Override
    public String toString() {
        return "Actividad{" +
                "calificacion=" + calificacion +
                ", fecha='" + fecha + '\'' +
                '}';
    }
    public boolean estaPendiente() {
    return calificacion == 0;
}
}