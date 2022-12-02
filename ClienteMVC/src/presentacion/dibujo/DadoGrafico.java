package presentacion.dibujo;

import entidades.Dado;
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
        this.repaint();
    }
    
   
//Metodo que dibujar la seccion de las fichas donde sera colocadas

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
//Cordeandas de fichas Circulos ahi las tengo en la libreta
        CompositorCasilla dadosCompositor = new CompositorCasilla(6);
        for (int i = 0; i < 5; i++) {
            Dado get = dados.get(i);
//            get.cambiarCara();
            Figura cana = new Cana(x[i], y[i], 70, 105, get.isCara(), i, g);
            dadosCompositor.addElemento(cana);
        }

        dadosCompositor.dibujar();
        
    }

  
    
}
