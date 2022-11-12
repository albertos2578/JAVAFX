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
    
    void delete(Timestamp fecha);
    
    void update(Timestamp fecha);
    
    Pedidos get(Timestamp fecha);
    
     ArrayList<Pedidos> GETALGUNOS();
     
     ArrayList<Pedidos> getAllPEDIDOS();
     
 	ArrayList<Pedidos> GetAllPedidosByCliente(String cliente);
 	
    int NumeroClientes();
    ArrayList<Pedidos> NombreClientes();

	String ProductoRepetido();

	int TotalDeIngresosDelMes();
     

}

