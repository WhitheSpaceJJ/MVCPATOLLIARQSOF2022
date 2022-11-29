package entidades;

import java.io.Serializable;
//Clase que representa un dado que es utilizado por una partida

public class Dado implements Serializable {
    private boolean cara;
//Constructor
    public Dado(boolean cara) {
        this.cara = cara;
    }
//Metodos Get y Set 
    public boolean isCara() {
        return cara;
    }

    public void setCara(boolean cara) {
        this.cara = cara;
    }

    @Override
    public String toString() {
        return "Dado{" + "cara=" + cara + '}';
    }
  
}
