
package presentacion.dibujo;

import java.awt.Graphics;
import java.util.Objects;


public abstract class Figura {

    protected int posicion;
    protected Graphics g;
    public Figura(int posicion) {
        this.posicion = posicion;
    }

    public abstract void dibujar();

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.posicion);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Figura other = (Figura) obj;
        return Objects.equals(this.posicion, other.posicion);
    }
    
}
