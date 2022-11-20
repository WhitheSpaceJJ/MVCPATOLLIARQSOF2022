
package presentacion.dibujo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class CasillaBordeada extends Figura {

    private int[] x;
    private int[] y;
    private Color color;
    
    public CasillaBordeada(int[] x, int[] y,int posicion) {
        super(posicion);
        this.x = x;
        this.y = y;
    }

    public CasillaBordeada(int[] x, int[] y, Color color, int posicion) {
        super(posicion);
        this.x = x;
        this.y = y;
        this.color = color;
    }

    
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void dibujar() {
        g.setColor(color);
        //Se pinta en rojo solo con el fin  de identificarlo.
        //Quitar
//        g.setColor(Color.red);
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
