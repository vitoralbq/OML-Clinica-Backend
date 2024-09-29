package com.tecnicas.sistema_consultas.controller;

import com.tecnicas.sistema_consultas.model.Medico;
import com.tecnicas.sistema_consultas.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public List<Medico> listarTodos() {
        return medicoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> buscarPorId(@PathVariable Long id) {
        Medico medico = medicoService.buscarPorId(id);
        return ResponseEntity.ok(medico);
    }

    @PostMapping
    public Medico cadastrarMedico(@RequestBody Medico medico) {
        return medicoService.cadastrarMedico(medico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medico> atualizarMedico(@PathVariable Long id, @RequestBody Medico medicoAtualizado) {
        Medico medicoExistente = medicoService.buscarPorId(id);

        if (medicoAtualizado.getNome() != null) {
            medicoExistente.setNome(medicoAtualizado.getNome());
        }

        if (medicoAtualizado.getCpf() != null) {
            medicoExistente.setCpf(medicoAtualizado.getCpf());
        }

        if (medicoAtualizado.getEmail() != null) {
            medicoExistente.setEmail(medicoAtualizado.getEmail());
        }

        if (medicoAtualizado.getEspecialidade() != null) {
            medicoExistente.setEspecialidade(medicoAtualizado.getEspecialidade());
        }

        Medico medicoAtualizadoFinal = medicoService.atualizarMedico(id, medicoExistente);

        return ResponseEntity.ok(medicoAtualizadoFinal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMedico(@PathVariable Long id) {
        medicoService.deletarMedico(id);
        return ResponseEntity.noContent().build();
    }
}