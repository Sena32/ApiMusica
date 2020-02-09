package dev.fujioka.ailton.ApiMusica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.fujioka.ailton.ApiMusica.model.Musica;

public interface MusicaRepository extends JpaRepository<Musica, Long> {

}
