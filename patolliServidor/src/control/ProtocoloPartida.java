package control;

import dominio.Dado;
import dominio.Jugador;
import dominio.Partida;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import jugador.JugadorLocal;
import modelo.PartidaServidor;

public class ProtocoloPartida {

    private PartidaServidor partidaLocal;
    private int totalJugadores;

    public ProtocoloPartida() {
    }

    public ProtocoloPartida(PartidaServidor partidaLocal) {
        this.partidaLocal = partidaLocal;
    }

    public List<JugadorLocal> procesandoCreacion(Socket sc) {
        List<JugadorLocal> jugadores = null;
        try {
            ObjectInputStream input = new ObjectInputStream(sc.getInputStream());
            Object aux = input.readObject();
            if (aux instanceof Partida) {
                this.partidaLocal.establecerPartida((Partida) aux);
                Jugador jugador = ((Partida) aux).getTurno();
                jugadores = new ArrayList<>();
                System.out.println("La partida ha sido creada");
                System.out.println("Jugador creador; Nombre=" + jugador.getNombre() + " Color=" + jugador.getColor());
                jugadores.add(new JugadorLocal(jugador, sc));
            } else {
                ObjectOutputStream output = new ObjectOutputStream(sc.getOutputStream());
                output.writeObject(null);
                System.out.println("La partida debe de ser creada antes de unirse");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error; " + e.getMessage());
        }
        return jugadores;
    }

    public List<JugadorLocal> procesandoEspera(Socket sc, List<JugadorLocal> jugadores) {
        List<JugadorLocal> jugadoresNuevos = null;
        try {
            ObjectInputStream input = new ObjectInputStream(sc.getInputStream());
            Object object = input.readObject();
            if (object instanceof Jugador) {
                Jugador jugador = (Jugador) object;
                JugadorLocal jugadorLocal = new JugadorLocal(jugador, sc);
                int jugadorEsta = jugadores.indexOf(jugadorLocal);
                                    ObjectOutputStream output = new ObjectOutputStream(sc.getOutputStream());
                if (jugadorEsta == -1) {
                    jugadores.add(jugadorLocal);
                    jugadoresNuevos = jugadores;
                    output.writeObject(jugador);
                    System.out.println("Jugador conectado; Nombre=" + jugador.getNombre() + " Color=" + jugador.getColor());
                    this.partidaLocal.agregarJugador(jugador);
                } else {
                    output.writeObject(null);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error; " + e.getMessage());
        }
        return jugadoresNuevos;
    }

    public boolean procesandoJugador(Object object) {
        if (object instanceof Jugador) {
            Jugador jugador = (Jugador) object;
//            int totalJugadoresMaximo = this.partidaLocal.getPartidaLocal().getTotalJugadores();
//            int totalJugadoresActuales = this.partidaLocal.getPartidaLocal().getJugadores().size();
//            if (totalJugadoresActuales <= totalJugadoresMaximo) {
            int jugadorEsta = this.partidaLocal.getPartidaLocal().getJugadores().indexOf(jugador);
            if (jugadorEsta == -1) {
                System.out.println("Jugador conectado; Nombre=" + jugador.getNombre() + " Color=" + jugador.getColor());
                this.partidaLocal.agregarJugador(jugador);
                return true;
            } else {
                return false;
            }
//            }
        }
        return false;
    }

    public void procesarDados(Object object) {
        if (object instanceof List) {
            this.lanzarDados((List<Dado>) object);
        }
    }

    public void lanzarDados(List<Dado> lista) {
    }

    public boolean procesarEntrada(Object object) {
        if (this.partidaLocal.getPartidaLocal() == null) {
            if (object instanceof Partida) {
                this.partidaLocal.establecerPartida((Partida) object);
                return true;
            }
            return false;
        } else {
            if (this.partidaLocal.getPartidaLocal().getTotalJugadores() == this.partidaLocal.getPartidaLocal().getJugadores().size()) {
                if (object instanceof List) {
                    this.lanzarDados((List<Dado>) object);
                }
            } else {
                if (object instanceof Jugador) {
                    Jugador jugador = (Jugador) object;
//            int totalJugadoresMaximo = this.partidaLocal.getPartidaLocal().getTotalJugadores();
//            int totalJugadoresActuales = this.partidaLocal.getPartidaLocal().getJugadores().size();
//            if (totalJugadoresActuales <= totalJugadoresMaximo) {
                    int jugadorEsta = this.partidaLocal.getPartidaLocal().getJugadores().indexOf(jugador);
                    if (jugadorEsta == -1) {
                        System.out.println("Jugador conectado; Nombre=" + jugador.getNombre() + " Color=" + jugador.getColor());
                        this.partidaLocal.agregarJugador(jugador);
                        return true;
                    } else {
                        return false;
                    }
//            }
                }
            }
            return false;
        }
    }

    public int getTotalJugadores() {
        return totalJugadores;
    }

    public void setTotalJugadores(int totalJugadores) {
        this.totalJugadores = totalJugadores;
    }

    public boolean establecerPartidaLocal(Partida partida, JugadorLocal jugador) {
        return true;
    }
//    public void crearPartidaLocal(Partida partida) {
//        this.partidaLocal.crearPartidaLocal(partida);
//    }
//
//    public void agregarJugadorPartida(Jugador jugador) {
//        this.partidaLocal.agregarJugador(jugador);
//    }

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
