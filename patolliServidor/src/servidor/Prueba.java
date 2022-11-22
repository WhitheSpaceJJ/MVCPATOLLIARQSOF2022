

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;

import control.ControlServidor;
import java.net.InetAddress;
import modelo.ModeloServidor;

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
            ModeloServidor modeloServidor = new ModeloServidor();
            ControlServidor controlServidor = new ControlServidor(modeloServidor);
            Servidor servidor = new Servidor(controlServidor, 80);
            modeloServidor.addObserver(servidor);
            servidor.crear();
            servidor.esperar();
            servidor.start();
//            Thread servidorPrincipal = new Thread(servidor);
//            servidorPrincipal.start();
        } catch (Exception e) {
            System.out.println("Error; " + e.getMessage());
        }
    }

}
