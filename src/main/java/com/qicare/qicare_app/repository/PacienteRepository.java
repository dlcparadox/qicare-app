package com.qicare.qicare_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qicare.qicare_app.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    // Aqui você pode adicionar métodos personalizados, se quiser
}
