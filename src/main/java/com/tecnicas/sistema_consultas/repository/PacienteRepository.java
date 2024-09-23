package com.tecnicas.sistema_consultas.repository;

import com.tecnicas.sistema_consultas.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}