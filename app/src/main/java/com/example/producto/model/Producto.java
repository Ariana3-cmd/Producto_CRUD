package com.example.producto.model;

public class Producto {
    private Integer _id;
    private String nombre;
    private String precio;
    private String stock;

    public Producto() {
    }

    public Producto(Integer _id, String nombre, String precio, String stock) {
        this._id = _id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
}
