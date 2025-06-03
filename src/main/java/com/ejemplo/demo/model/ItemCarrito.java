package com.ejemplo.demo.model;

public class ItemCarrito {
    private String id;
    private String productoId;
    private int cantidad;

    public ItemCarrito() {
    }

    public ItemCarrito(String id, String productoId, int cantidad) {
        this.id = id;
        this.productoId = productoId;
        this.cantidad = cantidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductoId() {
        return productoId;
    }

    public void setProductoId(String productoId) {
        this.productoId = productoId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
