
package dominio;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa el tablero de la partida.
 *
 * @author Equipo 1
 */
public class Tablero {
//Numero de tablero.

    private String numeroTablero;
    //Casillas del tablero
    private List<Casilla> casillas ;
    private int tamano;
    
    //Jugadores del tablero.
//Constructores 

    public Tablero() {
    }

    public Tablero(String numeroTablero, int tamano) {
        this.numeroTablero = numeroTablero;
        this.tamano = tamano;
        this.casillas= new ArrayList();
        //Inicializar casillas orden
        if(tamano==10){
        }else if(tamano==12){
        }else if(tamano==14){
        }
    }

//Metodos get y set

    public String getNumeroTablero() {
        return numeroTablero;
    }

    public void setNumeroTablero(String numeroTablero) {
        this.numeroTablero = numeroTablero;
    }

    public List<Casilla> getCasillas() {
        return casillas;
    }

    public void setCasillas(ArrayList<Casilla> casillas) {
        this.casillas = casillas;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

 
//Metodo to string.    

    @Override
    public String toString() {
        return "Tablero{" + "numeroTablero=" + numeroTablero + ", casillas=" + casillas +'}';
    }

}
