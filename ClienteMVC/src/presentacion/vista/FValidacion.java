
package presentacion.vista;

import java.util.Observable;

/**
 * Clase que representa la validacion de la salida del juego.
 *
 * @author Equipo1
 */
public class FValidacion extends FrameBase {

    /**
     * Creates new form FValidacion
     */
    public FValidacion() {
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

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BOXseleccion = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();

        jButton1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 51, 51));
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Salir");
        setFocusable(false);
        setMinimumSize(new java.awt.Dimension(400, 300));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jLabel1.setText("¿Realmente desea abondanar la partida?");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 10, 410, 40);

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel2.setText("Selecciona la opcion:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 100, 250, 20);

        BOXseleccion.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        BOXseleccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Si" }));
        jPanel1.add(BOXseleccion);
        BOXseleccion.setBounds(250, 90, 130, 40);

        jButton2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 255, 102));
        jButton2.setText("Confirmar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(130, 170, 120, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 390, 280);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.salirPartida();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * Salir de partida y aplicar cambios al juego.
     */
    public void salirPartida() {
        if (BOXseleccion.getSelectedItem().equals("No")) {
            //En espera.
            dispose();
        } else {
            System.exit(0);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BOXseleccion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
  
    //aqui se verifica que el jugador ha salido y se elimina el jugador del juego Nota no se elimina en si se da de baja
    @Override
    public void update(Observable o, Object o1) {

    }
}