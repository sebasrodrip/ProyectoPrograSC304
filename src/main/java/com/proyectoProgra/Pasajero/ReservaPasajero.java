package com.proyectoProgra.Pasajero;

import java.util.ArrayList;
import com.github.javafaker.Faker;
import javax.swing.JOptionPane;
import com.proyectoProgra.Registro.*;
import com.proyectoProgra.Boletos.*;

public class ReservaPasajero {

    public ArrayList<Pasajeros> pasajeros = new ArrayList();
    Faker faker = new Faker();
    Agregar a = new Agregar();
    ReservaBoleto b = new ReservaBoleto();
    Pasajeros p = new Pasajeros();
    
    private NodoPUsuario cima;
    //NodoPUsuario u = new NodoPUsuario();

    public void AsignarPasajero() {
        if (!a.esVacia()) {
            NodoPUsuario aux = cima;
            String busqueda;
            //String cambio;
            busqueda = JOptionPane.showInputDialog(null, "Ingrese el nick que desea asignar: ");
            while (aux != null) {
                p.setNickp(aux.getDato().getNick());
                if (busqueda == aux.getDato().getNick()) {
                    int opc = Integer.parseInt(JOptionPane.showInputDialog(null, "Desea ver los boletos disponibles?", null, JOptionPane.YES_NO_OPTION));
                    if (opc == JOptionPane.YES_OPTION) {
                        b.MostrarBoletos();
                    } else if (opc == JOptionPane.NO_OPTION) {
                    }
                    int busquedaB = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número de boleto que desea comprar:"));
                    int x;
                    for (x = 0; x < b.boletos.size(); x++) {
                        if (busquedaB == b.boletos.get(x).getNumeroBoleto()){
                            int opc2 = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Desea comprar el siguiente boleto?" + "\n\nBOLETO # " + b.boletos.get(x).getNumeroBoleto()
                        + "\nSALIDA: " + b.boletos.get(x).getCiudadSalida()
                        + "\nDESTINO: " + b.boletos.get(x).getCiudadDestino()
                        + "\nFECHA DE SALIDA: " + b.boletos.get(x).getFechaDeUso()
                        + "\nHORA DE SALIDA: " + b.boletos.get(x).getHoraDeSalida()+"\n----------------------"
                        + "\n        PRECIO:"+ b.boletos.get(x).getPrecioTiquete(), null, JOptionPane.YES_NO_OPTION));
                    if (opc == JOptionPane.YES_OPTION) {
                        p.setTicketp(b.boletos.get(x).getNumeroBoleto());
                        pasajeros.add(p);
                    } else if (opc == JOptionPane.NO_OPTION) {
                        
                    }
                        }
                     
                            
                    }
                }
            }
        }
    }
}
