package modelo;

import entidades.Jugador;
import entidades.Partida;
import entidades.Tablero;
import java.util.Observable;
import java.util.Observer;

public class MPartida extends ModeloBase implements Observer {
    
    private Partida partida;

    public MPartida() {
    }

    public MPartida(Partida partida) {
        this.partida = partida;
    }

    public void crearPartida(Partida partida) {
        this.partida = partida;
        this.actualizarModelo();
    }

    public void actualizarPartida(Partida partida) {
        this.partida = partida;
        this.actualizarModelo();
    }

    public Partida getPartida() {
        return partida;
    }
    
    @Override
    public void update(Observable o, Object o1) {
        this.actualizarPartida((Partida) o1);
    }
    
}
