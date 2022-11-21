/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author AlbertoMoralesGálvez
 */

import controler.Conexion;
import controler.PedidosDAOMYSQL;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Setter;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author AlbertoMoralesGálvez
 */

public class Pedidos implements Serializable {
    
    
     private int NumeroPedido; 
     private Timestamp fecha;
     private String cliente;
     private String estado;
     private String  producto;

    @Override
    public String toString() {
        return "Pedidos{" + "NumeroPedido=" + NumeroPedido + ", fecha=" + fecha + ", cliente=" + cliente + ", estado=" + estado + ", producto=" + producto + '}';
    }
    

	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
       

    public int getNumeroPedido() {
        return NumeroPedido;
    }

    public void setNumeroPedido(int NumeroPedido) {
        this.NumeroPedido = NumeroPedido;
    }
 
     
     
      
        }
            
