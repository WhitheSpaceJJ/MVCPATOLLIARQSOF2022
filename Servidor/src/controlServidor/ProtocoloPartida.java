package controlServidor;

import entidades.Dado;
import entidades.Jugador;
import entidades.Partida;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import jugador.JugadorLocal;
import modeloServidor.PartidaServidor;

public class ProtocoloPartida {

    private PartidaServidor partidaLocal;
    private int auxiliar;
    public ProtocoloPartida() {
    }

    public ProtocoloPartida(PartidaServidor partidaLocal) {
        this.partidaLocal = partidaLocal;
        this.auxiliar=0;
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
                this.auxiliar=((Partida) aux).getTotalJugadores();
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
                Jugador jugadorObjecto =((Jugador) object) ;
                jugadorObjecto.inicializarFichas(auxiliar);
                Jugador jugador=jugadorObjecto;
                JugadorLocal jugadorLocal = new JugadorLocal(jugador, sc);
                int jugadorEsta = jugadores.indexOf(jugadorLocal);
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

//                int auxiliar
//                for (int i = 0; i < jugadoresNuevos.size(); i++) {
//                    JugadorLocal get = jugadoresNuevos.get(i);
//                    if () {
//                        
//                    }
//                }
//                try {
//                    ObjectInputStream inputd = new ObjectInputStream(jugadores.get(0).getSocket().getInputStream());
//                    Object objectIniciar = inputd.readObject();
//                } catch (IOException | ClassNotFoundException e) {
//                    System.out.println("Error; " + e.getMessage());
//                }
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
    public int procesarDados(Object object) {
        //Regresara el indice del jugador que esta en turno, si la partida ya esta esta acaba retorna 
        //100 de que la partida ya acabo , este actualizara la partida en la PartidaServidor, y este metodo noticara los ultimos 
        //datos de la partida y se cierra el ciclo
        if (object instanceof List) {
            this.lanzarDados((List<Dado>) object);
            return 0;
        }
        return 0;
    }

    /*
    Metodos que actualizaran la respectiva partida, moveran la ficha, realizaran pagos,etc.
    Estos metodos seran la logica del juego, y la clave para que se finalice una partida, o se elimine un jugador    
     */
    public void lanzarDados(List<Dado> lista) {
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
