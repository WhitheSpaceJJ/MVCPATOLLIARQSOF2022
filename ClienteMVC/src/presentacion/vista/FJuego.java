package presentacion.vista;

import control.CJugador;
import entidades.Dado;
import entidades.Dinero;
import entidades.Ficha;
import entidades.Jugador;
import entidades.Partida;
import entidades.Tablero;
import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Random;
import javax.swing.JOptionPane;
import modelo.MPartida;
import presentacion.dibujo.DadoGrafico;
import presentacion.dibujo.TableroGrafico;

/**
 * Clase que representa el juego.
 *
 * @author Equipo1.
 */
public class FJuego extends FrameBase {

    TableroGrafico tablero1;
    DadoGrafico dadoJ;

    // se recibe una partida con el fin de dibujar los datos iniciales de la partida
    public FJuego(Partida partida) {
        initComponents();
        this.tablero1 = new TableroGrafico(partida.getTablero());
        this.getContentPane().add(tablero1);
        tablero1.setBounds(0, 0, 600, 600);
        tablero1.setBackground(Color.LIGHT_GRAY);

        this.dadoJ = new DadoGrafico(
                new int[]{35, 140, 245, 70, 210},
                new int[]{35, 35, 35, 175, 175},
                partida.getDados());

        this.getContentPane().add(dadoJ);
        dadoJ.setBounds(600, 200, 400, 400);
        dadoJ.setBackground(Color.WHITE);

        this.rellenarDatos(partida);

//        this.partida = partida;
    }

    // se recibe una partida con el fin de dibujar los datos iniciales de la partida
    public FJuego() {
        initComponents();
    }

//Actualizacion de datoa del turno 
    public void rellenarDatos(Partida partida) {
        if(partida.isActiva()){
        this.jugadores.removeAllItems();
        for (int i = 0; i < partida.getJugadores().size(); i++) {
            Jugador jugador = partida.getJugadores().get(i);
            this.jugadores.addItem("Nombre; " + jugador.getNombre() + ", Color; " + jugador.getColor());
        }
        this.tamanoTablero.setText(String.valueOf(partida.getTablero().getTamano()));
        this.penalizacion.setText(String.valueOf(partida.getMontoApuesta()));
        this.nombre.setText(partida.getTurno().getNombre());
//        this.monto.setText(String.valueOf(partida.getTurno().getDinero().getCantidad()));
        this.monto.setText(String.valueOf(partida.getTurno().getDinero().getCantidad()));
        int contadorFichasEliminadas = 0;
        int contadorFichasVuelta = 0;
        Jugador turno=partida.getTurno();
        
        for (int i = 0; i < turno.getFichas().size(); i++) {
            Ficha ficha = turno.getFichas().get(i);
            if (ficha.isTerminoVuelta()) {
                contadorFichasVuelta += 1;
            }
        }
//        for (int i = 0; i < partida.getTurno().getFichas().size(); i++) {
//            if (!partida.getTurno().getFichas().get(i).isEnJuego()) {
//                contadorFichasEliminadas += 1;
//            }
//            if (partida.getTurno().getFichas().get(i).isTerminoVuelta()) {
//                contadorFichasVuelta += 1;
//            }
//        }
        //Azul, Amarillo, Rojo, Verde
//        this.fichasEliminadas.setText(String.valueOf(contadorFichasEliminadas));
        this.fichaRestantes.setText(String.valueOf(contadorFichasVuelta));
        if (partida.getTurno().getColor().equalsIgnoreCase("Rojo")) {
            this.turno.setBackground(Color.RED);
        }
        if (partida.getTurno().getColor().equalsIgnoreCase("Verde")) {
            this.turno.setBackground(Color.GREEN);
        }
        if (partida.getTurno().getColor().equalsIgnoreCase("Rosa")) {
            this.turno.setBackground(Color.PINK);
        }
        if (partida.getTurno().getColor().equalsIgnoreCase("Azul")) {
            this.turno.setBackground(Color.BLUE);
        }
        this.tablero1.actualizarTablero(partida.getTablero());
        this.dadoJ.setDados(partida.getDados());
                }
        else{
            JOptionPane.showMessageDialog(null, "La partida ha finalizado; Ganador="+partida.getTurno().getNombre() );
                        System.exit(0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        fichasEnJuego = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        fichasEliminadas = new javax.swing.JLabel();
        turno = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        fichaRestantes = new javax.swing.JLabel();
        monto = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lanzar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        fichas = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        MontoTitulo = new javax.swing.JLabel();
        MontoTitulo2 = new javax.swing.JLabel();
        MontoTitulo1 = new javax.swing.JLabel();
        penalizacion = new javax.swing.JLabel();
        tamanoTablero = new javax.swing.JLabel();
        jugadores = new javax.swing.JComboBox<>();

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel4.setText("Fichas En Juego");

        fichasEnJuego.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        fichasEnJuego.setText("0");

        jLabel3.setText("jLabel3");

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel7.setText("Fichas Con");

        fichasEliminadas.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        fichasEliminadas.setText("0");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Juego");
        setMinimumSize(new java.awt.Dimension(1268, 640));
        setResizable(false);
        getContentPane().setLayout(null);

        turno.setBackground(new java.awt.Color(204, 204, 204));
        turno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        turno.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setText("Turno  Actual");
        turno.add(jLabel1);
        jLabel1.setBounds(50, 30, 160, 20);

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel2.setText("Jugador");
        turno.add(jLabel2);
        jLabel2.setBounds(10, 90, 90, 21);

        nombre.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        nombre.setText("0");
        turno.add(nombre);
        nombre.setBounds(140, 90, 90, 20);

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel6.setText("Monto Actual");
        turno.add(jLabel6);
        jLabel6.setBounds(10, 130, 120, 21);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(null);

        jLabel8.setText("Turno ");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(10, 10, 35, 16);

        jLabel9.setText("Jugador");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(10, 50, 60, 16);

        jLabel10.setText("Fichas en Juego");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(10, 110, 100, 16);

        jLabel11.setText("jLabel4");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(120, 50, 41, 16);

        jLabel12.setText("jLabel4");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(120, 110, 41, 16);

        jLabel13.setText("Monto Actual");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(10, 80, 70, 16);

        jLabel14.setText("jLabel4");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(120, 80, 41, 16);

        turno.add(jPanel2);
        jPanel2.setBounds(0, 600, 240, 170);

        fichaRestantes.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        fichaRestantes.setText("0");
        turno.add(fichaRestantes);
        fichaRestantes.setBounds(120, 210, 70, 19);

        monto.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        monto.setText("0");
        turno.add(monto);
        monto.setBounds(140, 130, 90, 19);

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel5.setText("Fichas Restantes");
        turno.add(jLabel5);
        jLabel5.setBounds(50, 180, 160, 19);

        getContentPane().add(turno);
        turno.setBounds(1000, 0, 250, 240);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(null);

        lanzar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lanzar.setText("Lanzar");
        lanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lanzarActionPerformed(evt);
            }
        });
        jPanel3.add(lanzar);
        lanzar.setBounds(70, 70, 110, 40);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(1000, 240, 250, 190);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(null);

