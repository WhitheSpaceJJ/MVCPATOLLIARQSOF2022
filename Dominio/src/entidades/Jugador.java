package entidades;

import java.io.Serializable;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clase que representa un jugador.
 *
 * @author Equipo1 1
 */
public class Jugador implements Serializable {
//Nombre color
    private String nombre;
    private String color;
    //Dinero
    private Dinero dinero;
    /**
     * Lista de fichas.
     */
    private List<Ficha> fichas;
    private int totalLanzamientos;
//Constructores
   private boolean activo;
    public Jugador(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
        this.fichas = new ArrayList<>();
        this.totalLanzamientos=0;
    }

    public int getTotalLanzamientos() {
        return totalLanzamientos;
    }

    public void setTotalLanzamientos(int totalLanzamientos) {
        this.totalLanzamientos = totalLanzamientos;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.nombre);
        hash = 53 * hash + Objects.hashCode(this.color);
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
        final Jugador other = (Jugador) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.color, other.color);
    }

//Metodo to string
    @Override
    public String toString() {
        return "usuario{" + " nombre= " + nombre + ", color= " + color + '}';
    }
//Metodo que agrega las fichas al jugador

    public void inicializarFichas(int cantidad) {
        this.fichas = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            this.fichas.add(new Ficha(i, this));
        }
    }
}
