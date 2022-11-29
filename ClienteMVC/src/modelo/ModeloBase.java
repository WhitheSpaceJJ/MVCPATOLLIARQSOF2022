package modelo;

import java.util.Observable;

public class ModeloBase extends Observable {

    public void actualizarModelo() {
        this.setChanged();
        this.notifyObservers();
    }
}
