package dominio;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un jugador.
 *
 * @author Equipo1 1
 */
public class Jugador {
//Nombre color

    private String nombre;
    private String color;
    //Dinero
    private Dinero dinero;
    /**
     * Lista de fichas.
     */
    private List<Ficha> fichas;
//Constructores

    public Jugador() {
    }

    public Jugador(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
    }

//Metodos get y set   
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Ficha> getFichas() {
        return fichas;
    }

    public Dinero getDinero() {
        return dinero;
    }

    public void setDinero(Dinero dinero) {
        this.dinero = dinero;
    }

    public void setFichas(ArrayList<Ficha> fichas) {
        this.fichas = fichas;
    }
//Metodo to string

    @Override
    public String toString() {
        return "usuario{" + " nombre= " + nombre + ", color= " + color + '}';
    }

}
