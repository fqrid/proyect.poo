package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
