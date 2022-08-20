package com.proyectoProgra.Reserva;


class Pasajeros {
    private String nickp;
    private int ticketp;
    private int maletasp;
    private byte maletasId;
    private Double precioreserva;
    private boolean manop;

    public Pasajeros() {
        this.nickp = "";
        this.ticketp = 0;
        this.maletasp = 0;
        this.maletasId=0;
        this.precioreserva = 0.00;
        this.manop=false;
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

    public int getMaletasp() {
        return maletasp;
    }

    public void setMaletasp(int maletasp) {
        this.maletasp = maletasp;
    }

    public byte getMaletasId() {
        return maletasId;
    }

    public void setMaletasId(byte maletasId) {
        this.maletasId = maletasId;
    }
    
    public Double getPrecioreserva() {
        return precioreserva;
    }

    public void setPrecioreserva(Double precioreserva) {
        this.precioreserva = precioreserva;
    }

    public boolean isManop() {
        return manop;
    }

    public void setManop(boolean manop) {
        this.manop = manop;
    }
    
    
}
