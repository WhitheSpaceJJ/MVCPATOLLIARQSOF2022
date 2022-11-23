

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
            PartidaServidor modeloServidor = new PartidaServidor();
            ProtocoloPartida controlServidor = new ProtocoloPartida(modeloServidor);
            Servidor servidor = new Servidor(controlServidor, 80);
            modeloServidor.addObserver(servidor);
//            servidor.crear();
//            servidor.esperar();
            servidor.start();
//            Thread servidorPrincipal = new Thread(servidor);
//            servidorPrincipal.start();
        } catch (Exception e) {
            System.out.println("Error; " + e.getMessage());
        }
    }

}
