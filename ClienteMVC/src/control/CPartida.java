package control;

import clientePatolli.Cliente;
import entidades.Partida;
import modelo.MPartida;
import modelo.ModeloBase;

public class CPartida extends ControlBase {

    public CPartida() {
    }

    public CPartida(ModeloBase modelo, Cliente cliente) {
        super(modelo, cliente);
    }

    public CPartida(ModeloBase modelo) {
        super(modelo);
    }

    public void crearPartida(Partida partida) {
        if (this.cliente.establecerCreacionPartida(partida)) {
            ((MPartida) this.modelo).crearPartida(partida);
            Thread thradCliente = new Thread(this.cliente);
            thradCliente.start();
        }
    }

    public void inicarPartida() {
        if(this.cliente.iniciarPartida()){
        }
    }
}
