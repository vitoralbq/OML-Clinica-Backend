package com.tecnicas.sistema_consultas.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;




    @Entity
    public class Consulta {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        private Paciente paciente;

        @ManyToOne
        private Medico medico;

        private LocalDateTime dataHora;
        private String status;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Paciente getPaciente() {
            return paciente;
        }

        public void setPaciente(Paciente paciente) {
            this.paciente = paciente;
        }

        public Medico getMedico() {
            return medico;
        }

        public void setMedico(Medico medico) {
            this.medico = medico;
        }

        public LocalDateTime getDataHora() {
            return dataHora;
        }

        public void setDataHora(LocalDateTime dataHora) {
            this.dataHora = dataHora;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

    }

