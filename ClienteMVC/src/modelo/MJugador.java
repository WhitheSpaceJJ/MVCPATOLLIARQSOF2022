package modelo;

import entidades.Jugador;
import entidades.Partida;

public class MJugador extends ModeloBase {
    
    private Jugador jugador;
    
    public void unirsePartida(Jugador jugador, Partida partida) {
        this.jugador = jugador;
        this.setChanged();
        this.notifyObservers(partida);
    }
    
    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    
}
