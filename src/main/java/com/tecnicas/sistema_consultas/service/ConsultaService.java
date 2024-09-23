package com.tecnicas.sistema_consultas.service;

import com.tecnicas.sistema_consultas.model.Consulta;
import com.tecnicas.sistema_consultas.model.Paciente;
import com.tecnicas.sistema_consultas.repository.ConsultaRepository;
import com.tecnicas.sistema_consultas.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public Consulta agendarConsulta(Consulta consulta) {
        Optional<Paciente> pacienteOptional = pacienteRepository.findById(consulta.getPaciente().getId());
        if (!pacienteOptional.isPresent()) {
            throw new RuntimeException("Paciente não encontrado! Não é possível agendar a consulta.");
        }

        return consultaRepository.save(consulta);
    }

    public List<Consulta> listarConsultasPorPaciente(Long pacienteId) {
        Optional<Paciente> pacienteOptional = pacienteRepository.findById(pacienteId);
        if (!pacienteOptional.isPresent()) {
            throw new RuntimeException("Paciente não encontrado!");
        }


        return consultaRepository.findAll();
    }

    public void cancelarConsulta(Long id) {
        Optional<Consulta> consultaOptional = consultaRepository.findById(id);
        if (consultaOptional.isPresent()) {
            consultaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Consulta não encontrada!");
        }
    }
}