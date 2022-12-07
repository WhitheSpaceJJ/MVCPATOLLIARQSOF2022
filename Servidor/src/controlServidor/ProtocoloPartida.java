
//Reactualizacion de Protocolo Servidor
package controlServidor;

import entidades.Casilla;
import entidades.Dado;
import entidades.Ficha;
import entidades.Jugador;
import entidades.Partida;
import entidades.Tablero;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jugador.JugadorLocal;
import modeloServidor.PartidaServidor;

public class ProtocoloPartida {

    private PartidaServidor partidaLocal;
//    private int auxiliar;
    private int next = 0;

    public ProtocoloPartida() {
    }

    public ProtocoloPartida(PartidaServidor partidaLocal) {
        this.partidaLocal = partidaLocal;
//        this.auxiliar = 0;
    }

    /*
 Protocolo para procesar la creacion de la partida,recibe el socket y objeto correspondiente del cliente que se haya conectado.
El metodo retorna un JugadorLocal si es que este envia los datos de la partida, en cambio regresa null, si solo esta tratando de
    conectarse a la partida que no tiene datos aun.
     */
    public JugadorLocal procesandoCreacion(Socket sc, Object aux) {
        JugadorLocal jugadorCreador = null;
        try {
            /*
            Con el fin de conocer los datos de una partida, se establece un flujo de entrada con el respectivo cliente, 
            se espera que el cliente envia los datos de una partida, en caso contrario se rechaza la conexion.
            Condicion que determina si el objeto es de instancia de partida
             */
            if (aux instanceof Partida) {
                ((Partida) aux).setActiva(true);
//                this.auxiliar = ((Partida) aux).getTotalJugadores();
                //Se crea jugador deacuerdo al turno, ya que el jugador, creador de una partida, siempre tendra el primer turno
                Jugador jugador = ((Partida) aux).getTurno();
                System.out.println("La partida ha sido creada");
                System.out.println("Jugador creador; Nombre=" + jugador.getNombre() + " Color=" + jugador.getColor());
                jugadorCreador = new JugadorLocal(jugador, sc);
                //Se envia la partida con el fin de que el cliente verifique que la partida se ha creado.
                ObjectOutputStream output = new ObjectOutputStream(sc.getOutputStream());
                output.writeObject((Partida) aux);
                //Se establece la partida
                this.partidaLocal.establecerPartida((Partida) aux);
            } else {
                //En cambio si la instancia no es de partida se establece un flujo de salida de datos
                //con el fin de enviar algo null, que este sera verificado por cliente y ejecutara sus respectivos comandos.
                ObjectOutputStream output = new ObjectOutputStream(sc.getOutputStream());
                output.writeObject(null);
                System.out.println("La partida debe de ser creada antes de unirse");
            }
        } catch (IOException e) {
            System.out.println("Error; " + e.getMessage());
        }
        //Se retorna al jugador creador
        return jugadorCreador;
    }

    public int indiceJugador(List<JugadorLocal> jugadores, Jugador jugador) {
        int indice = -1;
        for (int i = 0; i < jugadores.size(); i++) {
            JugadorLocal get = jugadores.get(i);
            if (get.getJugador().equals(jugador)) {
                indice = i;
                break;
            }
        }
        return indice;
    }

