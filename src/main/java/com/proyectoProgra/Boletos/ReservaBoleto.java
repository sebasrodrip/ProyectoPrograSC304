package com.proyectoProgra.Boletos;

import java.util.ArrayList;
import com.github.javafaker.Faker;
import javax.swing.JOptionPane;

public class ReservaBoleto {

    private ArrayList<Boleto> boletos = new ArrayList();
    Faker faker = new Faker();

    public void AsignarBoleto() {
        int seguir = 0;
        while (seguir == 0) {
            //se crea el Boleto
            Boleto bol = new Boleto();
            bol.setNumeroBoleto(Integer.parseInt(faker.address().streetAddressNumber()));
            bol.setCiudadSalida(faker.address().cityName());
            bol.setCiudadDestino(faker.address().cityName());
            bol.setFechaDeUso(JOptionPane.showInputDialog(null, "Ingrese la fecha de salida(dd-MM-AA): "));
            bol.setHoraDeSalida(JOptionPane.showInputDialog(null, "Ingrese la hora de salida(hh:mm): "));
            bol.setPrecioTiquete(Double.parseDouble(faker.commerce().price()));
            //Se agrega el boleto al ArrayList
            boletos.add(bol);

            JOptionPane.showMessageDialog(null, "¡Boleto agregado exitosamente!",
                    "Datos agregados", JOptionPane.INFORMATION_MESSAGE);
            seguir = JOptionPane.showConfirmDialog(null, "Desea agregar otro boleto?",
                    "Continuar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        }
    }

    public void MostrarBoletos() {
        if (boletos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay boletos disponibles.");
        } else {
            for (int x = 0; x < boletos.size(); x++) {
                JOptionPane.showMessageDialog(null, "***BOLETOS DISPONIBLES***\n\n"
                        + "BOLETO # " + boletos.get(x).getNumeroBoleto()
                        + "\nSALIDA: " + boletos.get(x).getCiudadSalida()
                        + "\nDESTINO: " + boletos.get(x).getCiudadDestino()
                        + "\nFECHA DE SALIDA: " + boletos.get(x).getFechaDeUso()
                        + "\nHORA DE SALIDA: " + boletos.get(x).getHoraDeSalida());
            }
        }
    }

    public void ModificaBoleto() {
        int busqueda = 0;
        String cambio;
        busqueda = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero del boleto que desea modificar: "));
        for (int x = 0; x < boletos.size(); x++) {
            if (busqueda == boletos.get(x).getNumeroBoleto()) {
                int opc;
                opc = Integer.parseInt(JOptionPane.showInputDialog(null, "Que desea cambiar?\n1. Fecha\n2. Hora" + "\n3. Ambas"));
                if (opc == 1) {
                    cambio = boletos.get(x).getFechaDeUso();
                    boletos.get(x).setFechaDeUso(JOptionPane.showInputDialog(null, "Ingrese la nueva fecha de salida: "));
                    JOptionPane.showMessageDialog(null, "Se cambio la fecha: " + cambio + " a: " + boletos.get(x).getFechaDeUso());
                } else if (opc == 2) {
                    cambio = boletos.get(x).getHoraDeSalida();
                    boletos.get(x).setHoraDeSalida(JOptionPane.showInputDialog(null, "Ingrese la nueva hora de salida: "));
                    JOptionPane.showMessageDialog(null, "Se cambio la hora: " + cambio + " a: " + boletos.get(x).getHoraDeSalida());
                } else if (opc == 3) {
                    cambio = boletos.get(x).getFechaDeUso();
                    boletos.get(x).setFechaDeUso(JOptionPane.showInputDialog(null, "Ingrese la nueva fecha de salida: "));
                    cambio = boletos.get(x).getHoraDeSalida();
                    boletos.get(x).setHoraDeSalida(JOptionPane.showInputDialog(null, "Ingrese la nueva hora de salida: "));
                    JOptionPane.showMessageDialog(null, "Se cambio la fecha: " + cambio + " a: " + boletos.get(x).getFechaDeUso()
                            + "\nSe cambio la hora: " + cambio + " a: " + boletos.get(x).getHoraDeSalida());
                } else {
                    JOptionPane.showMessageDialog(null, "Opcion incorrecta!");
                }
            }
        }
    }

    public void EliminarBoleto() {
        int busqueda = 0;
        busqueda = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero del boleto que desea eliminar: "));
        for (int x = 0; x < boletos.size(); x++) {
            if (busqueda == boletos.get(x).getNumeroBoleto()) {
                int opc = JOptionPane.showConfirmDialog(null, "Se va a eliminar el boleto #: " + boletos.get(x).getNumeroBoleto()
                        + "\nque sale desde: " + boletos.get(x).getCiudadSalida() + "\ncon destino a: " + boletos.get(x).getCiudadDestino()
                        + "\nel dia: " + boletos.get(x).getFechaDeUso() + " a las: " + boletos.get(x).getHoraDeSalida()
                        + "\n\nDesea continuar?", null, JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                if (opc == JOptionPane.YES_OPTION) {
                    boletos.remove(x);
                    JOptionPane.showMessageDialog(null, "Se elimino con exito.");
                } else if (opc == JOptionPane.NO_OPTION) {
                    EliminarBoleto();
                }
            }
        }
    }
}
