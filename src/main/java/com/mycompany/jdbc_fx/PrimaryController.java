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
    private MenuItem menuSalir;
    @FXML
    private Label info;
   
    @FXML
    private Button btnAñadir;
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnBorrar;
    @FXML
    private Label detalle;
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
   
    
     
   

    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
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
    private void abrirVentanaPerfil(ActionEvent event) {
    }

    @FXML
    private void switchToPrimary(ActionEvent event) {
    }

    @FXML
    private void añadirTarea(ActionEvent event) {
            try {
              App.setRoot("añadir");
          } catch (IOException ex) {
              Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    

    @FXML
    private void actualizarTarea(ActionEvent event) {
      
                   
     numeropeda = Integer.parseInt(NumeroPedido.getText());
          
            System.out.println(numeropeda);
            
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
    private void borrarTarea(ActionEvent event) {
          try {
              App.setRoot("secondary");
          } catch (IOException ex) {
              Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    @FXML
    private void mostrarTarea(MouseEvent event) {
          Pedidos pedidos = tabla.getSelectionModel().getSelectedItem();
          Timestamp ara = pedidos.getFecha();
      

        if (pedidos != null) {
            NumeroPedido.setText(pedidos.getNumeroPedido()+"");
            System.out.println(pedidos.getNumeroPedido());
            ClienteText.setText(pedidos.getCliente());
            textEstado.setText(pedidos.getEstado());
            ProductoText.setText(pedidos.getProducto());
                 textFecha.setText(pedidos.getFecha().toString());
    
    }

  
}
}
