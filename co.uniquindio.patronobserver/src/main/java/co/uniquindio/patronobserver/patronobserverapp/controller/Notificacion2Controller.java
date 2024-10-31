package co.uniquindio.patronobserver.patronobserverapp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import co.uniquindio.patronobserver.patronobserverapp.model.Producto;
import co.uniquindio.patronobserver.patronobserverapp.service.IObserver;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.paint.Color;

public class Notificacion2Controller implements IObserver {
    ObservableList<Producto> productosNotificados = FXCollections.observableArrayList();


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label labelEmpleado;

    @FXML
    private TableView<Producto> tableProducto;

    @FXML
    private TableColumn<Producto, Integer> tbCantidad;

    @FXML
    private TableColumn<Producto, String> tbCodigo;

    @FXML
    private TableColumn<Producto, String> tbNombre;

    @FXML
    void initialize() {
        initDataBinding();
        tableProducto.setItems(productosNotificados);
    }

    private void initDataBinding() {
        tbCantidad.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getCantidad()).asObject());
        tbCodigo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigo()));
        tbNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
    }

    @Override
    public void actualizar(int cantidad, String nombre, String codigo) {
        Producto productoActualizado = new Producto();
        productoActualizado.setCantidad(cantidad);
        productoActualizado.setNombre(nombre);
        productoActualizado.setCodigo(codigo);

        // Agrega o actualiza el producto en la lista de productos notificados
        productosNotificados.removeIf(p -> p.getCodigo().equals(codigo));
        productosNotificados.add(productoActualizado);

        tableProducto.refresh();

        if (cantidad <= 0) {
            labelEmpleado.setTextFill(Color.RED);
            labelEmpleado.setText("Producto fuera de stock");
        } else {
            labelEmpleado.setTextFill(Color.BLACK);
            labelEmpleado.setText("Producto en stock");
        }

    }
}



