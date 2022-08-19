package com.proyectoProgra.Equipaje;

public class Equipaje {
    
    private int Equipaje;
    private int EquipajeMano;
    private double Peso;
    private double Precio;
    
    public Equipaje(){
        this.Equipaje=0;
        this.EquipajeMano=0;
        this.Peso=0.00;
        this.Precio=0.00;
    }

    public int getEquipaje() {
        return Equipaje;
    }

    public void setEquipaje(int Equipaje) {
        this.Equipaje = Equipaje;
    }

    public int getEquipajeMano() {
        return EquipajeMano;
    }

    public void setEquipajeMano(int EquipajeMano) {
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
