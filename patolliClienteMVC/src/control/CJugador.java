package control;

import clientePatolli.Cliente;
import dominio.Jugador;
import dominio.Partida;
import modelo.MJugador;
import modelo.ModeloBase;

public class CJugador extends ControlBase {

    public CJugador() {
    }

    public CJugador(ModeloBase modelo, Cliente cliente) {
        super(modelo, cliente);
    }

    public CJugador(ModeloBase modelo) {
        super(modelo);
    }
//Va a llamar al metodo unirse de cliente para establecer la conexion y se cambiara el respectivo modelo

    public void unirsePartida(Jugador jugador) {
        Partida partida = (this.cliente.unirsePartida(jugador));
        if (partida != null) {
            ((MJugador) this.modelo).unirsePartida(jugador,partida);
            Thread thradCliente = new Thread(this.cliente);
            thradCliente.start();
        }
    }

    public void lanzarDados() {
    }
}
