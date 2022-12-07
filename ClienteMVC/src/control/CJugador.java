package control;

import clientePatolli.Cliente;
import entidades.Dado;
import entidades.Jugador;
import entidades.Partida;
import java.util.ArrayList;
import java.util.List;
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

    /*
    Metodo que solicita o hace uso
     */
    public void unirsePartida(Jugador jugador) {
        if (!jugador.getNombre().isEmpty()) {
            Partida partida = (this.cliente.unirsePartida(jugador));
            if (partida != null) {
                jugador = partida.getJugadores().get(partida.getJugadores().size() - 1);
//                jugador.inicializarFichas(partida.getCantidadFichas());
                ((MJugador) this.modelo).unirsePartida(jugador, partida);
                Thread thradCliente = new Thread(this.cliente);
                thradCliente.start();
            } else {
                ((MJugador) this.modelo).unirsePartida(jugador, partida);
            }
        }
    }

    public void lanzarDados() {
        List<Dado> lista = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Dado dado = new Dado(false);
            dado.cambiarCara();
            lista.add(dado);
        }
        this.cliente.lanzarDados(lista);
    }
}
