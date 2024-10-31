package co.uniquindio.patronobserver.patronobserverapp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import co.uniquindio.patronobserver.patronobserverapp.model.Producto;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PrincipalController {
    ObservableList<Producto> listaProductos = FXCollections.observableArrayList();
    Producto producto;
    private Notificacion1Controller notificacion1Controller;
    private Notificacion2Controller notificacion2Controller;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizarProducto;

    @FXML
    private Button btnAgregarProducto;

    @FXML
    private Button btnBuscarProducto;

    @FXML
    private Button btnEliminarProducto;

    @FXML
    private TableView<Producto> tableProducto;

    @FXML
    private TableColumn<Producto, Integer> tbCantidad;

    @FXML
    private TableColumn<Producto, String> tbCodigo;

    @FXML
    private TableColumn<Producto, String> tbNombre;

    @FXML
    private TextField txtBuscadorProducto;

    @FXML
    private TextField txtCantidadProducto;

    @FXML
    private TextField txtCodigoProuducto;

    @FXML
    private TextField txtNombreProducto;

    @FXML
    void onActualizarProducto(ActionEvent event) {
        if (!listaProductos.isEmpty()) {
            Producto producto = listaProductos.get(0); // Simulación de un producto
            producto.setCantidad(producto.getCantidad() - 1); // Modificación de la cantidad
        }
    }

    @FXML
    void onAgregarProducto(ActionEvent event) {

    }

    @FXML
    void onBuscarProducto(ActionEvent event) {

    }

    @FXML
    void onEliminarProducto(ActionEvent event) {

    }

    @FXML
    void initialize() {
        notificacion1Controller = new Notificacion1Controller();
        notificacion2Controller = new Notificacion2Controller();
        initDataBinding();
        PrincipalController principalController = new PrincipalController();
        Producto p1 = new Producto();
        p1.setCantidad(20);
        p1.setNombre("Perro");
        p1.setCodigo("123");
        Producto p2 = new Producto();
        p2.setCodigo("456");
        p2.setNombre("Gato");
        p2.setCantidad(10);
        Producto p3 = new Producto();
        p3.setCodigo("789");
        p3.setNombre("Pc");
        p3.setCantidad(10);
        listaProductos.add(p1);
        listaProductos.add(p2);
        listaProductos.add(p3);
        tableProducto.getItems().clear();
        tableProducto.setItems(listaProductos);
    }

    private void initDataBinding() {
        tbCantidad.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getCantidad()).asObject());
        tbCodigo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigo()));
        tbNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
    }
    private void agregarObservers(Producto producto) {
        producto.agregarObserver(notificacion1Controller);
        producto.agregarObserver(notificacion2Controller);
    }

}
