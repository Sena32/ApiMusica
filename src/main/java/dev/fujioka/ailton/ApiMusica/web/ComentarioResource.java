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
import dev.fujioka.ailton.ApiMusica.model.Comentario;
import dev.fujioka.ailton.ApiMusica.service.ComentarioService;

@RestController
public class ComentarioResource {
	@Autowired
	private ComentarioService service;

	@GetMapping("/api/comentario")
	public List<Comentario> getAllComentario() {
		return this.service.findAll();
	}

	@GetMapping("/api/comentario/{id}")
	public Comentario getComentarioById(@PathVariable("id") Long id) {
		return this.service.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Comentario", "id", id.toString()));
	}

	@PostMapping("/api/comentario")
	public ResponseEntity<Comentario> saveComentario(@Valid @RequestBody Comentario comentario) {
		this.service.save(comentario);
		return ResponseEntity.ok(comentario);
	}

	@PutMapping("/api/comentario")
	public ResponseEntity<Comentario> updateComentario(@Valid @RequestBody Comentario comentario) {
		this.service.save(comentario);
		return ResponseEntity.ok().body(comentario);
	}

	@DeleteMapping("/api/comentario")
	public ResponseEntity<String> deleteComentario(Comentario comentario) {
		this.service.delete(comentario);
		return ResponseEntity.ok().body("Comentario excluded ID: " + comentario.getId());
	}
	

	@DeleteMapping("/api/comentario/{id}")
	public ResponseEntity<String> deleteComentarioById(@PathVariable("id") Long id) {
        Comentario comentarioDelete = service.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Comentario", "id", id.toString()));
        service.deleteById(id);
		return ResponseEntity.ok().body("Comentario excluded ID: " + id);
	}
}
