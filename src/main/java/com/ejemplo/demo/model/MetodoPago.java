package com.ejemplo.demo.model;

public class MetodoPago {
    private Long id;
    private Long clienteId;
    private String tipoMetodo;
    private String detalles;
    private Cliente cliente;

    // Constructor vacío
    public MetodoPago() {}

    // Constructor con parámetros
    public MetodoPago(Long clienteId, String tipoMetodo, String detalles) {
        this.clienteId = clienteId;
        this.tipoMetodo = tipoMetodo;
        this.detalles = detalles;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getTipoMetodo() {
        return tipoMetodo;
    }

    public void setTipoMetodo(String tipoMetodo) {
        this.tipoMetodo = tipoMetodo;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}