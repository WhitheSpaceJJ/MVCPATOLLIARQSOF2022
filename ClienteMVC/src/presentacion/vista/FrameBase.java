package presentacion.vista;

import control.ControlBase;
import java.util.Observable;
import java.util.Observer;

public abstract class FrameBase extends javax.swing.JFrame implements Observer {

    protected ControlBase control;

    public FrameBase() {
    }

    public FrameBase(ControlBase control) {
        this.control = control;
    }

    public void establecerControl(ControlBase control) {
        this.control = control;
    }

    public ControlBase getControl() {
        return control;
    }

    public void setControl(ControlBase control) {
        this.control = control;
    }
//Metodo update abtracto
    @Override
    public abstract void update(Observable o, Object o1);

}
