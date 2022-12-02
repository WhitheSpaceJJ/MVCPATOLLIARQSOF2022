package presentacion.dibujo;

import entidades.Casilla;
import entidades.Ficha;
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

    private List<Integer> x14;
    private List<Integer> y14;
    private List<Integer> x12;
    private List<Integer> y12;
    private List<Integer> x10;
    private List<Integer> y10;

    private List<List<Integer>> listaX;
    List<Polygon> triangulos;

    private List<List<Integer>> listaY;
    private int tamaño;
    private Tablero tablero;
//

    public TableroGrafico(Tablero tablero) {
        this.tablero = tablero;
        this.tamaño = tablero.getTamano();
        this.inicializarArreglos();
        this.rellenarCasillas();
    }

    public TableroGrafico() {
    }

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
        super.paintComponent(g);
        this.dibujarTablero(g);
        this.dibujarFichas(tablero.getCasillas(), g);
    }

    public void dibujarTablero(Graphics g) {
        CompositorCasilla tableroGrafico = new CompositorCasilla(tamaño);
        if (tamaño == 14) {
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
            for (int i = 0; i < 52; i++) {
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
        }
        this.dibujarFichas(tablero.getCasillas(), g);
    }

    public void dibujarFichas(List<Casilla> casilla, Graphics g) {
        if (tamaño == 14) {
            for (int i = 0; i < casilla.size(); i++) {
                Ficha get = casilla.get(i).getFicha();
                if (get != null) {
                    if (get.getJugador().getColor().equalsIgnoreCase("Azul")) {
                        g.setColor(Color.BLUE);
                        g.fillOval(x14.get(i), y14.get(i), 28, 28);
                    }
                    if (get.getJugador().getColor().equalsIgnoreCase("Rosa")) {
                        g.setColor(Color.PINK);
                        g.fillOval(x14.get(i), y14.get(i), 28, 28);
                    }
                    if (get.getJugador().getColor().equalsIgnoreCase("Verde")) {
                        g.setColor(Color.GREEN);
                        g.fillOval(x14.get(i), y14.get(i), 28, 28);
                    }
                    if (get.getJugador().getColor().equalsIgnoreCase("Rojo")) {
                        g.setColor(Color.RED);
                        g.fillOval(x14.get(i), y14.get(i), 28, 28);
                    }
                }
            }
        }
        if (tamaño == 12) {
            for (int i = 0; i < casilla.size(); i++) {
                Ficha get = casilla.get(i).getFicha();
                if (get != null) {
                    if (get.getJugador().getColor().equalsIgnoreCase("Azul")) {
                        g.setColor(Color.BLUE);
                        g.fillOval(x12.get(i), y12.get(i), 28, 28);
                    }
                    if (get.getJugador().getColor().equalsIgnoreCase("Rosa")) {
                        g.setColor(Color.PINK);
                        g.fillOval(x12.get(i), y12.get(i), 28, 28);
                    }
                    if (get.getJugador().getColor().equalsIgnoreCase("Verde")) {
                        g.setColor(Color.GREEN);
                        g.fillOval(x12.get(i), y12.get(i), 28, 28);
                    }
                    if (get.getJugador().getColor().equalsIgnoreCase("Rojo")) {
                        g.setColor(Color.RED);
                        g.fillOval(x12.get(i), y12.get(i), 28, 28);
                    }
                }
            }
        }
        if (tamaño == 10) {
            for (int i = 0; i < casilla.size(); i++) {
                Ficha get = casilla.get(i).getFicha();
                if (get != null) {
                    if (get.getJugador().getColor().equalsIgnoreCase("Azul")) {
                        g.setColor(Color.BLUE);
                        g.fillOval(x10.get(i), y10.get(i), 28, 28);
                    }
                    if (get.getJugador().getColor().equalsIgnoreCase("Rosa")) {
                        g.setColor(Color.PINK);
                        g.fillOval(x10.get(i), y10.get(i), 28, 28);
                    }
                    if (get.getJugador().getColor().equalsIgnoreCase("Verde")) {
                        g.setColor(Color.GREEN);
                        g.fillOval(x10.get(i), y10.get(i), 28, 28);
                    }
                    if (get.getJugador().getColor().equalsIgnoreCase("Rojo")) {
                        g.setColor(Color.RED);
                        g.fillOval(x10.get(i), y10.get(i), 28, 28);
                    }
                }
            }
        }
    }

    public void inicializarArreglos() {
        this.listaX = new ArrayList<List<Integer>>();
        this.listaY = new ArrayList<List<Integer>>();
        this.triangulos = new ArrayList<>();
        this.x14 = Arrays.asList(358, 385, 412, 439, 466, 493, 520, 480, 453, 426, 399, 372, 345, 318, 280, 251, 221, 194, 167, 140, 110, 80,
                40, 70, 100, 127, 154, 181, 211, 240, 210, 180, 148, 121, 94, 67, 40, 80, 107, 134, 161, 188, 220, 250, 280,
                310, 340, 370, 400, 430, 460, 490, 525, 500, 470, 440, 415, 390, 365, 320);
        this.y14 = Arrays.asList(250, 220, 188, 161, 134, 107, 80, 40, 67, 94, 121, 148, 180, 210, 256, 211, 181, 154, 127, 100, 70, 40,
                80, 110, 140, 167, 194, 221, 251, 290, 318, 345, 372, 399, 426, 453, 480, 520, 493, 466, 439, 412, 385, 358, 320,
                365, 390, 415, 440, 470, 500, 525, 490, 460, 430, 400, 370, 340, 310, 290);
        this.x12 = Arrays.asList(358, 385, 412, 439, 466, 493, 453, 426, 399, 372, 345, 318, 280, 251, 221, 194, 167, 140, 110, 70, 100, 127, 154, 181, 211, 240, 210, 180, 148, 121, 94, 67, 107, 134, 161, 188, 220, 250,
                280, 310, 340, 370, 400, 430, 460, 500, 470, 440, 415, 390, 365, 320);
        this.y12 = Arrays.asList(250, 220, 188, 161, 134, 107, 67, 94, 121, 148, 180, 210, 256, 211, 181, 154, 127, 100, 70, 110, 140, 167, 194, 221, 251, 290, 318, 345, 372, 399, 426, 453, 493, 466, 439, 412, 385, 358,
                320, 365, 390, 415, 440, 470, 500, 460, 430, 400, 370, 340, 310, 290);
        this.x10 = Arrays.asList(358, 385, 412, 439, 466, 426, 399, 372, 345, 318, 280, 251, 221, 194, 167, 140, 100, 127, 154, 181, 211, 240, 210, 180, 148, 121, 94, 134, 161, 188, 220, 250,
                280, 310, 340, 370, 400, 430, 470, 440, 415, 390, 365, 320);
        this.y10 = Arrays.asList(250, 220, 188, 161, 134, 94, 121, 148, 180, 210, 256,
                211, 181, 154, 127, 100, 140, 167, 194, 221, 251, 290, 318, 345, 372,
                399, 426, 466, 439, 412, 385, 358, 320, 365, 390, 415, 440, 470, 430,
                400, 370, 340, 310, 290);

    }

    public void rellenarCasillas() {
        Polygon p1 = new Polygon();
        Polygon p2 = new Polygon();
        Polygon p3 = new Polygon();
        Polygon p4 = new Polygon();
        Polygon p5 = new Polygon();
        Polygon p6 = new Polygon();
        Polygon p7 = new Polygon();
        Polygon p8 = new Polygon();
        Polygon p9 = new Polygon();
        Polygon p10 = new Polygon();
        Polygon p11 = new Polygon();
        Polygon p12 = new Polygon();
        Polygon p13 = new Polygon();
        Polygon p14 = new Polygon();
        Polygon p15 = new Polygon();
        Polygon p16 = new Polygon();

        if (tamaño == 10) {
            listaX.add(Arrays.asList(340, 380, 408, 368));
            listaX.add(Arrays.asList(368, 408, 436, 396));
            listaX.add(Arrays.asList(396, 436, 464, 424));
            listaX.add(Arrays.asList(424, 464, 492, 452));
            listaX.add(Arrays.asList(412, 452, 500, 440));

            listaX.add(Arrays.asList(452, 492, 520, 500));
            listaX.add(Arrays.asList(384, 424, 452, 412));
            listaX.add(Arrays.asList(356, 396, 424, 384));
            listaX.add(Arrays.asList(328, 368, 396, 356));
            listaX.add(Arrays.asList(300, 340, 368, 328));
            //Central
            listaX.add(Arrays.asList(260, 300, 340, 300));

            listaX.add(Arrays.asList(260, 300, 272, 232));
            listaX.add(Arrays.asList(232, 272, 244, 204));
            listaX.add(Arrays.asList(204, 244, 216, 176));
            listaX.add(Arrays.asList(176, 216, 188, 148));
            listaX.add(Arrays.asList(148, 188, 160, 100));

            listaX.add(Arrays.asList(108, 148, 100, 80));
            listaX.add(Arrays.asList(136, 176, 148, 108));
            listaX.add(Arrays.asList(164, 204, 176, 136));
            listaX.add(Arrays.asList(192, 232, 204, 164));
            listaX.add(Arrays.asList(220, 260, 232, 192));
            //Central
            listaX.add(Arrays.asList(220, 260, 300, 260));

            listaX.add(Arrays.asList(220, 260, 232, 192));
            listaX.add(Arrays.asList(192, 232, 204, 164));
            listaX.add(Arrays.asList(164, 204, 176, 136));
            listaX.add(Arrays.asList(136, 176, 148, 108));
            listaX.add(Arrays.asList(148, 188, 160, 100));

            listaX.add(Arrays.asList(108, 148, 100, 80));
            listaX.add(Arrays.asList(176, 216, 188, 148));
            listaX.add(Arrays.asList(204, 244, 216, 176));
            listaX.add(Arrays.asList(232, 272, 244, 204));
            listaX.add(Arrays.asList(260, 300, 272, 232));
            //Central
            listaX.add(Arrays.asList(260, 300, 340, 300));

            listaX.add(Arrays.asList(300, 340, 368, 328));
            listaX.add(Arrays.asList(328, 368, 396, 356));
            listaX.add(Arrays.asList(356, 396, 424, 384));
            listaX.add(Arrays.asList(384, 424, 452, 412));
            listaX.add(Arrays.asList(412, 452, 500, 440));

            listaX.add(Arrays.asList(452, 492, 520, 500));
            listaX.add(Arrays.asList(424, 464, 492, 452));
            listaX.add(Arrays.asList(396, 436, 464, 424));
            listaX.add(Arrays.asList(368, 408, 436, 396));
            listaX.add(Arrays.asList(340, 380, 408, 368));

            listaX.add(Arrays.asList(300, 340, 380, 340));

            listaY.add(Arrays.asList(260, 300, 272, 232));
            listaY.add(Arrays.asList(232, 272, 244, 204));
            listaY.add(Arrays.asList(204, 244, 216, 176));
            listaY.add(Arrays.asList(176, 216, 188, 148));
            listaY.add(Arrays.asList(108, 148, 100, 80));

            listaY.add(Arrays.asList(148, 188, 160, 100));
            listaY.add(Arrays.asList(136, 176, 148, 108));
            listaY.add(Arrays.asList(164, 204, 176, 136));
            listaY.add(Arrays.asList(192, 232, 204, 164));
            listaY.add(Arrays.asList(220, 260, 232, 192));
            //Cental
            listaY.add(Arrays.asList(260, 220, 260, 300));

            listaY.add(Arrays.asList(260, 220, 192, 232));
            listaY.add(Arrays.asList(232, 192, 164, 204));
            listaY.add(Arrays.asList(204, 164, 136, 176));
            listaY.add(Arrays.asList(176, 136, 108, 148));
            listaY.add(Arrays.asList(148, 108, 80, 100));

            listaY.add(Arrays.asList(188, 148, 100, 160));
            listaY.add(Arrays.asList(216, 176, 148, 188));
            listaY.add(Arrays.asList(244, 204, 176, 216));
            listaY.add(Arrays.asList(272, 232, 204, 244));
            listaY.add(Arrays.asList(300, 260, 232, 272));
            //Central
            listaY.add(Arrays.asList(300, 260, 300, 340));

            listaY.add(Arrays.asList(300, 340, 368, 328));
            listaY.add(Arrays.asList(328, 368, 396, 356));
            listaY.add(Arrays.asList(356, 396, 424, 384));
            listaY.add(Arrays.asList(384, 424, 452, 412));
            listaY.add(Arrays.asList(452, 492, 520, 500));

            listaY.add(Arrays.asList(412, 452, 500, 440));
            listaY.add(Arrays.asList(424, 464, 492, 452));
            listaY.add(Arrays.asList(396, 436, 464, 424));
            listaY.add(Arrays.asList(368, 408, 436, 396));
            listaY.add(Arrays.asList(340, 380, 408, 368));
            //Central
            listaY.add(Arrays.asList(340, 300, 340, 380));

            listaY.add(Arrays.asList(380, 340, 368, 408));
            listaY.add(Arrays.asList(408, 368, 396, 436));
            listaY.add(Arrays.asList(436, 396, 424, 464));
            listaY.add(Arrays.asList(464, 424, 452, 492));
            listaY.add(Arrays.asList(492, 452, 500, 520));

            listaY.add(Arrays.asList(452, 412, 440, 500));
            listaY.add(Arrays.asList(424, 384, 412, 452));
            listaY.add(Arrays.asList(396, 356, 384, 424));
            listaY.add(Arrays.asList(368, 328, 356, 396));
            listaY.add(Arrays.asList(340, 300, 328, 368));

            listaY.add(Arrays.asList(300, 260, 300, 340));

            p1.addPoint(384, 136);
            p1.addPoint(424, 176);
            p1.addPoint(377, 143);

            p2.addPoint(424, 176);
            p2.addPoint(384, 136);
            p2.addPoint(391, 129);

            p3.addPoint(424, 176);
            p3.addPoint(464, 216);
            p3.addPoint(457, 223);

            p4.addPoint(424, 176);
            p4.addPoint(464, 216);
            p4.addPoint(473, 209);

            p5.addPoint(176, 176);
            p5.addPoint(136, 216);
            p5.addPoint(143, 223);

            p6.addPoint(176, 176);
            p6.addPoint(129, 209);
            p6.addPoint(136, 216);

            p7.addPoint(176, 176);
            p7.addPoint(216, 136);
            p7.addPoint(223, 143);

            p8.addPoint(176, 176);
            p8.addPoint(209, 129);
            p8.addPoint(216, 136);

            p9.addPoint(176, 424);
            p9.addPoint(136, 384);
            p9.addPoint(129, 391);

            p10.addPoint(176, 424);
            p10.addPoint(136, 384);
            p10.addPoint(143, 377);

            p11.addPoint(176, 424);
            p11.addPoint(216, 464);
            p11.addPoint(209, 473);

            p12.addPoint(176, 424);
            p12.addPoint(216, 464);
            p12.addPoint(223, 457);
            p13.addPoint(424, 424);
            p13.addPoint(464, 384);
            p13.addPoint(471, 391);

            p14.addPoint(424, 424);
            p14.addPoint(457, 377);
            p14.addPoint(464, 384);

            p15.addPoint(424, 424);
            p15.addPoint(384, 464);
            p15.addPoint(391, 471);

            p16.addPoint(424, 424);
            p16.addPoint(377, 457);
            p16.addPoint(384, 464);
        }
        if (tamaño
                == 12) {
            listaX.add(Arrays.asList(340, 380, 408, 368));
            listaX.add(Arrays.asList(368, 408, 436, 396));
            listaX.add(Arrays.asList(396, 436, 464, 424));
            listaX.add(Arrays.asList(424, 464, 492, 452));
            listaX.add(Arrays.asList(452, 492, 520, 480));
            listaX.add(Arrays.asList(440, 480, 520, 468));

            listaX.add(Arrays.asList(480, 520, 548, 520));
            listaX.add(Arrays.asList(412, 452, 480, 440));
            listaX.add(Arrays.asList(384, 424, 452, 412));
            listaX.add(Arrays.asList(356, 396, 424, 384));
            listaX.add(Arrays.asList(328, 368, 396, 356));
            listaX.add(Arrays.asList(300, 340, 368, 328));
            //Central
            listaX.add(Arrays.asList(260, 300, 340, 300));

            listaX.add(Arrays.asList(260, 300, 272, 232));
            listaX.add(Arrays.asList(232, 272, 244, 204));
            listaX.add(Arrays.asList(204, 244, 216, 176));
            listaX.add(Arrays.asList(176, 216, 188, 148));
            listaX.add(Arrays.asList(148, 188, 160, 120));
            listaX.add(Arrays.asList(120, 160, 132, 80));

            listaX.add(Arrays.asList(80, 120, 80, 52));
            listaX.add(Arrays.asList(108, 148, 120, 80));
            listaX.add(Arrays.asList(136, 176, 148, 108));
            listaX.add(Arrays.asList(164, 204, 176, 136));
            listaX.add(Arrays.asList(192, 232, 204, 164));
            listaX.add(Arrays.asList(220, 260, 232, 192));
            //Central
            listaX.add(Arrays.asList(220, 260, 300, 260));

            listaX.add(Arrays.asList(220, 260, 232, 192));
            listaX.add(Arrays.asList(192, 232, 204, 164));
            listaX.add(Arrays.asList(164, 204, 176, 136));
            listaX.add(Arrays.asList(136, 176, 148, 108));
            listaX.add(Arrays.asList(108, 148, 120, 80));
            listaX.add(Arrays.asList(120, 160, 132, 80));

            listaX.add(Arrays.asList(80, 120, 80, 52));
            listaX.add(Arrays.asList(148, 188, 160, 120));
            listaX.add(Arrays.asList(176, 216, 188, 148));
            listaX.add(Arrays.asList(204, 244, 216, 176));
            listaX.add(Arrays.asList(232, 272, 244, 204));
            listaX.add(Arrays.asList(260, 300, 272, 232));
            //Central
            listaX.add(Arrays.asList(260, 300, 340, 300));

            listaX.add(Arrays.asList(300, 340, 368, 328));
            listaX.add(Arrays.asList(328, 368, 396, 356));
            listaX.add(Arrays.asList(356, 396, 424, 384));
            listaX.add(Arrays.asList(384, 424, 452, 412));
            listaX.add(Arrays.asList(412, 452, 480, 440));
            listaX.add(Arrays.asList(440, 480, 520, 468));

            listaX.add(Arrays.asList(480, 520, 548, 520));
            listaX.add(Arrays.asList(452, 492, 520, 480));
            listaX.add(Arrays.asList(424, 464, 492, 452));
            listaX.add(Arrays.asList(396, 436, 464, 424));
            listaX.add(Arrays.asList(368, 408, 436, 396));
            listaX.add(Arrays.asList(340, 380, 408, 368));
            listaX.add(Arrays.asList(300, 340, 380, 340));

            listaY.add(Arrays.asList(260, 300, 272, 232));
            listaY.add(Arrays.asList(232, 272, 244, 204));
            listaY.add(Arrays.asList(204, 244, 216, 176));
            listaY.add(Arrays.asList(176, 216, 188, 148));
            listaY.add(Arrays.asList(148, 188, 160, 120));
            listaY.add(Arrays.asList(80, 120, 80, 52));

            listaY.add(Arrays.asList(120, 160, 132, 80));
            listaY.add(Arrays.asList(108, 148, 120, 80));
            listaY.add(Arrays.asList(136, 176, 148, 108));
            listaY.add(Arrays.asList(164, 204, 176, 136));
            listaY.add(Arrays.asList(192, 232, 204, 164));
            listaY.add(Arrays.asList(220, 260, 232, 192));
            //Central
            listaY.add(Arrays.asList(260, 220, 260, 300));

            listaY.add(Arrays.asList(260, 220, 192, 232));
            listaY.add(Arrays.asList(232, 192, 164, 204));
            listaY.add(Arrays.asList(204, 164, 136, 176));
            listaY.add(Arrays.asList(176, 136, 108, 148));
            listaY.add(Arrays.asList(148, 108, 80, 120));
            listaY.add(Arrays.asList(120, 80, 52, 80));

            listaY.add(Arrays.asList(160, 120, 80, 132));
            listaY.add(Arrays.asList(188, 148, 120, 160));
            listaY.add(Arrays.asList(216, 176, 148, 188));
            listaY.add(Arrays.asList(244, 204, 176, 216));
            listaY.add(Arrays.asList(272, 232, 204, 244));
            listaY.add(Arrays.asList(300, 260, 232, 272));
            //Central
            listaY.add(Arrays.asList(300, 260, 300, 340));

            listaY.add(Arrays.asList(300, 340, 368, 328));
            listaY.add(Arrays.asList(328, 368, 396, 356));
            listaY.add(Arrays.asList(356, 396, 424, 384));
            listaY.add(Arrays.asList(384, 424, 452, 412));
            listaY.add(Arrays.asList(412, 452, 480, 440));
            listaY.add(Arrays.asList(480, 520, 548, 520));

            listaY.add(Arrays.asList(440, 480, 520, 468));
            listaY.add(Arrays.asList(452, 492, 520, 480));
            listaY.add(Arrays.asList(424, 464, 492, 452));
            listaY.add(Arrays.asList(396, 436, 464, 424));
            listaY.add(Arrays.asList(368, 408, 436, 396));
            listaY.add(Arrays.asList(340, 380, 408, 368));
            //Central
            listaY.add(Arrays.asList(340, 300, 340, 380));

            listaY.add(Arrays.asList(380, 340, 368, 408));
            listaY.add(Arrays.asList(408, 368, 396, 436));
            listaY.add(Arrays.asList(436, 396, 424, 464));
            listaY.add(Arrays.asList(464, 424, 452, 492));
            listaY.add(Arrays.asList(492, 452, 480, 520));
            listaY.add(Arrays.asList(520, 480, 520, 548));

            listaY.add(Arrays.asList(480, 440, 468, 520));
            listaY.add(Arrays.asList(452, 412, 440, 480));
            listaY.add(Arrays.asList(424, 384, 412, 452));
            listaY.add(Arrays.asList(396, 356, 384, 424));
            listaY.add(Arrays.asList(368, 328, 356, 396));
            listaY.add(Arrays.asList(340, 300, 328, 368));
            listaY.add(Arrays.asList(300, 260, 300, 340));
            p1.addPoint(412, 108);
            p1.addPoint(452, 148);
            p1.addPoint(405, 115);

            p2.addPoint(452, 148);
            p2.addPoint(412, 108);
            p2.addPoint(419, 101);

            p3.addPoint(452, 148);
            p3.addPoint(485, 195);
            p3.addPoint(492, 188);

            p4.addPoint(452, 148);
            p4.addPoint(492, 188);
            p4.addPoint(499, 181);

            p5.addPoint(148, 148);
            p5.addPoint(108, 188);
            p5.addPoint(115, 195);
            p6.addPoint(148, 148);
            p6.addPoint(101, 181);
            p6.addPoint(108, 188);

            p7.addPoint(148, 148);
            p7.addPoint(188, 108);
            p7.addPoint(195, 115);

            p8.addPoint(148, 148);
            p8.addPoint(181, 101);
            p8.addPoint(188, 108);

            p9.addPoint(148, 452);
            p9.addPoint(108, 412);
            p9.addPoint(101, 419);

            p10.addPoint(148, 452);
            p10.addPoint(115, 405);
            p10.addPoint(108, 412);

            p11.addPoint(148, 452);
            p11.addPoint(188, 492);
            p11.addPoint(181, 499);

            p12.addPoint(148, 452);
            p12.addPoint(195, 485);
            p12.addPoint(188, 492);

            p13.addPoint(452, 452);
            p13.addPoint(492, 412);
            p13.addPoint(499, 419);

            p14.addPoint(452, 452);
            p14.addPoint(485, 405);
            p14.addPoint(492, 412);
            p15.addPoint(452, 452);
            p15.addPoint(412, 492);
            p15.addPoint(419, 499);
            p16.addPoint(452, 452);
            p16.addPoint(405, 485);
            p16.addPoint(412, 492);

        }
        if (tamaño
                == 14) {
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
            listaY.add(Arrays.asList(300, 260, 300, 340));

            p1.addPoint(480, 120);
            p1.addPoint(513, 167);
            p1.addPoint(520, 160);
            p2.addPoint(480, 120);
            p2.addPoint(520, 160);
            p2.addPoint(527, 153);
            p3.addPoint(480, 120);
            p3.addPoint(440, 80);
            p3.addPoint(447, 73);
            p4.addPoint(440, 80);
            p4.addPoint(480, 120);
            p4.addPoint(433, 87);
            p5.addPoint(120, 120);
            p5.addPoint(160, 80);
            p5.addPoint(167, 87);
            p6.addPoint(120, 120);
            p6.addPoint(153, 73);
            p6.addPoint(160, 80);
            p7.addPoint(120, 120);
            p7.addPoint(73, 153);
            p7.addPoint(80, 160);
            p8.addPoint(120, 120);
            p8.addPoint(80, 160);
            p8.addPoint(87, 167);
            p9.addPoint(120, 480);
            p9.addPoint(87, 433);
            p9.addPoint(80, 440);
            p10.addPoint(120, 480);
            p10.addPoint(80, 440);
            p10.addPoint(73, 447);
            p11.addPoint(120, 480);
            p11.addPoint(160, 520);
            p11.addPoint(153, 527);
            p12.addPoint(120, 480);
            p12.addPoint(167, 513);
            p12.addPoint(160, 520);
            p13.addPoint(480, 480);
            p13.addPoint(440, 520);
            p13.addPoint(447, 527);
            p14.addPoint(480, 480);
            p14.addPoint(433, 513);
            p14.addPoint(440, 520);
            p15.addPoint(480, 480);
            p15.addPoint(520, 440);
            p15.addPoint(527, 447);
            p16.addPoint(480, 480);
            p16.addPoint(513, 433);
            p16.addPoint(520, 440);

        }

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
    }
}
