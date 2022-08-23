package com.proyectoProgra.Reserva;
public class Cajas {
    private double Ingresos;
    private String clientesAtendidos;
    
    public Cajas(){
        this.Ingresos=0.00;
        this.clientesAtendidos="";
    }

    public double getIngresos() {
        return Ingresos;
    }

    public void setIngresos(double Ingresos) {
        this.Ingresos = Ingresos;
    }

    public String getClientesAtendidos() {
        return clientesAtendidos;
    }

    public void setClientesAtendidos(String clientesAtendidos) {
        this.clientesAtendidos = clientesAtendidos;
    }
    
}
