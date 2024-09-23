package com.tecnicas.sistema_consultas.repository;

import com.tecnicas.sistema_consultas.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}