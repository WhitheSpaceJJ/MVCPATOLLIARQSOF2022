package servidor;

import control.ControlServidor;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import jugador.JugadorPartida;

public class Servidor implements Observer, Runnable {

    private List<JugadorPartida> datos;
    private ControlServidor controlPartidaLocal;
    private ServerSocket servidor;
    private ObjectOutputStream output;

    @Override
    public void update(Observable o, Object o1) {
    }

    @Override
    public void run() {
    }

    public void notificarClientes() {
    }

    public void finalizarPartida() {
    }

    public List<JugadorPartida> getDatos() {
        return datos;
    }

    public void setDatos(List<JugadorPartida> datos) {
        this.datos = datos;
    }

    public ControlServidor getControlPartidaLocal() {
        return controlPartidaLocal;
    }

    public void setControlPartidaLocal(ControlServidor controlPartidaLocal) {
        this.controlPartidaLocal = controlPartidaLocal;
    }

    public ServerSocket getServidor() {
        return servidor;
    }

    public void setServidor(ServerSocket servidor) {
        this.servidor = servidor;
    }

    public ObjectOutputStream getOutput() {
        return output;
    }

    public void setOutput(ObjectOutputStream output) {
        this.output = output;
    }

}
