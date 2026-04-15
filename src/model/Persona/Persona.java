package model.Persona;

public abstract class Persona {

    private String nombres;
    private String apellidos;
    private String correo;
    private String identificacion;
    private String tipoDoc;
    private int edad;

    public Persona() {}

    public Persona(String nombres, String apellidos, String correo,
                   String identificacion, String tipoDoc, int edad) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.identificacion = identificacion;
        this.tipoDoc = tipoDoc;
        this.edad = edad;
    }
    public String getCorreoElectronico() {
    return correo;
}

public void setCorreoElectronico(String correoElectronico) {
    this.correo = correoElectronico;
}

    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getIdentificacion() { return identificacion; }
    public void setIdentificacion(String identificacion) { this.identificacion = identificacion; }

    public String getTipoDoc() { return tipoDoc; }
    public void setTipoDoc(String tipoDoc) { this.tipoDoc = tipoDoc; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    @Override
    public String toString() {
        return nombres + " " + apellidos + " (" + identificacion + ")";
    }
}