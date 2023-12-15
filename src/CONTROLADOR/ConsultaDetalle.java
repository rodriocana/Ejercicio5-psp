/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import MODELO.Coche;
import MODELO.Usuario;
import VISTA.JPanelEntrar;
import java.sql.Connection;

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
public class ConsultaDetalle {

    private static ResultSet rs;
    ResultSet rsAux;
    int numfilas = 0;

    public ConsultaDetalle() {

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

    public static Coche inicial(Usuario usuario) throws SQLException {

        Coche coche = new Coche();

        rs.first();
        coche.setCod_coche(rs.getInt("ID"));
        coche.setCodigo_usuario(rs.getInt("CODIGOUSUARIO"));
        coche.setColor(rs.getString("COLOR"));
        coche.setModelo(rs.getString("MODELO"));

        return coche;
    }

    public static Coche Siguiente(Usuario usuario) throws SQLException {

        Coche coche = new Coche();

        if (!rs.isAfterLast()) {
            coche.setCod_coche(rs.getInt("ID"));
            coche.setCodigo_usuario(rs.getInt("CODIGOUSUARIO"));
            coche.setColor(rs.getString("COLOR"));
            coche.setModelo(rs.getString("MODELO"));

        }

        return coche;
    }

    public static Coche Atras(Usuario usuario) throws SQLException {

        Coche coche = new Coche();

        if (!rs.isAfterLast()) {

            coche.setCod_coche(rs.getInt("ID"));
            coche.setCodigo_usuario(rs.getInt("CODIGOUSUARIO"));
            coche.setColor(rs.getString("COLOR"));
            coche.setModelo(rs.getString("MODELO"));
        }

        return coche ;

    }
    
public static ResultSet getResultSet(Usuario user){
        
        try {
            Connection conexion;
            conexion = JavaConnect.getConnection();
            Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs;
            //rs = st.executeQuery("SELECT ID, CODIGOUSUARIO, NOMBRE, PRECIO, DESCRIPCION FROM MANGA M INNER JOIN USUARIO U ON M.CODIGOUSUARIO = U.IDUSUARIO WHERE U.USUARIO = '"+user.getNombre()+ "' AND U.CONTRASENIA = '"+user.getContrasenia()+"'");
             rs = st.executeQuery("SELECT * FROM coche WHERE cod_usuario = " + Usuario.getNumero() + "");
            
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDetalle.class.getName()).log(Level.SEVERE, null, ex);
            
        };
        
        return null;  
    }

}
    
   
        
        


