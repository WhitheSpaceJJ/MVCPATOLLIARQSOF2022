package presentacion.vista;

import entidades.Dado;
import entidades.Dinero;
import entidades.Ficha;
import entidades.Jugador;
import entidades.Partida;
import entidades.Tablero;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PruebaDibujado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

//        Jugador jugador1 = new Jugador("Jose", "Azul");
//        jugador1.inicializarFichas(6);
//        Jugador jugador2 = new Jugador("Jose1", "Amarillo");
//        jugador1.inicializarFichas(6);
//        Jugador jugador3 = new Jugador("Jose2", "Verde");
//        jugador3.inicializarFichas(6);
//        Jugador jugador4 = new Jugador("Jose3", "Rojo");
//        jugador4.inicializarFichas(6);
//        Tablero tablero= new Tablero("30112022", 10);
//        for (int i = 0; i < tablero.getCasillas().size(); i++) {
//            Ficha ficha=new Ficha(i, jugador1);
//            tablero.getCasillas().get(i).setFicha(ficha);
//        }
//        Partida partida = new Partida(jugador1,tablero, 2000, 100, 4);
////        partida.getJugadores().add(jugador1);
//        partida.getJugadores().add(jugador2);
//        partida.getJugadores().add(jugador3);
//        partida.getJugadores().add(jugador4);
//        List<Dado> dados=new ArrayList<>();
//        for (int i = 0; i <5; i++) {
//         Dado dado=new Dado(false);
//         dados.add(dado);
//        }
//        partida.setDados(dados);
//        
//        for (int i = 0; i < partida.getJugadores().size(); i++) {
//            partida.getJugadores().get(i).setDinero(new Dinero(partida.getMontoJugador()));
//        }
//        
        Jugador jugador1 = new Jugador("Jose", "Azul");
        jugador1.inicializarFichas(6);
        Jugador jugador2 = new Jugador("Jose1", "Rosa");
        jugador2.inicializarFichas(6);
        Jugador jugador3 = new Jugador("Jose2", "Verde");
        jugador3.inicializarFichas(6);
        Jugador jugador4 = new Jugador("Jose3", "Rojo");
        jugador4.inicializarFichas(6);
        Tablero tablero = new Tablero("30112022", 14);
        Random r = new Random();
        for (int i = 0; i < tablero.getCasillas().size(); i++) {
            int x = r.nextInt(5);
            if (x == 1) {
                Ficha ficha = new Ficha(i, jugador1);
                tablero.getCasillas().get(i).setFicha(ficha);
            }
            if (x == 2) {
                Ficha ficha = new Ficha(i, jugador2);
                tablero.getCasillas().get(i).setFicha(ficha);
            }
            if (x == 3) {
                Ficha ficha = new Ficha(i, jugador3);
                tablero.getCasillas().get(i).setFicha(ficha);
            }
            if (x == 4) {
                Ficha ficha = new Ficha(i, jugador4);
                tablero.getCasillas().get(i).setFicha(ficha);
            }
//          
        }
        Partida partida = new Partida(jugador1, tablero, 2000, 100, 4);
//        partida.getJugadores().add(jugador1);
        partida.getJugadores().add(jugador2);
        partida.getJugadores().add(jugador3);
        partida.getJugadores().add(jugador4);
           List<Dado> dados=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Dado dado = new Dado(false);
            dados.add(dado);
        }
        partida.setDados(dados);
        for (int i = 0; i < partida.getJugadores().size(); i++) {
            partida.getJugadores().get(i).setDinero(new Dinero(partida.getMontoJugador()));
        }
        FrameBase fJuego = new FJuego(partida);
//       
        ((FJuego) fJuego).setVisible(true);
//        ((FJuego) fJuego).prepararJuego(partida);

    }

}
