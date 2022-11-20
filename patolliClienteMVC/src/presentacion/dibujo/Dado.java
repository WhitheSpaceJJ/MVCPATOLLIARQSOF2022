/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.dibujo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;

/**
 * Clase que dibuja los dados. Sera utilizado por el panel de tablero.
 * @author Judi
 */
public class Dado extends Figura {

    private int x;
    private int y;
    private int width;
    private int heigth;
    private boolean cara;
    private Graphics g;

    public Dado(int x, int y, int width, int heigth, boolean cara, Graphics g, String posicion) {
        super(posicion);
        this.x = x;
        this.y = y;
        this.width = width;
        this.heigth = heigth;
        this.cara = cara;
        this.g = g;
    }

    @Override
    public void dibujar() {
        if (cara) {
            //Aun no implementando         g.drawOval(52, 87, 35, 35);
        } else {
            g.setColor(Color.BLACK);
            g.drawRect(x, y, width, heigth);
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    public boolean isCara() {
        return cara;
    }

    public void setCara(boolean cara) {
        this.cara = cara;
    }

    public Graphics getG() {
        return g;
    }

    public void setG(Graphics g) {
        this.g = g;
    }

}
