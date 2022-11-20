package presentacion.dibujo;

import dominio.Dado;
import java.util.List;
import javax.swing.JPanel;
import java.awt.Graphics;

public class DadoGrafico extends JPanel {
    //Lista de cordaneas x

    private int x[];
    private int y[];
    private List<Dado> dados;

    public DadoGrafico(List<Dado> dados) {
        this.dados = dados;
    }

    public DadoGrafico(int[] x, int[] y, List<Dado> dados) {
        this.x = x;
        this.y = y;
        this.dados = dados;
    }

    public List<Dado> getDados() {
        return dados;
    }

    public void setDados(List<Dado> dados) {
        this.dados = dados;
    }

    public void actualizarDados(List<Dado> dados) {
        this.dados = dados;
    }

    @Override
    public void paintComponent(Graphics g) {
    }
    @Override
    public void repaint() {
    }
   
}
