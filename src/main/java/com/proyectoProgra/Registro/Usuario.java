package com.proyectoProgra.Registro;

public class Usuario {

    private String Nombre;
    private String Apellidos;
    private String Nick;
    private String Password;
    private boolean Estado;

    public Usuario() {
        this.Nombre = "0";
        this.Apellidos = "0";
        this.Nick = "0";
        this.Password = "0";
        this.Estado = false;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getNick() {
        return Nick;
    }

    public void setNick(String Nick) {
        this.Nick = Nick;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

}
