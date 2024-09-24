package com.tecnicas.sistema_consultas.repository;

import com.tecnicas.sistema_consultas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}