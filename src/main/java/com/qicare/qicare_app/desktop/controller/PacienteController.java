package com.qicare.qicare_app.desktop.controller;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qicare.qicare_app.desktop.model.Paciente;

import javafx.event.ActionEvent;
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
    private TextField alturaField;

    @FXML
    private TextArea observacoesField;

    @FXML
    private TextArea analiseField;

    @FXML
    private void salvar(ActionEvent event) {
        try {
            // 1. Ler os dados da tela
            Paciente paciente = new Paciente();
            paciente.setNome(nomeField.getText());
            paciente.setPeso(pesoField.getText());
            paciente.setIdade(idadeField.getText());
            paciente.setObservacoes(observacoesField.getText());
            paciente.setAnalise(analiseField.getText());

            // 2. Converter para JSON
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(paciente);

            // 3. Enviar para a API Spring Boot
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://192.168.0.8:8080/pacientes"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("✅ Paciente enviado com sucesso!");
            System.out.println("Status: " + response.statusCode());
            System.out.println("Body: " + response.body());

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("❌ Erro ao enviar paciente para API.");
        }
    }
}