package modelo;

import dominio.Jugador;
import dominio.Partida;
import dominio.Tablero;

public class MPartida extends ModeloBase {

    private Partida partida;
    public void preCreacion(Partida partida) {
        this.partida=partida;
        this.actualizarModelo();
    }
    public void actualizarPartida(Partida partida){
        this.partida=partida;
        this.actualizarModelo();
    }
//    public void crearPartida(Partida partida) {
//        this.actualizarModelo();
//    }
//
//    public void actualizarTablero(Tablero tablero) {
//        this.actualizarModelo();
//    }
//
//    public void establecerTurno(Jugador jugador) {
//        this.actualizarModelo();
//    }
//
//    public void agregarJugador(Jugador jugador) {
//        this.actualizarModelo();
//    }

    public Partida getPartida() {
        return partida;
    }

}
