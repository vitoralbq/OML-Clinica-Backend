package com.tecnicas.sistema_consultas.controller;

import com.tecnicas.sistema_consultas.model.Consulta;
import com.tecnicas.sistema_consultas.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;


    @PostMapping
    public ResponseEntity<Consulta> agendarConsulta(@RequestBody Consulta consulta) {
        try {
            Consulta novaConsulta = consultaService.agendarConsulta(consulta);
            return ResponseEntity.status(HttpStatus.CREATED).body(novaConsulta);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Consulta>> listarTodas() {
        List<Consulta> consultas = consultaService.listarTodas();
        if (consultas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(consultas);
    }


    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<Consulta>> listarConsultasPorPaciente(@PathVariable Long pacienteId) {
        List<Consulta> consultas = consultaService.listarConsultasPorPaciente(pacienteId);
        if (consultas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(consultas);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelarConsulta(@PathVariable Long id) {
        try {
            consultaService.cancelarConsulta(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/medicoDia")
    public ResponseEntity<List<Consulta>> listarConsultasPorMedicoeDia(@RequestParam Long medicoId, @RequestParam String data) {
        List<Consulta> consultas = consultaService.listarConsultasPorMedicoEDia(medicoId, data);
        if (consultas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(consultas);
    }
}