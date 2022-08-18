package com.proyectoProgra.Registro;

import com.github.javafaker.Faker;
import javax.swing.JOptionPane;

public class Agregar {
    
    private NodoPUsuario cima;
    String status;
    
    
    public Agregar(){
        this.cima=null;
        
    }
    
    public boolean esVacia() {
        if (cima == null) {
            return true;
        } else {
            return false;
        }
    }
    
    //Metodo para verificar si esta activo o inactivo
    public void Status(){
        if(!esVacia()){
            NodoPUsuario aux=cima;
            while(aux!=null){
            if(aux.getDato().isEstado()==true){
                status="Activo";
                aux=aux.getSiguiente();
            }else{
                status="Inactivo";
                aux=aux.getSiguiente();
            }
            }
        }
        }
    
    public void AgregarNuevoUsuario(){
        //Creacion del Usuario
        Faker faker=new Faker();
        Usuario usr=new Usuario();
        usr.setNombre(faker.name().firstName());
        usr.setApellidos(faker.name().lastName());
        usr.setNick(faker.name().username());
        usr.setPassword(faker.internet().password());
        JOptionPane.showMessageDialog(null, "El nombre del usuario es: "+usr.getNombre()+" "+usr.getApellidos()+".\nNombre de usuario: "+usr.getNick());
        usr.setEstado(true);
        
        //Creacion del nodo de la pila con el usuario asignado anteriormente
        NodoPUsuario nuevo=new NodoPUsuario();
        nuevo.setDato(usr);
        if(esVacia()){
          cima=nuevo;
       }else{
          nuevo.setSiguiente(cima);
          cima=nuevo;
       }
        Status();
        JOptionPane.showMessageDialog(null, "El usuario "+usr.getNombre()+" "+usr.getApellidos() +" fue agregado al sistema!\nUsuario se encuentra: "+status);
    }
    
    public void DesactivarUsuario(){
        if(!esVacia()){
            
        }
    }
    
    
    public void mostrarUsuario(){
       if(!esVacia()){
          NodoPUsuario aux=cima;
          String s="";
          while(aux!=null){
             s=s+"Nombre: "+aux.getDato().getNombre()+"\nApellidos: "+aux.getDato().getApellidos()+
                "\nNombre de usuario: "+aux.getDato().getNick()+"\nContrasena: "+aux.getDato().getPassword()+"\nEstado: "+status+"\n----------------------------------\n";
             aux=aux.getSiguiente();
          }
          JOptionPane.showMessageDialog(null,
                  "La pila contiene:\n"+s);
       }else{
          JOptionPane.showMessageDialog(null,"¡No se puede mostrar, pila vacía!");
       }
    }
}
