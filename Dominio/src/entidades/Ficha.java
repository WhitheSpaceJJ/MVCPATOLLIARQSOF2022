package entidades;

import java.io.Serializable;
import java.util.Objects;

/**
 * Clase que representa la ficha del jugador.
 *
 * @author Equipo 1
 */
public class Ficha implements Serializable {

    /**
     * Numero
     */
    private int numeroPosicion;
    /**
     * Jugador que pertenece la ficha
     */
    private Jugador jugador;
    private boolean enJuego;
    private boolean terminoVuelta;
    private boolean eliminada;

//Constructores
    public Ficha() {
        this.enJuego = false;
    }

    public Ficha(int numeroPosicion, Jugador jugador, boolean enJuego) {
        this.numeroPosicion = numeroPosicion;
        this.jugador = jugador;
        this.enJuego = enJuego;
        this.terminoVuelta=false;
        this.eliminada=false;
    }

    public Ficha(int numeroPosicion, Jugador jugador) {
        this.numeroPosicion = numeroPosicion;
        this.jugador = jugador;
        this.enJuego = false;
         this.terminoVuelta=false;
        this.eliminada=false;
    }
//Metodos get y set

    public int getNumeroPosicion() {
        return numeroPosicion;
    }

    public void setNumeroPosicion(int numeroPosicion) {
        this.numeroPosicion = numeroPosicion;
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

    public boolean isTerminoVuelta() {
        return terminoVuelta;
    }

    public void setTerminoVuelta(boolean terminoVuelta) {
        this.terminoVuelta = terminoVuelta;
    }

    public boolean isEliminada() {
        return eliminada;
    }

    public void setEliminada(boolean eliminada) {
        this.eliminada = eliminada;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.jugador);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ficha other = (Ficha) obj;
        return Objects.equals(this.jugador, other.jugador);
    }
    
//Metodo to String

    @Override
    public String toString() {
        return "Ficha{" + "numero=" + numeroPosicion + ", jugador=" + jugador + ", enJuego=" + enJuego + '}';
    }

}