    /*
    Metodo encargado de procesar la espera de los jugadores, este recibe la lista de
    jugadores actuales, y el socket correspondiente.
    De igual manera se realiza una evaluacion del tipo de objeto, que se recibe si este envia una partida
    aunque esta ya este creada, se rechaza la conexion en cambio si es un jugador se establece la conexion con el socket
    y se añade el juego. Sin embargo, este paso por un filtro con el fin de verificar que
    los datos de su nombre y color, se encuentren disponibles, en caso de que ya exista alguien similar se rechaza la conexion.
    Retonr la lista de jugadores actuales + el jugador aceptado si este fue paso las condiciones.
     */
    public List<JugadorLocal> procesandoEspera(Socket sc, List<JugadorLocal> jugadores, Object object) {
        List<JugadorLocal> jugadoresNuevos = null;
        try {
            //condicion que determina si el objeto leido es una instancia de jugador
            //Si es asi pasa pasa por el filtro de aceptacion si este no se encuentra en la lista de jugadores Locales
            if (object instanceof Jugador) {
                Jugador jugadorObjecto = ((Jugador) object);
                jugadorObjecto.inicializarFichas(partidaLocal.getPartidaLocal().getCantidadFichas());

//                jugadorObjecto.inicializarFichas(auxiliar);
                Jugador jugador = jugadorObjecto;
                JugadorLocal jugadorLocal = new JugadorLocal(jugador, sc);
                int jugadorEsta = indiceJugador(jugadores, jugador);
                ObjectOutputStream output = new ObjectOutputStream(sc.getOutputStream());
                //Se determina si el jugador se encuentra en la lista con el apoyo del metodo indexOf
                if (jugadorEsta == -1) {
                    jugadores.add(jugadorLocal);
                    jugadoresNuevos = jugadores;
                    this.partidaLocal.agregarJugador(jugador);
                    output.writeObject(this.partidaLocal.getPartidaLocal());
                    System.out.println("Jugador conectado; Nombre=" + jugador.getNombre() + " Color=" + jugador.getColor());
//                    this.partidaLocal.agregarJugador(jugador);
                } else {
                    //Si el jugador ya existe se encia un dato null, con el fin de que el cliente lo procese
                    output.writeObject(null);
                }
            } else if (object instanceof Boolean) {
                //Evaluar Creacion de la partida
                ObjectOutputStream output = new ObjectOutputStream(sc.getOutputStream());
                if (jugadores.size() >= 2) {
                    output.writeObject(true);
                    this.iniciarPartida(jugadores.size());
                    return null;
                } else {
                    output.writeObject(null);
                }

            } else {
                //En cambio si es otra partida la que se recibe este envia algo null con el de que rechaze la conexion
                ObjectOutputStream output = new ObjectOutputStream(sc.getOutputStream());
                output.writeObject(null);
            }
        } catch (IOException e) {
            System.out.println("Error; " + e.getMessage());
        }
        return jugadoresNuevos;
    }

    //Metodo que recibirael total de jugadores
    public void iniciarPartida(int jugadoresUnidos) {
    }

    /*
    Metodo que procesa la entrada de listas de dados,que son recibidas pro el jugador en turno.
     */
    public void procesarDados(Object object) {
        //Regresara el indice del jugador que esta en turno, si la partida ya esta esta acaba retorna 
        //100 de que la partida ya acabo , este actualizara la partida en la PartidaServidor, y este metodo noticara los ultimos 
        //datos de la partida y se cierra el ciclo
        if (object instanceof List) {
            this.lanzarDados((List<Dado>) object);
        }
    }

