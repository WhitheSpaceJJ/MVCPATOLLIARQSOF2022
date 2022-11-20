package dominio;

/**
 * Clase que representa la ficha del jugador.
 *
 * @author Equipo 1
 */
public class Ficha {

    /**
     * Numero
     */
    private int numeroPosicion;
    /**
     * Jugador que pertenece la ficha
     */
    private Jugador jugador;
    private boolean enJuego;
//Constructores

    public Ficha() {
        this.enJuego = true;
    }

    public Ficha(int numeroPosicion, Jugador jugador) {
        this.numeroPosicion = numeroPosicion;
        this.jugador = jugador;
        this.enJuego = true;
    }
//Metodos get y set

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
