package com.qicare.qicare_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qicare.qicare_app.model.Consulta;
import com.qicare.qicare_app.repository.ConsultaRepository;
import com.qicare.qicare_app.repository.PacienteRepository;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping
    public List<Consulta> listar() {
        return consultaRepository.findAll();
    }

    @PostMapping
    public Consulta criar(@RequestBody Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    @GetMapping("/{id}")
    public Consulta buscar(@PathVariable Long id) {
        return consultaRepository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Consulta atualizar(@PathVariable Long id, @RequestBody Consulta consultaAtualizada) {
        Consulta consulta = consultaRepository.findById(id).orElseThrow();
        consulta.setAnotacoes(consultaAtualizada.getAnotacoes());
        consulta.setPaciente(consultaAtualizada.getPaciente());
        return consultaRepository.save(consulta);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        consultaRepository.deleteById(id);
    }
}
