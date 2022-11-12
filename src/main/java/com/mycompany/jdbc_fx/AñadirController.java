/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.jdbc_fx;

import static com.mycompany.jdbc_fx.PrimaryController.dau;
import controler.ProductosDAOMYSQL;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import models.Pedidos;
import models.Productos;
import org.hibernate.query.criteria.internal.expression.function.CurrentTimeFunction;
/**
 * FXML Controller class
 *
 * @author alber
 */
public class AñadirController implements Initializable {
 static ProductosDAOMYSQL dao = new ProductosDAOMYSQL();

    @FXML
    private TableView<Productos> tablaProducto;
    @FXML
    private TableColumn<Productos, String> Producto;
    @FXML
    private TextField ClienteText;
    @FXML
    private TextField ProductoText;
    @FXML
    private Button btnAñadir;
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnBorrar;
    @FXML
    private TableColumn<Productos, String> Disponibilidad;
    @FXML
    private TableColumn<Productos, String> TipoID;
    @FXML
    private TableColumn<Productos, Integer> precioID;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
       this.Producto.setCellValueFactory(new PropertyValueFactory<>("nombre"));
	     this.Disponibilidad.setCellValueFactory(new PropertyValueFactory<>("disponibilidad"));
             this.TipoID.setCellValueFactory(new PropertyValueFactory<>("tipo"));
              this.precioID.setCellValueFactory(new PropertyValueFactory<>("precio"));
           
            Productos pro= new Productos();
       ArrayList<Productos> items= dao.getAllProductos();
    var   itemss = FXCollections.observableList(items);
       this.tablaProducto.setItems(itemss);
    }
      
    
    @FXML
    private void mostrarTarea(MouseEvent event) {
    }

    @FXML
    private void añadirTarea(ActionEvent event) {
        Pedidos pedidoAñadir= new Pedidos();
        ClienteText.getText();
        ProductoText.getText();
        Timestamp fecha= new Timestamp(System.currentTimeMillis());
        pedidoAñadir.setCliente(ClienteText.getText());
        pedidoAñadir.setProducto(ProductoText.getText());
        pedidoAñadir.setEstado("En preparación");
        pedidoAñadir.setFecha(fecha);
        dau.add(pedidoAñadir);
    }

    @FXML
    private void actualizarTarea(ActionEvent event) {
    }

    @FXML
    private void borrarTarea(ActionEvent event) {
    }

}
