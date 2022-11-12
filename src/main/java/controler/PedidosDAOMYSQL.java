/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Pedidos;
import models.Productos;

/**
 *
 * @author AlbertoMoralesGÃ¡lvez
 */


    
public class PedidosDAOMYSQL implements PedidosDAO {
    
    
	  private static final String getpedidoporcliente_query= "Select * From `pedidos` where cliente= ? ";
      private static final String GET_PEDIDOS_HOY_QUERY= "Select *  From `pedidos` where EXTRACT(DAY FROM fecha)= EXTRACT(DAY FROM CURDATE());";
      private static final String DELETE_QUERY = "DELETE FROM pedidos WHERE `pedidos`.`fecha` = ?";
      private static final String UPDATE= "update `pedidos` SET `estado` = ? WHERE `pedidos`.`fecha` = ?;";
       private static final String GETALLPEDIDOS = "SELECT * FROM `pedidos`";
      private static final String Ventas_QUERY= "SELECT sum(precio) FROM productos INNER JOIN pedidos ON pedidos.producto = p.nombre where EXTRACT(MONTH FROM fecha) = EXTRACT(MONTH FROM NOW());";
       private static final String add_query  = "INSERT INTO `pedidos` (`cliente`, `estado`, `producto`, `fecha`) VALUES (?, ?, ?, ?);";
       private static final String Numero_clientes_QUERY = "SELECT count(DISTINCT cliente) as 'miau' FROM `pedidos`;";
       private static final String Nombres_clientes_QUERY = "SELECT DISTINCT cliente FROM `pedidos`;";
       	private static final String Producto_Fav_QUERY = "SELECT producto FROM `pedidos` group by producto order by COUNT(producto) desc limit 1;";
      private static Connection conexion= Conexion.getConexion();

    public PedidosDAOMYSQL () {
        
    }
   
        

    
    
