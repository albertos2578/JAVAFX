/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Productos;

/**
 *
 * @author AlbertoMoralesGÃ¡lvez
 */

  

    public class ProductosDAOMYSQL implements ProductosDAO {
    
   


       private static final String Productos = "SELECT * FROM `productos` order by tipo";
    private static Connection conexion= Conexion.getConexion();
    public ProductosDAOMYSQL() {
        
    }
    
       public  ArrayList<Productos> getAllProductos(){
       {
       
          var salida = new ArrayList<Productos>();
        try(var pst=conexion.prepareStatement(Productos)){
            ResultSet resultado = pst.executeQuery();
            while(resultado.next()){
                  var  producto = new Productos();
            producto.setNombre(resultado.getString("nombre"));
            producto.setTipo(resultado.getString("tipo"));
            producto.setPrecio(resultado.getDouble("precio"));
            producto.setDisponibilidad(resultado.getString("disponibilidad"));
               salida.add(producto);
              
                
            }
        } catch (SQLException ex) {
              Logger.getLogger(PedidosDAOMYSQL.class.getName()).log(Level.SEVERE, null, ex);
          }
     return salida;
    }
       
   
    }

   
    }
 

 
   
        

    

