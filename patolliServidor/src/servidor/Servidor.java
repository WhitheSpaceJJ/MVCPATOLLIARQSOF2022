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
//este auxiliar es para escuhar las peticiones de conexiones
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
            notificarClientes(((PartidaServidor) o).getPartidaLocal());
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
            while (jugadores.size() <= maximoPermitido) {
                sc = servidor.accept();
                List<JugadorLocal> jugadoresEspera = this.protocoloPartidaLocal.procesandoEspera(sc, jugadores);
                if (jugadoresEspera.size() != this.jugadores.size()) {
                    this.jugadores = jugadoresEspera;
                } else {
                    System.out.println("Ya existe un jugador con los mismos datos");
                    sc.close();
                }
            }
            System.out.println("El juego ha iniciado, ha alcanzado el maximo de jugadores");
//              while (enServicio) {
//            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void notificarClientes(Partida partida) {
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
    }

}
