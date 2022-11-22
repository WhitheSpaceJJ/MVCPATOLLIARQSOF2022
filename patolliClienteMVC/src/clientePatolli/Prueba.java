/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clientePatolli;

import dominio.Jugador;
import java.net.InetAddress;
import java.net.UnknownHostException;

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
            InetAddress ip = InetAddress.getLocalHost();
            String host = ip.getHostAddress();
//            System.out.println(host);
            Cliente cliente = new Cliente(host, 80);
            cliente.setJugador(new Jugador("Jose", "Mario"));
            System.out.println(cliente.establecerConexion());
        } catch (UnknownHostException e) {
            System.out.println("Error; " + e.getMessage());
        }
    }

}
