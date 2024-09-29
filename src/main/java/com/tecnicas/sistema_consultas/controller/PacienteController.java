package com.tecnicas.sistema_consultas.controller;

import com.tecnicas.sistema_consultas.model.Paciente;
import com.tecnicas.sistema_consultas.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<Paciente>> listarTodos() {
        List<Paciente> pacientes = pacienteService.listarTodos();
        if (pacientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pacientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable Long id) {
        try {
            Paciente paciente = pacienteService.buscarPorId(id);
            return ResponseEntity.ok(paciente);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Paciente> cadastrarPaciente(@Valid @RequestBody Paciente paciente) {
        Paciente novoPaciente = pacienteService.cadastrarPaciente(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPaciente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> atualizarPaciente(@PathVariable Long id, @RequestBody Paciente pacienteAtualizado) {
        try {
            Paciente pacienteExistente = pacienteService.buscarPorId(id);

            if (pacienteAtualizado.getNome() != null) {
                pacienteExistente.setNome(pacienteAtualizado.getNome());
            }

            if (pacienteAtualizado.getCpf() != null) {
                pacienteExistente.setCpf(pacienteAtualizado.getCpf());
            }

            if (pacienteAtualizado.getEmail() != null) {
                pacienteExistente.setEmail(pacienteAtualizado.getEmail());
            }

            if (pacienteAtualizado.getDataNascimento() != null) {
                pacienteExistente.setDataNascimento(pacienteAtualizado.getDataNascimento());
            }

            Paciente pacienteAtualizadoFinal = pacienteService.atualizarPaciente(id, pacienteExistente);

            return ResponseEntity.ok(pacienteAtualizadoFinal);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPaciente(@PathVariable Long id) {
        try {
            pacienteService.deletarPaciente(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Paciente> login(@RequestBody Map<String, String> request) {
        try {
            String email = request.get("email");
            Paciente paciente = pacienteService.buscarPorEmail(email);
            return ResponseEntity.ok().body(paciente);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}