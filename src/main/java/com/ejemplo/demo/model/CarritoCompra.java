package com.ejemplo.demo.model;

public class CarritoCompra {
    private String id;
    private String clienteId;
    private String fecha;

    public CarritoCompra() {}

    public CarritoCompra(String id, String clienteId, String fecha) {
        this.id = id;
        this.clienteId = clienteId;
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
