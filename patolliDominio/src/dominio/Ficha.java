package dominio;

import java.io.Serializable;

/**
 * Clase que representa la ficha del jugador.
 *
 * @author Equipo 1
 */
public class Ficha implements Serializable{

    /**
     * Numero
     */
    private int numeroPosicion;
    /**
     * Jugador que pertenece la ficha
     */
    private Jugador jugador;
    private boolean enJuego;
    private boolean eliminada;

//Constructores
    public Ficha() {
        this.enJuego = true;
    }

    public Ficha(int numeroPosicion, Jugador jugador, boolean enJuego, boolean eliminada) {
        this.numeroPosicion = numeroPosicion;
        this.jugador = jugador;
        this.enJuego = enJuego;
        this.eliminada = eliminada;
    }

    public Ficha(int numeroPosicion, Jugador jugador) {
        this.numeroPosicion = numeroPosicion;
        this.jugador = jugador;
        this.enJuego = true;
    }
//Metodos get y set

    public int getNumeroPosicion() {
        return numeroPosicion;
    }

    public void setNumeroPosicion(int numeroPosicion) {
        this.numeroPosicion = numeroPosicion;
    }

    public boolean isEliminada() {
        return eliminada;
    }

    public void setEliminada(boolean eliminada) {
        this.eliminada = eliminada;
    }

    public int getNumero() {
        return numeroPosicion;
    }

    public void setNumero(int numeroPosicion) {
        this.numeroPosicion = numeroPosicion;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public boolean isEnJuego() {
        return enJuego;
    }

    public void setEnJuego(boolean enJuego) {
        this.enJuego = enJuego;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
//Metodo to String

    @Override
    public String toString() {
        return "Ficha{" + "numero=" + numeroPosicion + ", jugador=" + jugador + ", enJuego=" + enJuego + '}';
    }

}
