package model.InicioSesion;

import model.Persona.Persona;

public class Usuario {

    private String username;
    private String password;
    private Persona persona; 

    public Usuario() {}

    public Usuario(String username, String password, Persona persona) {
        this.username = username;
        this.password = password;
        this.persona = persona;
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Persona getPersona() { return persona; }
    public void setPersona(Persona persona) { this.persona = persona; }

    @Override
    public String toString() {
        return "Usuario{" +
                "username='" + username + '\'' +
                ", persona=" + persona +
                '}';
    }

}

