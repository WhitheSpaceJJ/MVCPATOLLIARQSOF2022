package servidor;

import control.ControlServidor;
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
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jugador.JugadorPartida;
import modelo.ModeloServidor;

public class Servidor implements Observer, Runnable {

    private List<Socket> jugadoresSocket;
    private List<JugadorPartida> jugadores;
    private ControlServidor controlPartidaLocal;
    private int puerto;

//este auxiliar es para escuhar las peticiones de conexiones
    private boolean escuchando1 = true;

    //este auxiliar es para escuhar si el juego aun esta activo
    private boolean escuchando2 = true;

    //Se inicializaran cuando se ejecute Run
    private ServerSocket servidor;
    private ObjectOutputStream output;
    private ObjectInputStream input;

    public Servidor(ControlServidor controlPartidaLocal, int puerto) {
        this.controlPartidaLocal = controlPartidaLocal;
        this.puerto = puerto;
        this.jugadores = new ArrayList<>();
        this.jugadoresSocket = new ArrayList<>();
//        this.jugadores.add(new JugadorPartida(new Jugador("Jose", "Mario"), null));
    }

    @Override
    public void update(Observable o, Object o1) {
    }

    @Override
    public void run() {

        Socket sc = null;

        try {
            //Creamos el socket del servidor
            this.servidor = new ServerSocket(puerto);
            System.out.println("Servidor iniciado");

            //Siempre estara escuchando peticiones
            while (escuchando1) {

                //Espero a que un cliente se conecte
                sc = servidor.accept();
                try {
                    this.input = new ObjectInputStream(sc.getInputStream());
                    Object aux = input.readObject();
                    if (aux instanceof Jugador) {
                        Jugador jugador = (Jugador) aux;
                        boolean axuliarConexion = true;
                        for (int i = 0; i < jugadores.size(); i++) {
                            JugadorPartida jugadorRevision = jugadores.get(i);
                            if (jugadorRevision.getJugador().getNombre().equalsIgnoreCase(jugador.getNombre())
                                    && jugadorRevision.getJugador().getColor().equalsIgnoreCase(jugador.getColor())) {
                                this.output = new ObjectOutputStream(sc.getOutputStream());
                                output.writeObject(aux);
                                axuliarConexion = false;
                            }
                        }
                        if (axuliarConexion) {
                            jugadores.add(new JugadorPartida(jugador, sc));
                            System.out.println("Jugador conectado; Nombre=" + jugador.getNombre() + " Color=" + jugador.getColor());
                        } else {
                            sc.close();
                        }
                    }
                } catch (IOException | ClassNotFoundException e) {
                    System.err.println("Error al leer lo enviado por el cliente.");
                }
//                jugadoresSocket.add(sc);
            }

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void notificarClientes(Partida partida) {
        for (int i = 0; i < jugadores.size(); i++) {
            JugadorPartida jugador = jugadores.get(i);
            try {
                this.output = new ObjectOutputStream(jugador.getSocket().getOutputStream());
                this.output.writeObject(partida);
                this.output.close();
            } catch (IOException ex) {
                System.err.println("Error; " + ex.getMessage());
//                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void escuchar() {
        boolean escuchando = true;
        while (escuchando) {
            try {
//                Object aux = input.readObject();
//                if (aux instanceof LinkedList) {
////                    ejecutar((LinkedList<String>) aux);
//                }
            } catch (Exception e) {
                System.err.println("Error; " + e.getMessage());
            }
        }
    }

    public void finalizarPartida() {
        //Envia datos finales al cliente de quien gano,total de dinero, etc. Y termina el servidor.
    }

}
