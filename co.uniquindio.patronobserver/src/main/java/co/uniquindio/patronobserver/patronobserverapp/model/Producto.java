package co.uniquindio.patronobserver.patronobserverapp.model;

import co.uniquindio.patronobserver.patronobserverapp.service.IObserver;

import java.util.ArrayList;
import java.util.List;

public class Producto {
    private List<IObserver> observers = new ArrayList<>();
    private int cantidad;
    private String nombre;
    private String codigo;

    public Producto(List<IObserver> observers, int cantidad, String nombre, String codigo) {
        this.observers = observers;
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.codigo = codigo;
    }
    public Producto(){}

    public void agregarObserver(IObserver observer) {
        observers.add(observer);
    }

    public void eliminarObserver(IObserver observer) {
        observers.remove(observer);
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        notificarObservers();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        notificarObservers();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
        notificarObservers();
    }

    private void notificarObservers() {
        for (IObserver observer : observers) {
            observer.actualizar(cantidad,nombre,codigo);
        }
    }
}
