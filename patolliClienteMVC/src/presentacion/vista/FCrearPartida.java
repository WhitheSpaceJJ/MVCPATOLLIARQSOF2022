package presentacion.vista;

import control.CJugador;
import control.CPartida;
import control.ControlBase;
import dominio.Jugador;
import dominio.Partida;
import dominio.Tablero;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import modelo.MPartida;
import modelo.ModeloBase;

/**
 * Frame de Creación de Partida.
 *
 * @author Equipo1
 */
public class FCrearPartida extends FrameBase {

    /**
     * Creates new form FCrearPartida
     */
    public FCrearPartida() {
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

        resetDatos = new javax.swing.JButton();
        jButtonMenu = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        colorJugador = new javax.swing.JComboBox<>();
        nombreJugador = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        montoApuesta = new javax.swing.JTextField();
        fondoJugador = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButtonComenzar = new javax.swing.JButton();
        cantidadJugadores = new javax.swing.JComboBox<>();
        tamanoTablero = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        resetDatos.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        resetDatos.setForeground(new java.awt.Color(204, 0, 0));
        resetDatos.setText("Borrar");
        resetDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetDatosActionPerformed(evt);
            }
        });
        resetDatos.getAccessibleContext().setAccessibleDescription("");

        jButtonMenu.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButtonMenu.setForeground(new java.awt.Color(255, 0, 0));
        jButtonMenu.setText("Menu");
        jButtonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Creacion Partida");
        setMinimumSize(new java.awt.Dimension(629, 452));
        setResizable(false);
        setSize(new java.awt.Dimension(629, 452));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setText("Configuración partida");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(170, 10, 330, 30);

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel2.setText("Escoga su color;");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 130, 150, 30);

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel3.setText("Datos del creador");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 50, 210, 20);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(0, 40, 700, 10);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(0, 200, 700, 10);

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel8.setText("Escriba su apodo;");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(10, 90, 170, 20);

        colorJugador.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        colorJugador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Azul", "Amarillo", "Rojo", "Verde" }));
        jPanel1.add(colorJugador);
        colorJugador.setBounds(170, 130, 120, 30);

        nombreJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreJugadorActionPerformed(evt);
            }
        });
        jPanel1.add(nombreJugador);
        nombreJugador.setBounds(170, 90, 150, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 630, 230);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(null);
        jPanel2.add(montoApuesta);
        montoApuesta.setBounds(490, 100, 130, 30);
        jPanel2.add(fondoJugador);
        fondoJugador.setBounds(490, 50, 130, 30);

        jLabel9.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel9.setText("Monto apuesta");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(320, 90, 140, 30);

        jLabel11.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel11.setText("Fondo por jugador:");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(320, 50, 170, 30);

        jButtonComenzar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButtonComenzar.setForeground(new java.awt.Color(0, 153, 0));
        jButtonComenzar.setText("Comenzar");
        jButtonComenzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComenzarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonComenzar);
        jButtonComenzar.setBounds(250, 130, 120, 40);

        cantidadJugadores.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        cantidadJugadores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "3", "4" }));
        jPanel2.add(cantidadJugadores);
        cantidadJugadores.setBounds(190, 90, 120, 30);

        tamanoTablero.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        tamanoTablero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "14", "12", "10" }));
        jPanel2.add(tamanoTablero);
        tamanoTablero.setBounds(190, 50, 120, 30);

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel7.setText("Total Jugadores");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(0, 90, 180, 30);

        jLabel10.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel10.setText("Tamaño:");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(10, 50, 110, 30);

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel6.setText("Configuración Partida");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(10, 10, 250, 20);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 220, 630, 230);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuActionPerformed
        this.dispose();
        java.awt.EventQueue.invokeLater(() -> {
            new FInicio().setVisible(true);
        });
    }//GEN-LAST:event_jButtonMenuActionPerformed

    private void nombreJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreJugadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreJugadorActionPerformed

    private void jButtonComenzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonComenzarActionPerformed
        if (validarConfiguracion() == false) {

            String color = colorJugador.getSelectedItem().toString();
            int tamaño = Integer.valueOf(tamanoTablero.getSelectedItem().toString());
            int totalJugadores = Integer.valueOf(cantidadJugadores.getSelectedItem().toString());
            double montoApuestaD = Double.valueOf(this.montoApuesta.getText());
            double montoJugadorD = Double.valueOf(this.fondoJugador.getText());
            Tablero tablero = new Tablero(Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + "" + Calendar.getInstance().get(Calendar.SECOND), tamaño);
            Partida partida = new Partida(new Jugador(this.nombreJugador.getText(), color), tablero, montoJugadorD, montoApuestaD, totalJugadores);
            ((CPartida) this.control).crearPartida(partida);
        }
    }//GEN-LAST:event_jButtonComenzarActionPerformed

    private void resetDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetDatosActionPerformed
        this.nombreJugador.setText("");
        this.colorJugador.setSelectedIndex(0);
    }//GEN-LAST:event_resetDatosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cantidadJugadores;
    private javax.swing.JComboBox<String> colorJugador;
    private javax.swing.JTextField fondoJugador;
    private javax.swing.JButton jButtonComenzar;
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField montoApuesta;
    private javax.swing.JTextField nombreJugador;
    private javax.swing.JButton resetDatos;
    private javax.swing.JComboBox<String> tamanoTablero;
    // End of variables declaration//GEN-END:variables

