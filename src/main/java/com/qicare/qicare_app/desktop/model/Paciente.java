package com.qicare.qicare_app.desktop.model;

public class Paciente {
    private String nome;
    private String peso;
    private String idade;
    private String altura;
    private String observacoes;
    private String analise;

    // Getters e Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPeso() {
        return peso;
    }
    public void setPeso(String peso) {
        this.peso = peso;
    }
    public void setAltura(String altura) {
        this.altura = altura;
    }
    public String getIdade() {
        return idade;
    }
    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getObservacoes() {
        return observacoes;
    }
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getAnalise() {
        return analise;
    }
    public void setAnalise(String analise) {
        this.analise = analise;
    }
}