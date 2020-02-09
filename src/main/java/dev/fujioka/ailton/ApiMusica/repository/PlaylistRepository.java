package dev.fujioka.ailton.ApiMusica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.fujioka.ailton.ApiMusica.model.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

}
