package entidades;

import com.sun.org.apache.bcel.internal.generic.D2F;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PruebaJuego {

    private static Partida partida;

    public static void main(String[] args) {
        Jugador jugador1 = new Jugador("Jose1", "Amarillo");
        Jugador jugador2 = new Jugador("Jose2", "Rosa");
        Jugador jugador3 = new Jugador("Jose3", "Azul");
//        Jugador jugador4 = new Jugador("Jose4", "Rojo");
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.add(jugador3);
//        jugadores.add(jugador4);
        Tablero tablero = new Tablero("4122022", 10);

        partida = new Partida(jugador1, tablero, 2000, 100, 4, 6);
        for (int i = 0; i < jugadores.size(); i++) {
            jugadores.get(i).setActivo(true);
            jugadores.get(i).inicializarFichas(partida.getCantidadFichas());
        }
        partida.setActiva(true);
        partida.setJugadores(jugadores);
        List<Dado> dados = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Dado dado = new Dado(false);
            dados.add(dado);
        }
        partida.setDados(dados);
        System.out.println("Simulacion Partida");

        while (partida.isActiva()) {
            System.out.println("Jugador " + partida.getTurno().getNombre() + " ha lanzado Dados");
            lanzarDados(dados);
        }
        System.out.println("Ganador nombre;  " + partida.getTurno().getNombre() + " color; " + partida.getTurno().getColor());
    }

    private static int[] indicesCentro14 = {30, 0, 15, 45};

    private static int[] indicesCentro12 = {26, 0, 12, 39};

    private static int[] indicesCentro10 = {22, 0, 11, 33};

    public static void lanzarDados(List<Dado> lista) {
        int cara = 0;
        int sinCara = 0;
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).cambiarCara();
            Dado dado = lista.get(i);
            if (dado.isCara()) {
                cara += 1;
            } else {
                sinCara += 1;
            }
        }
        System.out.println("Con cara; " + cara);
        System.out.println("Sin cara; " + sinCara);
        preIntroduccionFicha(cara, sinCara);
    }





    public static void preIntroduccionFicha(int conCara, int sinCara) {
        int indiceJugador = partida.getJugadores().
                indexOf(partida.getTurno());
        Jugador turno = partida.getTurno();
        List<Ficha> fichasDisponibles = new ArrayList<>();
        List<Ficha> fichasEnJuego = new ArrayList<>();
        List<Ficha> fichasEliminadas = new ArrayList<>();
        List<Ficha> fichasConVuelta = new ArrayList<>();
        for (int i = 0; i < turno.getFichas().size(); i++) {
            Ficha ficha = turno.getFichas().get(i);
            if (ficha.isEnJuego()) {
                fichasEnJuego.add(ficha);
            } else if (ficha.isEliminada()) {
                fichasEliminadas.add(ficha);
            } else if (ficha.isTerminoVuelta()) {
                fichasConVuelta.add(ficha);
            } else if (!ficha.isEnJuego() && !ficha.isEliminada() && !ficha.isTerminoVuelta()) {
                fichasDisponibles.add(ficha);
            }
        }
        int auxiliarEliminacion = 0;
        int[] arregloAuxiliar = null;
        if (partida.getTablero().getTamano() == 14) {
            arregloAuxiliar = indicesCentro14;
            auxiliarEliminacion = 60;
        }
        if (partida.getTablero().getTamano() == 12) {
            arregloAuxiliar = indicesCentro12;
            auxiliarEliminacion = 52;
        }
        if (partida.getTablero().getTamano() == 10) {
            arregloAuxiliar = indicesCentro10;
            auxiliarEliminacion = 44;
        }
        int opcion = 0;
        int avance = 0;
        if (conCara == 1 && sinCara == 4) {
            System.out.println("Se avanzara 1 casilla");
            avance = 1;
            opcion = 1;
        }
        if (conCara == 2 && sinCara == 3) {
            System.out.println("Se avanzaran 2 casilla");
            avance = 2;
            opcion = 2;
        }
        if (conCara == 3 && sinCara == 2) {
            System.out.println("Se avanzaran 3 casilla");
            avance = 3;
            opcion = 3;
        }
        if (conCara == 4 && sinCara == 1) {
            System.out.println("Se avanzaran 4 casilla");
            avance = 4;
            opcion = 4;
        }
        if (conCara == 5 && sinCara == 0) {
            System.out.println("Se avanzaran 10 casilla");
            avance = 10;
            opcion = 5;
        }
        if (conCara == 0 && sinCara == 5) {
            System.out.println("Se cedera el turno casilla");
            opcion = 6;
        }

        int auxliarSalidaJugador = -1;
        Tablero tablero = partida.getTablero();
        if (Arrays.asList(1, 2, 3, 4, 5).contains(opcion)) {
            int validarturno = -1;
            if (fichasEnJuego.isEmpty()) {
                if (!fichasDisponibles.isEmpty()) {
                    Ficha aMeter = fichasDisponibles.get(0);
                    fichasEnJuego.add(aMeter);
                }
            }
            Ficha enJuego = fichasEnJuego.get(0);
            System.out.println("Ficha a jugar; " + enJuego.getNumeroPosicion());
            int indiceCasilla = buscarIndice(enJuego);
            if (indiceCasilla == -1) {
                if (indiceJugador == 1) {
                    indiceCasilla = arregloAuxiliar[indiceJugador] + avance;
                    Casilla casilla = tablero.getCasillas().get(indiceCasilla);
                    List<Casilla> casillas = tablero.getCasillas();
                    if (casilla.getFicha() == null) {
                        System.out.println("La ficha; " + (enJuego.getNumeroPosicion() + 1) + " del jugador ha ingresado a la posicion; " + (indiceCasilla));
                        enJuego.setEnJuego(true);
                        Casilla casillaActualizar = new Casilla(casilla.getTipo());
                        casillaActualizar.setFicha(enJuego);
                        casillas.set(indiceCasilla, casillaActualizar);
                    }
                } else {
                    indiceCasilla = arregloAuxiliar[indiceJugador] + avance;
                    Casilla casilla = tablero.getCasillas().get(indiceCasilla);
                    List<Casilla> casillas = tablero.getCasillas();
                    if (casilla.getFicha() == null) {
                        System.out.println("La ficha; " + (enJuego.getNumeroPosicion() + 1) + " del jugador ha ingresado a la posicion; " + (indiceCasilla));
                        enJuego.setEnJuego(true);
                        Casilla casillaActualizar = new Casilla(casilla.getTipo());
                        casillaActualizar.setFicha(enJuego);
                        casillas.set(indiceCasilla, casillaActualizar);
                    }
                }
            } else {
                Casilla casillaPrueba = null;
                try {
                    casillaPrueba = tablero.getCasillas().get(indiceCasilla + avance);
                } catch (Exception e) {
                }
                if (indiceJugador == 1) {
                    List<Casilla> casillas = tablero.getCasillas();
                    if (casillaPrueba == null) {
                        Casilla actualizarBase = tablero.getCasillas().get(indiceCasilla);
                        Casilla casillaActualizar = new Casilla(actualizarBase.getTipo());
                        enJuego.setEnJuego(false);
                        enJuego.setEliminada(false);
                        enJuego.setTerminoVuelta(true);
                        System.out.println("La ficha; " + (enJuego.getNumeroPosicion() + 1)
                                + " ha terminado la vuelta, posicion que estaba; " + indiceCasilla);
                        casillas.set(indiceCasilla, casillaActualizar);
                    } else {
                        if (casillaPrueba.getFicha() == null) {
                            Casilla anteriorO = tablero.getCasillas().get(indiceCasilla);
                            Casilla casillaAnteriorActualizada = new Casilla(anteriorO.getTipo());
                            casillas.set(indiceCasilla, casillaAnteriorActualizada);
                            System.out.println("La ficha; " + (enJuego.getNumeroPosicion() + 1)
                                    + " del jugador ha movido a la posicion; " + (indiceCasilla + avance));
                            enJuego.setEnJuego(true);
                            Casilla actualizarBase = tablero.getCasillas().get(indiceCasilla);
                            Casilla casillaActualizar = new Casilla(actualizarBase.getTipo());
                            casillaActualizar.setFicha(enJuego);
                            casillas.set(indiceCasilla + avance, casillaActualizar);
                        }
                    }
                } else {
                    List<Casilla> casillas = tablero.getCasillas();
                    int punteroJugador = arregloAuxiliar[indiceJugador];
                    if (casillaPrueba != null) {
                        if (indiceCasilla > punteroJugador) {
                            Casilla anteriorO = tablero.getCasillas().get(indiceCasilla);
                            Casilla casillaAnteriorActualizada = new Casilla(anteriorO.getTipo());
                            casillas.set(indiceCasilla, casillaAnteriorActualizada);
                            System.out.println("La ficha; " + (enJuego.getNumeroPosicion() + 1)
                                    + " del jugador ha movido a la posicion; " + (indiceCasilla + avance));
                            enJuego.setEnJuego(true);
                            Casilla actualizarBase = tablero.getCasillas().get(indiceCasilla);
                            Casilla casillaActualizar = new Casilla(actualizarBase.getTipo());
                            casillaActualizar.setFicha(enJuego);
                            casillas.set(indiceCasilla + avance, casillaActualizar);
                        } else if (indiceCasilla < punteroJugador) {
                            //&& (indiceCasilla + avance) < punteroJugador

                            if ((indiceCasilla + avance) < punteroJugador) {
                                Casilla anteriorO = tablero.getCasillas().get(indiceCasilla);
                                Casilla casillaAnteriorActualizada = new Casilla(anteriorO.getTipo());
                                casillas.set(indiceCasilla, casillaAnteriorActualizada);
                                System.out.println("La ficha; " + (enJuego.getNumeroPosicion() + 1)
                                        + " del jugador ha movido a la posicion; " + (indiceCasilla + avance));
                                enJuego.setEnJuego(true);
                                Casilla actualizarBase = tablero.getCasillas().get(indiceCasilla);
                                Casilla casillaActualizar = new Casilla(actualizarBase.getTipo());
                                casillaActualizar.setFicha(enJuego);
                                casillas.set(indiceCasilla + avance, casillaActualizar);
                            } else {
                                enJuego.setEnJuego(false);
                                enJuego.setEliminada(false);
                                enJuego.setTerminoVuelta(true);
                                Casilla casillaActualizar = new Casilla(tablero.getCasillas().get(indiceCasilla).getTipo());
                                System.out.println("La ficha; " + (enJuego.getNumeroPosicion() + 1)
                                        + " ha terminado la vuelta, posicion que estaba; " + indiceCasilla);
                                casillas.set(indiceCasilla, casillaActualizar);
                            }
                        }
                    } else {
                        int indicePasado = indiceCasilla;
                        indiceCasilla = (indiceCasilla + avance) - (auxiliarEliminacion);
                        Casilla anteriorO = tablero.getCasillas().get(indicePasado);
                        Casilla casillaAnteriorActualizada = new Casilla(anteriorO.getTipo());
                        casillas.set(indicePasado, casillaAnteriorActualizada);
                        System.out.println("La ficha; " + (enJuego.getNumeroPosicion() + 1)
                                + " del jugador ha movido a la posicion; " + (indiceCasilla));
                        enJuego.setEnJuego(true);
                        Casilla actualizarBase = tablero.getCasillas().get(indiceCasilla);
                        Casilla casillaActualizar = new Casilla(actualizarBase.getTipo());
                        casillaActualizar.setFicha(enJuego);
                        casillas.set(indiceCasilla, casillaActualizar);
                    }
                }
            }
            indiceJugador += 1;
            if (indiceJugador == partida.getJugadores().size()) {
                indiceJugador = 0;
            }
            Jugador turnoSiguiente = partida.getJugadores().get(indiceJugador);
            partida.setTurno(turnoSiguiente);
        } else {
            indiceJugador += 1;
            if (indiceJugador == partida.getJugadores().size()) {
                indiceJugador = 0;
            }
            Jugador turnoSiguiente = partida.getJugadores().get(indiceJugador);
            System.out.println("No salio tirada exitosa se cedera el turno nombre;" + turnoSiguiente.getNombre() + ", color;" + turnoSiguiente.getColor());
            partida.setTurno(turnoSiguiente);
        }
        verificarTotal();
        mostrarDatos();
    }

    public void introducirFicha(){
    }
    
    public static boolean realizarPago() {
        return true;
    }

    public static void mostrarDatos() {
        System.out.println("------------");
        System.out.println("");
        for (int f = 0; f < partida.getTablero().getCasillas().size(); f++) {
            Casilla get = partida.getTablero().getCasillas().get(f);
            System.out.print(
                    
                    (get.getFicha() != null ?
                            
                            " [ Tipo Casilla; "+get.getTipo() + " "+get.getFicha().getJugador().getNombre() + " ] " : (" [ Tipo Casilla"+ get.getTipo()+""+ (f) + " ] ")));
        }
        System.out.println("");
        System.out.println("------------------");
    }

    public static void verificarTotal() {
        Jugador jugador=null;
        int auxiliar = -1;
        for (int i = 0; i < partida.getJugadores().size(); i++) {
            Jugador turno = partida.getJugadores().get(i);
            List<Ficha> fichasDisponibles = new ArrayList<>();
            List<Ficha> fichasEnJuego = new ArrayList<>();
            List<Ficha> fichasEliminadas = new ArrayList<>();
            List<Ficha> fichasConVuelta = new ArrayList<>();
            for (int d = 0; d < turno.getFichas().size(); d++) {
                Ficha ficha = turno.getFichas().get(d);
                if (ficha.isEnJuego()) {
                    fichasEnJuego.add(ficha);
                } else if (ficha.isEliminada()) {
                    fichasEliminadas.add(ficha);
                } else if (ficha.isTerminoVuelta()) {
                    fichasConVuelta.add(ficha);
                } else if (!ficha.isEnJuego() && !ficha.isEliminada() && !ficha.isTerminoVuelta()) {
                    fichasDisponibles.add(ficha);
                }
            }
            System.out.println(fichasConVuelta.size() + " de las fichas del jugador " + turno.getNombre() + " han dado la vuelta");
            if (fichasConVuelta.size() == partida.getCantidadFichas()) {
                jugador=turno;
                auxiliar = 0;
            }
        }
        if (auxiliar == 0) {
            partida.setTurno(jugador);
            partida.setActiva(false);
        }

    }

    public static void limpiarCasillas() {
        int tamañotablero = partida.getTablero().getTamano();
        String nombreTablero = partida.getTablero().getNumeroTablero();
        Tablero tableroFin = new Tablero(nombreTablero, tamañotablero);
        partida.setTablero(tableroFin);
    }

    public static int buscarIndice(Ficha ficha) {
        int indice = -1;
        for (int i = 0; i < partida.getTablero().getCasillas().size(); i++) {
            Casilla get = partida.getTablero().getCasillas().get(i);
            if (get.getFicha() != null) {
                if (get.getFicha().getJugador().equals(ficha.getJugador())) {
                    indice = i;
                    break;
                }
            }
        }
        return indice;
    }

    public static void verificarLanzamiento() {
    }

    public static boolean pasarTurno() {
        return true;
    }

    public static boolean establecerSalidaFicha() {
        return true;
    }

    public static boolean removerFichaCasilla() {
        return true;
    }

}


