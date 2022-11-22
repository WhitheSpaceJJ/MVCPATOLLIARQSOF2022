package modelo;

import dominio.Jugador;
import dominio.Partida;
import dominio.Tablero;
import java.util.Observable;

public class ModeloServidor extends Observable {

    //addObserver y notifyObervers
    private Partida partidaLocal;

    public Partida getPartidaLocal() {
        return partidaLocal;
    }

    public void setPartidaLocal(Partida partidaLocal) {
        this.partidaLocal = partidaLocal;
    }

    public void crearPartidaLocal(Partida partidaLocal) {
        this.partidaLocal = partidaLocal;
        this.establecerCambiosNotificar();
    }

    public void actualizarTablero(Tablero tablero) {
        this.partidaLocal.setTablero(tablero);
        this.establecerCambiosNotificar();
    }

    public void establecerTurno(Jugador jugador) {
        this.partidaLocal.setTurno(jugador);
        this.establecerCambiosNotificar();
    }

    public void agregarJugador(Jugador jugador) {
        this.partidaLocal.getJugadores().add(jugador);
        this.establecerCambiosNotificar();
    }

    public void establecerCambiosNotificar() {
        this.setChanged();
        this.notifyObservers();
    }

}
