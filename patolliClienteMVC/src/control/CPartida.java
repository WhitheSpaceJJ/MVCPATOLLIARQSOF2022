package control;

import clientePatolli.Cliente;
import dominio.Partida;
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

    public void preCreacion(Partida partida) {
        ((MPartida)this.modelo).preCreacion(partida);
    }
//
//    public void crearPartida(Partida partida) {
//    }
//
//    public void finalizarPartida() {
//    }
//
//    public boolean realizarPago() {
//        return true;
//    }
//
//    public boolean introducirFicha() {
//        return true;
//    }
//
//    public boolean verificarLanzamiento() {
//        return true;
//    }
//
//    public boolean pasarTurno() {
//        return true;
//    }
//
//    public boolean establecerSalidaFicha() {
//        return true;
//    }
//
//    public boolean removerFichaCasilla() {
//        return true;
//    }
}
