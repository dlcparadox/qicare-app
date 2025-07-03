package com.qicare.qicare_app.desktop.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PacienteController {

    @FXML
    private TextField nomeField;

    @FXML
    private TextField pesoField;

    @FXML
    private TextField idadeField;

    @FXML
    private TextArea observacoesField;

    @FXML
    private TextArea analiseField;

    @FXML
    private void salvar() {
        String nome = nomeField.getText();
        String pesoStr = pesoField.getText();
        String idadeStr = idadeField.getText();
        String observacoes = observacoesField.getText();
        String analise = analiseField.getText();

        // Simples validação
        if (nome.isEmpty()) {
            System.out.println("Nome é obrigatório!");
            return;
        }

        Double peso = null;
        Integer idade = null;
        try {
            peso = Double.parseDouble(pesoStr);
        } catch (NumberFormatException e) {
            System.out.println("Peso inválido!");
            return;
        }

        try {
            idade = Integer.parseInt(idadeStr);
        } catch (NumberFormatException e) {
            System.out.println("Idade inválida!");
            return;
        }

        System.out.println("Salvando paciente:");
        System.out.println("Nome: " + nome);
        System.out.println("Peso: " + peso);
        System.out.println("Idade: " + idade);
        System.out.println("Observações: " + observacoes);
        System.out.println("Análise: " + analise);

        // Aqui você chama o serviço REST para persistir no banco
        // Exemplo:
        // pacienteService.salvar(new Paciente(nome, peso, idade, observacoes, analise));
    }
}