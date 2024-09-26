package com.tecnicas.sistema_consultas.repository;

import com.tecnicas.sistema_consultas.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    List<Consulta> findByMedicoIdAndDataHoraBetween(Long medicoId, LocalDateTime startDateTime, LocalDateTime endDateTime);
}