package dev.fujioka.ailton.ApiMusica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.fujioka.ailton.ApiMusica.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
