package com.tecnicas.sistema_consultas.service;

import com.tecnicas.sistema_consultas.exception.MedicoNotFoundException;
import com.tecnicas.sistema_consultas.model.Medico;
import com.tecnicas.sistema_consultas.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public List<Medico> listarTodos() {
        return medicoRepository.findAll();
    }

    public Medico buscarPorId(Long id) {
        return medicoRepository.findById(id)
                .orElseThrow(() -> new MedicoNotFoundException("Médico com ID " + id + " não encontrado."));
    }

    public Medico cadastrarMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    public Medico atualizarMedico(Long id, Medico medicoAtualizado) {
        Medico medico = buscarPorId(id);
        medico.setNome(medicoAtualizado.getNome());
        medico.setEspecialidade(medicoAtualizado.getEspecialidade());
        medico.setEmail(medicoAtualizado.getEmail());
        medico.setCpf(medicoAtualizado.getCpf());

        return medicoRepository.save(medico);
    }

    public void deletarMedico(Long id) {
        Medico medico = buscarPorId(id);
        medicoRepository.delete(medico);
    }
}