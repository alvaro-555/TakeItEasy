package model.Persona;

public class Persona {
    private String nombres;
    private String apellidos;
    private String correoElectronico;
    private String numIdentificacion;
    private String tipoDoc;
    private int edad;

    public Persona() {}

    public Persona(String nombres, String apellidos, String correoElectronico,
                   String numIdentificacion, String tipoDoc, int edad) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correoElectronico = correoElectronico;
        this.numIdentificacion = numIdentificacion;
        this.tipoDoc = tipoDoc;
        this.edad = edad;
    }

    // Getters y Setters
    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getCorreoElectronico() { return correoElectronico; }
    public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }

    public String getNumIdentificacion() { return numIdentificacion; }
    public void setNumIdentificacion(String numIdentificacion) { this.numIdentificacion = numIdentificacion; }

    public String getTipoDoc() { return tipoDoc; }
    public void setTipoDoc(String tipoDoc) { this.tipoDoc = tipoDoc; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    @Override
    public String toString() {
        return "Persona{" +
                "nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", correo='" + correoElectronico + '\'' +
                ", id='" + numIdentificacion + '\'' +
                ", tipoDoc='" + tipoDoc + '\'' +
                ", edad=" + edad +
                '}';
    }
}

