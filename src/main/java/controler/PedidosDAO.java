/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controler;

import java.sql.Timestamp;
import java.util.ArrayList;

import models.Pedidos;

/**
 *
 * @author AlbertoMoralesGálvez
 */
public interface PedidosDAO {
    
	void add(Pedidos p);
    
    void delete(int numeroPedid);
    
    void update(int numeroPedid,Pedidos pedidoActualizar);
    
    Pedidos get(Timestamp fecha);
    
     ArrayList<Pedidos> GETALGUNOS();
     
     ArrayList<Pedidos> getAllPEDIDOS();
     
 
 	

   

}

