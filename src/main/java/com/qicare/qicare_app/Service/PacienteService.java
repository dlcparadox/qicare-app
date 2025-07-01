package com.qicare.qicare_app.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qicare.qicare_app.model.Paciente;
import com.qicare.qicare_app.repository.PacienteRepository;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente criarPaciente(Paciente paciente) {
        // Seta a data e hora automaticamente
        paciente.setDataHoraAtendimento(LocalDateTime.now());
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> buscarPorId(Long id) {
        return pacienteRepository.findById(id);
    }

    public Paciente atualizarAnalise(Long id, String analise) {
        Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);
        if (pacienteOptional.isPresent()) {
            Paciente paciente = pacienteOptional.get();
            paciente.setAnalise(analise);
            return pacienteRepository.save(paciente);
        } else {
            throw new RuntimeException("Paciente não encontrado");
        }
    }
    
    public void deletarPaciente(Long id) {
    pacienteRepository.deleteById(id);
    }

}
