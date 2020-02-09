package dev.fujioka.ailton.ApiMusica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.fujioka.ailton.ApiMusica.model.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

}
