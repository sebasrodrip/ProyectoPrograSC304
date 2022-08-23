package com.proyectoProgra.Reserva;
public class NodoLESCompra {
    private Compra dato;
    private NodoLESCompra siguiente;
    
    public NodoLESCompra(){
        this.siguiente=null;
    }

    public Compra getDato() {
        return dato;
    }

    public void setDato(Compra dato) {
        this.dato = dato;
    }

    public NodoLESCompra getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLESCompra siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
