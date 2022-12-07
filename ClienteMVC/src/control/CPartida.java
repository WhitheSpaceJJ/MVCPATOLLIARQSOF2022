package control;

import clientePatolli.Cliente;
import entidades.Dado;
import entidades.Partida;
import java.util.ArrayList;
import java.util.List;
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
        if (!partida.getTurno().getNombre().isEmpty()) {
        
            if (this.cliente.establecerCreacionPartida(partida)) {
                partida.setActiva(true);
                ((MPartida) this.modelo).crearPartida(partida);
                Thread thradCliente = new Thread(this.cliente);
                thradCliente.start();
            }
            else {
                ((MPartida) this.modelo).crearPartida(partida);
            }
        }
    }

    public void inicarPartida() {
        if (this.cliente.iniciarPartida()) {
        }
    }
}
