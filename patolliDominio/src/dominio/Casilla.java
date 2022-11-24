package dominio;

import java.io.Serializable;

/**
 * Clase que representa una casilla,del tablero.
 *
 * @author Equipo1
 */

public class Casilla implements Serializable{

    /**
     * Tipo de casilla
     */
    private TipoCasilla tipo;
    /**
     * La ficha que tendra la casilla.
     */
    private Ficha ficha;

    /**
     * Constructor que inicializa la casilla deacuerdo a su tipo.
     *
     * @param tipo
     */
    public Casilla(TipoCasilla tipo) {
        this.tipo = tipo;
    }
    //Metodos y set de casilla.
    public TipoCasilla getTipo() {
        return tipo;
    }

    public void setTipo(TipoCasilla tipo) {
        this.tipo = tipo;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }
   // Metodo to string
    @Override
    public String toString() {
        return "Casilla{" + "tipo=" + tipo + ", ficha=" + ficha + '}';
    }

}
