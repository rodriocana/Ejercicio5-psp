/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import CONTROLADOR.JavaConnect;
import MODELO.Usuario;
import java.sql.Connection;
import java.sql.*;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author bosque
 */
public class JPanelEntrar extends javax.swing.JPanel {

    String usuario;
    String contraseña;
    int numero;
    String nombre;
    float sueldo;
    String password;
    String fechaAlta;
    int existe;
    int crear;
    byte[] imagenBytes;
    static Usuario usuarioActual;

    private final JFramePrincipal JFramePrincipal1;

    public JPanelEntrar(JFramePrincipal frame) {
        initComponents();

        this.JFramePrincipal1 = frame;

    }

    /*public byte[] foto()
    {
        String rutaImagen = "C:\\Users\\sleza\\OneDrive\\StevenDrive\\DAM\\Temario 2 DAM\\Programacion Servicios y Procesos (HLC)\\p05_BDs_derby\\fotos\\1002.jpg";
        
        File imagenFile = new File(rutaImagen);
        imagenBytes = new byte[(int) imagenFile.length()];
        try (FileInputStream inputStream = new FileInputStream(imagenFile);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream)) 
        {
            bufferedInputStream.read(imagenBytes, 0, imagenBytes.length);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        
        return imagenBytes;
    }*/
    public String verificarUsuario() {

        ResultSet rs;

        usuario = jTextFieldUsuario.getText();
        contraseña = jPasswordField1.getText();

        try {

            Statement stmt = JavaConnect.getConnection().createStatement(); // creamos una consulta en la base de datos
            rs = stmt.executeQuery("SELECT * FROM usuario WHERE nombre = '" + usuario + "'");
            ResultSetMetaData rsmd = rs.getMetaData();

            existe = 0; //inicializo la variable a 0 cada vez que se ejecuta la consulta
            crear = 0; //idem

            while (rs.next()) {

                // aqui guardamos los valores de los campos de la tabla en variables
                numero = rs.getInt(1);
                nombre = rs.getString(2);
                sueldo = rs.getFloat(3);
                fechaAlta = rs.getString(4);
                password = rs.getString(5);

                System.out.print(rs.getString(1) + " ");

                if (password.equals(contraseña)) {

                    System.out.println("Usuario y contraseña CORRECTA");
                    ((JFramePrincipal) JFramePrincipal1).VisibilizarMenu(); // APRENDER BIEN
                    existe++;
                    crear++;
                    
                     jTextArea1.setText("Verificacion correcta!!");
                    
                    usuarioActual = new Usuario(numero, nombre, sueldo, fechaAlta, password, imagenBytes);
                    System.out.println("Usuario creado");
                    return usuario;

                } else {

                    System.out.println("Usuario y contraseña INCORRECTA");
                    existe++;
                    jTextArea1.setText("Verificacion Incorrecta!!");
                }

                rs.close();
                stmt.close();

                //JavaConnect.CerrarConexion();
                System.out.println("");
            }

            if (existe == 0) //si la variable vuelve a 0, avisa que el usuario no existe
            {
                System.out.println("USUARIO INEXISTENTE");

            }

            if (crear != 0) //objeto Usuario creado si la contraseña y usuario son correctos
            {
                
            }

            
        } catch (SQLException ex) {
            Logger.getLogger(JPanelEntrar.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelUsuario = new javax.swing.JLabel();
        jLabelContrasena = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jButtonAceptar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPasswordField1 = new javax.swing.JPasswordField();

        jLabelUsuario.setText("Usuario:");

        jLabelContrasena.setText("Contraseña:");

        jTextFieldUsuario.setText("usuario");

        jButtonAceptar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jButtonCancelar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 3));
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelUsuario)
                            .addComponent(jLabelContrasena))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(jPasswordField1))
                        .addContainerGap(102, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAceptar)
                        .addGap(62, 62, 62))))
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUsuario)
                    .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelContrasena)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonAceptar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed

        verificarUsuario();
        
       
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        String nombre = javax.swing.JOptionPane.showInputDialog("Escriba su nombre para salir");
        javax.swing.JOptionPane.showMessageDialog(null, nombre + " Hasta luego!!!");
    }//GEN-LAST:event_jButtonCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabelContrasena;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables
}
