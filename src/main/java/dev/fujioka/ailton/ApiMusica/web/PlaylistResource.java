package dev.fujioka.ailton.ApiMusica.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.fujioka.ailton.ApiMusica.exception.EntityNotFoundException;
import dev.fujioka.ailton.ApiMusica.model.Playlist;
import dev.fujioka.ailton.ApiMusica.service.PlaylistService;

@RestController
public class PlaylistResource {
	@Autowired
	private PlaylistService service;

	@GetMapping("/api/playlist")
	public List<Playlist> getAllPlaylist() {
		return this.service.findAll();
	}

	@GetMapping("/api/playlist/{id}")
	public Playlist getPlaylistById(@PathVariable("id") Long id) {
		return this.service.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Playlist", "id", id.toString()));
	}

	@PostMapping("/api/playlist")
	public ResponseEntity<Playlist> savePlaylist(@Valid @RequestBody Playlist playlist) {
		this.service.save(playlist);
		return ResponseEntity.ok(playlist);
	}

	@PutMapping("/api/playlist")
	public ResponseEntity<Playlist> updatePlaylist(@Valid @RequestBody Playlist playlist) {
		this.service.save(playlist);
		return ResponseEntity.ok().body(playlist);
	}

	@DeleteMapping("/api/playlist")
	public ResponseEntity<String> deletePlaylist(Playlist playlist) {
		this.service.delete(playlist);
		return ResponseEntity.ok().body("Playlist excluded ID: " + playlist.getId());
	}
	

	@DeleteMapping("/api/playlist/{id}")
	public ResponseEntity<String> deletePlaylistById(@PathVariable("id") Long id) {
        Playlist playlistDelete = service.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Playlist", "id", id.toString()));
        service.deleteById(id);
		return ResponseEntity.ok().body("Playlist excluded ID: " + id);
	}
}
