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

    public void actualizarPartida(Partida partida) {
        this.partidaLocal = partida;
        this.setChanged();
        //Se envia un objeto para determinar si la partida esta en juego
        //Condicion que determina si se envia el objeto o numero
        if (partida.isActiva()) {
            this.notifyObservers(-1);
        } else {
            this.notifyObservers(100);
        }
    }

    public void agregarJugador(Jugador jugador) {
        this.partidaLocal.getJugadores().add(jugador);
        this.setChanged();
        //Condicion que determina si se se recore la lista de objetos con exceppcion del jugador
        this.notifyObservers(this.partidaLocal.getJugadores().indexOf(jugador));
    }

}
