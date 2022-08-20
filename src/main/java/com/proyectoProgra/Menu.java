package com.proyectoProgra;

import com.proyectoProgra.Reserva.*;
import javax.swing.JOptionPane;

public class Menu {

    Reserva r = new Reserva();

    private String[] opciones = {"1.Registrar usuario", "2.Desactivar Usuarios","3.Mostrar usuarios", "4.Boleteria", "5.Pasajero", "6.Salir"};

    public void mostrarMenuPrincipal() {
        String opc = (String) JOptionPane.showInputDialog(null, "Seleccione su opcion:", "Menu principal", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        if (opc.equals("1.Registrar usuario")) {
            r.AgregarNuevoUsuario();
            mostrarMenuPrincipal();
        } else if (opc.equals("2.Desactivar Usuarios")) {
            r.DesactivarUsuario();
            mostrarMenuPrincipal();
        } else if (opc.equals("3.Mostrar usuarios")) {
            r.mostrarUsuario();
            mostrarMenuPrincipal();
        } else if (opc.equals("4.Boleteria")) {
            mostrarMenuBoletos();
            mostrarMenuPrincipal();
        } else if (opc.equals("5.Pasajero")) {
            mostrarMenuPasajeros();
            mostrarMenuPrincipal();
        }         
        else if (opc.equals("6.Salir")) {
            System.exit(0);
        }
    }

    private String[] opciones2 = {"1.Agregar Boleto", "2.Modificar Boleto", "3.Eliminar Boleto", "4.Mostrar Boletos", "5.Volver"};

    public void mostrarMenuBoletos() {
        String opc = (String) JOptionPane.showInputDialog(null, "Seleccione su opcion:", "Menu principal", JOptionPane.QUESTION_MESSAGE, null, opciones2, opciones2[0]);

        if (opc.equals("1.Agregar Boleto")) {
            r.AsignarBoleto();
            mostrarMenuBoletos();
        } else if (opc.equals("2.Modificar Boleto")) {
            r.ModificaBoleto();
            mostrarMenuBoletos();
        } else if (opc.equals("3.Eliminar Boleto")) {
            r.EliminarBoleto();
            mostrarMenuBoletos();
        } else if (opc.equals("4.Mostrar Boletos")) {
            r.MostrarBoletos();
            mostrarMenuBoletos();
        } else if (opc.equals("5.Volver")) {
            mostrarMenuPrincipal();
        }
    }

    private String[] opciones3 = {"1.Registrar Boleto", "2.Modificar", "3.Eliminar", "4.Mostrar", "5.Volver"};

    public void mostrarMenuPasajeros() {
        String opc = (String) JOptionPane.showInputDialog(null, "Seleccione su opcion:", "Menu principal", JOptionPane.QUESTION_MESSAGE, null, opciones3, opciones3[0]);

        if (opc.equals("1.Registrar Boleto")) {
            r.AsignarPasajero();
            mostrarMenuPasajeros();
        } else if (opc.equals("2.Modificar")) {
            r.CambioPasajero();
            mostrarMenuPasajeros();
        } else if (opc.equals("3.Eliminar")) {
            r.EliminarPasajero();
            mostrarMenuPasajeros();
        } else if (opc.equals("4.Mostrar")) {
            r.mostrarPasajero();
            mostrarMenuPasajeros();
        } else if (opc.equals("5.Volver")) {
            mostrarMenuPrincipal();
        }
    }

}
