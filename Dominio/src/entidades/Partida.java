package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Partida implements Serializable {

    private Jugador turno;
    private List<Jugador> jugadores;
    private Tablero tablero;
    private double montoJugador;
    private double montoApuesta;
    private List<Dado> dados;
    private int totalJugadores;
    private boolean activa;
    private int cantidadFichas;

    public Partida(Jugador turno, Tablero tablero, double montoJugador, double montoApuesta, int totalJugadores) {
        this.turno = turno;
        this.tablero = tablero;
        this.montoJugador = montoJugador;
        this.montoApuesta = montoApuesta;
        this.totalJugadores = totalJugadores;
        this.dados = new ArrayList<>();
        this.jugadores = new ArrayList<>();
        this.jugadores.add(turno);
        this.activa = true;
    }

    public int getCantidadFichas() {
        return cantidadFichas;
    }

    public void setCantidadFichas(int cantidadFichas) {
        this.cantidadFichas = cantidadFichas;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public int getTotalJugadores() {
        return totalJugadores;
    }

    public void setTotalJugadores(int totalJugadores) {
        this.totalJugadores = totalJugadores;
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
