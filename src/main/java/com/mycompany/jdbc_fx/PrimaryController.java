package com.mycompany.jdbc_fx;

import controler.Conexion;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
   
    @FXML
    private MenuItem menuSalir;
    @FXML
    private Label info;
    @FXML
    private TextField textId;
    @FXML
    private TextField textActividad;
    @FXML
    private TextField textCategoria;
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
    private TableColumn<Pedidos, String> clienteID;
    @FXML
    private TableColumn<Pedidos, String> productoID;
    @FXML
    private TableColumn<Pedidos, String> estadoID;
    @FXML
    private TableColumn<Pedidos, Timestamp> fechaID;
    
     
   

    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
      @Override
    public void initialize(URL url, ResourceBundle rb) {
  
	     this.clienteID.setCellValueFactory(new PropertyValueFactory<>("cliente"));
             this.productoID.setCellValueFactory(new PropertyValueFactory<>("estado"));
              this.estadoID.setCellValueFactory(new PropertyValueFactory<>("producto"));
               this.fechaID.setCellValueFactory(new PropertyValueFactory<>("fecha"));
            Pedidos p= new Pedidos();
       ObservableList<Pedidos> items= p.getPedidos();
       this.tabla.setItems(items);
    }

    @FXML
    private void abrirVentanaPerfil(ActionEvent event) {
    }

    @FXML
    private void switchToPrimary(ActionEvent event) {
    }

    @FXML
    private void añadirTarea(ActionEvent event) {
    }

    @FXML
    private void actualizarTarea(ActionEvent event) {
    }

    @FXML
    private void borrarTarea(ActionEvent event) {
    }

    @FXML
    private void mostrarTarea(MouseEvent event) {
          Pedidos pedidos = tabla.getSelectionModel().getSelectedItem();

        System.out.println(tabla.getSelectionModel().getSelectedIndex());

        if (pedidos != null) {
            textId.setText(pedidos.getCliente());
            textActividad.setText(pedidos.getEstado());
            textCategoria.setText(pedidos.getProducto());
            
    }

  
}
}
