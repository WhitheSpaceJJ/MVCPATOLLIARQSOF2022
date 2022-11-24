package servidor;

import control.ProtocoloPartida;
import dominio.Partida;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import jugador.JugadorLocal;
import modelo.PartidaServidor;

public class Servidor extends Thread implements Observer {

    //Puntero que determina el turno actual
    private Integer puntero;
    //Lista de jugadores locales
    private List<JugadorLocal> jugadores;
    //Protocolo de partida que procesa los datos de entrada y salida
    private ProtocoloPartida protocoloPartidaLocal;
    //Puerto por el que escucha el servidors
    private int puerto;
    //Variable que determina la cantida de jugadores maximos permito
    //esta se iniciliza la primera vez que el cliente envia los datos de la partida.
    private int maximoPermitido;

    //Se inicializaran cuando se ejecute Run
    //ServerSocket del servidor 
    private ServerSocket servidor;
    //Atributo para el flujo de datos de salida.
    private ObjectOutputStream output;
    //Atributo para el flujo de datos de entrada.
    private ObjectInputStream input;
    //Condicion que determina el ciclo infito donde se procesa los datos que se reciben de los jugadores.
    //Cuando el juego ha comenzado
    private boolean enServicio;

    /*
    Constructor del servidor.
     */
    public Servidor(ProtocoloPartida controlPartidaLocal, int puerto) {
        this.maximoPermitido = 0;
        this.enServicio = true;
        this.protocoloPartidaLocal = controlPartidaLocal;
        this.puntero = null;
        this.puerto = puerto;
        this.jugadores = new ArrayList<>();
    }

    /*
    Metodo update que es ejecutado con el observable lo llama.
     */
    @Override
    public void update(Observable o, Object o1) {
        //Cuando se ejecuta por primera vez este metodo, se establece la cantida de jugadores maximo
        if (maximoPermitido == 0) {
            this.maximoPermitido = ((PartidaServidor) o).getPartidaLocal().getTotalJugadores();
        } else {
            //Cuando el metodo se ejecuta por segunda vez, se llama al metodo de notifica cliente con el fin de 
            //noticicar la union de jugadores, o la actualizacion de datos a los sockets
            //Como se abaran dado cuenta el o1, se castea a una instancia de Integer, ya que este recibe un entero por parte de 
            //PartidaServidor, y los datos de una partida.
            notificarClientes(((PartidaServidor) o).getPartidaLocal(), ((Integer) o1));
        }
    }

