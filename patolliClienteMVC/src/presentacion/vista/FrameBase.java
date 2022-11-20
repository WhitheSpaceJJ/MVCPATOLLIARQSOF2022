package presentacion.vista;

import control.ControlBase;
import java.util.Observable;
import java.util.Observer;

public class FrameBase extends javax.swing.JFrame implements Observer {

    protected ControlBase control;

    public void establecerControl(ControlBase control) {
        this.control = control;
    }

    @Override
    public void update(Observable o, Object o1) {
    }

    public ControlBase getControl() {
        return control;
    }

    public void setControl(ControlBase control) {
        this.control = control;
    }

}
