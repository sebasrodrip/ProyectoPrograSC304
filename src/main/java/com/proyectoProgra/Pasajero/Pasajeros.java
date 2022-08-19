package com.proyectoProgra.Pasajero;


class Pasajeros {
    private String nickp;
    private int ticketp;
    private String maletasp;
    private String precioreserva;

    public Pasajeros() {
        this.nickp = "";
        this.ticketp = 0;
        this.maletasp = "";
        this.precioreserva = "";
    }

    public String getNickp() {
        return nickp;
    }

    public void setNickp(String nickp) {
        this.nickp = nickp;
    }

    public int getTicketp() {
        return ticketp;
    }

    public void setTicketp(int ticketp) {
        this.ticketp = ticketp;
    }

    public String getMaletasp() {
        return maletasp;
    }

    public void setMaletasp(String maletasp) {
        this.maletasp = maletasp;
    }

    public String getPrecioreserva() {
        return precioreserva;
    }

    public void setPrecioreserva(String precioreserva) {
        this.precioreserva = precioreserva;
    }

    
}
