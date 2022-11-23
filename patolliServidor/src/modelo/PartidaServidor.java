package modelo;

import dominio.Jugador;
import dominio.Partida;
import dominio.Tablero;
import java.util.List;
import java.util.Observable;
import jugador.JugadorLocal;

public class PartidaServidor extends Observable {

    private Partida partidaLocal;

    public PartidaServidor() {
    }

    public Partida getPartidaLocal() {
        return partidaLocal;
    }

    public void establecerPartida(Partida partida) {
        this.partidaLocal = partida;
        this.setChanged();
        this.notifyObservers();
    }

    public void agregarJugador(Jugador jugador) {
        this.partidaLocal.getJugadores().add(jugador);
        this.setChanged();
        this.notifyObservers();
    }

}