    public void add(Pedidos a) {
          try(var pst =  conexion.prepareStatement(add_query)){
              pst.setString(1, a.getCliente());
              pst.setString(2, a.getEstado());
              pst.setString(3, a.getProducto());
              pst.setTimestamp(4, a.getFecha());
                 if (pst.executeUpdate()>0){
                     
               
                 };
          } catch (SQLException ex) {
              Logger.getLogger(ProductosDAOMYSQL.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

  

 

  
    public void delete(Timestamp fecha) {
         
         try(var pst=conexion.prepareStatement(DELETE_QUERY)){
             pst.setTimestamp(1, fecha);
            if( pst.executeUpdate()==0){
                Logger.getLogger(ProductosDAOMYSQL.class.getName()).warning("Ese re no existe");
            };

         } catch (SQLException ex) {
              Logger.getLogger(ProductosDAOMYSQL.class.getName()).log(Level.SEVERE, null, ex);
          }
}

   
   
    public void update(Timestamp fecha){
          try( var pst=conexion.prepareStatement(UPDATE)){
        
        	  		pst.setString(1, "Recogido");
                    pst.setTimestamp(2, fecha);
                   if(pst.executeUpdate()==0){
                        Logger.getLogger(PedidosDAOMYSQL.class.getName()).warning("cliente no existe");
                   }
    }     catch (SQLException ex) {
              Logger.getLogger(PedidosDAOMYSQL.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

   @Override
    public ArrayList<Pedidos> GETALGUNOS() {
        
        var salida = new ArrayList<Pedidos>();
        try(var pst=conexion.prepareStatement(GET_PEDIDOS_HOY_QUERY)){
            ResultSet resultado = pst.executeQuery();
            while(resultado.next()){
                  var  pedido = new Pedidos();
            pedido.setCliente(resultado.getString("cliente"));
            pedido.setEstado(resultado.getString("estado"));
            pedido.setProducto(resultado.getString("producto"));
            pedido.setFecha(resultado.getTimestamp("fecha"));
               salida.add(pedido);
                
            }
        } catch (SQLException ex) {
              Logger.getLogger(PedidosDAOMYSQL.class.getName()).log(Level.SEVERE, null, ex);
          }
     return salida;
    }


    public ArrayList<Pedidos> getAllPEDIDOS() {
       
          var salida = new ArrayList<Pedidos>();
        try(var pst=conexion.prepareStatement(GETALLPEDIDOS)){
            ResultSet resultado = pst.executeQuery();
            while(resultado.next()){
                  var  pedido = new Pedidos();
            pedido.setCliente(resultado.getString("cliente"));
            pedido.setEstado(resultado.getString("estado"));
            pedido.setProducto(resultado.getString("producto"));
            pedido.setFecha(resultado.getTimestamp("fecha"));
               salida.add(pedido);
                
            }
        } catch (SQLException ex) {
              Logger.getLogger(PedidosDAOMYSQL.class.getName()).log(Level.SEVERE, null, ex);
          }
     return salida;
    }





	@Override
	public ArrayList<Pedidos> GetAllPedidosByCliente(String cliente) {
		   var salida = new ArrayList<Pedidos>();
	        try(var pst=conexion.prepareStatement(getpedidoporcliente_query)){
	        	 pst.setString(1, cliente);
	            ResultSet resultado = pst.executeQuery();
	            while(resultado.next()){
	                  var  pedido = new Pedidos();
	            pedido.setCliente(resultado.getString("cliente"));
	            pedido.setEstado(resultado.getString("estado"));
	            pedido.setProducto(resultado.getString("producto"));
	            pedido.setFecha(resultado.getTimestamp("fecha"));
                 
	               salida.add(pedido);
	                
	            }
	        } catch (SQLException ex) {
	              Logger.getLogger(PedidosDAOMYSQL.class.getName()).log(Level.SEVERE, null, ex);
	          }
	     return salida;
	    }
        
          @Override
    public int NumeroClientes() {
        int a = 0;
      
        try(var pst=conexion.prepareStatement(Numero_clientes_QUERY)){
            ResultSet resultado = pst.executeQuery();
               if (resultado.next()) {
  
              a= resultado.getInt("miau");
              System.out.println(a);
               }
            
        } catch (SQLException ex) {
              Logger.getLogger(PedidosDAOMYSQL.class.getName()).log(Level.SEVERE, null, ex);
          }
     return a;
    }
          






		@Override
		public Pedidos get(Timestamp fecha) {
		      var  pedido = new Pedidos();
		    try(var pst=conexion.prepareStatement(GETALLPEDIDOS)){
	            ResultSet resultado = pst.executeQuery();
	            while(resultado.next()){
	            
	            pedido.setCliente(resultado.getString("cliente"));
	            pedido.setEstado(resultado.getString("estado"));
	            pedido.setProducto(resultado.getString("producto"));
	            pedido.setFecha(resultado.getTimestamp("fecha"));
	               
	                
	            }
	        } catch (SQLException ex) {
	              Logger.getLogger(PedidosDAOMYSQL.class.getName()).log(Level.SEVERE, null, ex);
	          }
	     return pedido;
	    }





		@Override
		public ArrayList<Pedidos> NombreClientes() {
			
			   var salida = new ArrayList<Pedidos>();
		        try(var pst=conexion.prepareStatement(Nombres_clientes_QUERY)){
		        	
		            ResultSet resultado = pst.executeQuery();
		            while(resultado.next()){
		                  var  pedido = new Pedidos();
		            pedido.setCliente(resultado.getString("cliente"));
           
		               salida.add(pedido);
		         
		                
		            }
		        } catch (SQLException ex) {
		              Logger.getLogger(PedidosDAOMYSQL.class.getName()).log(Level.SEVERE, null, ex);
		          }
		     return salida;
		}
		
		   @Override
		    public String ProductoRepetido() {
			
					  String salida = "";
				        try(var pst=conexion.prepareStatement(Producto_Fav_QUERY)){
				        	
				            ResultSet resultado = pst.executeQuery();
				        
				               if (resultado.next()) {
		  
		              salida= resultado.getString("producto");
		             
		               }
       
				            } catch (SQLException ex) {
		                  Logger.getLogger(PedidosDAOMYSQL.class.getName()).log(Level.SEVERE, null, ex);
		              }
				      
				     return salida;
				}
		   
		   
		   @Override
		    public int TotalDeIngresosDelMes() {
			
					  int salida = 0;
				        try(var pst=conexion.prepareStatement(Ventas_QUERY)){
				        	
				            ResultSet resultado = pst.executeQuery();
				        
				               if (resultado.next()) {
		  
		              salida= resultado.getInt("sum(precio)");
		             
		               }
      
				            } catch (SQLException ex) {
		                  Logger.getLogger(PedidosDAOMYSQL.class.getName()).log(Level.SEVERE, null, ex);
		              }
				      
				     return salida;
				}
			
		}

    
   
      
 
    
    
    



  
    