    /*
     El metodo run ejecuta tres ciclos en total. Ciclo de espera para la creacion u obtencion de los datos de una partida.
    Ciclo para la espera de los jugadores, y ciclo, para procesar el juego(Entrada de dados)
     */
    @Override
    public void run() {

        Socket sc;
        try {
            //Creamos el socket del servidor
            this.servidor = new ServerSocket(puerto);
            System.out.println("Servidor iniciado");

            //Primer ciclo del servidor, el cual utiliza como auxilizar la lista de jugadores, mientras esta 
            //este vacia, es que no se ha creado una partida
            while (jugadores.isEmpty()) {
                //Se aceota la conexion.
                sc = servidor.accept();
                JugadorLocal jugadorLocal = null;
                Object object = null;
                try {
                    ObjectInputStream inputd = new ObjectInputStream(sc.getInputStream());
                    object = inputd.readObject();
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println("Error; " + e.getMessage());
                }

                jugadorLocal = this.protocoloPartidaLocal.procesandoCreacion(sc, object);
                //Si jugadorLocal es nulo, es porque un jugador se esta tratando de conectar a la partida,
                //pero como el servidor no recibo los datos de una partida sino del jugador la el protocolo
                //de procesando creacion regresa null, y si es nullo, se cierra el socket
                if (jugadorLocal == null) {
                    sc.close();
                } else {
                    //Si se envio los datos de una partida, el jugador local se agrega a la lista de jugadores
                    //y el ciclo actual finaliza ya que ahora la lista de jugadores de jugadores contiene un JugadorLocal
                    this.jugadores.add(jugadorLocal);
                }
            }
            //Segundo ciclo  del servidor
            while (true) {
                //Aqui se establcera una entrada de datos
                //para recibir la repuesta de el creador si ya quiere iniciar la partida
                //iniciar la partida y comenzarla
                //se actualizar el total de jugadores totales y se notificara los usuarios actuales del cambio.

                //Se acepta la conexion de un cliente.
                sc = servidor.accept();
                Object object = null;
                try {
                    ObjectInputStream inputd = new ObjectInputStream(sc.getInputStream());
                    object = inputd.readObject();
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println("Error; " + e.getMessage());
                }

                //Se manda a llamar al metodo del protocolo, con el fin de procesar la entrada del cliente
                List<JugadorLocal> jugadoresEspera = this.protocoloPartidaLocal.procesandoEspera(sc, jugadores, object);
                //Si jugadores es igual a null es que la lista de jugadores actuales no sufrio algun cambio en memoria.
                //y que el jugador que queria conectar mando, datos de la creacion de una partida, o que ya habia un jugador
                //con los mismos datos. por lo tanto se cierra la conexion
                if (jugadoresEspera == null) {
                    System.out.println("Ya existe un jugador con los mismos datos");
                    sc.close();
                } else {
                    //si la lista es diferente de nulo se actualiza la lista.
                    this.jugadores = jugadoresEspera;
                    //sin embargo se pasa por un ultimo friltro, el cual utiliza el atributo de maximoPermitod
                    //que fue establecido al momento de el servidor recibio los datos de la partida
                    if (this.jugadores.size() == this.maximoPermitido) {
                        break;
                    }
                }
            }
            System.out.println("El juego ha iniciado, ha alcanzado el maximo de jugadores");
//             Ciclo que procesara la entrada de los datos o dados
//              while (enServicio) {
//            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void notificarClientes(Partida partida, int indice) {
        //Si indice es un valor diferente de-1 que sea positivo es que el juego esta procesando a los jugadores faltantes 
        //Y por ende se noticia a todos de cada excepto al jugador que entro se le notifica 
        // de la nueva actualizacion de los datos de  partida
        if (indice > -1 && indice < 5) {
            for (int i = 0; i < jugadores.size(); i++) {
                if (indice != i) {
                    JugadorLocal jugador = jugadores.get(i);
                    try {
                        this.output = new ObjectOutputStream(jugador.getSocket().getOutputStream());
                        this.output.writeObject(partida);
//                        this.output.close();
                    } catch (IOException ex) {
                        System.err.println("Error; " + ex.getMessage());
                    }
                }
            }
        } //-1 indica que el juego esta en marcha y se tiene que notificar de los datos actualizados
        // a los jugadores correspondientes
        else if (indice == -1) {
            for (int i = 0; i < jugadores.size(); i++) {
                JugadorLocal jugador = jugadores.get(i);
                try {
                    this.output = new ObjectOutputStream(jugador.getSocket().getOutputStream());
                    this.output.writeObject(partida);
//                    this.output.close();
                } catch (IOException ex) {
                    System.err.println("Error; " + ex.getMessage());
                }
            }
        } //Si indice es igual a 100 indica que la partida ha finalizado cierra la lista de sockets , termina el 
        //el flujo del run estableciendo el atributo enServicio a 
        //false, y se envian los datos de la partida, a los sockets restantes
        else if (indice == 100) {
            for (int i = 0; i < jugadores.size(); i++) {
                JugadorLocal jugador = jugadores.get(i);
                try {
                    this.output = new ObjectOutputStream(jugador.getSocket().getOutputStream());
                    this.output.writeObject(partida);
//                    this.output.close();
                } catch (IOException ex) {
                    System.err.println("Error; " + ex.getMessage());
                }
            }
        }
        //nueva condicion cuando se quiere iniciar la partida

    }

}
