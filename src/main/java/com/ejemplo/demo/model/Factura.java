// Factura.java
package com.ejemplo.demo.model;

import java.time.LocalDate;

public class Factura {
    private String id;
    private String clienteId;
    private LocalDate fecha;
    private double total;

    public Factura() {
    }

    public Factura(String id, String clienteId, LocalDate fecha, double total) {
        this.id = id;
        this.clienteId = clienteId;
        this.fecha = fecha;
        this.total = total;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