    /*
    Metodos que actualizaran la respectiva partida, moveran la ficha, realizaran pagos,etc.
    Estos metodos seran la logica del juego, y la clave para que se finalice una partida, o se elimine un jugador    
     */
    public void lanzarDados(List<Dado> lista) {
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).cambiarCara();
        }
        reLanzamientoDados(lista);
    }

    public void reLanzamientoDados(List<Dado> lista) {
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
        partidaLocal.getPartidaLocal().setDados(lista);
        preIntroduccionFicha(cara, sinCara, partidaLocal.getPartidaLocal());
    }

    public void introduccionFicha(Jugador jugador, int opcion, Partida partida,
            int[] arregloAuxiliar, int auxiliarEliminacion, int avance) {
        next = 0;
        int indiceJugador = partida.getJugadores().
                indexOf(partida.getTurno());
        Jugador turno = partida.getTurno();
        List<Ficha> fichasDisponibles = this.fichasDisponibles(turno);
        List<Ficha> fichasEnJuego = this.fichasEnJuego(turno);

        //Variables no usadas
        List<Ficha> fichasEliminadas = this.fichasEliminadas(turno);
        List<Ficha> fichasConVuelta = this.fichasConVuelta(turno);
        int auxliarSalidaJugador = -1;
        int validarturno = -1;

        Tablero tablero = partida.getTablero();
        if (Arrays.asList(1, 2, 3, 4, 5).contains(opcion)) {
            if (fichasEnJuego.isEmpty()) {
                if (!fichasDisponibles.isEmpty()) {
                    Ficha aMeter = fichasDisponibles.get(0);
                    fichasEnJuego.add(aMeter);
                }
            }
            Ficha enJuego = fichasEnJuego.get(0);
            System.out.println("Ficha a jugar; " + enJuego.getNumeroPosicion());
            int indiceCasilla = buscarIndice(enJuego, partida);
            if (indiceCasilla == -1) {
                ingresoFichaInicial(indiceJugador, avance, arregloAuxiliar, tablero, enJuego);
            } else {
                moverFicha(indiceCasilla, avance, tablero, indiceJugador, enJuego, auxiliarEliminacion, arregloAuxiliar);
            }
            if (next == 0) {
                pasarTurno(indiceJugador, partida, 0);
            }

        } else {
            pasarTurno(indiceJugador, partida, 1);
        }
        verificarTotal(partida);
        mostrarDatos(partida);
        this.partidaLocal.actualizarPartida(partida);
    }

    public void vueltaCompletaFicha(Tablero tablero, int indiceCasilla, Ficha enJuego, List<Casilla> casillas) {
        Casilla actualizarBase = tablero.getCasillas().get(indiceCasilla);
        Casilla casillaActualizar = new Casilla(actualizarBase.getTipo());
        enJuego.setEnJuego(false);
        enJuego.setEliminada(false);
        enJuego.setTerminoVuelta(true);
        System.out.println("La ficha; " + (enJuego.getNumeroPosicion() + 1)
                + " ha terminado la vuelta, posicion que estaba; " + indiceCasilla);
        casillas.set(indiceCasilla, casillaActualizar);
    }

    public void moverFicha(int indiceCasilla, int avance, Tablero tablero, int indiceJugador, Ficha enJuego,
            int auxiliarEliminacion, int[] arregloAuxiliar) {
        Casilla casillaPrueba = null;
        try {
            casillaPrueba = tablero.getCasillas().get(indiceCasilla + avance);
        } catch (Exception e) {
        }
        if (indiceJugador == 1) {
            List<Casilla> casillas = tablero.getCasillas();
            if (casillaPrueba == null) {
                vueltaCompletaFicha(tablero, indiceCasilla, enJuego, casillas);
            } else {
                if (casillaPrueba.getFicha() == null) {
                    acualizarPosicionFicha(tablero, indiceCasilla, casillas, enJuego, avance);
                }
            }
        } else {
            List<Casilla> casillas = tablero.getCasillas();
            int punteroJugador = arregloAuxiliar[indiceJugador];
            if (casillaPrueba != null) {
                if (indiceCasilla > punteroJugador) {
                    acualizarPosicionFicha(tablero, indiceCasilla, casillas, enJuego, avance);
                } else if (indiceCasilla < punteroJugador) {
                    //&& (indiceCasilla + avance) < punteroJugador

                    if ((indiceCasilla + avance) < punteroJugador) {
                        acualizarPosicionFicha(tablero, indiceCasilla, casillas, enJuego, avance);
                    } else {
                        vueltaCompletaFicha(tablero, indiceCasilla, enJuego, casillas);
                    }
                }
            } else {
                actualizarPosicionFichaEspecial(indiceCasilla, avance, auxiliarEliminacion, tablero, enJuego, casillas);
            }
        }

    }

    public void actualizarPosicionFichaEspecial(int indiceCasilla, int avance, int auxiliarEliminacion, Tablero tablero, Ficha enJuego, List<Casilla> casillas) {
        int indicePasado = indiceCasilla;
        indiceCasilla = (indiceCasilla + avance) - (auxiliarEliminacion);
        Casilla anteriorO = tablero.getCasillas().get(indicePasado);
        Casilla casillaAnteriorActualizada = new Casilla(anteriorO.getTipo());
        casillas.set(indicePasado, casillaAnteriorActualizada);
        System.out.println("La ficha; " + (enJuego.getNumeroPosicion() + 1)
                + " del jugador ha movido a la posicion; " + (indiceCasilla));
        enJuego.setEnJuego(true);
        Casilla actualizarBase = tablero.getCasillas().get(indiceCasilla);
        //Se verificara la nueva posicion,reglas,de triangulos,etc
        Casilla casillaActualizar = new Casilla(actualizarBase.getTipo());
        casillaActualizar.setFicha(enJuego);
        casillas.set(indiceCasilla, casillaActualizar);
    }

    public void acualizarPosicionFicha(Tablero tablero, int indiceCasilla, List<Casilla> casillas, Ficha enJuego, int avance) {
        Casilla anteriorO = tablero.getCasillas().get(indiceCasilla);
        Casilla casillaAnteriorActualizada = new Casilla(anteriorO.getTipo());
        casillas.set(indiceCasilla, casillaAnteriorActualizada);
        System.out.println("La ficha; " + (enJuego.getNumeroPosicion() + 1)
                + " del jugador ha movido a la posicion; " + (indiceCasilla + avance));
        enJuego.setEnJuego(true);
        Casilla actualizarBase = tablero.getCasillas().get(indiceCasilla+avance);
        //Se verificara la nueva posicion,reglas,de triangulos,etc
        Casilla casillaActualizar = new Casilla(actualizarBase.getTipo());
        casillaActualizar.setFicha(enJuego);
        casillas.set(indiceCasilla + avance, casillaActualizar);

    }

    public void ingresoFichaInicial(int indiceJugador, int avance, int[] arregloAuxiliar, Tablero tablero, Ficha enJuego) {

        int indiceCasilla = arregloAuxiliar[indiceJugador] + avance;
        Casilla casilla = tablero.getCasillas().get(indiceCasilla);
        List<Casilla> casillas = tablero.getCasillas();
        if (casilla.getFicha() == null) {
            //Se verificara si caasilla es bordeada, penalizacion,central
            //pasara por un filtro que determine si se paga o se pasa el turno
            System.out.println("La ficha; " + (enJuego.getNumeroPosicion() + 1) + " del jugador ha ingresado a la posicion; " + (indiceCasilla));
            enJuego.setEnJuego(true);
            Casilla casillaActualizar = new Casilla(casilla.getTipo());
            casillaActualizar.setFicha(enJuego);
            casillas.set(indiceCasilla, casillaActualizar);
        }
    }

    public void pasarTurno(int indiceJugador, Partida partida, int numero) {
        if (numero == -1) {
            indiceJugador += 1;
            if (indiceJugador == partida.getJugadores().size()) {
                indiceJugador = 0;
            }
            Jugador turnoSiguiente = partida.getJugadores().get(indiceJugador);
            System.out.println("No salio tirada exitosa se cedera el turno nombre;" + turnoSiguiente.getNombre() + ", color;" + turnoSiguiente.getColor());
            partida.setTurno(turnoSiguiente);
        } else {
            indiceJugador += 1;
            if (indiceJugador == partida.getJugadores().size()) {
                indiceJugador = 0;
            }
            Jugador turnoSiguiente = partida.getJugadores().get(indiceJugador);
            System.out.println("El siguiente turno es para el nombre;" + turnoSiguiente.getNombre() + ", color;" + turnoSiguiente.getColor());
            partida.setTurno(turnoSiguiente);
        }
    }

    public void preIntroduccionFicha(int conCara, int sinCara, Partida partida) {
        Jugador jugador = partida.getTurno();
        int auxiliarEliminacion = 0;
        int[] arregloAuxiliar = null;
        if (partida.getTablero().getTamano() == 14) {
//            arregloAuxiliar = indicesCentro14;
            int[] arreglo = {30, 0, 15, 45};
            arregloAuxiliar = arreglo;
            auxiliarEliminacion = 60;
        }
        if (partida.getTablero().getTamano() == 12) {
//            arregloAuxiliar = indicesCentro12;
            int[] arreglo = {26, 0, 12, 39};
            arregloAuxiliar = arreglo;
            auxiliarEliminacion = 52;
        }
        if (partida.getTablero().getTamano() == 10) {
//            arregloAuxiliar = indicesCentro10;
            auxiliarEliminacion = 44;
            int[] arreglo = {22, 0, 11, 33};
            arregloAuxiliar = arreglo;
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
        introduccionFicha(jugador, opcion, partida, arregloAuxiliar, auxiliarEliminacion, avance);
    }

    public void mostrarDatos(Partida partida) {
        System.out.println("------------");
        System.out.println("");
        for (int f = 0; f < partida.getTablero().getCasillas().size(); f++) {
            Casilla get = partida.getTablero().getCasillas().get(f);
            System.out.print((get.getFicha() != null ? " " + get.getFicha().getJugador().getNombre() + " " : (" " + (f) + " ")));
        }
        System.out.println("");
        System.out.println("------------------");
    }

    public void verificarTotal(Partida partida) {
        Jugador jugador = null;
        int auxiliar = -1;
        for (int i = 0; i < partida.getJugadores().size(); i++) {
            Jugador turno = partida.getJugadores().get(i);
            List<Ficha> fichasConVuelta = this.fichasConVuelta(turno);
            System.out.println(fichasConVuelta.size() + " de las fichas del jugador " + turno.getNombre() + " han dado la vuelta");
            if (fichasConVuelta.size() == partida.getCantidadFichas()) {
                jugador = turno;
                auxiliar = 0;
            }
        }
        if (auxiliar == 0) {
            partida.setTurno(jugador);
            partida.setActiva(false);
            partidaLocal.actualizarPartida(partida);
        }

    }

    public int buscarIndice(Ficha ficha, Partida partida) {
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


    public List<Ficha> fichasDisponibles(Jugador turno) {
        List<Ficha> fichasDisponibles = new ArrayList<>();
        for (int i = 0; i < turno.getFichas().size(); i++) {
            Ficha ficha = turno.getFichas().get(i);
            if (!ficha.isEnJuego() && !ficha.isEliminada() && !ficha.isTerminoVuelta()) {
                fichasDisponibles.add(ficha);
            }
        }
        return fichasDisponibles;
    }

    public List<Ficha> fichasEnJuego(Jugador turno) {
        List<Ficha> fichasEnJuego = new ArrayList<>();

        for (int i = 0; i < turno.getFichas().size(); i++) {
            Ficha ficha = turno.getFichas().get(i);
            if (ficha.isEnJuego()) {
                fichasEnJuego.add(ficha);
            }
        }

        return fichasEnJuego;
    }

    public List<Ficha> fichasEliminadas(Jugador turno) {
        List<Ficha> fichasEliminadas = new ArrayList<>();

        for (int i = 0; i < turno.getFichas().size(); i++) {
            Ficha ficha = turno.getFichas().get(i);
            if (ficha.isEliminada()) {
                fichasEliminadas.add(ficha);
            }
        }

        return fichasEliminadas;
    }

    public List<Ficha> fichasConVuelta(Jugador turno) {
        List<Ficha> fichasConVuelta = new ArrayList<>();

        for (int i = 0; i < turno.getFichas().size(); i++) {
            Ficha ficha = turno.getFichas().get(i);
            if (ficha.isTerminoVuelta()) {
                fichasConVuelta.add(ficha);
            }
        }

        return fichasConVuelta;
    }
    
     //Metodo el cual realizara o efectuara los pagos a los respectivos clientes
    public void realizarPago() {
    }

    public void filtroCasillas() {
    }
    public void establecerSalidaFicha() {
    }

    public void removerFichaCasilla() {
    }

}
