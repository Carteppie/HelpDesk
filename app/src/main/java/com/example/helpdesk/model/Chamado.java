package com.example.helpdesk.model;

import androidx.annotation.NonNull;

import java.util.Date;

public class Chamado {

    private int id;

    private String texto;

    private Date dataEnvio;

    private String status;

    private String solucao;

    private String descricao;

    public Chamado(int id, String texto, Date dataEnvio, String status, String solucao, String descricao) {
        this.id = id;
        this.texto = texto;
        this.dataEnvio = dataEnvio;
        this.status = status;
        this.solucao = solucao;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }

    public Chamado() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    @NonNull
    @Override
    public String toString() {
        return this.texto;
    }
}