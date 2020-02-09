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
import dev.fujioka.ailton.ApiMusica.model.Musica;
import dev.fujioka.ailton.ApiMusica.service.MusicaService;

@RestController
public class MusicaResource {
	@Autowired
	private MusicaService service;

	@GetMapping("/api/musica")
	public List<Musica> getAllMusica() {
		return this.service.findAll();
	}

	@GetMapping("/api/musica/{id}")
	public Musica getMusicaById(@PathVariable("id") Long id) {
		return this.service.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Musica", "id", id.toString()));
	}

	@PostMapping("/api/musica")
	public ResponseEntity<Musica> saveMusica(@Valid @RequestBody Musica musica) {
		this.service.save(musica);
		return ResponseEntity.ok(musica);
	}

	@PutMapping("/api/musica")
	public ResponseEntity<Musica> updateMusica(@Valid @RequestBody Musica musica) {
		this.service.save(musica);
		return ResponseEntity.ok().body(musica);
	}

	@DeleteMapping("/api/musica")
	public ResponseEntity<String> deleteMusica(Musica musica) {
		this.service.delete(musica);
		return ResponseEntity.ok().body("Musica excluded ID: " + musica.getId());
	}
	

	@DeleteMapping("/api/musica/{id}")
	public ResponseEntity<String> deleteMusicaById(@PathVariable("id") Long id) {
        Musica musicaDelete = service.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Musica", "id", id.toString()));
        service.deleteById(id);
		return ResponseEntity.ok().body("Musica excluded ID: " + id);
	}
}
