package clientePatolli;

import dominio.Jugador;
import dominio.Partida;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import jugador.JugadorPartida;

public class Cliente extends Thread {

    private String host;
    private Socket socket;
    private int puerto;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private Jugador jugador;
    private boolean conexionEstablecida;

    public Cliente() throws UnknownHostException {
        this.conexionEstablecida = true;
        InetAddress ip = InetAddress.getLocalHost();
        String hostLocal = ip.getHostAddress();
        this.host = hostLocal;
        this.puerto = 80;
    }

    public Cliente(String host, int puerto) {
        this.conexionEstablecida = true;
        this.host = host;
        this.puerto = puerto;
    }

    public Cliente(String host, Socket socket, int puerto, ObjectInputStream input) {
        this.conexionEstablecida = true;
        this.host = host;
        this.socket = socket;
        this.puerto = puerto;
        this.input = input;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public ObjectInputStream getInput() {
        return input;
    }

    public void setInput(ObjectInputStream input) {
        this.input = input;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public void run() {
//        if (unirsePartida(jugador)) {
//            while (conexionEstablecida) {
//                escuchando();
//            }
//        }
        while (conexionEstablecida) {
            try {
                this.input = new ObjectInputStream(socket.getInputStream());
                Object aux = input.readObject();
                if (aux instanceof Partida) {
                    this.procesarPartida((Partida) aux);
                }
            } catch (IOException | ClassNotFoundException e) {
            }
        }

    }

    public void procesarPartida(Partida partida) {
        if (partida.isActiva()) {
            //Actualizar respectivos datos
            
        } else {
            this.conexionEstablecida = false;
        }
    }

    public boolean unirsePartida(Jugador jugador) {
        //Estas verificaciones se realizaran  antes de realizar la conexion
        try {
            this.socket = new Socket(host, puerto);
            System.out.println("Se ha establecido la conexion correctamente");
        } catch (IOException e) {
            System.out.println("El servidor no se ha levantado correctamente.");
            return false;
        }
        try {
            this.output = new ObjectOutputStream(socket.getOutputStream());
            this.output.writeObject(jugador);
            System.out.println("Se ha enviado el jugador para validacion.");
        } catch (IOException e) {
            System.out.println("No se ha enviado el jugador.");
            return false;
        }
        //Con el fin de verificar la conexion si esta el mismo jugador
        try {
            this.input = new ObjectInputStream(socket.getInputStream());
            Jugador jugadorPrueba = (Jugador) input.readObject();
            if (jugadorPrueba != null) {
                            System.out.println("Ya existe un jugador con el mismo nombre y color.");
                return false;
            } else {
                this.jugador = jugador;
                this.conexionEstablecida=true;
                return true;
            }
        } catch (IOException | ClassNotFoundException e) {
            return false;
        }

    }

    public boolean establecerCreacionPartida(Partida partida) {

        try {
            this.socket = new Socket(host, puerto);
            System.out.println("Se ha establecido la conexion correctamente");
            this.output = new ObjectOutputStream(socket.getOutputStream());
            this.output.writeObject(partida);
            System.out.println("Se ha creado la partida satisfactoriamente");
                            this.conexionEstablecida=true;
            return true;
        } catch (IOException e) {
            System.out.println("No se ha enviado el jugador.");
            return false;
        }
//    
    }

    public void enviarDatos() {
    }

    public void escuchando() {
    }
}
