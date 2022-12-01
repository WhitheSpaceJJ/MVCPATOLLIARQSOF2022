package presentacion.dibujo;

import entidades.Casilla;
import entidades.Tablero;
import entidades.TipoCasilla;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import javax.swing.JPanel;

/**
 * CLase que realiza el dibujo del tablero y lanzamienento de dados.
 *
 * @author Equipo1
 */
public class TableroGrafico extends JPanel {

    private int tamaño;
    private Tablero tablero;
//

    public TableroGrafico(Tablero tablero) {
        this.tablero = tablero;
        this.tamaño = tablero.getTamano();
    }

    public TableroGrafico() {
    }
//
//    public TableroGrafico(int tamaño) {
//        this.tamaño = tamaño;
//    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public void actualizarTablero(Tablero tablero) {
        this.tablero = tablero;
        repaint();
    }

//Metodo que pinta el tablero, en base al tablero este se reactualizara
    @Override
    public void paintComponent(Graphics g) {

//        Se reactualizara el metodo para dibujar con valores mas facilmente. ya que se tenga el tablero lleno
        super.paintComponent(g);

        List<Polygon> triangulos = new ArrayList<>();

        List<List<Integer>> listaX14Normales = new ArrayList<List<Integer>>();

        List<List<Integer>> listay14Normales = new ArrayList<List<Integer>>();

        //1-14
        listaX14Normales.add(Arrays.asList(340, 380, 408, 368));
        listaX14Normales.add(Arrays.asList(368, 408, 436, 396));
        listaX14Normales.add(Arrays.asList(396, 436, 464, 424));
        listaX14Normales.add(Arrays.asList(424, 464, 492, 452));
        listaX14Normales.add(Arrays.asList(452, 492, 520, 480));
        listaX14Normales.add(Arrays.asList(480, 520, 548, 508));
        listaX14Normales.add(Arrays.asList(508, 548, 576, 560));
        listaX14Normales.add(Arrays.asList(468, 508, 560, 496));
        listaX14Normales.add(Arrays.asList(440, 480, 508, 468));
        listaX14Normales.add(Arrays.asList(412, 452, 480, 440));
        listaX14Normales.add(Arrays.asList(384, 424, 452, 412));
        listaX14Normales.add(Arrays.asList(356, 396, 424, 384));
        listaX14Normales.add(Arrays.asList(328, 368, 396, 356));
        listaX14Normales.add(Arrays.asList(300, 340, 368, 328));
        listaX14Normales.add(Arrays.asList(260, 300, 340, 300));
        listaX14Normales.add(Arrays.asList(260, 300, 272, 232));
        listaX14Normales.add(Arrays.asList(232, 272, 244, 204));
        listaX14Normales.add(Arrays.asList(204, 244, 216, 176));
        listaX14Normales.add(Arrays.asList(176, 216, 188, 148));
        listaX14Normales.add(Arrays.asList(148, 188, 160, 120));
        listaX14Normales.add(Arrays.asList(120, 160, 132, 92));
        listaX14Normales.add(Arrays.asList(40, 92, 132, 104));
        listaX14Normales.add(Arrays.asList(52, 92, 40, 24));
        listaX14Normales.add(Arrays.asList(80, 120, 92, 52));
        listaX14Normales.add(Arrays.asList(108, 148, 120, 80));
        listaX14Normales.add(Arrays.asList(136, 176, 148, 108));
        listaX14Normales.add(Arrays.asList(164, 204, 176, 136));
        listaX14Normales.add(Arrays.asList(192, 232, 204, 164));
        listaX14Normales.add(Arrays.asList(220, 260, 232, 192));
        //Centrales
//        listaX14Normales.add(Arrays.asList(260, 300, 340, 300));
        listaX14Normales.add(Arrays.asList(220, 260, 300, 260));
//      listaX14Normales.add(Arrays.asList(300, 340, 380, 340));  

        listaX14Normales.add(Arrays.asList(220, 260, 232, 192));
        listaX14Normales.add(Arrays.asList(192, 232, 204, 164));
        listaX14Normales.add(Arrays.asList(164, 204, 176, 136));
        listaX14Normales.add(Arrays.asList(136, 176, 148, 108));
        listaX14Normales.add(Arrays.asList(108, 148, 120, 80));
        listaX14Normales.add(Arrays.asList(80, 120, 92, 52));
        listaX14Normales.add(Arrays.asList(52, 92, 40, 24));
        listaX14Normales.add(Arrays.asList(92, 132, 104, 40));
        listaX14Normales.add(Arrays.asList(120, 160, 132, 92));
        listaX14Normales.add(Arrays.asList(148, 188, 160, 120));
        listaX14Normales.add(Arrays.asList(176, 216, 188, 148));
        listaX14Normales.add(Arrays.asList(204, 244, 216, 176));
        listaX14Normales.add(Arrays.asList(232, 272, 244, 204));
        listaX14Normales.add(Arrays.asList(260, 300, 272, 232));

        //1-14
        listay14Normales.add(Arrays.asList(260, 300, 272, 232));
        listay14Normales.add(Arrays.asList(232, 272, 244, 204));
        listay14Normales.add(Arrays.asList(204, 244, 216, 176));
        listay14Normales.add(Arrays.asList(176, 216, 188, 148));
        listay14Normales.add(Arrays.asList(148, 188, 160, 120));
        listay14Normales.add(Arrays.asList(120, 160, 132, 92));
        listay14Normales.add(Arrays.asList(92, 132, 104, 40));
        listay14Normales.add(Arrays.asList(52, 92, 40, 24));
        listay14Normales.add(Arrays.asList(80, 120, 92, 52));
        listay14Normales.add(Arrays.asList(108, 148, 120, 80));
        listay14Normales.add(Arrays.asList(136, 176, 148, 108));
        listay14Normales.add(Arrays.asList(164, 204, 176, 136));
        listay14Normales.add(Arrays.asList(192, 232, 204, 164));
        listay14Normales.add(Arrays.asList(220, 260, 232, 192));
        listay14Normales.add(Arrays.asList(260, 220, 260, 300));
        listay14Normales.add(Arrays.asList(260, 220, 192, 232));
        listay14Normales.add(Arrays.asList(232, 192, 164, 204));
        listay14Normales.add(Arrays.asList(204, 164, 136, 176));
        listay14Normales.add(Arrays.asList(176, 136, 108, 148));
        listay14Normales.add(Arrays.asList(148, 108, 80, 120));
        listay14Normales.add(Arrays.asList(120, 80, 52, 92));
        listay14Normales.add(Arrays.asList(40, 92, 52, 24));
        listay14Normales.add(Arrays.asList(132, 92, 40, 104));
        listay14Normales.add(Arrays.asList(160, 120, 92, 132));
        listay14Normales.add(Arrays.asList(188, 148, 120, 160));
        listay14Normales.add(Arrays.asList(216, 176, 148, 188));
        listay14Normales.add(Arrays.asList(244, 204, 176, 216));
        listay14Normales.add(Arrays.asList(272, 232, 204, 244));
        listay14Normales.add(Arrays.asList(300, 260, 232, 272));
//Centrales
//        listay14Normales.add(Arrays.asList(340, 300, 340, 380));
        listay14Normales.add(Arrays.asList(300, 260, 300, 340));
//     listay14Normales.add(Arrays.asList(300, 260, 300, 340));

        listay14Normales.add(Arrays.asList(300, 340, 368, 328));
        listay14Normales.add(Arrays.asList(328, 368, 396, 356));
        listay14Normales.add(Arrays.asList(356, 396, 424, 384));
        listay14Normales.add(Arrays.asList(384, 424, 452, 412));
        listay14Normales.add(Arrays.asList(412, 452, 480, 440));
        listay14Normales.add(Arrays.asList(440, 480, 508, 468));
        listay14Normales.add(Arrays.asList(468, 508, 560, 496));
        listay14Normales.add(Arrays.asList(508, 548, 576, 560));
        listay14Normales.add(Arrays.asList(480, 520, 548, 508));
        listay14Normales.add(Arrays.asList(452, 492, 520, 480));
        listay14Normales.add(Arrays.asList(424, 464, 492, 452));
        listay14Normales.add(Arrays.asList(396, 436, 464, 424));
        listay14Normales.add(Arrays.asList(368, 408, 436, 396));
        listay14Normales.add(Arrays.asList(340, 380, 408, 368));

        Polygon p12 = new Polygon();
        p12.addPoint(120, 480);
        p12.addPoint(80, 440);
        p12.addPoint(73, 447);

        Polygon p11 = new Polygon();
        p11.addPoint(120, 480);
        p11.addPoint(87, 433);
        p11.addPoint(80, 440);

        Polygon p10 = new Polygon();
        p10.addPoint(120, 480);
        p10.addPoint(160, 520);
        p10.addPoint(153, 527);

        Polygon p9 = new Polygon();
        p9.addPoint(120, 480);
        p9.addPoint(167, 513);
        p9.addPoint(160, 520);

        if (tamaño == 14) {

            Polygon p4 = new Polygon();
            p4.addPoint(440, 80);
            p4.addPoint(480, 120);
            p4.addPoint(433, 87);

            Polygon p3 = new Polygon();
            p3.addPoint(480, 120);
            p3.addPoint(440, 80);
            p3.addPoint(447, 73);

            Polygon p2 = new Polygon();
            p2.addPoint(480, 120);
            p2.addPoint(513, 167);
            p2.addPoint(520, 160);

            Polygon p1 = new Polygon();
            p1.addPoint(480, 120);
            p1.addPoint(520, 160);
            p1.addPoint(527, 153);
//Nuevo
            Polygon p8 = new Polygon();
            p8.addPoint(120, 120);
            p8.addPoint(80, 160);
            p8.addPoint(87, 167);

            Polygon p7 = new Polygon();
            p7.addPoint(120, 120);
            p7.addPoint(73, 153);
            p7.addPoint(80, 160);

            Polygon p6 = new Polygon();
            p6.addPoint(120, 120);
            p6.addPoint(160, 80);
            p6.addPoint(167, 87);

            Polygon p5 = new Polygon();
            p5.addPoint(120, 120);
            p5.addPoint(153, 73);
            p5.addPoint(160, 80);

            triangulos.add(p1);
            triangulos.add(p2);
            triangulos.add(p3);
            triangulos.add(p4);
            triangulos.add(p5);
            triangulos.add(p6);
            triangulos.add(p7);
            triangulos.add(p8);
            triangulos.add(p12);
            triangulos.add(p11);
            triangulos.add(p10);
            triangulos.add(p9);

            CompositorCasilla tableroGrafico = new CompositorCasilla(1);
            int triangulosContador = 0;
            for (int i = 0; i < 37; i++) {
                Casilla casilla = this.tablero.getCasillas().get(i);
                Figura f = null;
                switch (casilla.getTipo()) {
                    case EntradaSalida:
                        f = new CasillaEntradaSalida(
                                new int[]{
                                    listaX14Normales.get(i).get(0),
                                    listaX14Normales.get(i).get(1),
                                    listaX14Normales.get(i).get(2),
                                    listaX14Normales.get(i).get(3)
                                },
                                new int[]{
                                    listay14Normales.get(i).get(0),
                                    listay14Normales.get(i).get(1),
                                    listay14Normales.get(i).get(2),
                                    listay14Normales.get(i).get(3)
                                },
                                (i + 1), g);
                        ((CasillaEntradaSalida) f).setMarcador((i + 1));
                        break;
                    case Normal:
                        f = new CasillaNormal(
                                new int[]{
                                    listaX14Normales.get(i).get(0),
                                    listaX14Normales.get(i).get(1),
                                    listaX14Normales.get(i).get(2),
                                    listaX14Normales.get(i).get(3)
                                },
                                new int[]{
                                    listay14Normales.get(i).get(0),
                                    listay14Normales.get(i).get(1),
                                    listay14Normales.get(i).get(2),
                                    listay14Normales.get(i).get(3)
                                },
                                (i + 1), g);
                        break;
                    case Central:
                        f = new CasillaNormal(
                                new int[]{
                                    listaX14Normales.get(i).get(0),
                                    listaX14Normales.get(i).get(1),
                                    listaX14Normales.get(i).get(2),
                                    listaX14Normales.get(i).get(3)
                                },
                                new int[]{
                                    listay14Normales.get(i).get(0),
                                    listay14Normales.get(i).get(1),
                                    listay14Normales.get(i).get(2),
                                    listay14Normales.get(i).get(3)
                                },
                                (i + 1), g);
                        break;

                    case Penalizacion:
                        f = new CasillaEspecial(
                                new int[]{
                                    listaX14Normales.get(i).get(0),
                                    listaX14Normales.get(i).get(1),
                                    listaX14Normales.get(i).get(2),
                                    listaX14Normales.get(i).get(3)
                                },
                                new int[]{
                                    listay14Normales.get(i).get(0),
                                    listay14Normales.get(i).get(1),
                                    listay14Normales.get(i).get(2),
                                    listay14Normales.get(i).get(3)
                                },
                                triangulos.get(triangulosContador), (i + 1), g);
                        triangulosContador += 1;
                        break;
                    case Bordeada:
                        f = new CasillaBordeada(
                                new int[]{
                                    listaX14Normales.get(i).get(0),
                                    listaX14Normales.get(i).get(1),
                                    listaX14Normales.get(i).get(2),
                                    listaX14Normales.get(i).get(3)
                                },
                                new int[]{
                                    listay14Normales.get(i).get(0),
                                    listay14Normales.get(i).get(1),
                                    listay14Normales.get(i).get(2),
                                    listay14Normales.get(i).get(3)
                                },
                                Color.RED,
                                (i + 1),
                                g);
                        break;
                    default:
                        break;
                }
                tableroGrafico.addElemento(f);
            }
            tableroGrafico.dibujar();

//         
//            int xD1[] = {300, 340, 368, 328};
//            int yD1[] = {380, 340, 368, 408};
//            Figura cD1 = new CasillaEntradaSalida(xD1, yD1, g, "cB1");
//            int xD2[] = {328, 368, 396, 356};
//            int yD2[] = {408, 368, 396, 436};
//            Figura cD2 = new CasillaNormal(xD2, yD2, g, "cD2");
//            int xD3[] = {356, 396, 424, 384};
//            int yD3[] = {436, 396, 424, 464};
//            Figura cD3 = new CasillaNormal(xD3, yD3, g, "cD3");
//            int xD4[] = {384, 424, 452, 412};
//            int yD4[] = {464, 424, 452, 492};
//            Figura cD4 = new CasillaNormal(xD4, yD4, g, "cD4");
//            int xD5[] = {412, 452, 480, 440};
//            int yD5[] = {492, 452, 480, 520};
//            Polygon cD5T = new Polygon();
//            cD5T.addPoint(480, 480);
//            cD5T.addPoint(520, 440);
//            cD5T.addPoint(527, 447);
//            Figura cD5 = new CasillaEspecial(xD5, yD5, g, "cD5", cD5T);
//            int xD6[] = {440, 480, 508, 468};
//            int yD6[] = {520, 480, 508, 548};
//            Polygon cD6T = new Polygon();
//            cD6T.addPoint(480, 480);
//            cD6T.addPoint(513, 433);
//            cD6T.addPoint(520, 440);
//            Figura cD6 = new CasillaEspecial(xD6, yD6, g, "cD6", cD6T);
//            int xD7[] = {468, 508, 560, 496};
//            int yD7[] = {548, 508, 560, 576};
//            Figura cD7 = new CasillaBordeada(xD7, yD7, g, "cD7");
//            int xD8[] = {508, 548, 576, 560};
//            int yD8[] = {508, 468, 496, 560};
//            Figura cD8 = new CasillaBordeada(xD8, yD8, g, "cD8");
//            int xD9[] = {480, 520, 548, 508};
//            int yD9[] = {480, 440, 468, 508};
//            Polygon cD9T = new Polygon();
//            cD9T.addPoint(480, 480);
//            cD9T.addPoint(440, 520);
//            cD9T.addPoint(447, 527);
//            Figura cD9 = new CasillaEspecial(xD9, yD9, g, "cD9", cD9T);
//            int xD10[] = {452, 492, 520, 480};
//            int yD10[] = {452, 412, 440, 480};
//            Polygon cD10T = new Polygon();
//            cD10T.addPoint(480, 480);
//            cD10T.addPoint(433, 513);
//            cD10T.addPoint(440, 520);
//            Figura cD10 = new CasillaEspecial(xD10, yD10, g, "cD10", cD10T);
//            int xD11[] = {424, 464, 492, 452};
//            int yD11[] = {424, 384, 412, 452};
//            Figura cD11 = new CasillaNormal(xD11, yD11, g, "cD11");
//            int xD12[] = {396, 436, 464, 424};
//            int yD12[] = {396, 356, 384, 424};
//            Figura cD12 = new CasillaNormal(xD12, yD12, g, "cD12");
//            int xD13[] = {368, 408, 436, 396};
//            int yD13[] = {368, 328, 356, 396};
//            Figura cD13 = new CasillaNormal(xD13, yD13, g, "cD13");
//            int xD14[] = {340, 380, 408, 368};
//            int yD14[] = {340, 300, 328, 368};
//            Figura cD14 = new CasillaNormal(xD14, yD14, g, "cD14");
//            //    CompositorCasilla deB = new CompositorCasilla("deB");
//            CompositorCasilla deB = new CompositorCasilla(4);
//            deB.addElemento(cD1);
//            deB.addElemento(cD2);
//            deB.addElemento(cD3);
//            deB.addElemento(cD4);
//            deB.addElemento(cD5);
//            deB.addElemento(cD6);
//            deB.addElemento(cD7);
//            deB.addElemento(cD8);
//            deB.addElemento(cD9);
//            deB.addElemento(cD10);
//            deB.addElemento(cD11);
//            deB.addElemento(cD12);
//            deB.addElemento(cD13);
//            deB.addElemento(cD14);
//            deB.dibujar();
//
//            int xCE1[] = {300, 340, 380, 340};
//            int yCE1[] = {300, 260, 300, 340};
//            Figura cCE1 = new CasillaNormal(xCE1, yCE1, g, "cCE1");
//            int xCE2[] = {260, 300, 340, 300};
//            int yCE2[] = {260, 220, 260, 300};
//            Figura cCE2 = new CasillaNormal(xCE2, yCE2, g, "cCE2");
//            int xCE3[] = {220, 260, 300, 260};
//            int yCE3[] = {300, 260, 300, 340};
//            Figura cCE3 = new CasillaNormal(xCE3, yCE3, g, "cCE3");
//            int xCE4[] = {260, 300, 340, 300};
//            int yCE4[] = {340, 300, 340, 380};
//            Figura cCE4 = new CasillaNormal(xCE4, yCE4, g, "cCE4");
////            CompositorCasilla ce = new CompositorCasilla("ce");
//            CompositorCasilla ce = new CompositorCasilla(0);
//            ce.addElemento(cCE1);
//            ce.addElemento(cCE2);
//            ce.addElemento(cCE3);
//            ce.addElemento(cCE4);
//            ce.dibujar();
        }
        /*else if (tamaño == 12) {
            int xA1[] = {260, 300, 272, 232};
            int yA1[] = {260, 220, 192, 232};
            Figura cA1 = new CasillaEntradaSalida(xA1, yA1, g, "cA1");
            int xA2[] = {232, 272, 244, 204};
            int yA2[] = {232, 192, 164, 204};
            Figura cA2 = new CasillaNormal(xA2, yA2, g, "cA2");
            int xA3[] = {204, 244, 216, 176};
            int yA3[] = {204, 164, 136, 176};
            Figura cA3 = new CasillaNormal(xA3, yA3, g, "cA3");
            int xA4[] = {176, 216, 188, 148};
            int yA4[] = {176, 136, 108, 148};
            Polygon cA4T = new Polygon();
            cA4T.addPoint(148, 148);
            cA4T.addPoint(108, 188);
            cA4T.addPoint(115, 195);
            Figura cA4 = new CasillaEspecial(xA4, yA4, g, "cA4", cA4T);
            int xA5[] = {148, 188, 160, 120};
            int yA5[] = {148, 108, 80, 120};
            Polygon cA5T = new Polygon();
            cA5T.addPoint(148, 148);
            cA5T.addPoint(101, 181);
            cA5T.addPoint(108, 188);
            Figura cA5 = new CasillaEspecial(xA5, yA5, g, "cA5", cA5T);
            int xA6[] = {120, 160, 132, 80};
            int yA6[] = {120, 80, 52, 80};
            Figura cA6 = new CasillaBordeada(xA6, yA6, g, "cA6");
            int xA9[] = {80, 120, 80, 52};
            int yA9[] = {160, 120, 80, 132};
            Figura cA9 = new CasillaBordeada(xA9, yA9, g, "cA9");
            int xA10[] = {108, 148, 120, 80};
            int yA10[] = {188, 148, 120, 160};
            Polygon cA10T = new Polygon();
            cA10T.addPoint(148, 148);
            cA10T.addPoint(188, 108);
            cA10T.addPoint(195, 115);
            Figura cA10 = new CasillaEspecial(xA10, yA10, g, "cA10", cA10T);
            int xA11[] = {136, 176, 148, 108};
            int yA11[] = {216, 176, 148, 188};
            Polygon cA11T = new Polygon();
            cA11T.addPoint(148, 148);
            cA11T.addPoint(181, 101);
            cA11T.addPoint(188, 108);
            Figura cA11 = new CasillaEspecial(xA11, yA11, g, "cA11", cA11T);
            int xA12[] = {164, 204, 176, 136};
            int yA12[] = {244, 204, 176, 216};
            Figura cA12 = new CasillaNormal(xA12, yA12, g, "cA12");
            int xA13[] = {192, 232, 204, 164};
            int yA13[] = {272, 232, 204, 244};
            Figura cA13 = new CasillaNormal(xA13, yA13, g, "cA13");
            int xA14[] = {220, 260, 232, 192};
            int yA14[] = {300, 260, 232, 272};
            Figura cA14 = new CasillaNormal(xA14, yA14, g, "cA14");
            // CompositorCasilla izA = new CompositorCasilla("izA");
            CompositorCasilla izA = new CompositorCasilla(2);

            izA.addElemento(cA1);
            izA.addElemento(cA2);
            izA.addElemento(cA3);
            izA.addElemento(cA4);
            izA.addElemento(cA5);
            izA.addElemento(cA6);
            izA.addElemento(cA9);
            izA.addElemento(cA10);
            izA.addElemento(cA11);
            izA.addElemento(cA12);
            izA.addElemento(cA13);
            izA.addElemento(cA14);
            izA.dibujar();

            int xB1[] = {300, 340, 368, 328};
            int yB1[] = {220, 260, 232, 192};
            Figura cB1 = new CasillaNormal(xB1, yB1, g, "cB1");
            int xB2[] = {328, 368, 396, 356};
            int yB2[] = {192, 232, 204, 164};
            Figura cB2 = new CasillaNormal(xB2, yB2, g, "cB2");
            int xB3[] = {356, 396, 424, 384};
            int yB3[] = {164, 204, 176, 136};
            Figura cB3 = new CasillaNormal(xB3, yB3, g, "cB3");
            int xB4[] = {384, 424, 452, 412};
            int yB4[] = {136, 176, 148, 108};
            Polygon cB4T = new Polygon();
            cB4T.addPoint(412, 108);
            cB4T.addPoint(452, 148);
            cB4T.addPoint(405, 115);
            Figura cB4 = new CasillaEspecial(xB4, yB4, g, "cB4", cB4T);
            int xB5[] = {412, 452, 480, 440};
            int yB5[] = {108, 148, 120, 80};
            Polygon cB5T = new Polygon();
            cB5T.addPoint(452, 148);
            cB5T.addPoint(412, 108);
            cB5T.addPoint(419, 101);
            Figura cB5 = new CasillaEspecial(xB5, yB5, g, "cB5", cB5T);
            int xB6[] = {440, 480, 520, 468};
            int yB6[] = {80, 120, 80, 52};
            Figura cB6 = new CasillaBordeada(xB6, yB6, g, "cB6");
            int xB9[] = {480, 520, 548, 520};
            int yB9[] = {120, 160, 132, 80};
            Figura cB9 = new CasillaBordeada(xB9, yB9, g, "cB9");
            int xB10[] = {452, 492, 520, 480};
            int yB10[] = {148, 188, 160, 120};
            Polygon cB10T = new Polygon();
            cB10T.addPoint(452, 148);
            cB10T.addPoint(485, 195);
            cB10T.addPoint(492, 188);
            Figura cB10 = new CasillaEspecial(xB10, yB10, g, "cB10", cB10T);
            int xB11[] = {424, 464, 492, 452};
            int yB11[] = {176, 216, 188, 148};
            Polygon cB11T = new Polygon();
            cB11T.addPoint(452, 148);
            cB11T.addPoint(492, 188);
            cB11T.addPoint(499, 181);
            Figura cB11 = new CasillaEspecial(xB11, yB11, g, "cB11", cB11T);
            int xB12[] = {396, 436, 464, 424};
            int yB12[] = {204, 244, 216, 176};
            Figura cB12 = new CasillaNormal(xB12, yB12, g, "cB12");
            int xB13[] = {368, 408, 436, 396};
            int yB13[] = {232, 272, 244, 204};
            Figura cB13 = new CasillaNormal(xB13, yB13, g, "cB13");
            int xB14[] = {340, 380, 408, 368};
            int yB14[] = {260, 300, 272, 232};
            Figura cB14 = new CasillaEntradaSalida(xB14, yB14, g, "cB14");
//            CompositorCasilla deA = new CompositorCasilla("deA");
            CompositorCasilla deA = new CompositorCasilla(1);

            deA.addElemento(cB1);
            deA.addElemento(cB2);
            deA.addElemento(cB3);
            deA.addElemento(cB4);
            deA.addElemento(cB5);
            deA.addElemento(cB6);
            deA.addElemento(cB9);
            deA.addElemento(cB10);
            deA.addElemento(cB11);
            deA.addElemento(cB12);
            deA.addElemento(cB13);
            deA.addElemento(cB14);
            deA.dibujar();

            int xD1[] = {300, 340, 368, 328};
            int yD1[] = {380, 340, 368, 408};
            Figura cD1 = new CasillaEntradaSalida(xD1, yD1, g, "cB1");
            int xD2[] = {328, 368, 396, 356};
            int yD2[] = {408, 368, 396, 436};
            Figura cD2 = new CasillaNormal(xD2, yD2, g, "cD2");
            int xD3[] = {356, 396, 424, 384};
            int yD3[] = {436, 396, 424, 464};
            Figura cD3 = new CasillaNormal(xD3, yD3, g, "cD3");
            int xD4[] = {384, 424, 452, 412};
            int yD4[] = {464, 424, 452, 492};
            Polygon cD4T = new Polygon();
            cD4T.addPoint(452, 452);
            cD4T.addPoint(492, 412);
            cD4T.addPoint(499, 419);
            Figura cD4 = new CasillaEspecial(xD4, yD4, g, "cD4", cD4T);
            int xD5[] = {412, 452, 480, 440};
            int yD5[] = {492, 452, 480, 520};
            Polygon cD5T = new Polygon();
            cD5T.addPoint(452, 452);
            cD5T.addPoint(485, 405);
            cD5T.addPoint(492, 412);
            Figura cD5 = new CasillaEspecial(xD5, yD5, g, "cD5", cD5T);
            int xD6[] = {440, 480, 520, 468};
            int yD6[] = {520, 480, 520, 548};
            Figura cD6 = new CasillaBordeada(xD6, yD6, g, "cD6");
            int xD9[] = {480, 520, 548, 520};
            int yD9[] = {480, 440, 468, 520};
            Figura cD9 = new CasillaBordeada(xD9, yD9, g, "cD9");
            int xD10[] = {452, 492, 520, 480};
            int yD10[] = {452, 412, 440, 480};

            Polygon cD10T = new Polygon();
            cD10T.addPoint(452, 452);
            cD10T.addPoint(412, 492);
            cD10T.addPoint(419, 499);
            Figura cD10 = new CasillaEspecial(xD10, yD10, g, "cD10", cD10T);
            int xD11[] = {424, 464, 492, 452};
            int yD11[] = {424, 384, 412, 452};
            Polygon cD11T = new Polygon();
            cD11T.addPoint(452, 452);
            cD11T.addPoint(405, 485);
            cD11T.addPoint(412, 492);
            Figura cD11 = new CasillaEspecial(xD11, yD11, g, "cD11", cD11T);
            int xD12[] = {396, 436, 464, 424};
            int yD12[] = {396, 356, 384, 424};
            Figura cD12 = new CasillaNormal(xD12, yD12, g, "cD12");
            int xD13[] = {368, 408, 436, 396};
            int yD13[] = {368, 328, 356, 396};
            Figura cD13 = new CasillaNormal(xD13, yD13, g, "cD13");
            int xD14[] = {340, 380, 408, 368};
            int yD14[] = {340, 300, 328, 368};
            Figura cD14 = new CasillaNormal(xD14, yD14, g, "cD14");
//            CompositorCasilla deB = new CompositorCasilla("deB");
            CompositorCasilla deB = new CompositorCasilla(4);

            deB.addElemento(cD1);
            deB.addElemento(cD2);
            deB.addElemento(cD3);
            deB.addElemento(cD4);
            deB.addElemento(cD5);
            deB.addElemento(cD6);
            deB.addElemento(cD9);
            deB.addElemento(cD10);
            deB.addElemento(cD11);
            deB.addElemento(cD12);
            deB.addElemento(cD13);
            deB.addElemento(cD14);
            deB.dibujar();

            int xC1[] = {260, 300, 272, 232};
            int yC1[] = {340, 380, 408, 368};
            Figura cC1 = new CasillaNormal(xC1, yC1, g, "cC1");
            int xC2[] = {232, 272, 244, 204};
            int yC2[] = {368, 408, 436, 396};
            Figura cC2 = new CasillaNormal(xC2, yC2, g, "cC2");
            int xC3[] = {204, 244, 216, 176};
            int yC3[] = {396, 436, 464, 424};
            Figura cC3 = new CasillaNormal(xC3, yC3, g, "cC3");
            int xC4[] = {176, 216, 188, 148};
            int yC4[] = {424, 464, 492, 452};
            Polygon cC4T = new Polygon();
            cC4T.addPoint(148, 452);
            cC4T.addPoint(108, 412);
            cC4T.addPoint(101, 419);
            Figura cC4 = new CasillaEspecial(xC4, yC4, g, "cC4", cC4T);
            int xC5[] = {148, 188, 160, 120};
            int yC5[] = {452, 492, 520, 480};
            Polygon cC5T = new Polygon();
            cC5T.addPoint(148, 452);
            cC5T.addPoint(115, 405);
            cC5T.addPoint(108, 412);
            Figura cC5 = new CasillaEspecial(xC5, yC5, g, "cC5", cC5T);
            int xC6[] = {120, 160, 132, 80};
            int yC6[] = {480, 520, 548, 520};
            Figura cC6 = new CasillaBordeada(xC6, yC6, g, "cC6");
            int xC9[] = {80, 120, 80, 52};
            int yC9[] = {440, 480, 520, 468};
            Figura cC9 = new CasillaBordeada(xC9, yC9, g, "cC9");
            int xC10[] = {108, 148, 120, 80};
            int yC10[] = {412, 452, 480, 440};

            Polygon cC10T = new Polygon();
            cC10T.addPoint(148, 452);
            cC10T.addPoint(188, 492);
            cC10T.addPoint(181, 499);
            Figura cC10 = new CasillaEspecial(xC10, yC10, g, "cC10", cC10T);
            int xC11[] = {136, 176, 148, 108};
            int yC11[] = {384, 424, 452, 412};
            Polygon cC11T = new Polygon();
            cC11T.addPoint(148, 452);
            cC11T.addPoint(195, 485);
            cC11T.addPoint(188, 492);
            Figura cC11 = new CasillaEspecial(xC11, yC11, g, "cA11", cC11T);
            int xC12[] = {164, 204, 176, 136};
            int yC12[] = {356, 396, 424, 384};
            Figura cC12 = new CasillaNormal(xC12, yC12, g, "cC12");
            int xC13[] = {192, 232, 204, 164};
            int yC13[] = {328, 368, 396, 356};
            Figura cC13 = new CasillaNormal(xC13, yC13, g, "cC13");
            int xC14[] = {220, 260, 232, 192};
            int yC14[] = {300, 340, 368, 328};
            Figura cC14 = new CasillaEntradaSalida(xC14, yC14, g, "cC14");
            //   CompositorCasilla izB = new CompositorCasilla("izB");
            CompositorCasilla izB = new CompositorCasilla(3);
            izB.addElemento(cC1);
            izB.addElemento(cC2);
            izB.addElemento(cC3);
            izB.addElemento(cC4);
            izB.addElemento(cC5);
            izB.addElemento(cC6);
            izB.addElemento(cC9);
            izB.addElemento(cC10);
            izB.addElemento(cC11);
            izB.addElemento(cC12);
            izB.addElemento(cC13);
            izB.addElemento(cC14);
            izB.dibujar();

            int xCE1[] = {300, 340, 380, 340};
            int yCE1[] = {300, 260, 300, 340};
            Figura cCE1 = new CasillaNormal(xCE1, yCE1, g, "cCE1");
            int xCE2[] = {260, 300, 340, 300};
            int yCE2[] = {260, 220, 260, 300};
            Figura cCE2 = new CasillaNormal(xCE2, yCE2, g, "cCE2");
            int xCE3[] = {220, 260, 300, 260};
            int yCE3[] = {300, 260, 300, 340};
            Figura cCE3 = new CasillaNormal(xCE3, yCE3, g, "cCE3");
            int xCE4[] = {260, 300, 340, 300};
            int yCE4[] = {340, 300, 340, 380};
            Figura cCE4 = new CasillaNormal(xCE4, yCE4, g, "cCE4");
            CompositorCasilla ce = new CompositorCasilla(0);
            //            CompositorCasilla ce = new CompositorCasilla("ce");

            ce.addElemento(cCE1);
            ce.addElemento(cCE2);
            ce.addElemento(cCE3);
            ce.addElemento(cCE4);
            ce.dibujar();

        } else if (tamaño == 10) {
            int xA1[] = {260, 300, 272, 232};
            int yA1[] = {260, 220, 192, 232};
            Figura cA1 = new CasillaEntradaSalida(xA1, yA1, g, "cA1");
            int xA2[] = {232, 272, 244, 204};
            int yA2[] = {232, 192, 164, 204};
            Figura cA2 = new CasillaNormal(xA2, yA2, g, "cA2");
            int xA3[] = {204, 244, 216, 176};
            int yA3[] = {204, 164, 136, 176};
            Polygon cA3T = new Polygon();
            cA3T.addPoint(176, 176);
            cA3T.addPoint(136, 216);
            cA3T.addPoint(143, 223);
            Figura cA3 = new CasillaEspecial(xA3, yA3, g, "cA3", cA3T);
            int xA4[] = {176, 216, 188, 148};
            int yA4[] = {176, 136, 108, 148};
            Polygon cA4T = new Polygon();
            cA4T.addPoint(176, 176);
            cA4T.addPoint(129, 209);
            cA4T.addPoint(136, 216);
            Figura cA4 = new CasillaEspecial(xA4, yA4, g, "cA4", cA4T);
            int xA5[] = {148, 188, 160, 100};
            int yA5[] = {148, 108, 80, 100};
            Figura cA5 = new CasillaBordeada(xA5, yA5, g, "cA5");
            int xA10[] = {108, 148, 100, 80};
            int yA10[] = {188, 148, 100, 160};
            Figura cA10 = new CasillaBordeada(xA10, yA10, g, "cA10");
            int xA11[] = {136, 176, 148, 108};
            int yA11[] = {216, 176, 148, 188};
            Polygon cA11T = new Polygon();
            cA11T.addPoint(176, 176);
            cA11T.addPoint(216, 136);
            cA11T.addPoint(223, 143);
            Figura cA11 = new CasillaEspecial(xA11, yA11, g, "cA11", cA11T);
            int xA12[] = {164, 204, 176, 136};
            int yA12[] = {244, 204, 176, 216};
            Polygon cA12T = new Polygon();
            cA12T.addPoint(176, 176);
            cA12T.addPoint(209, 129);
            cA12T.addPoint(216, 136);
            Figura cA12 = new CasillaEspecial(xA12, yA12, g, "cA12", cA12T);
            int xA13[] = {192, 232, 204, 164};
            int yA13[] = {272, 232, 204, 244};
            Figura cA13 = new CasillaNormal(xA13, yA13, g, "cA13");
            int xA14[] = {220, 260, 232, 192};
            int yA14[] = {300, 260, 232, 272};
            Figura cA14 = new CasillaNormal(xA14, yA14, g, "cA14");
            CompositorCasilla izA = new CompositorCasilla(2);
            //            CompositorCasilla izA = new CompositorCasilla("izA");

            izA.addElemento(cA1);
            izA.addElemento(cA2);
            izA.addElemento(cA3);
            izA.addElemento(cA4);
            izA.addElemento(cA5);
            izA.addElemento(cA10);
            izA.addElemento(cA11);
            izA.addElemento(cA12);
            izA.addElemento(cA13);
            izA.addElemento(cA14);
            izA.dibujar();

            int xB1[] = {300, 340, 368, 328};
            int yB1[] = {220, 260, 232, 192};
            Figura cB1 = new CasillaNormal(xB1, yB1, g, "cB1");
            int xB2[] = {328, 368, 396, 356};
            int yB2[] = {192, 232, 204, 164};
            Figura cB2 = new CasillaNormal(xB2, yB2, g, "cB2");
            int xB3[] = {356, 396, 424, 384};
            int yB3[] = {164, 204, 176, 136};
            Polygon cB3T = new Polygon();
            cB3T.addPoint(384, 136);
            cB3T.addPoint(424, 176);
            cB3T.addPoint(377, 143);
            Figura cB3 = new CasillaEspecial(xB3, yB3, g, "cB3", cB3T);
            int xB4[] = {384, 424, 452, 412};
            int yB4[] = {136, 176, 148, 108};
            Polygon cB4T = new Polygon();
            cB4T.addPoint(424, 176);
            cB4T.addPoint(384, 136);
            cB4T.addPoint(391, 129);
            Figura cB4 = new CasillaEspecial(xB4, yB4, g, "cB4", cB4T);
            int xB5[] = {412, 452, 500, 440};
            int yB5[] = {108, 148, 100, 80};
            Figura cB5 = new CasillaBordeada(xB5, yB5, g, "cB5");
            int xB10[] = {452, 492, 520, 500};
            int yB10[] = {148, 188, 160, 100};
            Figura cB10 = new CasillaBordeada(xB10, yB10, g, "cB10");
            int xB11[] = {424, 464, 492, 452};
            int yB11[] = {176, 216, 188, 148};
            Polygon cB11T = new Polygon();
            cB11T.addPoint(424, 176);
            cB11T.addPoint(464, 216);
            cB11T.addPoint(457, 223);
            Figura cB11 = new CasillaEspecial(xB11, yB11, g, "cB11", cB11T);
            int xB12[] = {396, 436, 464, 424};
            int yB12[] = {204, 244, 216, 176};
            Polygon cB12T = new Polygon();
            cB12T.addPoint(424, 176);
            cB12T.addPoint(464, 216);
            cB12T.addPoint(473, 209);
            Figura cB12 = new CasillaEspecial(xB12, yB12, g, "cB12", cB12T);
            int xB13[] = {368, 408, 436, 396};
            int yB13[] = {232, 272, 244, 204};
            Figura cB13 = new CasillaNormal(xB13, yB13, g, "cB13");
            int xB14[] = {340, 380, 408, 368};
            int yB14[] = {260, 300, 272, 232};
            Figura cB14 = new CasillaEntradaSalida(xB14, yB14, g, "cB14");
            //         CompositorCasilla deA = new CompositorCasilla("deA");

            CompositorCasilla deA = new CompositorCasilla(1);
            deA.addElemento(cB1);
            deA.addElemento(cB2);
            deA.addElemento(cB3);
            deA.addElemento(cB4);
            deA.addElemento(cB5);
            deA.addElemento(cB10);
            deA.addElemento(cB11);
            deA.addElemento(cB12);
            deA.addElemento(cB13);
            deA.addElemento(cB14);
            deA.dibujar();

            int xD1[] = {300, 340, 368, 328};
            int yD1[] = {380, 340, 368, 408};
            Figura cD1 = new CasillaEntradaSalida(xD1, yD1, g, "cB1");
            int xD2[] = {328, 368, 396, 356};
            int yD2[] = {408, 368, 396, 436};
            Figura cD2 = new CasillaNormal(xD2, yD2, g, "cD2");
            int xD3[] = {356, 396, 424, 384};
            int yD3[] = {436, 396, 424, 464};
            Polygon cD3T = new Polygon();
            cD3T.addPoint(424, 424);
            cD3T.addPoint(464, 384);
            cD3T.addPoint(471, 391);
            Figura cD3 = new CasillaEspecial(xD3, yD3, g, "cD3", cD3T);
            int xD4[] = {384, 424, 452, 412};
            int yD4[] = {464, 424, 452, 492};
            Polygon cD4T = new Polygon();
            cD4T.addPoint(424, 424);
            cD4T.addPoint(457, 377);
            cD4T.addPoint(464, 384);
            Figura cD4 = new CasillaEspecial(xD4, yD4, g, "cD4", cD4T);
            int xD5[] = {412, 452, 500, 440};
            int yD5[] = {492, 452, 500, 520};
            Figura cD5 = new CasillaBordeada(xD5, yD5, g, "cD5");
            int xD10[] = {452, 492, 520, 500};
            int yD10[] = {452, 412, 440, 500};
            Figura cD10 = new CasillaBordeada(xD10, yD10, g, "cD10");
            int xD11[] = {424, 464, 492, 452};
            int yD11[] = {424, 384, 412, 452};
            Polygon cD11T = new Polygon();
            cD11T.addPoint(424, 424);
            cD11T.addPoint(384, 464);
            cD11T.addPoint(391, 471);
            Figura cD11 = new CasillaEspecial(xD11, yD11, g, "cD11", cD11T);
            int xD12[] = {396, 436, 464, 424};
            int yD12[] = {396, 356, 384, 424};
            Polygon cD12T = new Polygon();
            cD12T.addPoint(424, 424);
            cD12T.addPoint(377, 457);
            cD12T.addPoint(384, 464);
            Figura cD12 = new CasillaEspecial(xD12, yD12, g, "cD12", cD12T);
            int xD13[] = {368, 408, 436, 396};
            int yD13[] = {368, 328, 356, 396};
            Figura cD13 = new CasillaNormal(xD13, yD13, g, "cD13");
            int xD14[] = {340, 380, 408, 368};
            int yD14[] = {340, 300, 328, 368};
            Figura cD14 = new CasillaNormal(xD14, yD14, g, "cD14");
//            CompositorCasilla deB = new CompositorCasilla("deB");
CompositorCasilla deB = new CompositorCasilla(4);
            deB.addElemento(cD1);
            deB.addElemento(cD2);
            deB.addElemento(cD3);
            deB.addElemento(cD4);
            deB.addElemento(cD5);
            deB.addElemento(cD10);
            deB.addElemento(cD11);
            deB.addElemento(cD12);
            deB.addElemento(cD13);
            deB.addElemento(cD14);
            deB.dibujar();

            int xC1[] = {260, 300, 272, 232};
            int yC1[] = {340, 380, 408, 368};
            Figura cC1 = new CasillaNormal(xC1, yC1, g, "cC1");
            int xC2[] = {232, 272, 244, 204};
            int yC2[] = {368, 408, 436, 396};
            Figura cC2 = new CasillaNormal(xC2, yC2, g, "cC2");
            int xC3[] = {204, 244, 216, 176};
            int yC3[] = {396, 436, 464, 424};
            Polygon cC3T = new Polygon();
            cC3T.addPoint(176, 424);
            cC3T.addPoint(136, 384);
            cC3T.addPoint(129, 391);
            Figura cC3 = new CasillaEspecial(xC3, yC3, g, "cC3", cC3T);
            int xC4[] = {176, 216, 188, 148};
            int yC4[] = {424, 464, 492, 452};
            Polygon cC4T = new Polygon();
            cC4T.addPoint(176, 424);
            cC4T.addPoint(136, 384);
            cC4T.addPoint(143, 377);
            Figura cC4 = new CasillaEspecial(xC4, yC4, g, "cC4", cC4T);
            int xC5[] = {148, 188, 160, 100};
            int yC5[] = {452, 492, 520, 500};
            Figura cC5 = new CasillaBordeada(xC5, yC5, g, "cC5");
            int xC10[] = {108, 148, 100, 80};
            int yC10[] = {412, 452, 500, 440};
            Figura cC10 = new CasillaBordeada(xC10, yC10, g, "cC10");
            int xC11[] = {136, 176, 148, 108};
            int yC11[] = {384, 424, 452, 412};
            Polygon cC11T = new Polygon();
            cC11T.addPoint(176, 424);
            cC11T.addPoint(216, 464);
            cC11T.addPoint(209, 473);
            Figura cC11 = new CasillaEspecial(xC11, yC11, g, "cA11", cC11T);
            int xC12[] = {164, 204, 176, 136};
            int yC12[] = {356, 396, 424, 384};
            Polygon cC12T = new Polygon();
            cC12T.addPoint(176, 424);
            cC12T.addPoint(216, 464);
            cC12T.addPoint(223, 457);
            Figura cC12 = new CasillaEspecial(xC12, yC12, g, "cC12", cC12T);
            int xC13[] = {192, 232, 204, 164};
            int yC13[] = {328, 368, 396, 356};
            Figura cC13 = new CasillaNormal(xC13, yC13, g, "cC13");
            int xC14[] = {220, 260, 232, 192};
            int yC14[] = {300, 340, 368, 328};
            Figura cC14 = new CasillaEntradaSalida(xC14, yC14, g, "cC14");
//            CompositorCasilla izB = new CompositorCasilla("izB");
            CompositorCasilla izB = new CompositorCasilla(3);

            izB.addElemento(cC1);
            izB.addElemento(cC2);
            izB.addElemento(cC3);
            izB.addElemento(cC4);
            izB.addElemento(cC5);
            izB.addElemento(cC10);
            izB.addElemento(cC11);
            izB.addElemento(cC12);
            izB.addElemento(cC13);
            izB.addElemento(cC14);
            izB.dibujar();

            int xCE1[] = {300, 340, 380, 340};
            int yCE1[] = {300, 260, 300, 340};
            Figura cCE1 = new CasillaNormal(xCE1, yCE1, g, "cCE1");
            int xCE2[] = {260, 300, 340, 300};
            int yCE2[] = {260, 220, 260, 300};
            Figura cCE2 = new CasillaNormal(xCE2, yCE2, g, "cCE2");
            int xCE3[] = {220, 260, 300, 260};
            int yCE3[] = {300, 260, 300, 340};
            Figura cCE3 = new CasillaNormal(xCE3, yCE3, g, "cCE3");
            int xCE4[] = {260, 300, 340, 300};
            int yCE4[] = {340, 300, 340, 380};
            Figura cCE4 = new CasillaNormal(xCE4, yCE4, g, "cCE4");
//            CompositorCasilla ce = new CompositorCasilla("ce");
            CompositorCasilla ce = new CompositorCasilla(0);
            ce.addElemento(cCE1);
            ce.addElemento(cCE2);
            ce.addElemento(cCE3);
            ce.addElemento(cCE4);
            ce.dibujar();
        }
         */
    }

    /*
    Metodo Repaint utilizara estas cordenadas
    int x14[] = {358, 385, 412, 439, 466, 493, 520, 480, 453, 426, 399, 372, 345, 318, 280, 251, 221, 194, 167, 140, 110, 80,
        40, 70, 100, 127, 154, 181, 211, 240, 210, 180, 148, 121, 94, 67, 40, 80, 107, 134, 161, 188, 220, 250, 280,
        310, 340, 370, 400, 430, 460, 490, 525, 500, 470, 440, 415, 390, 365, 320};
    int y14[] = {250, 220, 188, 161, 134, 107, 80, 40, 67, 94, 121, 148, 180, 210, 256, 211, 181, 154, 127, 100, 70, 40,
        80, 110, 140, 167, 194, 221, 251, 290, 318, 345, 372, 399, 426, 453, 480, 520, 493, 466, 439, 412, 385, 358, 320,
        365, 390, 415, 440, 470, 500, 525, 490, 460, 430, 400, 370, 340, 310, 290};
     
   int x12[] = {358, 385, 412, 439, 466, 493, 453, 426, 399, 372, 345, 318, 280, 251, 221, 194, 167, 140, 110, 70, 100, 127, 154, 181, 211, 240, 210, 180, 148, 121, 94, 67, 107, 134, 161, 188, 220, 250,
        280, 310, 340, 370, 400, 430, 460, 500, 470, 440, 415, 390, 365, 320};
    int y12[] = {250, 220, 188, 161, 134, 107, 67, 94, 121, 148, 180, 210, 256, 211, 181, 154, 127, 100, 70, 110, 140, 167, 194, 221, 251, 290, 318, 345, 372, 399, 426, 453, 493, 466, 439, 412, 385, 358,
        320, 365, 390, 415, 440, 470, 500, 460, 430, 400, 370, 340, 310, 290};
 
    int x10[] = {358, 385, 412, 439, 466, 426, 399, 372, 345, 318, 280, 251, 221, 194, 167, 140, 100, 127, 154, 181, 211, 240, 210, 180, 148, 121, 94, 134, 161, 188, 220, 250,
        280, 310, 340, 370, 400, 430, 470, 440, 415, 390, 365, 320};
    int y10[] = {250, 220, 188, 161, 134, 94, 121, 148, 180, 210, 256, 211, 181, 154, 127, 100,
        140, 167, 194, 221, 251, 290, 318, 345, 372, 399, 426, 466, 439, 412, 385, 358,
        320, 365, 390, 415, 440, 470, 430, 400, 370, 340, 310, 290};
     */
}
