
package presentacion.vista;

import javax.swing.JOptionPane;

/**
 * Frame para la espera de jugadores.
 *
 * @author Equipo1
 */
public class FLobby extends FrameBase {


    /**
     * Creates new form FLobbyHost
     */
    private FLobby() {
        initComponents();
    }

    private static FLobby instanceFLobby;

    public static FLobby getFLobby() {
        if (instanceFLobby == null) {
            instanceFLobby = new FLobby();
        }
        return instanceFLobby;
    }

//     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanelJugador4 = new javax.swing.JPanel();
        Ljugador4 = new javax.swing.JLabel();
        Lcolor4 = new javax.swing.JLabel();
        jPanelJugador3 = new javax.swing.JPanel();
        Ljugador3 = new javax.swing.JLabel();
        Lcolor3 = new javax.swing.JLabel();
        jPanelJugador2 = new javax.swing.JPanel();
        Ljugador2 = new javax.swing.JLabel();
        Lcolor2 = new javax.swing.JLabel();
        jPanelJugador1 = new javax.swing.JPanel();
        ljugador1 = new javax.swing.JLabel();
        lcolor1 = new javax.swing.JLabel();
        jButtonInicar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        Monto = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        apuesta = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tamano = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lobby");
        setMinimumSize(new java.awt.Dimension(600, 375));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(null);

        jPanelJugador4.setBackground(new java.awt.Color(204, 255, 255));
        jPanelJugador4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelJugador4.setLayout(null);

        Ljugador4.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        Ljugador4.setText("\"DISPONIBLE\"");
        jPanelJugador4.add(Ljugador4);
        Ljugador4.setBounds(10, 10, 110, 30);

        Lcolor4.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jPanelJugador4.add(Lcolor4);
        Lcolor4.setBounds(10, 70, 0, 30);

        jPanel2.add(jPanelJugador4);
        jPanelJugador4.setBounds(430, 90, 130, 180);

        jPanelJugador3.setBackground(new java.awt.Color(204, 255, 255));
        jPanelJugador3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelJugador3.setLayout(null);

        Ljugador3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        Ljugador3.setText("\"DISPONIBLE\"");
        jPanelJugador3.add(Ljugador3);
        Ljugador3.setBounds(10, 10, 110, 30);

        Lcolor3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jPanelJugador3.add(Lcolor3);
        Lcolor3.setBounds(10, 70, 110, 30);

        jPanel2.add(jPanelJugador3);
        jPanelJugador3.setBounds(290, 90, 130, 180);

        jPanelJugador2.setBackground(new java.awt.Color(204, 255, 255));
        jPanelJugador2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelJugador2.setLayout(null);

        Ljugador2.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        Ljugador2.setText("\"DISPONIBLE\"");
        jPanelJugador2.add(Ljugador2);
        Ljugador2.setBounds(10, 10, 110, 30);

        Lcolor2.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jPanelJugador2.add(Lcolor2);
        Lcolor2.setBounds(10, 70, 110, 30);

        jPanel2.add(jPanelJugador2);
        jPanelJugador2.setBounds(150, 90, 130, 180);

        jPanelJugador1.setBackground(new java.awt.Color(204, 255, 255));
        jPanelJugador1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelJugador1.setLayout(null);

        ljugador1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        ljugador1.setText("\"DISPONIBLE\"");
        jPanelJugador1.add(ljugador1);
        ljugador1.setBounds(10, 10, 110, 30);

        lcolor1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        lcolor1.setText("\"DISPONIBLE\"");
        jPanelJugador1.add(lcolor1);
        lcolor1.setBounds(10, 70, 110, 30);

        jPanel2.add(jPanelJugador1);
        jPanelJugador1.setBounds(10, 90, 130, 180);

        jButtonInicar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButtonInicar.setForeground(new java.awt.Color(0, 255, 0));
        jButtonInicar.setText("Iniciar");
        jButtonInicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInicarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonInicar);
        jButtonInicar.setBounds(220, 290, 110, 40);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setText("Lobby de Espera Jugadores");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(90, 20, 400, 50);
        jPanel2.add(jSeparator3);
        jSeparator3.setBounds(0, 280, 580, 10);
        jPanel2.add(jSeparator4);
        jSeparator4.setBounds(0, 80, 580, 10);

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel2.setText("Tamaño  Tablero;");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 320, 150, 30);

        Monto.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        Monto.setText("0");
        jPanel2.add(Monto);
        Monto.setBounds(160, 290, 60, 30);

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel3.setText("Monto por Apuesta");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(340, 290, 140, 30);

        apuesta.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        apuesta.setText("0");
        jPanel2.add(apuesta);
        apuesta.setBounds(480, 290, 100, 30);

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel4.setText("Monto Por Jugador;");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(10, 290, 150, 30);

        tamano.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        tamano.setText("0");
        jPanel2.add(tamano);
        tamano.setBounds(160, 320, 60, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 600, 370);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonInicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInicarActionPerformed
