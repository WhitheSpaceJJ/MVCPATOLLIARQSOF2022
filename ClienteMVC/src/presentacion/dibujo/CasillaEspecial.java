
package presentacion.dibujo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 * Clase que representa una casilla de castigo o con triangulo.
 * @author Equipo1
 */
public class CasillaEspecial extends Figura {

    private int[] x;
    private int[] y;
    private Polygon p;

    public CasillaEspecial(int[] x, int[] y, int posicion, Polygon p) {
        super(posicion);
        this.x = x;
        this.y = y;
        this.p = p;
    }

    public CasillaEspecial(int[] x, int[] y, Polygon p, int posicion, Graphics g) {
        super(posicion, g);
        this.x = x;
        this.y = y;
        this.p = p;
    }
    
    
    
//Metodo que se encarga de dibujar las casillas que poseen triangulos


    
    @Override
    public void dibujar() {
        g.setColor(Color.red);
        g.fillPolygon(p);
        g.setColor(Color.black);
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
