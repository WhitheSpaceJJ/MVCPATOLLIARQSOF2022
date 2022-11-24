

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;

import control.ProtocoloPartida;
import java.net.InetAddress;
import modelo.PartidaServidor;

/**
 *
 * @author Judi
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            /*Si se ejecuta el siguiente codigo, recuerde cliente en el proyecto patolliClienteMVC debe de actualizar
            la direccion del servidor. Esta direccion es la de la direccion IP de la maquina donde se ejecute
            el servidor, ademas recuerda desmilitarizar  en tu modem hacia la direccion IP de esta la maquina que
            ejecute el servidor .
            */
            PartidaServidor modeloServidor = new PartidaServidor();
            ProtocoloPartida controlServidor = new ProtocoloPartida(modeloServidor);
            /*Si desesa cambiar el puerto 80 adelante, solo que tambien cambiela en el cliente del proyecto
              patolliMVC con el fin de evitar problemas
            */
            Servidor servidor = new Servidor(controlServidor, 80);
            modeloServidor.addObserver(servidor);
            servidor.start();
        } catch (Exception e) {
            System.out.println("Error; " + e.getMessage());
        }
    }

}
