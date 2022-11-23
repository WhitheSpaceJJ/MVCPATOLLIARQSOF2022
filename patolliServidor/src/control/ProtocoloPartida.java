package control;

import dominio.Jugador;
import dominio.Partida;
import modelo.ModeloServidor;

public class ControlServidor {
    
    private ModeloServidor partidaLocal;
    private int totalJugadores;
    
    public ControlServidor(ModeloServidor partidaLocal) {
        this.partidaLocal = partidaLocal;
    }
    
    public int getTotalJugadores() {
        return totalJugadores;
    }
    
    public void setTotalJugadores(int totalJugadores) {
        this.totalJugadores = totalJugadores;
    }
    
    public void crearPartidaLocal(Partida partida) {
        this.partidaLocal.crearPartidaLocal(partida);
    }

    public void agregarJugadorPartida(Jugador jugador) {
        this.partidaLocal.agregarJugador(jugador);
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
    
}
