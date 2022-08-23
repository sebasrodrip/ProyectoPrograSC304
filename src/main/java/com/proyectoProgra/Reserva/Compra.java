package com.proyectoProgra.Reserva;
public class Compra {
    public String FechaHoy;
    public String NickCliente;
    public double MontoT;
    
    public Compra(){
        this.FechaHoy="";
        this.NickCliente="";
        this.MontoT=0.00;
    }

    public String getFechaHoy() {
        return FechaHoy;
    }

    public void setFechaHoy(String FechaHoy) {
        this.FechaHoy = FechaHoy;
    }


    public String getNickCliente() {
        return NickCliente;
    }

    public void setNickCliente(String NickCliente) {
        this.NickCliente = NickCliente;
    }

    public double getMontoT() {
        return MontoT;
    }

    public void setMontoT(double MontoT) {
        this.MontoT = MontoT;
    }
    
    
}
