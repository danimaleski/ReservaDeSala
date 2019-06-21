package com.example.udesc.reservadesalas.Model;

public class Reservas {
    String id;
    private String nome;
    private String data;
    private String horario;
    private String sala;
    private String codcancela;

    public Reservas() {}

    public Reservas(String id, String nome, String data, String horario, String sala, String codcancela) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.horario = horario;
        this.sala = sala;
        this.codcancela = codcancela;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getcodcancela() {
        return codcancela;
    }

    public void setcodcancela(String codcancela) {
        this.codcancela = codcancela;
    }
}
