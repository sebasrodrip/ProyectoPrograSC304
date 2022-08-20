package com.proyectoProgra.Reserva;

public class Equipaje {
    
    private int Equipaje;
    private byte idEquipaje;
    private boolean EquipajeMano;
    private double Peso;
    private double Precio;
    
    public Equipaje(){
        this.Equipaje=0;
        this.idEquipaje=0;
        this.EquipajeMano=false;
        this.Peso=0.00;
        this.Precio=0.00;
    }

    public int getEquipaje() {
        return Equipaje;
    }

    public void setEquipaje(int Equipaje) {
        this.Equipaje = Equipaje;
    }

    public byte getIdEquipaje() {
        return idEquipaje;
    }

    public void setIdEquipaje(byte idEquipaje) {
        this.idEquipaje = idEquipaje;
    }
   
    public boolean isEquipajeMano() {
        return EquipajeMano;
    }

    public void setEquipajeMano(boolean EquipajeMano) {
        this.EquipajeMano = EquipajeMano;
    }

    public double getPeso() {
        return Peso;
    }

    public void setPeso(double Peso) {
        this.Peso = Peso;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }
    
    
}
