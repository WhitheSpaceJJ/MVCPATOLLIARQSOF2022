package clientePatolli;

import entidades.Dado;
import entidades.Jugador;
import entidades.Partida;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.List;
import java.util.Observable;

public class Cliente extends Observable implements Runnable {

    private String host;
    private Socket socket;
    private int puerto;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private Jugador jugador;
    private boolean conexionEstablecida;
//Constructor del cliente que se encarga de procesar los datos del juego conrespecto al servidor

    public Cliente() {
        this.conexionEstablecida = true;
//Si desea levantar un servidor como se menciono en el proyecto del patolliServidor, este es el dato que se 
//necesita cambiar con respecto a la computadora a la que se desmilitarizo, y su correspiende ip y puerto que se establecio.
        this.host = "192.168.100.4";
        this.puerto = 80;
    }

    public Cliente(String host, int puerto) {
        this.conexionEstablecida = true;
        this.host = host;
        this.puerto = puerto;
    }

    public Cliente(String host, Socket socket, int puerto, ObjectInputStream input) {
        this.conexionEstablecida = true;
        this.host = host;
        this.socket = socket;
        this.puerto = puerto;
        this.input = input;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public ObjectInputStream getInput() {
        return input;
    }

    public void setInput(ObjectInputStream input) {
        this.input = input;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    //Metodo run del cliente  que se conecta al servidor correspiendente, y 
    // que actualiza los datos correspondientes a su
    //espectivo observer, y el observer actual es el de MPartida, que este a su vez es un observable,
    //y que actualiza la respectivas
    //pantallas de los usuarios

    @Override
    public void run() {
        System.out.println("Cliente esperando");
        //Ciclo que perifica el flujo de datos corrspondiente. Que se ven reflejados en la vista deel jugador
        while (conexionEstablecida) {
            try {
                this.input = new ObjectInputStream(socket.getInputStream());
                Object aux = input.readObject();
                if (aux instanceof Partida) {
                    this.procesarPartida((Partida) aux);
                }
            } catch (IOException | ClassNotFoundException e) {
            }
        }
        System.out.println("Se finalizo la conexion");

    }

    /*
    Metodo que actualiza o procesa la partida, actual gracias a los observers
     */
    public void procesarPartida(Partida partida) {
        //Si la partida esta activa se procesa la informacion
        if (partida.isActiva()) {
            System.out.println("Se ha actualizado la partida");
            this.setChanged();
            this.notifyObservers(partida);
        } else {
            //En cambio si la partida ha finalizado esta finaliza el ciclo run estableciendo la variabl conexionEstablecida a 
            //false y cerrando el socket correspondiente de este cliente
            this.conexionEstablecida = false;
        }
    }

    /*
    Metodo que establece la creacion de una partida, se conecta con el servidor, y este regresa los mismos datos de la partida
    con el fin de que aqui si los datos enviados contienen algo no son nullos, es decir que la partida,se ha creado
    satisfactoriamente en cambios si retorna valor nulo, es que no se creo correctamente. 
     */
    public boolean establecerCreacionPartida(Partida partida) {
        //Primer try catch que se ejecuta con el fin de establecer la conexion con el servidor
        try {
            this.socket = new Socket(host, 80);
            System.out.println("Se ha establecido la conexion correctamente");
        } catch (IOException e) {
            System.out.println("El servidor no se ha levantado correctamente.");
            return false;
        }
        //Segundo try catch con el fin de enviar los datos de la partida que quiere el cliente que se crea
        try {
            this.output = new ObjectOutputStream(socket.getOutputStream());
            this.output.writeObject(partida);
            System.out.println("Se ha enviado la partida para verifcar");
        } catch (IOException e) {
            System.out.println("No se ha enviado la partida.");
            return false;
        }
        //Tercer try catch que procesa los datos recibidos, como se menciono este recibe nuevamente la partida, si se recibo 
        //algo con datos la partida se proceso correctamente, en cambios si no se recibio nada es que la partida ya ha sido creada
        //y solo requiere jugadores
        try {
            this.input = new ObjectInputStream(socket.getInputStream());
            Partida partidaAuxiliar = (Partida) input.readObject();
            if (partidaAuxiliar != null) {
                System.out.println("Se ha creado la partida satisfactoriamente");
                this.conexionEstablecida = true;
                this.jugador = partida.getTurno();
                return true;
            } else {
                return false;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No se ha creado la partida satisfactoriamente");
            return false;
        }
    }

    /*
    Metodo que es jecutado cuando se necesita o se requiere enviar una lista de dados al servidor, si el envio tiene exito 
    es que se procesaron los dados, ya que era el turno actual de este cliente, en cambios no se procesara nada
     */
    public boolean lanzarDados(List<Dado> dados) {
        try {
            this.output = new ObjectOutputStream(socket.getOutputStream());
            this.output.writeObject(dados);
            System.out.println("Se ha enviado los dados para la verificacion, porque ha sido tu turno");
            //Por lo tanto se regresa true ya que se enviaron los dados
        } catch (IOException e) {
            System.out.println("No se ha enviado los dados porque no es el turno del jugador.");
            return false;
        }
        return true;
    }

    /*
    Metodo que cliente ejecuta cuando un jugador requiere unirse a una partida,  si se procesa 
    correctamente, este retorna los datos de la partida.
     */
    public Partida unirsePartida(Jugador jugador) {
        //Primer try catch para verificar que el servidor este levantado
        try {
            this.socket = new Socket(host, 80);
            System.out.println("Se ha establecido la conexion correctamente");
        } catch (IOException e) {
            System.out.println("El servidor no se ha levantado correctamente.");
            return null;
        }
        //Segundo try catch que establece o envia los datos del jugador para la verificacion correspondiente
        try {
            this.output = new ObjectOutputStream(socket.getOutputStream());
            this.output.writeObject(jugador);
            System.out.println("Se ha enviado el jugador para validacion.");
        } catch (IOException e) {
            System.out.println("No se ha enviado el jugador.");
            return null;
        }
        //Tercer try catch que analiza si la se recibio una partida con datos, si es el caso es que 
        //el jugador se pudo unir con exito en cambio si retorna null,  es que ya existia un jugador con los mismos datos
        try {
            this.input = new ObjectInputStream(socket.getInputStream());
            Partida partida = (Partida) input.readObject();
            if (partida != null) {
                this.jugador = (partida.getJugadores().get(partida.getJugadores().size() - 1));
                this.conexionEstablecida = true;
                return partida;
            } else {
                System.out.println("Ya existe un jugador con el mismo nombre y color");
                System.out.println("O el servidor se ha levantado pero no se ha establecido la creacion de una partida.");
                return null;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("El servidor se ha levantado pero no se ha establecido la creacion de una partida.");
            return null;
        }
    }

    /*Metodo que el jugador creador ejecutara cuando desea que la partida inicie
    prototipo
     */
    public boolean iniciarPartida() {
        try {
            this.socket = new Socket(host, 80);
            System.out.println("Se ha establecido la conexion correctamente");
            this.output = new ObjectOutputStream(socket.getOutputStream());
            this.output.writeObject(this.jugador);
            System.out.println("Se ha enviado la peticion de iniciar la partida");
            //Por lo tanto se regresa true ya que se enviaron los dados
        } catch (IOException e) {
            System.out.println("no se ha enviado la peticion de iniciar la partida");
            return false;
        }
        try {
            this.input = new ObjectInputStream(socket.getInputStream());
            Boolean peticion = (Boolean) input.readObject();
            if (peticion != null) {
                return true;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No se ha procesado la respuesta.");
            return false;
        }
        return false;
    }

    public void salirPartida() {
    }
}
