package com.proyectoProgra;

import com.proyectoProgra.Registro.Agregar;
import com.proyectoProgra.Boletos.ReservaBoleto;
import javax.swing.JOptionPane;

public class Menu {

    Agregar a = new Agregar();
    ReservaBoleto b = new ReservaBoleto();
    private String[] opciones = {"1.Registrar usuario", "3.Mostrar usuarios", "4.Boleteria", "5.Salir"};

    public void mostrarMenuPrincipal() {
        String opc = (String) JOptionPane.showInputDialog(null, "Seleccione su opcion:", "Menu principal", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        if (opc.equals("1.Registrar usuario")) {
            a.AgregarNuevoUsuario();
            mostrarMenuPrincipal();
        } //        else if(opc.equals("2. Desactivar usuarios")){
        //            p.desactivar();
        //            mostrarMenu();
        //        }
        else if (opc.equals("3.Mostrar usuarios")) {
            a.mostrarUsuario();
            mostrarMenuPrincipal();

        } else if (opc.equals("4.Boleteria")) {
            mostrarMenuBoletos();
            mostrarMenuPrincipal();
        } else if (opc.equals("5.Salir")) {
            System.exit(0);
        }
    }

    private String[] opciones2 = {"1.Agregar Boleto", "2.Modificar Boleto", "3.Eliminar Boleto", "4.Mostrar Boletos", "5.Volver"};

    public void mostrarMenuBoletos() {
        String opc = (String) JOptionPane.showInputDialog(null, "Seleccione su opcion:", "Menu principal", JOptionPane.QUESTION_MESSAGE, null, opciones2, opciones2[0]);

        if (opc.equals("1.Agregar Boleto")) {
            b.AsignarBoleto();
            mostrarMenuBoletos();
        } else if (opc.equals("2.Modificar Boleto")) {
            b.ModificaBoleto();
            mostrarMenuBoletos();
        } else if (opc.equals("3.Eliminar Boleto")) {
            b.EliminarBoleto();
            mostrarMenuBoletos();
        } else if (opc.equals("4.Mostrar Boletos")) {
            b.MostrarBoletos();
            mostrarMenuBoletos();
        } else if (opc.equals("5.Volver")) {
            mostrarMenuPrincipal();
        }
    }

}
