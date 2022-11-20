package dominio;

/**
 * Clase que representa una casilla,del tablero.
 *
 * @author Equipo1
 */

public class Casilla {

    /**
     * Tipo de casilla
     */
    private String tipo;
    /**
     * La ficha que tendra la casilla.
     */
    private Ficha ficha;

    /**
     * Constructor que inicializa la casilla deacuerdo a su tipo.
     *
     * @param tipo
     */
    public Casilla(String tipo) {
        this.tipo = tipo;
    }
    //Metodos y set de casilla.
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }
   /**
    * Metodo to string
    * @return  Retorna los datos de casilla.
    */
    @Override
    public String toString() {
        return "Casilla{" + "tipo=" + tipo + ", ficha=" + ficha + '}';
    }

}
