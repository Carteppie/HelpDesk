package com.example.helpdesk.model;

public class Mensagem {
    private long id;
    private String texto;
    private Status status;

    public Mensagem(long id, String texto, Status status) {
        this.id = id;
        this.texto = texto;
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Mensagem{" +
                "texto='" + texto + '\'' +
                '}';
    }
}
