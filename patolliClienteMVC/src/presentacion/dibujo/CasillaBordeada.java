/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.dibujo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 * Casilla que representa la punta de un aspa del tablero.
 * @author Judi
 */
public class CasillaBordeada extends Figura {

    private int[] x;
    private int[] y;
    private Graphics g;

    public CasillaBordeada(int[] x, int[] y, Graphics g, String posicion) {
        super(posicion);
        this.x = x;
        this.y = y;
        this.g = g;
    }

    @Override
    public void dibujar() {
        //Se pinta en rojo solo con el fin  de identificarlo.
        g.setColor(Color.red);
        Polygon polygon1 = new Polygon(x, y, x.length);
        g.drawPolygon(polygon1);
    }

    public int[] getX() {
        return x;
    }

    public void setX(int[] x) {
        this.x = x;
    }

    public int[] getY() {
        return y;
    }

    public void setY(int[] y) {
        this.y = y;
    }

    public Graphics getG() {
        return g;
    }

    public void setG(Graphics g) {
        this.g = g;
    }


}
