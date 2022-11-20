/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;

/**
 * Clase que representa el tablero de la partida.
 *
 * @author Equipo 1
 */
public class Tablero {
//Numero de tablero.

    private String numeroTablero;
    //Casillas del tablero
    private ArrayList<Casilla> casillas = new ArrayList();
    //Jugadores del tablero.
    private ArrayList<Jugador> jugadores = new ArrayList();
//Constructores 

    public Tablero() {
    }

    public Tablero(String numeroTablero) {
        this.numeroTablero = numeroTablero;
    }
//Metodos get y set

    public String getNumeroTablero() {
        return numeroTablero;
    }

    public void setNumeroTablero(String numeroTablero) {
        this.numeroTablero = numeroTablero;
    }

    public ArrayList<Casilla> getCasillas() {
        return casillas;
    }

    public void setCasillas(ArrayList<Casilla> casillas) {
        this.casillas = casillas;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
//Metodo to string.    

    @Override
    public String toString() {
        return "Tablero{" + "numeroTablero=" + numeroTablero + ", casillas=" + casillas + ", jugadores=" + jugadores + '}';
    }

}
