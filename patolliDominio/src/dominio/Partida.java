
package dominio;

import java.util.List;

public class Partida {
    private Jugador turno;
    private List<Jugador> jugadores;
    private Tablero tablero;
    private double montoJugador;
    private double montoApuesta;
    private List<Dado> dados;

    public Partida(Jugador turno, List<Jugador> jugadores, Tablero tablero, double montoJugador, double montoApuesta, List<Dado> dados) {
        this.turno = turno;
        this.jugadores = jugadores;
        this.tablero = tablero;
        this.montoJugador = montoJugador;
        this.montoApuesta = montoApuesta;
        this.dados = dados;
    }

    public Partida(Jugador turno, List<Jugador> jugadores, Tablero tablero, double montoJugador, double montoApuesta) {
        this.turno = turno;
        this.jugadores = jugadores;
        this.tablero = tablero;
        this.montoJugador = montoJugador;
        this.montoApuesta = montoApuesta;
    }

    public Jugador getTurno() {
        return turno;
    }

    public void setTurno(Jugador turno) {
        this.turno = turno;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public double getMontoJugador() {
        return montoJugador;
    }

    public void setMontoJugador(double montoJugador) {
        this.montoJugador = montoJugador;
    }

    public double getMontoApuesta() {
        return montoApuesta;
    }

    public void setMontoApuesta(double montoApuesta) {
        this.montoApuesta = montoApuesta;
    }

    public List<Dado> getDados() {
        return dados;
    }

    public void setDados(List<Dado> dados) {
        this.dados = dados;
    }

    @Override
    public String toString() {
        return "Partida{" + "turno=" + turno + ", jugadores=" + jugadores + ", tablero=" + tablero + ", montoJugador=" + montoJugador + ", montoApuesta=" + montoApuesta + ", dados=" + dados + '}';
    }
    
    
    
}
