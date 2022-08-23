package com.proyectoProgra.Reserva;

import com.github.javafaker.Faker;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;

public class Reserva {

    private ArrayList<Boleto> boletos = new ArrayList();
    private ArrayList<Pasajeros> pasajeros = new ArrayList();
    private ArrayList<Equipaje> equip = new ArrayList();
    private ArrayList<Cajas> cajas = new ArrayList();
    Faker faker = new Faker();
    Random random = new Random();
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
    Date date = new Date();  

    double PrecioXKg = 0.6;
    double pesoM;
    double precioT = 0;
    double ingresosT;

    private NodoPUsuario cima;
    private NodoLESCompra inicioLES;

    public Reserva() {
        this.cima = null;
        this.inicioLES=null;
    }

    public boolean esVacia() {
        if (cima == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean esVaciaLES(){
      if(inicioLES==null){
         return true;
      }else{
         return false;
      }
   }

    public void AgregarNuevoUsuario() {
        //Creacion del Usuario
        Usuario usr = new Usuario();
        usr.setNombre(faker.name().firstName());
        usr.setApellidos(faker.name().lastName());
        usr.setNick(faker.name().username());
        usr.setPassword(faker.internet().password());
        JOptionPane.showMessageDialog(null, "El nombre del usuario es: " + usr.getNombre() + " " + usr.getApellidos() + ".\nNombre de usuario: " + usr.getNick());
        usr.setEstado(true);

        //Creacion del nodo de la pila con el usuario asignado anteriormente
        NodoPUsuario nuevo = new NodoPUsuario();
        nuevo.setDato(usr);
        if (esVacia()) {
            cima = nuevo;
        } else {
            nuevo.setSiguiente(cima);
            cima = nuevo;
        }
        JOptionPane.showMessageDialog(null, "El usuario " + usr.getNombre() + " " + usr.getApellidos() + " fue agregado al sistema!\nUsuario se encuentra: " + (usr.isEstado() ? "Activo" : "Inactivo"));
    }

    public void DesactivarUsuario() {
        if (!esVacia()) {
            NodoPUsuario aux = cima;
            String busqueda = JOptionPane.showInputDialog(null, "Ingrese el nombre del usuario que desea inactivar: ");
            while (aux != null) {
                if (busqueda.equals(aux.getDato().getNick())) {
                    if (pasajeros.isEmpty()) {
                        aux.getDato().setEstado(false);
                        JOptionPane.showMessageDialog(null, "Usuario inactivado!");
                    } else {
                        for (int x = 0; x < pasajeros.size(); x++) {
                            if (busqueda.equals(pasajeros.get(x).getNickp())) {
                                JOptionPane.showMessageDialog(null, "No se puede desactivar, el usuario tiene un viaje asignado!");
                            }
                        }
                    }

                }
                aux = aux.getSiguiente();
            }
        }
    }

    public void mostrarUsuario() {
        if (!esVacia()) {
            NodoPUsuario aux = cima;
            String s = "";
            while (aux != null) {
                s = s + "Nombre: " + aux.getDato().getNombre() + "\nApellidos: " + aux.getDato().getApellidos()
                        + "\nNombre de usuario: " + aux.getDato().getNick() + "\nContrasena: " + aux.getDato().getPassword() + "\nEstado: " + (aux.getDato().isEstado() ? "Activo" : "Inactivo") + "\n----------------------------------\n";
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null,
                    "La pila contiene:\n" + s);
        } else {
            JOptionPane.showMessageDialog(null, "¡No se puede mostrar, pila vacía!");
        }
    }

    public void AsignarBoleto() {
        int seguir = 0;
        while (seguir == 0) {
            //se crea el Boleto
            Boleto bol = new Boleto();
            bol.setNumeroBoleto(Integer.parseInt(faker.address().streetAddressNumber()));
            bol.setCiudadSalida(faker.address().cityName());
            bol.setCiudadDestino(faker.address().cityName());
            bol.setFechaDeUso(JOptionPane.showInputDialog(null, "Ingrese la fecha de salida(dd-MM-AA) para el boleto: " + bol.getNumeroBoleto()
                    + "\nque sale desde: " + bol.getCiudadSalida() + " va hacia: " + bol.getCiudadDestino()));
            bol.setHoraDeSalida(JOptionPane.showInputDialog(null, "Ingrese la hora de salida(hh:mm) para el boleto: " + bol.getNumeroBoleto()
                    + "\nque sale desde: " + bol.getCiudadSalida() + " va hacia: " + bol.getCiudadDestino()));
            bol.setTrenRapido(JOptionPane.showInputDialog(null, "Ingrese si  es tren rapido o no: " ));
            bol.setPrecioTiquete(Double.parseDouble(faker.commerce().price()));
            bol.setTren(NumeroTren());
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
                        + "\nTREN # " + boletos.get(x).getTren()
                        + "\nSALIDA: " + boletos.get(x).getCiudadSalida()
                        + "\nDESTINO: " + boletos.get(x).getCiudadDestino()
                        + "\nFECHA DE SALIDA: " + boletos.get(x).getFechaDeUso()
                        + "\nHORA DE SALIDA: " + boletos.get(x).getHoraDeSalida()
                        + "\nTren Rapido: " + boletos.get(x).getTrenRapido()
                        + "\n----------------------------------\n        PRECIO: " + boletos.get(x).getPrecioTiquete());
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
                opc = Integer.parseInt(JOptionPane.showInputDialog(null, "Que desea cambiar?\n1. Fecha\n2. Hora" + "\n3. Ambas" + "\n4. # Tren" + "\n5. # TrenRapido"));
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
                } else if (opc == 4) {
                    int cambioTren = boletos.get(x).getTren();
                    boletos.get(x).setTren(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nuevo # de Tren: ")));
                    JOptionPane.showMessageDialog(null, "Se cambio el # de Tren: " + cambioTren + " a: " + boletos.get(x).getTren());
                } else if (opc == 5) {
                    String cambioTrenRapido = boletos.get(x).getTrenRapido();
                    boletos.get(x).setTren(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese si el tren es rapido o no: ")));
                    JOptionPane.showMessageDialog(null, "Se cambio si el tren es rapido o no: " + cambioTrenRapido + " a: " + boletos.get(x).getTrenRapido());
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
                if (pasajeros.isEmpty()) {
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
                } else {
                    if (busqueda == pasajeros.get(x).getTicketp()) {
                        JOptionPane.showMessageDialog(null, "No se puede eliminar boleto, se encuentra asociado al usuario: " + pasajeros.get(x).getNickp());
                    }
                }
            }
        }
    }

    public int NumeroTren() {
        int min = 1;
        int max = 10;

        int valor = random.nextInt(max + min) + min;

        return valor;
    }

    public void AsignarPasajero() {
        if (!esVacia()) {
            Pasajeros p = new Pasajeros();
            NodoPUsuario aux = cima;
            int salida = 0;
            String busqueda = JOptionPane.showInputDialog(null, "Ingrese el nick que desea asignar: ");
            while (aux != null) {
                if (busqueda.equals(aux.getDato().getNick())) {
                    if (aux.getDato().isEstado() == false) {
                        JOptionPane.showMessageDialog(null, "No se puede asignar, usuario inactivo!");
                        AsignarPasajero();
                    } else if (aux.getDato().isEstado() == true) {
                        do {
                            do {
                                int opc = JOptionPane.showConfirmDialog(null, "Desea ver los boletos disponibles?", null, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                                if (opc == JOptionPane.YES_OPTION) {
                                    MostrarBoletos();
                                    salida = 0;
                                } else if (opc == JOptionPane.NO_OPTION) {
                                    salida = 1;
                                }
                            } while (salida != 1);

                            int x;
                            salida = 0;
                            int busquedaB = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número de boleto que desea comprar:"));
                            for (x = 0; x < boletos.size(); x++) {
                                if (busquedaB == boletos.get(x).getNumeroBoleto()) {
                                    int opc2 = JOptionPane.showConfirmDialog(null,
                                            "Desea comprar el siguiente boleto?\n\nBOLETO # " + boletos.get(x).getNumeroBoleto()
                                            + "\nSALIDA: " + boletos.get(x).getCiudadSalida()
                                            + "\nDESTINO: " + boletos.get(x).getCiudadDestino()
                                            + "\nFECHA DE SALIDA: " + boletos.get(x).getFechaDeUso()
                                            + "\nHORA DE SALIDA: " + boletos.get(x).getHoraDeSalida() + "\n----------------------------------"
                                            + "\n        PRECIO: " + boletos.get(x).getPrecioTiquete(), null, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

                                    if (opc2 == JOptionPane.YES_OPTION) {
                                        p.setNickp(aux.getDato().getNick());
                                        p.setTicketp(boletos.get(x).getNumeroBoleto());
                                        p.setPrecioreserva(boletos.get(x).getPrecioTiquete());
                                        p.setManop(false);
                                        p.setMaletasp(0);
                                        pasajeros.add(p);
                                        salida = 1;

                                    } else if (opc2 == JOptionPane.NO_OPTION) {
                                        salida = 0;
                                    }
                                }
                            }
                        } while (salida != 1);
                        int opc3 = JOptionPane.showConfirmDialog(null, "Desea agregar equipaje de mano?", null, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        if (opc3 == JOptionPane.YES_OPTION) {
                            AsignarEquipaje(busqueda);
                        } else if (opc3 == JOptionPane.NO_OPTION) {
                            p.setMaletasp(0);
                            pasajeros.add(p);
                        }
                    }
                }
                aux = aux.getSiguiente();
            }
        }
    }

    public void EliminarPasajero() {
        if (!pasajeros.isEmpty()) {
            String busqueda = JOptionPane.showInputDialog(null, "Ingrese el nick del pasajero que desea eliminar: ");
            for (int x = 0; x < pasajeros.size(); x++) {
                if ((busqueda.equals(pasajeros.get(x).getNickp())) && (pasajeros.get(x).getTicketp() == boletos.get(x).getNumeroBoleto()) && (pasajeros.get(x).getMaletasId() == equip.get(x).getIdEquipaje())) {
                    JOptionPane.showMessageDialog(null, "No se puede eliminar el pasajero");
                } else {
                    pasajeros.remove(x);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay pasajeros registrados!");
        }
    }

    public void CambioPasajero() {
        if (!pasajeros.isEmpty()) {
            int salida = 0;
            String busqueda = JOptionPane.showInputDialog(null, "Ingrese el nick del usuario que desea modificar: ");
            for (int x = 0; x < pasajeros.size(); x++) {
                if (busqueda.equals(pasajeros.get(x).getNickp())) {
                    do {
                        int opc = Integer.parseInt(JOptionPane.showInputDialog(null, "Que desea hacer? \n1. Cambiar boleto\n2. Cambiar Equipaje\n3.Salir"));
                        if (opc == 1) {
                            do {
                                do {
                                    int opc2 = JOptionPane.showConfirmDialog(null, "Desea ver los boletos disponibles?", null, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                                    if (opc2 == JOptionPane.YES_OPTION) {
                                        MostrarBoletos();
                                        salida = 0;
                                    } else if (opc == JOptionPane.NO_OPTION) {
                                        salida = 1;
                                    }
                                } while (salida != 1);
                                salida = 0;
                                int busquedaB = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número de boleto que desea comprar:"));
                                for (int y = 0; y < boletos.size(); y++) {
                                    if (busquedaB == boletos.get(y).getNumeroBoleto()) {
                                        int opc2 = JOptionPane.showConfirmDialog(null,
                                                "Desea comprar el siguiente boleto?\n\nBOLETO # " + boletos.get(x).getNumeroBoleto()
                                                + "\nSALIDA: " + boletos.get(x).getCiudadSalida()
                                                + "\nDESTINO: " + boletos.get(x).getCiudadDestino()
                                                + "\nFECHA DE SALIDA: " + boletos.get(x).getFechaDeUso()
                                                + "\nHORA DE SALIDA: " + boletos.get(x).getHoraDeSalida() + "\n----------------------------------"
                                                + "\n        PRECIO: " + boletos.get(x).getPrecioTiquete(), null, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

                                        if (opc2 == JOptionPane.YES_OPTION) {
                                            pasajeros.get(x).setTicketp(boletos.get(y).getNumeroBoleto());
                                            salida = 1;

                                        } else if (opc2 == JOptionPane.NO_OPTION) {
                                            salida = 0;
                                        }

                                    }
                                }

                            } while (salida != 1);
                            salida = 0;
                        } else if (opc == 2) {
                            AsignarEquipaje(busqueda);
                            salida = 0;
                        } else if (opc == 3) {
                            salida = 1;
                        }
                    } while (salida != 1);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Lista de pasajeros vacia!");
        }
    }

    public void mostrarPasajero() {
        String busqueda = JOptionPane.showInputDialog(null, "Ingrese el nick que desea mostrar: ");
        for (int x = 0; x < pasajeros.size(); x++) {
            if (busqueda.equals(pasajeros.get(x).getNickp())) {
                JOptionPane.showMessageDialog(null, "***PASAJERO " + pasajeros.get(x).getNickp() + "***"
                        + "\nBOLETO # " + pasajeros.get(x).getTicketp() + "\nMALETAS: " + pasajeros.get(x).getMaletasp() + "ID MALETAS:  " + pasajeros.get(x).getMaletasId()
                        + "\nEQUIPAJE DE MANO: " + (pasajeros.get(x).isManop() ? "Si" : "No")+"\n-----------------------PRECIO TOTAL: "+String.format("2%f", pasajeros.get(x).getPrecioreserva())+"$");
            }
        }

    }

    public void AsignarEquipaje(String b) {
        //se crea el Equipaje
        Equipaje equi = new Equipaje();
        int seguir = 0;
        precioT = 0;
        pesoM = (double) (Math.random() * 50 + 1);
        while (seguir == 0) {
            for (int x = 0; x < pasajeros.size(); x++) {
                if (b.equals(pasajeros.get(x).getNickp())) {
                    equi.setEquipaje(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese cuantas maletas lleva: ")));
                    int mano = JOptionPane.showConfirmDialog(null, "Lleva equipaje de mano? ", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (mano == JOptionPane.YES_OPTION) {
                        equi.setEquipajeMano(true);
                        precioT = 0.5;
                    } else {
                        equi.setEquipajeMano(false);
                    }
                    JOptionPane.showMessageDialog(null, "Calculando peso.....");
                    precioT = (((pesoM) * (equi.getEquipaje()) * PrecioXKg));
                    JOptionPane.showMessageDialog(null, "El precio total es: " + String.format("2%f", precioT) + "$");
                    equi.setPrecio(PrecioXKg);
                    equi.setIdEquipaje((byte) (Math.random() * 10 + 1));
                    //Se agrega el equipaje al ArrayList
                    equip.add(equi);
                    pasajeros.get(x).setMaletasp(equip.get(x).getEquipaje());
                    pasajeros.get(x).setMaletasId(equi.getIdEquipaje());
                    pasajeros.get(x).setPrecioreserva(pasajeros.get(x).getPrecioreserva()+PrecioXKg);
                    JOptionPane.showMessageDialog(null, "¡Equipaje agregado exitosamente!",
                            "Datos agregados", JOptionPane.INFORMATION_MESSAGE);
                    seguir = 1;
                }
            }
        }
    }
    //Transacciones
    public void CompraReserva(){
        Compra c=new Compra();
        int salida =1;
        do{
            int opc = JOptionPane.showConfirmDialog(null, "Desea ver las reservas disponibles?",
                    null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(opc==JOptionPane.YES_OPTION){
                for(int x=0;x<pasajeros.size();x++){
                    JOptionPane.showMessageDialog(null, "***PASAJERO " + pasajeros.get(x).getNickp() + "***"
                        + "\nBOLETO # " + pasajeros.get(x).getTicketp() + "\nMALETAS: " + pasajeros.get(x).getMaletasp() + "ID MALETAS:  " + pasajeros.get(x).getMaletasId()
                        + "\nEQUIPAJE DE MANO: " + (pasajeros.get(x).isManop() ? "Si" : "No"));
                }
                salida=0;
            }else if(opc==JOptionPane.NO_OPTION){
                salida=1;
            }
        }while(salida!=1);
        String busqueda=JOptionPane.showInputDialog(null,"Ingrese el nick del pasajero que desea realizar la compra:");
        for(int x=0;x<pasajeros.size();x++){
            if(busqueda.equals(pasajeros.get(x).getNickp())){
                int opc2=JOptionPane.showConfirmDialog(null, "Esta seguro que desea realizar la siguiente compra?"+
                        "***PASAJERO " + pasajeros.get(x).getNickp() + "***"
                        + "\nBOLETO # " + pasajeros.get(x).getTicketp() + "\nMALETAS: " + pasajeros.get(x).getMaletasp() + "ID MALETAS:  " + pasajeros.get(x).getMaletasId()
                        + "\nEQUIPAJE DE MANO: " + (pasajeros.get(x).isManop() ? "Si" : "No")+"\n-----------------------PRECIO TOTAL: "+String.format("2%f", pasajeros.get(x).getPrecioreserva())+"$",null, JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if (opc2 == JOptionPane.YES_OPTION){
                    c.setFechaHoy(formatter.format(date));
                    c.setMontoT(pasajeros.get(x).getPrecioreserva());
                    c.setNickCliente(pasajeros.get(x).getNickp());
                } else if(opc2== JOptionPane.NO_OPTION){
                    CompraReserva();
                }
            }
        }
        NodoLESCompra nuevo = new NodoLESCompra();
        nuevo.setDato(c);
        if(esVaciaLES()){
            inicioLES=nuevo;
        }else if(c.getMontoT()<inicioLES.getDato().getMontoT()){
            nuevo.setSiguiente(inicioLES);
            inicioLES=nuevo;
        }else if(inicioLES.getSiguiente()==null){
            inicioLES.setSiguiente(nuevo);
        }else{
            NodoLESCompra aux=inicioLES;
            while((aux.getSiguiente()!=null)&&(aux.getSiguiente().getDato().getMontoT()<c.getMontoT())){
                aux=aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
        }
        JOptionPane.showMessageDialog(null, "Compra realizada con exito!");
    }
    
    public void mostrarTransacciones(){
        if(!esVaciaLES()){
            String s="";
            NodoLESCompra aux=inicioLES;
            while(aux!=null){
                s=s+"***FACTURA EMITIDA "+aux.getDato().getFechaHoy()+"***"+"\nNOMBRE DEL CLIENTE: "+aux.getDato().getNickCliente()+
                        "\nMONTO PAGADO: "+aux.getDato().getMontoT()+"\n-------------------------";
                aux=aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "La lista contiene:\n"+s);
        }else{
            JOptionPane.showMessageDialog(null, "Lista vacia!");
        }
        
    }
    
    public void Ingresos(){
        if(!cajas.isEmpty()){
            Cajas caj=new Cajas();
            if(!esVaciaLES()){
                String s="";
                NodoLESCompra aux=inicioLES;
                while(aux!=null){
                    for(int x=0;x<cajas.size();x++){
                        caj.setClientesAtendidos(aux.getDato().getNickCliente());
                        caj.setIngresos(aux.getDato().getMontoT());
                        ingresosT=ingresosT+caj.getIngresos();
                        s=s+caj.getClientesAtendidos()+"--";
                        cajas.add(caj);
                    }
                    aux=aux.getSiguiente();
                }
                JOptionPane.showMessageDialog(null, "Ingresos del dia: "+formatter.format(date)+"\n"+s+"\nTOTAL: "+ingresosT);
            }
        }
    }
}
