package presentacion.dibujo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;

public class Cana extends Figura {

    private int x;
    private int y;
    private int width;
    private int heigth;
    private boolean cara;

//    public Cana(int x, int y, int width, int heigth, boolean cara, int posicion) {
//        super(posicion);
//        this.x = x;
//        this.y = y;
//        this.width = width;
//        this.heigth = heigth;
//        this.cara = cara;
//    }
    public Cana(int x, int y, int width, int heigth, boolean cara, int posicion, Graphics g) {
        super(posicion, g);
        this.x = x;
        this.y = y;
        this.width = width;
        this.heigth = heigth;
        this.cara = cara;
    }


    /*
    Metodo que se encargar de dibujar la caña de acuerdo a lo que se solicite la clase de dado grafico
     */
    @Override
    public void dibujar() {
        if (cara) {
            g.setColor(Color.BLACK);
            g.drawRect(x, y, width, heigth);
            g.fillOval(x+25, y+50, 30, 30);

        } else {
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
