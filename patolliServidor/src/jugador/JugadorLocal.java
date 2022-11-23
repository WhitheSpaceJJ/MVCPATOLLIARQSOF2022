
package jugador;

import dominio.Jugador;
import java.net.Socket;


public class JugadorPartida {
    private Jugador jugador; 
    private Socket socket;

    public JugadorPartida(Jugador jugador, Socket socket) {
        this.jugador = jugador;
        this.socket = socket;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    
}
