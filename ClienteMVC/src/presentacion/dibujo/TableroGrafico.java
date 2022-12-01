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

    private List<List<Integer>> listaX;

    private List<List<Integer>> listaY;
    private int tamaño;
    private Tablero tablero;
//

    public TableroGrafico(Tablero tablero) {
        this.tablero = tablero;
        this.tamaño = tablero.getTamano();
        this.listaX = new ArrayList<List<Integer>>();
        this.listaY = new ArrayList<List<Integer>>();
        this.rellenarCasillas();
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

    public void rellenarCasillas() {
        if (tamaño == 10) {

        }
        if (tamaño == 12) {
            listaX.add(Arrays.asList(340, 380, 408, 368));
            listaX.add(Arrays.asList(368, 408, 436, 396));
            listaX.add(Arrays.asList(396, 436, 464, 424));
            listaX.add(Arrays.asList(424, 464, 492, 452));
            listaX.add(Arrays.asList(452, 492, 520, 480));
            listaX.add(Arrays.asList(480, 520, 548, 508));

            listaY.add(Arrays.asList(260, 300, 272, 232));
            listaY.add(Arrays.asList(232, 272, 244, 204));
            listaY.add(Arrays.asList(204, 244, 216, 176));
            listaY.add(Arrays.asList(176, 216, 188, 148));
            listaY.add(Arrays.asList(148, 188, 160, 120));
            listaY.add(Arrays.asList(120, 160, 132, 92));

        }
        if (tamaño == 14) {
            //1-14
            listaX.add(Arrays.asList(340, 380, 408, 368));
            listaX.add(Arrays.asList(368, 408, 436, 396));
            listaX.add(Arrays.asList(396, 436, 464, 424));
            listaX.add(Arrays.asList(424, 464, 492, 452));
            listaX.add(Arrays.asList(452, 492, 520, 480));
            listaX.add(Arrays.asList(480, 520, 548, 508));

            listaX.add(Arrays.asList(508, 548, 576, 560));
            listaX.add(Arrays.asList(468, 508, 560, 496));
            listaX.add(Arrays.asList(440, 480, 508, 468));
            listaX.add(Arrays.asList(412, 452, 480, 440));

            listaX.add(Arrays.asList(384, 424, 452, 412));
            listaX.add(Arrays.asList(356, 396, 424, 384));
            listaX.add(Arrays.asList(328, 368, 396, 356));
            listaX.add(Arrays.asList(300, 340, 368, 328));
            listaX.add(Arrays.asList(260, 300, 340, 300));
            listaX.add(Arrays.asList(260, 300, 272, 232));

            listaX.add(Arrays.asList(232, 272, 244, 204));
            listaX.add(Arrays.asList(204, 244, 216, 176));
            listaX.add(Arrays.asList(176, 216, 188, 148));
            listaX.add(Arrays.asList(148, 188, 160, 120));
            listaX.add(Arrays.asList(120, 160, 132, 92));
            listaX.add(Arrays.asList(40, 92, 132, 104));
            listaX.add(Arrays.asList(52, 92, 40, 24));
            listaX.add(Arrays.asList(80, 120, 92, 52));
            listaX.add(Arrays.asList(108, 148, 120, 80));
            listaX.add(Arrays.asList(136, 176, 148, 108));
            listaX.add(Arrays.asList(164, 204, 176, 136));
            listaX.add(Arrays.asList(192, 232, 204, 164));
            listaX.add(Arrays.asList(220, 260, 232, 192));
            listaX.add(Arrays.asList(220, 260, 300, 260));
            listaX.add(Arrays.asList(220, 260, 232, 192));
            listaX.add(Arrays.asList(192, 232, 204, 164));
            listaX.add(Arrays.asList(164, 204, 176, 136));
            listaX.add(Arrays.asList(136, 176, 148, 108));
            listaX.add(Arrays.asList(108, 148, 120, 80));
            listaX.add(Arrays.asList(80, 120, 92, 52));
            listaX.add(Arrays.asList(52, 92, 40, 24));
            listaX.add(Arrays.asList(92, 132, 104, 40));
            listaX.add(Arrays.asList(120, 160, 132, 92));
            listaX.add(Arrays.asList(148, 188, 160, 120));
            listaX.add(Arrays.asList(176, 216, 188, 148));
            listaX.add(Arrays.asList(204, 244, 216, 176));
            listaX.add(Arrays.asList(232, 272, 244, 204));
            listaX.add(Arrays.asList(260, 300, 272, 232));
            listaX.add(Arrays.asList(260, 300, 340, 300));
            listaX.add(Arrays.asList(300, 340, 368, 328));
            listaX.add(Arrays.asList(328, 368, 396, 356));
            listaX.add(Arrays.asList(356, 396, 424, 384));
            listaX.add(Arrays.asList(384, 424, 452, 412));
            listaX.add(Arrays.asList(412, 452, 480, 440));
            listaX.add(Arrays.asList(440, 480, 508, 468));
            listaX.add(Arrays.asList(468, 508, 560, 496));
            listaX.add(Arrays.asList(508, 548, 576, 560));
            listaX.add(Arrays.asList(480, 520, 548, 508));
            listaX.add(Arrays.asList(452, 492, 520, 480));
            listaX.add(Arrays.asList(424, 464, 492, 452));
            listaX.add(Arrays.asList(396, 436, 464, 424));
            listaX.add(Arrays.asList(368, 408, 436, 396));
            listaX.add(Arrays.asList(340, 380, 408, 368));
            listaX.add(Arrays.asList(300, 340, 380, 340));

            //1-14
            listaY.add(Arrays.asList(260, 300, 272, 232));
            listaY.add(Arrays.asList(232, 272, 244, 204));
            listaY.add(Arrays.asList(204, 244, 216, 176));
            listaY.add(Arrays.asList(176, 216, 188, 148));
            listaY.add(Arrays.asList(148, 188, 160, 120));
            listaY.add(Arrays.asList(120, 160, 132, 92));

            listaY.add(Arrays.asList(92, 132, 104, 40));
            listaY.add(Arrays.asList(52, 92, 40, 24));
            listaY.add(Arrays.asList(80, 120, 92, 52));
            listaY.add(Arrays.asList(108, 148, 120, 80));

            listaY.add(Arrays.asList(136, 176, 148, 108));
            listaY.add(Arrays.asList(164, 204, 176, 136));
            listaY.add(Arrays.asList(192, 232, 204, 164));
            listaY.add(Arrays.asList(220, 260, 232, 192));
            listaY.add(Arrays.asList(260, 220, 260, 300));
            listaY.add(Arrays.asList(260, 220, 192, 232));

            listaY.add(Arrays.asList(232, 192, 164, 204));
            listaY.add(Arrays.asList(204, 164, 136, 176));
            listaY.add(Arrays.asList(176, 136, 108, 148));
            listaY.add(Arrays.asList(148, 108, 80, 120));
            listaY.add(Arrays.asList(120, 80, 52, 92));
            listaY.add(Arrays.asList(40, 92, 52, 24));
            listaY.add(Arrays.asList(132, 92, 40, 104));
            listaY.add(Arrays.asList(160, 120, 92, 132));
            listaY.add(Arrays.asList(188, 148, 120, 160));
            listaY.add(Arrays.asList(216, 176, 148, 188));
            listaY.add(Arrays.asList(244, 204, 176, 216));
            listaY.add(Arrays.asList(272, 232, 204, 244));
            listaY.add(Arrays.asList(300, 260, 232, 272));
            listaY.add(Arrays.asList(300, 260, 300, 340));
            listaY.add(Arrays.asList(300, 340, 368, 328));
            listaY.add(Arrays.asList(328, 368, 396, 356));
            listaY.add(Arrays.asList(356, 396, 424, 384));
            listaY.add(Arrays.asList(384, 424, 452, 412));
            listaY.add(Arrays.asList(412, 452, 480, 440));
            listaY.add(Arrays.asList(440, 480, 508, 468));
            listaY.add(Arrays.asList(468, 508, 560, 496));
            listaY.add(Arrays.asList(508, 548, 576, 560));
            listaY.add(Arrays.asList(480, 520, 548, 508));
            listaY.add(Arrays.asList(452, 492, 520, 480));
            listaY.add(Arrays.asList(424, 464, 492, 452));
            listaY.add(Arrays.asList(396, 436, 464, 424));
            listaY.add(Arrays.asList(368, 408, 436, 396));
            listaY.add(Arrays.asList(340, 380, 408, 368));
            listaY.add(Arrays.asList(340, 300, 340, 380));
            //Lista de y final

            listaY.add(Arrays.asList(380, 340, 368, 408));
            listaY.add(Arrays.asList(408, 368, 396, 436));
            listaY.add(Arrays.asList(436, 396, 424, 464));
            listaY.add(Arrays.asList(464, 424, 452, 492));
            listaY.add(Arrays.asList(492, 452, 480, 520));
            listaY.add(Arrays.asList(520, 480, 508, 548));
            listaY.add(Arrays.asList(548, 508, 560, 576));

            listaY.add(Arrays.asList(508, 468, 496, 560));
            listaY.add(Arrays.asList(480, 440, 468, 508));
            listaY.add(Arrays.asList(452, 412, 440, 480));
            listaY.add(Arrays.asList(424, 384, 412, 452));
            listaY.add(Arrays.asList(396, 356, 384, 424));
            listaY.add(Arrays.asList(368, 328, 356, 396));

            listaY.add(Arrays.asList(340, 300, 328, 368));

            //Centrales
            listaY.add(Arrays.asList(300, 260, 300, 340));
        }
    }

//Metodo que pinta el tablero, en base al tablero este se reactualizara
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        List<Polygon> triangulos = new ArrayList<>();
        CompositorCasilla tableroGrafico = new CompositorCasilla(tamaño);
        if (tamaño == 14) {

            Polygon p4 = new Polygon();
            p4.addPoint(440, 80);
            p4.addPoint(480, 120);
            p4.addPoint(433, 87);

            Polygon p3 = new Polygon();
            p3.addPoint(480, 120);
            p3.addPoint(440, 80);
            p3.addPoint(447, 73);

            Polygon p1 = new Polygon();
            p1.addPoint(480, 120);
            p1.addPoint(513, 167);
            p1.addPoint(520, 160);

            Polygon p2 = new Polygon();
            p2.addPoint(480, 120);
            p2.addPoint(520, 160);
            p2.addPoint(527, 153);
//Nuev
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

            Polygon p16 = new Polygon();
            p16.addPoint(480, 480);
            p16.addPoint(520, 440);
            p16.addPoint(527, 447);

            Polygon p15 = new Polygon();
            p15.addPoint(480, 480);
            p15.addPoint(513, 433);
            p15.addPoint(520, 440);

            Polygon p14 = new Polygon();
            p14.addPoint(480, 480);
            p14.addPoint(440, 520);
            p14.addPoint(447, 527);

            Polygon p13 = new Polygon();
            p13.addPoint(480, 480);
            p13.addPoint(433, 513);
            p13.addPoint(440, 520);

            Polygon p9 = new Polygon();
            p9.addPoint(120, 480);
            p9.addPoint(80, 440);
            p9.addPoint(73, 447);
//
            Polygon p10 = new Polygon();
            p10.addPoint(120, 480);
            p10.addPoint(87, 433);
            p10.addPoint(80, 440);

            Polygon p11 = new Polygon();
            p11.addPoint(120, 480);
            p11.addPoint(160, 520);
            p11.addPoint(153, 527);

            Polygon p12 = new Polygon();
            p12.addPoint(120, 480);
            p12.addPoint(167, 513);
            p12.addPoint(160, 520);

            triangulos.add(p1);
            triangulos.add(p2);
            triangulos.add(p3);
            triangulos.add(p4);
            triangulos.add(p5);
            triangulos.add(p6);
            triangulos.add(p7);
            triangulos.add(p8);
            triangulos.add(p9);
            triangulos.add(p10);
            triangulos.add(p11);
            triangulos.add(p12);
            triangulos.add(p13);
            triangulos.add(p14);
            triangulos.add(p15);
            triangulos.add(p16);

            int triangulosContador = 0;
            for (int i = 0; i < 60; i++) {
                Casilla casilla = this.tablero.getCasillas().get(i);
                Figura f = null;
                switch (casilla.getTipo()) {
                    case EntradaSalida:
                        f = new CasillaEntradaSalida(
                                new int[]{
                                    listaX.get(i).get(0),
                                    listaX.get(i).get(1),
                                    listaX.get(i).get(2),
                                    listaX.get(i).get(3)
                                },
                                new int[]{
                                    listaY.get(i).get(0),
                                    listaY.get(i).get(1),
                                    listaY.get(i).get(2),
                                    listaY.get(i).get(3)
                                },
                                (i + 1), g);
                        ((CasillaEntradaSalida) f).setMarcador((i + 1));
                        break;
                    case Normal:
                        f = new CasillaNormal(
                                new int[]{
                                    listaX.get(i).get(0),
                                    listaX.get(i).get(1),
                                    listaX.get(i).get(2),
                                    listaX.get(i).get(3)
                                },
                                new int[]{
                                    listaY.get(i).get(0),
                                    listaY.get(i).get(1),
                                    listaY.get(i).get(2),
                                    listaY.get(i).get(3)
                                },
                                (i + 1), g);
                        break;
                    case Central:
                        f = new CasillaNormal(
                                new int[]{
                                    listaX.get(i).get(0),
                                    listaX.get(i).get(1),
                                    listaX.get(i).get(2),
                                    listaX.get(i).get(3)
                                },
                                new int[]{
                                    listaY.get(i).get(0),
                                    listaY.get(i).get(1),
                                    listaY.get(i).get(2),
                                    listaY.get(i).get(3)
                                },
                                (i + 1), g);
                        break;

                    case Penalizacion:
                        f = new CasillaEspecial(
                                new int[]{
                                    listaX.get(i).get(0),
                                    listaX.get(i).get(1),
                                    listaX.get(i).get(2),
                                    listaX.get(i).get(3)
                                },
                                new int[]{
                                    listaY.get(i).get(0),
                                    listaY.get(i).get(1),
                                    listaY.get(i).get(2),
                                    listaY.get(i).get(3)
                                },
                                triangulos.get(triangulosContador), (i + 1), g);
                        triangulosContador += 1;
                        break;
                    case Bordeada:
                        f = new CasillaBordeada(
                                new int[]{
                                    listaX.get(i).get(0),
                                    listaX.get(i).get(1),
                                    listaX.get(i).get(2),
                                    listaX.get(i).get(3)
                                },
                                new int[]{
                                    listaY.get(i).get(0),
                                    listaY.get(i).get(1),
                                    listaY.get(i).get(2),
                                    listaY.get(i).get(3)
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

        } else if (tamaño == 12) {

            int triangulosContador = 0;
            for (int i = 0; i < 7; i++) {
//            for (int i = 0; i < 52; i++) {
                Casilla casilla = this.tablero.getCasillas().get(i);
                Figura f = null;
                switch (casilla.getTipo()) {
                    case EntradaSalida:
                        f = new CasillaEntradaSalida(
                                new int[]{
                                    listaX.get(i).get(0),
                                    listaX.get(i).get(1),
                                    listaX.get(i).get(2),
                                    listaX.get(i).get(3)
                                },
                                new int[]{
                                    listaY.get(i).get(0),
                                    listaY.get(i).get(1),
                                    listaY.get(i).get(2),
                                    listaY.get(i).get(3)
                                },
                                (i + 1), g);
                        ((CasillaEntradaSalida) f).setMarcador((i + 1));
                        break;
                    case Normal:
                        f = new CasillaNormal(
                                new int[]{
                                    listaX.get(i).get(0),
                                    listaX.get(i).get(1),
                                    listaX.get(i).get(2),
                                    listaX.get(i).get(3)
                                },
                                new int[]{
                                    listaY.get(i).get(0),
                                    listaY.get(i).get(1),
                                    listaY.get(i).get(2),
                                    listaY.get(i).get(3)
                                },
                                (i + 1), g);
                        break;
                    case Central:
                        f = new CasillaNormal(
                                new int[]{
                                    listaX.get(i).get(0),
                                    listaX.get(i).get(1),
                                    listaX.get(i).get(2),
                                    listaX.get(i).get(3)
                                },
                                new int[]{
                                    listaY.get(i).get(0),
                                    listaY.get(i).get(1),
                                    listaY.get(i).get(2),
                                    listaY.get(i).get(3)
                                },
                                (i + 1), g);
                        break;

                    case Penalizacion:
                        f = new CasillaNormal(
                                new int[]{
                                    listaX.get(i).get(0),
                                    listaX.get(i).get(1),
                                    listaX.get(i).get(2),
                                    listaX.get(i).get(3)
                                },
                                new int[]{
                                    listaY.get(i).get(0),
                                    listaY.get(i).get(1),
                                    listaY.get(i).get(2),
                                    listaY.get(i).get(3)
                                },
                                (i + 1), g);
//                        f = new CasillaEspecial(
//                                new int[]{
//                                    listaX.get(i).get(0),
//                                    listaX.get(i).get(1),
//                                    listaX.get(i).get(2),
//                                    listaX.get(i).get(3)
//                                },
//                                new int[]{
//                                    listaY.get(i).get(0),
//                                    listaY.get(i).get(1),
//                                    listaY.get(i).get(2),
//                                    listaY.get(i).get(3)
//                                },
//                                triangulos.get(triangulosContador), (i + 1), g);
//                        triangulosContador += 1;
                        break;
                    case Bordeada:
                        f = new CasillaBordeada(
                                new int[]{
                                    listaX.get(i).get(0),
                                    listaX.get(i).get(1),
                                    listaX.get(i).get(2),
                                    listaX.get(i).get(3)
                                },
                                new int[]{
                                    listaY.get(i).get(0),
                                    listaY.get(i).get(1),
                                    listaY.get(i).get(2),
                                    listaY.get(i).get(3)
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
        } else if (tamaño == 10) {

            int triangulosContador = 0;
            for (int i = 0; i < 44; i++) {
                Casilla casilla = this.tablero.getCasillas().get(i);
                Figura f = null;
                switch (casilla.getTipo()) {
                    case EntradaSalida:
                        f = new CasillaEntradaSalida(
                                new int[]{
                                    listaX.get(i).get(0),
                                    listaX.get(i).get(1),
                                    listaX.get(i).get(2),
                                    listaX.get(i).get(3)
                                },
                                new int[]{
                                    listaY.get(i).get(0),
                                    listaY.get(i).get(1),
                                    listaY.get(i).get(2),
                                    listaY.get(i).get(3)
                                },
                                (i + 1), g);
                        ((CasillaEntradaSalida) f).setMarcador((i + 1));
                        break;
                    case Normal:
                        f = new CasillaNormal(
                                new int[]{
                                    listaX.get(i).get(0),
                                    listaX.get(i).get(1),
                                    listaX.get(i).get(2),
                                    listaX.get(i).get(3)
                                },
                                new int[]{
                                    listaY.get(i).get(0),
                                    listaY.get(i).get(1),
                                    listaY.get(i).get(2),
                                    listaY.get(i).get(3)
                                },
                                (i + 1), g);
                        break;
                    case Central:
                        f = new CasillaNormal(
                                new int[]{
                                    listaX.get(i).get(0),
                                    listaX.get(i).get(1),
                                    listaX.get(i).get(2),
                                    listaX.get(i).get(3)
                                },
                                new int[]{
                                    listaY.get(i).get(0),
                                    listaY.get(i).get(1),
                                    listaY.get(i).get(2),
                                    listaY.get(i).get(3)
                                },
                                (i + 1), g);
                        break;

                    case Penalizacion:
                        f = new CasillaNormal(
                                new int[]{
                                    listaX.get(i).get(0),
                                    listaX.get(i).get(1),
                                    listaX.get(i).get(2),
                                    listaX.get(i).get(3)
                                },
                                new int[]{
                                    listaY.get(i).get(0),
                                    listaY.get(i).get(1),
                                    listaY.get(i).get(2),
                                    listaY.get(i).get(3)
                                },
                                (i + 1), g);
//                        f = new CasillaEspecial(
//                                new int[]{
//                                    listaX.get(i).get(0),
//                                    listaX.get(i).get(1),
//                                    listaX.get(i).get(2),
//                                    listaX.get(i).get(3)
//                                },
//                                new int[]{
//                                    listaY.get(i).get(0),
//                                    listaY.get(i).get(1),
//                                    listaY.get(i).get(2),
//                                    listaY.get(i).get(3)
//                                },
//                                triangulos.get(triangulosContador), (i + 1), g);
//                        triangulosContador += 1;
                        break;
                    case Bordeada:
                        f = new CasillaBordeada(
                                new int[]{
                                    listaX.get(i).get(0),
                                    listaX.get(i).get(1),
                                    listaX.get(i).get(2),
                                    listaX.get(i).get(3)
                                },
                                new int[]{
                                    listaY.get(i).get(0),
                                    listaY.get(i).get(1),
                                    listaY.get(i).get(2),
                                    listaY.get(i).get(3)
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
        }
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