//Valida la configuracion de la creacion datos, nombre del jugador, montos,etc.
    public boolean validarConfiguracion() {
        if (this.nombreJugador.getText().isEmpty()) {
            this.mostrarMensaje("Establece el nombre del jugador");
            return true;
        }

        if (this.fondoJugador.getText().isEmpty()) {
            this.mostrarMensaje("Necesita escribir el fondo por jugador");
            return true;
        }

        if (this.montoApuesta.getText().isEmpty()) {
            this.mostrarMensaje("Necesita escribir el monto de apuesta");
            return true;
        }
        Double m;
        try {
            m = Double.valueOf(this.fondoJugador.getText());
        } catch (NumberFormatException e) {
            this.mostrarMensaje("El monto de dinero contienen caracteres invalidos");
            return true;
        }

        if (m > 2000) {
            this.mostrarMensaje("Por el momentto el monto de dinero debe de ser menor a 2000");
            return true;
        } else if (m < 1000) {
            this.mostrarMensaje("Por el momentto el monto de dinero debe de ser mayor a 1000");
            return true;
        } else {
            Double a;
            try {
                a = Double.valueOf(this.montoApuesta.getText());
            } catch (NumberFormatException e) {
                this.mostrarMensaje("El monto de apuesta contienen caracteres invalidos");
                return true;
            }

            double diezP = m * 0.1;
            if (a > diezP) {
                this.mostrarMensaje("Para un buen juego el monto por apuesta debe de ser menor a " + diezP);
                return true;
            }
        }
        return false;
    }
//mostrar mensaje 

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
//Muestra la pantalla de lobby

    public void mostrarPantallaLobby(FLobby fLobby) {
        java.awt.EventQueue.invokeLater(() -> {
            fLobby.setVisible(true);
        });
    }
//Metodo que abre el lobby del creador con los datos de la partida

    @Override
    public void update(Observable o, Object o1) {
        this.dispose();
        Partida partida = ((MPartida) o).getPartida();
        JOptionPane.showMessageDialog(this, "Usted ha creado una partida; Nombre Escogigo=" + partida.getTurno().getNombre() + " Color; " + partida.getTurno().getColor());
        ModeloBase modeloPartida = (MPartida) o;
        ControlBase controlJugador = new CJugador();
        controlJugador.establecerModelo(modeloPartida);
        this.control.getCliente().addObserver((Observer) modeloPartida);
        controlJugador.establecerCliente(this.control.getCliente());
        FrameBase fLobby = new FLobby(((MPartida) o).getPartida().getMontoJugador(),
                ((MPartida) o).getPartida().getMontoApuesta(), ((MPartida) o).getPartida().getTablero().getTamano());
        modeloPartida.deleteObserver(this);
        fLobby.establecerControl(control);
        modeloPartida.addObserver(fLobby);
        ((FLobby) fLobby).actualizarLobby(((MPartida) o).getPartida().getJugadores());
        this.mostrarPantallaLobby((FLobby) fLobby);

    }
}
