/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package VISTA;

import CONTROLADOR.JavaConnect;
import MODELO.Usuario;
import java.beans.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static org.apache.derby.iapi.reference.ClassName.ResultSet;

/**
 *
 * @author Rodri
 */
public class PanelDetalle extends javax.swing.JPanel {

    private final JPanelEntrar jframe;

    GregorianCalendar fecha;
    ResultSet rs = null;
    ResultSet rsAux;
    int numfilas = 0;

    public PanelDetalle(JPanelEntrar frame) {
        initComponents();

        this.jframe = frame;

        DatoUsuario();
        mostrarPrimerRegistro();

    }

    public void DatoUsuario() {

        //String usuario = jframe.verificarUsuario();  // necesito retornar el usuario usado en la verificacion
        try {

            java.sql.Statement stmt = JavaConnect.getConnection().createStatement(); // creamos una consulta en la base de datos

            //Statement stmt = JavaConnect.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT * FROM coche WHERE cod_usuario = " + Usuario.getNumero() + "");
            ResultSetMetaData rsmd = rs.getMetaData();

        } catch (SQLException ex) {

            Logger.getLogger(JPanelEntrar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /*public void actualizarDatos()
    {
        lblUsuario.setText(Usuario.getNombre());
        datosUsuario();
    }*/
    public void numeroFilas() {

        //
        try {
            rs.last();
            numfilas = rs.getRow();
        } catch (SQLException ex) {
            Logger.getLogger(PanelDetalle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostrarPrimerRegistro() {

        try {

            if (rs != null && rs.next()) {
                jlabelNumeroActual.setText(rs.getRow() + " / " + numfilas);
                textFieldModelo.setText(rs.getString("Modelo"));
                textFieldColor.setText(rs.getString("color"));

            } else {
                JOptionPane.showMessageDialog(this, "No hay más registros.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelDetalle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*public void fechaUsuario()     {
        try
        {
            
           Statement rsAux = JavaConnect.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rsAux = rsAux.executeQuery("SELECT fechaalta FROM usuario WHERE numero = " + Usuario.getNombre() + "");
            
            
            if (rsAux.next()) {
                java.sql.Timestamp timestamp = rsAux.getTimestamp("fechaalta");
                if (timestamp != null) 
                {
                    fecha = new GregorianCalendar();
                    fecha.setTimeInMillis(timestamp.getTime());

                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); // define el formato de la fecha
                    String fechaAltaFormateada = dateFormat.format(fecha.getTime()); // formatea la fecha
                    lblFechaUsuario.setText("Fecha Alta: " + fechaAltaFormateada); // muestro la fecha formateada en el label
                }
            }
        }
        catch (Exception e) 
        {
            System.out.println("ALGO HA FALLADO EN -> PanelDetalle -> fechaUsuario()");
            System.out.println(e);
        }
    }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textFieldColor = new javax.swing.JTextField();
        textFieldModelo = new javax.swing.JTextField();
        btnAnterior = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        lblNumero = new javax.swing.JLabel();
        jlabelNumeroActual = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        textFieldColor.setText("jTextField1");

        textFieldModelo.setText("jTextField1");
        textFieldModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldModeloActionPerformed(evt);
            }
        });

        btnAnterior.setText("Anterior");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        jButton2.setText("Primero");

        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        jButton4.setText("Ultimo");

        lblNumero.setText("Num:");

        jlabelNumeroActual.setText("jLabel1");

        jLabel1.setText("Modelo");

        jLabel2.setText("Color");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2)
                            .addComponent(btnAnterior)
                            .addComponent(lblNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnSiguiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlabelNumeroActual, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(356, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumero)
                    .addComponent(jlabelNumeroActual))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnterior)
                    .addComponent(btnSiguiente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addContainerGap(147, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldModeloActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed

        mostrarPrimerRegistro();

    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed

        try {
            if (!rs.isFirst()) {
                mostrarPrimerRegistro();
                rs.previous();

            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelDetalle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAnteriorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jlabelNumeroActual;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JTextField textFieldColor;
    private javax.swing.JTextField textFieldModelo;
    // End of variables declaration//GEN-END:variables
}
