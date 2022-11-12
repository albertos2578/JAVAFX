/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AlbertoMoralesGálvez
 */
public class Conexion {
        private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost:3307/comandascrud?zeroDateTimeBehavior=CONVERT_TO_NULL";
    
       private static Connection conexion;
       
       
    static{
        try {
            
            
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            Logger.getLogger(PedidosDAOMYSQL.class.getName()).info("Conexión establecida con exito");
        } catch (SQLException ex) {
            Logger.getLogger(PedidosDAOMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConexion() {
        return conexion;
    }
       
}