        jButton1.setText("Salir Partida");
        jPanel4.add(jButton1);
        jButton1.setBounds(1120, 490, 110, 40);

        jButtonSalir.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButtonSalir.setText("Salir Partida");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        jPanel4.add(jButtonSalir);
        jButtonSalir.setBounds(30, 80, 190, 40);

        jLabel16.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel16.setText("Desea abondonar juego");
        jPanel4.add(jLabel16);
        jLabel16.setBounds(10, 20, 230, 30);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(1000, 430, 250, 170);

        fichas.setBackground(new java.awt.Color(255, 255, 255));
        fichas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fichas.setPreferredSize(new java.awt.Dimension(380, 380));

        javax.swing.GroupLayout fichasLayout = new javax.swing.GroupLayout(fichas);
        fichas.setLayout(fichasLayout);
        fichasLayout.setHorizontalGroup(
            fichasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 348, Short.MAX_VALUE)
        );
        fichasLayout.setVerticalGroup(
            fichasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(fichas);
        fichas.setBounds(620, 240, 350, 0);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(460, 380, 0, 2);

        MontoTitulo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        MontoTitulo.setText("Jugadores;");
        getContentPane().add(MontoTitulo);
        MontoTitulo.setBounds(600, 100, 120, 40);

        MontoTitulo2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        MontoTitulo2.setText("Penalización En Juego;");
        getContentPane().add(MontoTitulo2);
        MontoTitulo2.setBounds(780, 10, 210, 40);

        MontoTitulo1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        MontoTitulo1.setText("Tamaño Tablero");
        getContentPane().add(MontoTitulo1);
        MontoTitulo1.setBounds(600, 10, 170, 40);

        penalizacion.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        penalizacion.setText("0");
        getContentPane().add(penalizacion);
        penalizacion.setBounds(860, 50, 120, 30);

        tamanoTablero.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        tamanoTablero.setText("0");
        getContentPane().add(tamanoTablero);
        tamanoTablero.setBounds(650, 50, 110, 22);

        getContentPane().add(jugadores);
        jugadores.setBounds(730, 100, 260, 40);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private Partida partida;

    private void lanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lanzarActionPerformed
//Se manda a llamar al metodo del control correspondientes y este a su vez al cliente que envia datos,
//sin embargo, no se actualizara o se realizara algo si este jugador no es su turno actual
        ((CJugador) this.control).lanzarDados();

    }//GEN-LAST:event_lanzarActionPerformed

    public void apagarBotonTurno() {
        this.lanzar.setEnabled(false);
    }

    public void encenderBotonTurno() {
        this.lanzar.setEnabled(true);
    }

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FValidacion().setVisible(true);
//            }
//        });
        // aqui se establece el nuevo control para el frame de validacion y se establecen los datos 
        //para salir o entrar


    }//GEN-LAST:event_jButtonSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MontoTitulo;
    private javax.swing.JLabel MontoTitulo1;
    private javax.swing.JLabel MontoTitulo2;
    private javax.swing.JLabel fichaRestantes;
    private javax.swing.JPanel fichas;
    private javax.swing.JLabel fichasEliminadas;
    private javax.swing.JLabel fichasEnJuego;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> jugadores;
    private javax.swing.JButton lanzar;
    private javax.swing.JLabel monto;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel penalizacion;
    private javax.swing.JLabel tamanoTablero;
    private javax.swing.JPanel turno;
    // End of variables declaration//GEN-END:variables

    //Al ejecutar este metodo recibe los nuevos datos de la partida
    //por lo tanto se actualizaran los jpanel y estos redibujaran los datos actuales y ademas se actualizaron los datos de la 
    //pantalla como el turno actual, fchas en juevo etc.
    @Override
    public void update(Observable o, Object o1) {
        this.rellenarDatos(((MPartida) o).getPartida());
    }

}
