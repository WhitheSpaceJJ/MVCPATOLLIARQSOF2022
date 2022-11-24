package servidor;

import control.ProtocoloPartida;
import dominio.Dado;
import dominio.Jugador;
import dominio.Partida;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jugador.JugadorLocal;
import modelo.PartidaServidor;

public class Servidor extends Thread implements Observer {

    private Integer puntero;
    private List<Socket> jugadoresSocket;
    private List<JugadorLocal> jugadores;
    private ProtocoloPartida protocoloPartidaLocal;
    private int puerto;
    private int maximoPermitido;
    private boolean escuchando1 = true;

    //este auxiliar es para escuhar si el juego aun esta activo
    private boolean escuchando2 = true;
    //Se inicializaran cuando se ejecute Run
    private ServerSocket servidor;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private boolean enServicio;

    public Servidor(ProtocoloPartida controlPartidaLocal, int puerto) {
        this.maximoPermitido = 0;
        this.enServicio = true;
        this.protocoloPartidaLocal = controlPartidaLocal;
        this.puntero = null;
        this.puerto = puerto;
        this.jugadores = new ArrayList<>();
        this.jugadoresSocket = new ArrayList<>();
    }

    @Override
    public void update(Observable o, Object o1) {
        if (maximoPermitido == 0) {
            this.maximoPermitido = ((PartidaServidor) o).getPartidaLocal().getTotalJugadores();
        } else {
            if (o1 instanceof Integer) {
//                if (((Integer) o1) > -1) {
                notificarClientes(((PartidaServidor) o).getPartidaLocal(), ((Integer) o1));
//                }
            }
        }
    }

    @Override
    public void run() {

        Socket sc;
        try {
            //Creamos el socket del servidor
            this.servidor = new ServerSocket(puerto);
            System.out.println("Servidor iniciado");
            while (jugadores.isEmpty()) {
                sc = servidor.accept();
                this.jugadores = this.protocoloPartidaLocal.procesandoCreacion(sc);
                if (this.jugadores == null) {
                    this.jugadores = new ArrayList<>();
                    sc.close();
                }
            }
            while (true) {
                sc = servidor.accept();
                List<JugadorLocal> jugadoresEspera = this.protocoloPartidaLocal.procesandoEspera(sc, jugadores);
                if (jugadoresEspera == null) {
                    System.out.println("Ya existe un jugador con los mismos datos");
                    sc.close();
                } else {
                    this.jugadores = jugadoresEspera;
                    if (jugadoresEspera.size() == maximoPermitido) {
                        break;
                    }
                }
            }
            System.out.println("El juego ha iniciado, ha alcanzado el maximo de jugadores");
//              while (enServicio) {
//            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void notificarClientes(Partida partida, int indice) {
        //si indice es un valor diferente de-1 que sea positivo es que el juego esta procesando a los jugadores faltantes 
        //Y por ende se noticia a todos de cada excepto al jugador que ente para actualizacion de sus datos de  partida
        if (indice > -1 && indice < 5) {
            for (int i = 0; i < jugadores.size(); i++) {
                JugadorLocal jugador = jugadores.get(i);
                try {
                    this.output = new ObjectOutputStream(jugador.getSocket().getOutputStream());
                    this.output.writeObject(partida);
                    this.output.close();
                } catch (IOException ex) {
                    System.err.println("Error; " + ex.getMessage());
                }
            }
        } //-1 indica que el juego esta en marcha y se tiene que notificar de los datos actualizados
        else if (indice == -1) {
            for (int i = 0; i < jugadores.size(); i++) {
                JugadorLocal jugador = jugadores.get(i);
                try {
                    this.output = new ObjectOutputStream(jugador.getSocket().getOutputStream());
                    this.output.writeObject(partida);
                    this.output.close();
                } catch (IOException ex) {
                    System.err.println("Error; " + ex.getMessage());
                }
            }
        } //Si indice es igual a 100 indica que la partida ha finalizado cierra la lista de sockets , termina
        //el flujo del run estableciendo su variable a false, y se envian los datos de la partida, a los sockets restantes
        else if (indice == 100) {
        }

    }

}
