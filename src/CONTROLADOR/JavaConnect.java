package CONTROLADOR;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaConnect {

    static Connection con;

    public static Connection connectdb() {

        try {

            Class.forName("org.apache.derby.jdbc.ClientDriver");
            System.out.println("Driver encontrado");

        } catch (Exception e) {
            System.out.println("JDBC driver falied to load.");
            return null;
        }

        try {

            con = DriverManager.getConnection("jdbc:derby://localhost:1527/UsuariosCoches", "rodrigo", "admin");
            System.out.println("Conectado");

        } catch (Exception e) {
            System.out.println(e);
        }

        return con;
    }

    public static Connection getConnection() {

        return con;
    }

    public static void CerrarConexion() {

        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(JavaConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
