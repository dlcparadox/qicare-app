package com.qicare.qicare_app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qicare.qicare_app.Service.PacienteService;
import com.qicare.qicare_app.model.Paciente;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public Paciente criarPaciente(@RequestBody @Valid Paciente paciente) {
        return pacienteService.criarPaciente(paciente);
    }

    @GetMapping
    public List<Paciente> listarPacientes() {
        return pacienteService.listarPacientes();
    }

    @GetMapping("/{id}")
    public Optional<Paciente> buscarPorId(@PathVariable Long id) {
        return pacienteService.buscarPorId(id);
    }

    @PutMapping("/{id}/analise")
    public Paciente atualizarAnalise(@PathVariable Long id, @RequestBody String analise) {
        return pacienteService.atualizarAnalise(id, analise);
    }

    @DeleteMapping("/{id}")
    public void deletarPaciente(@PathVariable Long id) {
    pacienteService.deletarPaciente(id);
    }
}