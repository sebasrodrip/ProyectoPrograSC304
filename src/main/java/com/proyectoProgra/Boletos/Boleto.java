package com.proyectoProgra.Boletos;

public class Boleto {

    private int NumeroBoleto;
    private String CiudadSalida;
    private String CiudadDestino;
    private String FechaDeUso;
    private String HoraDeSalida;
    private double PrecioTiquete;
    private int Tren;

    public Boleto() {
        this.NumeroBoleto = 0;
        this.CiudadSalida = "";
        this.CiudadDestino = "";
        this.FechaDeUso = "";
        this.HoraDeSalida = "";
        this.PrecioTiquete = 0.00;
        this.Tren = 0;
    }

    public int getNumeroBoleto() {
        return NumeroBoleto;
    }

    public void setNumeroBoleto(int NumeroBoleto) {
        this.NumeroBoleto = NumeroBoleto;
    }

    public String getCiudadSalida() {
        return CiudadSalida;
    }

    public void setCiudadSalida(String CiudadSalida) {
        this.CiudadSalida = CiudadSalida;
    }

    public String getCiudadDestino() {
        return CiudadDestino;
    }

    public void setCiudadDestino(String CiudadDestino) {
        this.CiudadDestino = CiudadDestino;
    }

    public String getFechaDeUso() {
        return FechaDeUso;
    }

    public void setFechaDeUso(String FechaDeUso) {
        this.FechaDeUso = FechaDeUso;
    }

    public String getHoraDeSalida() {
        return HoraDeSalida;
    }

    public void setHoraDeSalida(String HoraDeSalida) {
        this.HoraDeSalida = HoraDeSalida;
    }

    public double getPrecioTiquete() {
        return PrecioTiquete;
    }

    public void setPrecioTiquete(double PrecioTiquete) {
        this.PrecioTiquete = PrecioTiquete;
    }

    public int getTren() {
        return Tren;
    }

    public void setTren(int Tren) {
        this.Tren = Tren;
    }
}
