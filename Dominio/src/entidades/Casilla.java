package entidades;

import java.io.Serializable;
import java.util.Objects;

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

    public Casilla(Ficha ficha) {
        this.ficha = ficha;
    }

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.ficha);
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
        final Casilla other = (Casilla) obj;
        return Objects.equals(this.ficha, other.ficha);
    }
    
   // Metodo to string
    @Override
    public String toString() {
        return "Casilla{" + "tipo=" + tipo + ", ficha=" + ficha + '}';
    }

}
