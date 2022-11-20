package clientePatolli;

import java.io.ObjectInputStream;
import java.net.Socket;

public class Cliente implements Runnable {

    private String host;
    private Socket socket;
    private int puerto;
    private ObjectInputStream input;

    public Cliente(String host, Socket socket, int puerto, ObjectInputStream input) {
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

    @Override
    public void run() {
    }

    public void enviarDatos() {
    }
}
