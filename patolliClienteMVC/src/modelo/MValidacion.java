package modelo;

import dominio.Jugador;

public class MValidacion extends ModeloBase {

    private String confirmacion;
    private Jugador jugador;

    public void establecerSalida() {
        this.actualizarModelo();
    }

    public String getConfirmacion() {
        return confirmacion;
    }

    public void setConfirmacion(String confirmacion) {
        this.confirmacion = confirmacion;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    
}
