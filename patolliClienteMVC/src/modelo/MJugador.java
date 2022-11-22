package modelo;

import dominio.Jugador;

public class MJugador extends ModeloBase {

    private Jugador jugador;

    public void preUnion(Jugador jugador) {
        this.jugador = jugador;
        this.setChanged();
        this.actualizarModelo();
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