//
//        if (this.control.validarJugadores()) {
//            FJuego juego = FJuego.getFJuego();
//            java.awt.EventQueue.invokeLater(new Runnable() {
//                @Override
//                public void run() {
//                    juego.setVisible(true);
//                }
//            });
//            setVisible(false);
//        } else {
//            this.mostrarMensajeError("Nadie puede iniciar el juego hasta que este el total de jugadores." + "Total; " + this.control.getTotalJugadores());
//        }

    }//GEN-LAST:event_jButtonInicarActionPerformed

    public void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
//Sctualiza lista de jugadores.

    public void actualizaTablero() {
//        int totalJugadores = this.control.getTablero().getJugadores().size();
//        jPanelJugador1.setVisible(true);
//        jPanelJugador2.setVisible(true);
//        jPanelJugador3.setVisible(true);
//        jPanelJugador4.setVisible(true);
//
//        if (totalJugadores == 1) {
//            Jugador jugador1 = this.control.getTablero().getJugadores().get(0);
//            ljugador1.setText(jugador1.getNombre());
//            lcolor1.setText(jugador1.getColor());
//        }
//        if (totalJugadores == 2) {
//            Jugador jugador1 = this.control.getTablero().getJugadores().get(0);
//            ljugador1.setText(jugador1.getNombre());
//            lcolor1.setText(jugador1.getColor());
//            Jugador jugador2 = this.control.getTablero().getJugadores().get(1);
//            Ljugador2.setText(jugador2.getNombre());
//            Lcolor2.setText(jugador2.getColor());
//        }
//
//        if (totalJugadores == 3) {
//            Jugador jugador1 = this.control.getTablero().getJugadores().get(0);
//            ljugador1.setText(jugador1.getNombre());
//            lcolor1.setText(jugador1.getColor());
//            Jugador jugador2 = this.control.getTablero().getJugadores().get(1);
//            Ljugador2.setText(jugador2.getNombre());
//            Lcolor2.setText(jugador2.getColor());
//            Jugador jugador3 = this.control.getTablero().getJugadores().get(2);
//            Ljugador2.setText(jugador3.getNombre());
//            Lcolor2.setText(jugador3.getColor());
//        }
//
//        if (totalJugadores == 4) {
//            Jugador jugador1 = this.control.getTablero().getJugadores().get(0);
//            ljugador1.setText(jugador1.getNombre());
//            lcolor1.setText(jugador1.getColor());
//            Jugador jugador2 = this.control.getTablero().getJugadores().get(1);
//            Ljugador2.setText(jugador2.getNombre());
//            Lcolor2.setText(jugador2.getColor());
//            Jugador jugador3 = this.control.getTablero().getJugadores().get(2);
//            Ljugador2.setText(jugador3.getNombre());
//            Lcolor2.setText(jugador3.getColor());
//            Jugador jugador4 = this.control.getTablero().getJugadores().get(3);
//            Ljugador2.setText(jugador4.getNombre());
//            Lcolor2.setText(jugador4.getColor());
//        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lcolor2;
    private javax.swing.JLabel Lcolor3;
    private javax.swing.JLabel Lcolor4;
    private javax.swing.JLabel Ljugador2;
    private javax.swing.JLabel Ljugador3;
    private javax.swing.JLabel Ljugador4;
    private javax.swing.JLabel Monto;
    private javax.swing.JLabel apuesta;
    private javax.swing.JButton jButtonInicar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelJugador1;
    private javax.swing.JPanel jPanelJugador2;
    private javax.swing.JPanel jPanelJugador3;
    private javax.swing.JPanel jPanelJugador4;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lcolor1;
    private javax.swing.JLabel ljugador1;
    private javax.swing.JLabel tamano;
    // End of variables declaration//GEN-END:variables
}
