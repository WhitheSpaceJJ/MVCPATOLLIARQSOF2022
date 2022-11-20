
package control;

import clientePatolli.Cliente;
import modelo.ModeloBase;

public class ControlBase {
    protected ModeloBase modelo;
    protected Cliente cliente;

    public void establecerModelo(ModeloBase modelo) {
        this.modelo = modelo;
    }

    public void establecerCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
