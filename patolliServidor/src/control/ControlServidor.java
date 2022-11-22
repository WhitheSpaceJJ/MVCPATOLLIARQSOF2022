package control;

import modelo.ModeloServidor;

public class ControlServidor {

    private ModeloServidor partidaLocal;

    public ControlServidor(ModeloServidor partidaLocal) {
        this.partidaLocal = partidaLocal;
    }

    public void finalizarPartida() {
    }

    public boolean realizarPago() {
        return true;
    }

    public boolean introducirFicha() {
        return true;
    }

    public boolean verificarLanzamiento() {
        return true;
    }

    public boolean pasarTurno() {
        return true;
    }

    public boolean establecerSalidaFicha() {
        return true;
    }

    public boolean removerFichaCasilla() {
        return true;
    }

    public ModeloServidor getPartidaLocal() {
        return partidaLocal;
    }

    public void setPartidaLocal(ModeloServidor partidaLocal) {
        this.partidaLocal = partidaLocal;
    }

}
