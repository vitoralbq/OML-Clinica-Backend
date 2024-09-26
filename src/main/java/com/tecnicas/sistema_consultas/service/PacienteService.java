package com.tecnicas.sistema_consultas.service;

import com.tecnicas.sistema_consultas.exception.PacienteNotFoundException;
import com.tecnicas.sistema_consultas.model.Paciente;
import com.tecnicas.sistema_consultas.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;


    public List<Paciente> listarTodos() {
        return pacienteRepository.findAll();
    }


    public Paciente buscarPorId(Long id) {
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new PacienteNotFoundException("Paciente com ID " + id + " não encontrado"));
    }


    public Paciente cadastrarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }


    public Paciente atualizarPaciente(Long id, Paciente pacienteAtualizado) {
        Paciente pacienteExistente = buscarPorId(id);


        pacienteExistente.setNome(pacienteAtualizado.getNome());
        pacienteExistente.setCpf(pacienteAtualizado.getCpf());
        pacienteExistente.setDataNascimento(pacienteAtualizado.getDataNascimento());
        pacienteExistente.setEmail(pacienteAtualizado.getEmail());

        return pacienteRepository.save(pacienteExistente);
    }


    public void deletarPaciente(Long id) {
        Paciente pacienteExistente = buscarPorId(id);
        pacienteRepository.delete(pacienteExistente);
    }

    public Paciente buscarPorEmail(String email) {
        return pacienteRepository.findByEmail(email)
                .orElseThrow(() -> new PacienteNotFoundException("Paciente com email " + email + " não encontrado"));
    }
}