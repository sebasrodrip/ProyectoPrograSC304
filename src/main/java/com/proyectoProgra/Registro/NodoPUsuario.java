package com.proyectoProgra.Registro;
public class NodoPUsuario {
    
    private Usuario dato;
    private NodoPUsuario siguiente;
    
    public NodoPUsuario(){
        this.siguiente=null;
    }

    public Usuario getDato() {
        return dato;
    }

    public void setDato(Usuario dato) {
        this.dato = dato;
    }

    public NodoPUsuario getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPUsuario siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
