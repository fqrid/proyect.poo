package com.ejemplo.demo.model;

public class ItemCarrito {
    private Long id;
    private Long carritoId;
    private Long productoId;
    private Integer cantidad;

    // Constructor vacío
    public ItemCarrito() {}

    // Constructor con parámetros
    public ItemCarrito(Long carritoId, Long productoId, Integer cantidad) {
        this.carritoId = carritoId;
        this.productoId = productoId;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCarritoId() {
        return carritoId;
    }

    public void setCarritoId(Long carritoId) {
        this.carritoId = carritoId;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    // Método toString para mejor visualización del objeto
    @Override
    public String toString() {
        return "ItemCarrito{" +
                "id=" + id +
                ", carritoId=" + carritoId +
                ", productoId=" + productoId +
                ", cantidad=" + cantidad +
                '}';
    }
}