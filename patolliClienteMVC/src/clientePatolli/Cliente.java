package clientePatolli;

import dominio.Jugador;
import dominio.Partida;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Observable;

public class Cliente extends Observable implements Runnable {

    private String host;
    private Socket socket;
    private int puerto;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private Jugador jugador;
    private boolean conexionEstablecida;

    public Cliente() {
        this.conexionEstablecida = true;
        try {
            InetAddress ip = InetAddress.getLocalHost();
            String hostLocal = ip.getHostAddress();
            this.host = hostLocal;
        } catch (UnknownHostException e) {
        }
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
        System.out.println("Cliente esperando");
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
        System.out.println("Se finalizo la conexion");

    }

    public void procesarPartida(Partida partida) {
        if (partida.isActiva()) {
            System.out.println("Se ha actualizado la partida");
            this.setChanged();
            this.notifyObservers(partida);
        } else {
            this.conexionEstablecida = false;
        }
    }

    public boolean establecerCreacionPartida(Partida partida) {
        try {
            this.socket = new Socket("10.178.3.13", 80);
            System.out.println("Se ha establecido la conexion correctamente");
        } catch (IOException e) {
            System.out.println("El servidor no se ha levantado correctamente.");
            return false;
        }
        try {
            this.output = new ObjectOutputStream(socket.getOutputStream());
            this.output.writeObject(partida);
            System.out.println("Se ha creado la partida satisfactoriamente");
            this.conexionEstablecida = true;
            this.jugador = partida.getTurno();
            return true;
        } catch (IOException e) {
            System.out.println("No se ha enviado el jugador.");
            return false;
        }
    }

    public boolean lanzarDados() {
        return false;
    }

    public Partida unirsePartida(Jugador jugador) {
        try {
            this.socket = new Socket("10.178.3.13", 80);
            System.out.println("Se ha establecido la conexion correctamente");
        } catch (IOException e) {
            System.out.println("El servidor no se ha levantado correctamente.");
            return null;
        }
        try {
            this.output = new ObjectOutputStream(socket.getOutputStream());
            this.output.writeObject(jugador);
            System.out.println("Se ha enviado el jugador para validacion.");
        } catch (IOException e) {
            System.out.println("No se ha enviado el jugador.");
            return null;
        }
        try {
            this.input = new ObjectInputStream(socket.getInputStream());
            Partida partida = (Partida) input.readObject();
            if (partida != null) {
                this.jugador = (partida.getJugadores().get(partida.getJugadores().size() - 1));
                this.conexionEstablecida = true;
                return partida;
            } else {
                System.out.println("Ya existe un jugador con el mismo nombre y color");
                System.out.println("O el servidor se ha levantado pero no se ha establecido la creacion de una partida.");
                return null;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("El servidor se ha levantado pero no se ha establecido la creacion de una partida.");
            return null;
        }
    }

}
