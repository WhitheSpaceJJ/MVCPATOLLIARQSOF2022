package presentacion.vista;

import control.ControlBase;
import dominio.Jugador;
import java.util.List;
import java.util.Observable;
import javax.swing.JOptionPane;
import modelo.MPartida;
import modelo.ModeloBase;

/**
 * Frame para la espera de jugadores.
 *
 * @author Equipo1
 */
public class FLobby extends FrameBase {

    /**
     * Creates new form FLobbyHost
     */
    public FLobby() {
        initComponents();
    }

    /**
     * Creates new form FLobbyHost
     *
     * @param montoJugador
     * @param tamañoTablero
     * @param montoApuesta
     */
    public FLobby(double montoJugador, double montoApuesta, int tamañoTablero) {
        initComponents();
        this.Monto.setText(String.valueOf(montoJugador));
        this.apuesta.setText(String.valueOf(montoApuesta));
        this.tamano.setText(String.valueOf(tamañoTablero));
    }

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
        jLabel1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        Monto = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        apuesta = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tamano = new javax.swing.JLabel();
        jButtonInicar = new javax.swing.JButton();

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
        jPanelJugador4.setBounds(430, 70, 130, 180);

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
        jPanelJugador3.setBounds(290, 70, 130, 180);

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
        jPanelJugador2.setBounds(150, 70, 130, 180);

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
        jPanelJugador1.setBounds(10, 70, 130, 180);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setText("Lobby de Espera Jugadores");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(90, 10, 400, 50);
        jPanel2.add(jSeparator3);
        jSeparator3.setBounds(0, 260, 580, 10);
        jPanel2.add(jSeparator4);
        jSeparator4.setBounds(0, 60, 580, 10);

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel2.setText("Tamaño  Tablero;");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(420, 270, 150, 30);

        Monto.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        Monto.setText("0");
        jPanel2.add(Monto);
        Monto.setBounds(160, 270, 60, 30);

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel3.setText("Monto por Apuesta;");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 300, 150, 30);

        apuesta.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        apuesta.setText("0");
        jPanel2.add(apuesta);
        apuesta.setBounds(160, 300, 100, 30);

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel4.setText("Monto Por Jugador;");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(10, 270, 150, 30);

        tamano.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        tamano.setText("0");
        jPanel2.add(tamano);
        tamano.setBounds(480, 300, 60, 30);

        jButtonInicar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButtonInicar.setForeground(new java.awt.Color(0, 255, 0));
        jButtonInicar.setText("Iniciar");
        jButtonInicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInicarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonInicar);
        jButtonInicar.setBounds(290, 280, 110, 40);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 600, 370);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonInicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInicarActionPerformed
        //Se mandara a llamar al metodo de iniciar partida de control

    }//GEN-LAST:event_jButtonInicarActionPerformed

    //metodo utilizado para apagar el boton de un jugador que solo se une
    public void apagarBoton() {
        this.jButtonInicar.setEnabled(false);
        this.jButtonInicar.setVisible(false);
    }
//metodo que muestra un mensaje de pantalla

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
//ejecutado cuando se reciben datos para actualizacion

    @Override
    public void update(Observable o, Object o1) {
        //Aqui se verificara si la partida tiene el total de jugadores requeridos se inicie el juego
        if (((MPartida) o).getPartida().getTotalJugadores() == ((MPartida) o).getPartida().getJugadores().size()) {
            this.dispose();
            ((MPartida) o).deleteObserver(this);
            FrameBase frameJuego = new FJuego();
            frameJuego.establecerControl(this.control);
            java.awt.EventQueue.invokeLater(() -> {
                frameJuego.setVisible(true);
            });
        } else {
            List<Jugador> jugadores = ((MPartida) o).getPartida().getJugadores();
            this.actualizarLobby(jugadores);
        }
    }
//Metodo que acualiza el lobby con respecto a los datos de los jugadores

    public void actualizarLobby(List<Jugador> jugadores) {
        int totalJugadores = jugadores.size();
        if (totalJugadores == 1) {
            Jugador jugador1 = jugadores.get(0);
            ljugador1.setText(jugador1.getNombre());
            lcolor1.setText(jugador1.getColor());
        }
        if (totalJugadores == 2) {
            Jugador jugador1 = jugadores.get(0);
            ljugador1.setText(jugador1.getNombre());
            lcolor1.setText(jugador1.getColor());
            Jugador jugador2 = jugadores.get(1);
            Ljugador2.setText(jugador2.getNombre());
            Lcolor2.setText(jugador2.getColor());
        }
//
        if (totalJugadores == 3) {
            Jugador jugador1 = jugadores.get(0);
            ljugador1.setText(jugador1.getNombre());
            lcolor1.setText(jugador1.getColor());
            Jugador jugador2 = jugadores.get(1);
            Ljugador2.setText(jugador2.getNombre());
            Lcolor2.setText(jugador2.getColor());
            Jugador jugador3 = jugadores.get(2);
            Ljugador3.setText(jugador3.getNombre());
            Lcolor3.setText(jugador3.getColor());
        }
//
        if (totalJugadores == 4) {
            Jugador jugador1 = jugadores.get(0);
            ljugador1.setText(jugador1.getNombre());
            lcolor1.setText(jugador1.getColor());
            Jugador jugador2 = jugadores.get(1);
            Ljugador2.setText(jugador2.getNombre());
            Lcolor2.setText(jugador2.getColor());
            Jugador jugador3 = jugadores.get(2);
            Ljugador3.setText(jugador3.getNombre());
            Lcolor3.setText(jugador3.getColor());
            Jugador jugador4 = jugadores.get(3);
            Ljugador4.setText(jugador4.getNombre());
            Lcolor4.setText(jugador4.getColor());
        }
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
