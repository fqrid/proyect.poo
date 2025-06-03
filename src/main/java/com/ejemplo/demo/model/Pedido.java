package com.ejemplo.demo.model;

public class Pedido {
    private String id;
    private String clienteId;
    private String fechaPedido;

    public Pedido() {}

    public Pedido(String id, String clienteId, String fechaPedido) {
        this.id = id;
        this.clienteId = clienteId;
        this.fechaPedido = fechaPedido;
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

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }
}