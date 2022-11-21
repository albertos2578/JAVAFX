package com.mycompany.jdbc_fx;

import controler.Conexion;
import controler.PedidosDAOMYSQL;
import controler.ProductosDAOMYSQL;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import models.Pedidos;

public class PrimaryController implements Initializable {
     
    static PedidosDAOMYSQL dau = new PedidosDAOMYSQL();
    ArrayList<Timestamp> tiemposDePedidos = new ArrayList<Timestamp>();
    int numerito;
    Pedidos pedidosActualizar= new Pedidos();
    String  cli;
    String pro;
    String est;
    Timestamp fec;
    int numeropeda;
       
        
   
    @FXML
    private Button btnAñadir;
    @FXML
    private Button btnActualizar;
    @FXML
    private TableView<Pedidos> tabla;
    @FXML
    private TableColumn<Pedidos, Integer> NumeroDelPedido;
    @FXML
    private TableColumn<Pedidos, String> clienteID;
    @FXML
    private TableColumn<Pedidos, String> productoID;
    @FXML
    private TableColumn<Pedidos, String> estadoID;
    @FXML
    private TableColumn<Pedidos, Timestamp> fechaID;
   
    @FXML
    private TextField ClienteText;
    @FXML
    private TextField ProductoText;
    @FXML
    private TextField textEstado;
    @FXML
    private TextField textFecha;
    @FXML
    private TextField NumeroPedido;
    @FXML
    private Button BorrarID;
    @FXML
    private Button Volver;
   
    
     
   

  
      @Override
    public void initialize(URL url, ResourceBundle rb) {
             this.NumeroDelPedido.setCellValueFactory(new PropertyValueFactory<>("NumeroPedido"));
	     this.clienteID.setCellValueFactory(new PropertyValueFactory<>("cliente"));
             this.productoID.setCellValueFactory(new PropertyValueFactory<>("estado"));
              this.estadoID.setCellValueFactory(new PropertyValueFactory<>("producto"));
               this.fechaID.setCellValueFactory(new PropertyValueFactory<>("fecha"));
            Pedidos p= new Pedidos();
       ArrayList<Pedidos> items= dau.GETALGUNOS();
    var   itemss = FXCollections.observableList(items);
       this.tabla.setItems(itemss);
    }



    @FXML
    private void Volver(ActionEvent event) {
         try {
              App.setRoot("secondary");
          } catch (IOException ex) {
              Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    @FXML
    private void añadirPedido(ActionEvent event) {//mejora adicional
           try {
              App.setRoot("añadir");
          } catch (IOException ex) {
              Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
          }
        
    }

    @FXML
    private void actualizarPedido(ActionEvent event) {
                      
     numeropeda = Integer.parseInt(NumeroPedido.getText());
   
           cli=ClienteText.getText();
           pedidosActualizar.setCliente(cli);
              est=textEstado.getText();
           pedidosActualizar.setEstado(est);
           pro=ProductoText.getText();
           pedidosActualizar.setProducto(pro);
            dau.update(numeropeda,pedidosActualizar);
        
         //actualizamos la tabla que tenemos en ejecucion
         Pedidos p= new Pedidos();
       ArrayList<Pedidos> items= dau.GETALGUNOS();
    var   itemss = FXCollections.observableList(items);
       this.tabla.setItems(itemss);
    }

    @FXML
    private void borrarPedido(ActionEvent event) {//mejora adicional
          numeropeda = Integer.parseInt(NumeroPedido.getText());
        dau.delete(numeropeda);
     
             Pedidos p= new Pedidos();
       ArrayList<Pedidos> items= dau.GETALGUNOS();
    var   itemss = FXCollections.observableList(items);
       this.tabla.setItems(itemss);
              NumeroPedido.setText("");
           ClienteText.setText("");
            textEstado.setText("");
            ProductoText.setText("");
                 textFecha.setText("");
    }

    @FXML
    private void mostrarPedido(MouseEvent event) {
          Pedidos pedidos = tabla.getSelectionModel().getSelectedItem();
     
      

        if (pedidos != null) {
            NumeroPedido.setText(pedidos.getNumeroPedido()+"");
       
            ClienteText.setText(pedidos.getCliente());
            textEstado.setText(pedidos.getEstado());
            ProductoText.setText(pedidos.getProducto());
                 textFecha.setText(pedidos.getFecha().toString());
    }
    }
}
