package com.ejemplo.demo.model;

public class Notificacion {
    private int id;
    private String mensaje;
    private String destinatario;
    private String fecha;
    private boolean leido;

    public Notificacion() {}

    public Notificacion(int id, String mensaje, String destinatario, String fecha, boolean leido) {
        this.id = id;
        this.mensaje = mensaje;
        this.destinatario = destinatario;
        this.fecha = fecha;
        this.leido = leido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isLeido() {
        return leido;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }
}
