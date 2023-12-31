/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import MODELO.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Rodri
 */
public class ConsultaUsuario {

    public ConsultaUsuario(JavaConnect con) {

    }

    public static Usuario getUsuario(String nombre, String contraseña) throws SQLException {

        //en esta funcion le pasamos el nombre y contraseña introducidos y sacamos sus datos llamando a la funcion recorrer y pasandole el rs
        Statement stmt = JavaConnect.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery("Select NUMERO, NOMBRE, SUELDO, FECHAALTA, PASSWORD from USUARIO where NOMBRE = '" + nombre + "'" + " AND PASSWORD = '" + contraseña + "'");
        ResultSetMetaData rsmd = rs.getMetaData();  

        // resultSetMetaData es una interfaz que proporciona información sobre los metadatos del ResultSet, 
        //como el número de columnas, nombres de columnas, tipos de datos, etc.
 
        return recorrer(rs);
    }

    public static Usuario recorrer(ResultSet rs) throws SQLException {
        
        Usuario user = null;
        
        // aqui se pasan los datos del usuario introducido a las variables.

        while (rs.next()) {

            int numero = rs.getInt("NUMERO");
            String nombre = rs.getString("NOMBRE");
            Float sueldo = rs.getFloat("SUELDO");
            String fechaAlta = rs.getString("FECHAALTA");
            String password = rs.getString("PASSWORD");

            user = new Usuario(numero, nombre, sueldo, fechaAlta, password);
            
            System.out.println("Nombre de usuario: " + nombre + " " + password + " " + sueldo + " " + numero);
            System.out.println("La contraseña del usuario uno desde consultaUsuario es" + user.getPassword());
        }
        return user;
    }
    
     public static ArrayList<Usuario> listaUsuarios() throws SQLException {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        Connection conexion = JavaConnect.getConnection();
        Statement st = conexion.createStatement();

        ResultSet rs = st.executeQuery("Select IDUSUARIO, USUARIO, CONTRASENIA, FECHAINGRESO, FOTO from USUARIO");
        Usuario user;
        while (rs.next()) {

            int numero = rs.getInt("NUMERO");
            String nombre = rs.getString("NOMBRE");
            Float sueldo = rs.getFloat("SUELDO");
            String fechaAlta = rs.getString("FECHAALTA");
            String password = rs.getString("PASSWORD");
            user = new Usuario(numero, nombre, sueldo, fechaAlta, password);
            listaUsuarios.add(user);
        }
        return listaUsuarios;

    }

}
