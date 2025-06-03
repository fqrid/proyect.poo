package com.ejemplo.demo.model;

public class Factura {
    private Integer id;
    private Cliente cliente;
    private double total;

    public Factura() {}

    public Factura(Integer id, Cliente cliente, double total) {
        this.id = id;
        this.cliente = cliente;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}