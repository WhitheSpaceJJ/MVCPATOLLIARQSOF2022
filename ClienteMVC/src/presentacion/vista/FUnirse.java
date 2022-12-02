package presentacion.vista;

import control.CJugador;
import entidades.Jugador;
import entidades.Partida;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import modelo.MJugador;
import modelo.MPartida;
import modelo.ModeloBase;

/**
 * Framde para la union de jugadores
 *
 */
public class FUnirse extends FrameBase {

    /**
     * Creates new form FUnirse2
     */
    public FUnirse() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonMenu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        BoxColor = new javax.swing.JComboBox<>();
        jButtonUnirse = new javax.swing.JButton();
        txtnomjugador = new javax.swing.JTextField();

        jButtonMenu.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButtonMenu.setForeground(new java.awt.Color(255, 0, 0));
        jButtonMenu.setText("Menu");
        jButtonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Unirse a Partida");
        setMinimumSize(new java.awt.Dimension(550, 300));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setText("Unirse a partida");

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel2.setText("Escoga su color;");

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel3.setText("Datos del jugador");

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel8.setText("Escriba su apodo;");

        BoxColor.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        BoxColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Azul", "Rosa", "Rojo", "Verde" }));
        BoxColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxColorActionPerformed(evt);
            }
        });

        jButtonUnirse.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButtonUnirse.setForeground(new java.awt.Color(102, 255, 102));
        jButtonUnirse.setText("Unirse");
        jButtonUnirse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUnirseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtnomjugador, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(BoxColor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonUnirse, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(160, 160, 160)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 21, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnomjugador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(BoxColor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(jButtonUnirse, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 1, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 249, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuActionPerformed
        this.dispose();
        java.awt.EventQueue.invokeLater(() -> {
            new FInicio().setVisible(true);
        });
    }//GEN-LAST:event_jButtonMenuActionPerformed

    private void jButtonUnirseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUnirseActionPerformed

        if (!this.validarCampos()) {
            String color = BoxColor.getSelectedItem().toString();
            ((CJugador) this.control).unirsePartida(new Jugador(this.txtnomjugador.getText(), color));
        }


    }//GEN-LAST:event_jButtonUnirseActionPerformed

    private void BoxColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BoxColorActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BoxColor;
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JButton jButtonUnirse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField txtnomjugador;
    // End of variables declaration//GEN-END:variables

    //Metodo que muestra mensaje 
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
//Metodo que muestra la pantallla de llobby

    public void mostrarPantallaLobby(FLobby fLobby) {
        java.awt.EventQueue.invokeLater(() -> {
            fLobby.setVisible(true);
        });
    }
//metodo que valida o ejecutado cuando un jugador ha sido aceptado en una partida, y este a su vez abre el lobby

    @Override
    public void update(Observable o, Object o1) {
        this.dispose();
        Jugador jugador = ((MJugador) o).getJugador();
        JOptionPane.showMessageDialog(this, "Se ha unido a una partida; Nombre Escogigo=" + jugador.getNombre() + " Color; " + jugador.getColor());
////        ModeloBase modeloPartida = new MPartida(((Partida) o1));
//        ModeloBase modeloPartida = new MPartida(((Partida) o1));
//        ((CJugador) this.control).establecerModelo(modeloPartida);
//        this.control.getCliente().addObserver((Observer) modeloPartida);
//        FrameBase fLobby = new FLobby(((Partida) o1).getMontoJugador(),
//                ((Partida) o1).getMontoApuesta(), ((Partida) o1).getTablero().getTamano());
//        fLobby.establecerControl(((CJugador) this.control));
//        modeloPartida.addObserver(fLobby);
//        ((FLobby) fLobby).apagarBoton();
//        ((FLobby) fLobby).actualizarLobby(((Partida) o1).getJugadores());
//        this.mostrarPantallaLobby((FLobby) fLobby);
//        
        if (((Partida) o1).getTotalJugadores() == ((Partida) o1).getJugadores().size()) {
            ModeloBase modeloPartida = new MPartida(((Partida) o1));
            ((CJugador) this.control).establecerModelo(modeloPartida);
            this.control.getCliente().addObserver((Observer) modeloPartida);
            FrameBase frameJuego = new FJuego((Partida) o1);
            frameJuego.establecerControl(this.control);
            java.awt.EventQueue.invokeLater(() -> {
                frameJuego.setVisible(true);
            });
        } else {
            ModeloBase modeloPartida = new MPartida(((Partida) o1));
            ((CJugador) this.control).establecerModelo(modeloPartida);
            this.control.getCliente().addObserver((Observer) modeloPartida);
            FrameBase fLobby = new FLobby(((Partida) o1).getMontoJugador(),
                    ((Partida) o1).getMontoApuesta(), ((Partida) o1).getTablero().getTamano());
            fLobby.establecerControl(((CJugador) this.control));
            modeloPartida.addObserver(fLobby);
            ((FLobby) fLobby).apagarBoton();
            ((FLobby) fLobby).actualizarLobby(((Partida) o1).getJugadores());
            this.mostrarPantallaLobby((FLobby) fLobby);
        }

    }
//Metodo que valida la configuración  datos del jugador, si la partida tiene espacios, etc.

    public boolean validarCampos() {
        if (this.txtnomjugador.getText().isEmpty()) {
            this.mostrarMensaje("Establece el nombre del jugador, este no debe de estar vacio");
            return true;
        }
        return false;
    }

}
