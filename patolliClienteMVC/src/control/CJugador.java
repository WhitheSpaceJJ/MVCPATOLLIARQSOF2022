package control;

import clientePatolli.Cliente;
import dominio.Jugador;
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

    public void unirsePartida() {
    }

    public void preUnion(Jugador jugador) {
        ((MJugador) this.modelo).preUnion(jugador);
    }

//    public void lanzarDados() {
//    }

}
