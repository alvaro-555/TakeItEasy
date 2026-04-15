package model.Actividad;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Actividad {

    private int calificacion;
    private String fechaEntrega;
    private String horaEntrega;
    private boolean grupal;

    private int importancia;
    private String estado;

    public Actividad() {
        this.estado = "P";
    }

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
        this.estado = "P";
    }

    public LocalDate getFechaEntregaDate() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(fechaEntrega, f);
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

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Actividad{" +
                "nota=" + calificacion +
                ", importancia=" + importancia +
                ", estado='" + estado + '\'' +
                ", fechaEntrega='" + fechaEntrega + '\'' +
                '}';
    }
}