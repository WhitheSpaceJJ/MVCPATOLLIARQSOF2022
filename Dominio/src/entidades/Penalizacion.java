package entidades;

//Clase que representa la penalizacion.

import java.io.Serializable;

public class Penalizacion implements Serializable{

    //Cantidad a restar
    private double cantidad;
    //Jugador a penalizar
    private Jugador jugador;
    //Tipo de penalizacion
    private TipoPenalizacion tipo;
//Constructores 
    public Penalizacion() {
    }
    public Penalizacion(double cantidad, Jugador jugador, TipoPenalizacion tipo) {
        this.cantidad = cantidad;
        this.jugador = jugador;
        this.tipo = tipo;
    }
//Metodos get y set

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public TipoPenalizacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoPenalizacion tipo) {
        this.tipo = tipo;
    }
//Metodos to String

    @Override
    public String toString() {
        return "Penalizacion{" + "cantidad=" + cantidad + ", jugador=" + jugador + ", tipo=" + tipo + '}';
    }

}
