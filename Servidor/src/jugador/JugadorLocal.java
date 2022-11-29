package jugador;

import entidades.Jugador;
import java.net.Socket;
import java.util.Objects;

//Clase que representa un jugador local, los datos de su respectivo socket, y datos escogidos para jugar nombre y color
public class JugadorLocal {

    private Jugador jugador;
    private Socket socket;

    public JugadorLocal(Socket socket) {
        this.socket = socket;
    }

    public JugadorLocal(Jugador jugador, Socket socket) {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.jugador);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JugadorLocal other = (JugadorLocal) obj;
        return Objects.equals(this.jugador, other.jugador);
    }

}
