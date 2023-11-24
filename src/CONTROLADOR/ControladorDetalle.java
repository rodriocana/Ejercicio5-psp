/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import MODELO.Usuario;
import VISTA.JPanelEntrar;
import com.sun.jdi.connect.spi.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rodri
 */
public class ControladorDetalle {

    ResultSet rs;
    ResultSet rsAux;
    int numfilas = 0;

    public ControladorDetalle() {

        DatoUsuario();

    }

    public Connection DatoUsuario() {

        try {

            Statement stmt = JavaConnect.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT * FROM coche WHERE cod_usuario = " + Usuario.getNumero() + "");
            ResultSetMetaData rsmd = rs.getMetaData();

        } catch (SQLException ex) {

            Logger.getLogger(JPanelEntrar.class.getName()).log(Level.SEVERE, null, ex);
        }

        return (Connection) rs;

    }

}
