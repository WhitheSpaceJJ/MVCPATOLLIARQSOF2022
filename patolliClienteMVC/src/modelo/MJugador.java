package modelo;

import dominio.Jugador;
import dominio.Partida;

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
}
//    public void unirsePartida(Jugador jugador) {
//                this.actualizarModelo();
//    }
//
//    public void lanzarDados() {
//    }
//
//    public void actualizarJugador(Jugador jugador) {
//        this.jugador = jugador;
//        this.actualizarModelo();
//    }
//
//    public Jugador getJugador() {
//        return jugador;
//    }
//
//    public void setJugador(Jugador jugador) {
//        this.jugador = jugador;
//                this.actualizarModelo();
//    }

