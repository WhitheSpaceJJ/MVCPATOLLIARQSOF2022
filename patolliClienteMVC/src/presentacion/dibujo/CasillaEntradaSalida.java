package presentacion.dibujo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class CasillaEntradaSalida extends Figura {

    private int[] x;
    private int[] y;
    private int marcador;

    public CasillaEntradaSalida(int[] x, int[] y, int posicion) {
        super(posicion);
        this.x = x;
        this.y = y;
    }

    public CasillaEntradaSalida(int[] x, int[] y, int marcador, int posicion) {
        super(posicion);
        this.x = x;
        this.y = y;
        this.marcador = marcador;
    }

    public int getMarcador() {
        return marcador;
    }

    public void setMarcador(int marcador) {
        this.marcador = marcador;
    }
//metodo que dibuja la casilla de entrada y del tablero
    @Override
    public void dibujar() {
        g.setColor(Color.yellow);
        Polygon relleno = new Polygon(x, y, x.length);
        g.fillPolygon(relleno);
        g.setColor(Color.black);
        Polygon borde = new Polygon(x, y, x.length);
        g.drawPolygon(borde);
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
