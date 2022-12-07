//package modeloServidor;
//
//import entidades.Jugador;
//import entidades.Partida;
//import java.util.Observable;
//
//public class PartidaServidor extends Observable {
//
//    private Partida partidaLocal;
//
//    public PartidaServidor() {
//    }
//
//    public Partida getPartidaLocal() {
//        return partidaLocal;
//    }
//
//    /*
//    Ejecutado cuando la partida aun no 
//    contiene datos, sin embargo, se notifica al 
//    servidor de que se ingresaron datos con  el fin 
//    de que este actualice la variable de tamaño permitido de conexiones 
//     */
//    public void establecerPartida(Partida partida) {
//        this.partidaLocal = partida;
//        this.setChanged();
//        this.notifyObservers();
//    }
//
//    public void iniciarPartida(int totalJugadoresNuevos) {
//        //Se actualizara la partia, se establcer un nuevo en este caso el -1, de que la partida ya comezo 
//        //y se ejecuta el update de servidor con este nuevo numero
//        this.partidaLocal.setTotalJugadores(totalJugadoresNuevos);
//        this.setChanged();
//        this.notifyObservers(-1);
//    }
//
//    /*
//    Ejecutado para la respectiva actualizacion de los datos de la partida
//     */
//    public void actualizarPartida(Partida partida) {
//        this.partidaLocal = partida;
//        this.setChanged();
//        /*Condicion que determina si la partida aun no ha finalizado
//       si la partida esta activa entra en la condicional inicial, 
//       donde se envia el -1, el cual es analizado  por su respectivo observable
//        en este caso el servidor. 
//        el -1 representa que la partida no ha finalizado por lo tanto, el servidor notificara a los clientes
//        los nuevos datos de la partida, actualizado, y en la vista del cliente estos se actualizara.
//        En cambio el 100 representa que la partida, ya ha finalizado por lo tanto, el servidor notificara los ultimos cambios 
//        a los jugadores que aun no han perdido. 
//         */
//        if (partida.isActiva()) {
//            this.notifyObservers(-1);
//        } else {
//            this.notifyObservers(100);
//        }
//    }
//
//    /*
//   Metodo utilizado para agregar jugadores a los datos de la partida.
//     */
//    public void agregarJugador(Jugador jugador) {
//        this.partidaLocal.getJugadores().add(jugador);
//        this.setChanged();
//        /*
//          Se envia el indice del jugador que se ha conectado con el fin de que
//          el servidor no regrese los datos de la partida, ya que este al unirse
//          se le enviaron los datos de la partida, solamente los clientes que
//         esten esperando se les enviara los datos actualizaods con el nuevo
//         jugador añadido
//         */
//        this.notifyObservers(this.partidaLocal.getJugadores().indexOf(jugador));
//    }
//
//}

//Reactualizacion de partida servidor
package modeloServidor;

import entidades.Jugador;
import entidades.Partida;
import java.util.Observable;

public class PartidaServidor extends Observable {

    private Partida partidaLocal;

    public PartidaServidor() {
    }

    public Partida getPartidaLocal() {
        return partidaLocal;
    }

    /*
    Ejecutado cuando la partida aun no 
    contiene datos, sin embargo, se notifica al 
    servidor de que se ingresaron datos con  el fin 
    de que este actualice la variable de tamaño permitido de conexiones 
     */
    public void establecerPartida(Partida partida) {
        this.partidaLocal = partida;
        this.setChanged();
        this.notifyObservers();
    }

    public void iniciarPartida(int totalJugadoresNuevos) {
        //Se actualizara la partia, se establcer un nuevo en este caso el -1, de que la partida ya comezo 
        //y se ejecuta el update de servidor con este nuevo numero
        this.partidaLocal.setTotalJugadores(totalJugadoresNuevos);
        this.setChanged();
        this.notifyObservers(-1);
    }

     
    public void actualizarPartida() {
        this.setChanged();
        if (this.partidaLocal.isActiva()) {
            this.notifyObservers(-1);
        } else {
            this.notifyObservers(100);
        }
    }
    
    /*
    Ejecutado para la respectiva actualizacion de los datos de la partida
     */
    public void actualizarPartida(Partida partida) {
        this.partidaLocal = partida;
        this.setChanged();
        /*Condicion que determina si la partida aun no ha finalizado
       si la partida esta activa entra en la condicional inicial, 
       donde se envia el -1, el cual es analizado  por su respectivo observable
        en este caso el servidor. 
        el -1 representa que la partida no ha finalizado por lo tanto, el servidor notificara a los clientes
        los nuevos datos de la partida, actualizado, y en la vista del cliente estos se actualizara.
        En cambio el 100 representa que la partida, ya ha finalizado por lo tanto, el servidor notificara los ultimos cambios 
        a los jugadores que aun no han perdido. 
         */
        if (partida.isActiva()) {
            this.notifyObservers(-1);
        } else {
            this.notifyObservers(100);
        }
    }

    /*
   Metodo utilizado para agregar jugadores a los datos de la partida.
     */
    public void agregarJugador(Jugador jugador) {
        this.partidaLocal.getJugadores().add(jugador);
        this.setChanged();
        /*
          Se envia el indice del jugador que se ha conectado con el fin de que
          el servidor no regrese los datos de la partida, ya que este al unirse
          se le enviaron los datos de la partida, solamente los clientes que
         esten esperando se les enviara los datos actualizaods con el nuevo
         jugador añadido
         */
        this.notifyObservers(this.partidaLocal.getJugadores().indexOf(jugador));
    }

}

