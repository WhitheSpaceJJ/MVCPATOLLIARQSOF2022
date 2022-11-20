
package dominio;
/**
 * Clase que representa la ficha del jugador.
 * @author Equipo 1 
 */
public class Ficha {
    /**
     * Numero
     */
   private int numero;
   /**
    * Jugador que pertenece la ficha
    */
   private Jugador jugador;
//Constructores
    public Ficha() {
    }

    public Ficha(int numero, Jugador jugador) {
        this.numero = numero;
        this.jugador = jugador;
    }
//Metodos get y set
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
//Metodo to String
    @Override
    public String toString() {
        return "Ficha{" + "numero=" + numero + ", jugador=" + jugador + '}';
    }
   
    
    
}
