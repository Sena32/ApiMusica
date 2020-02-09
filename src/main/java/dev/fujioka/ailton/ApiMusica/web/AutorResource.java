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
import dev.fujioka.ailton.ApiMusica.model.Autor;
import dev.fujioka.ailton.ApiMusica.service.AutorService;


@RestController
public class AutorResource {
	@Autowired
	private AutorService service;

	@GetMapping("/api/autor")
	public List<Autor> getAllAutor() {
		return this.service.findAll();
	}

	@GetMapping("/api/autor/{id}")
	public Autor getAutorById(@PathVariable("id") Long id) {
		return this.service.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Autor", "id", id.toString()));
	}

	@PostMapping("/api/autor")
	public ResponseEntity<Autor> saveAutor(@Valid @RequestBody Autor autor) {
		this.service.save(autor);
		return ResponseEntity.ok(autor);
	}

	@PutMapping("/api/autor")
	public ResponseEntity<Autor> updateAutor(@Valid @RequestBody Autor autor) {
		this.service.save(autor);
		return ResponseEntity.ok().body(autor);
	}

	@DeleteMapping("/api/autor")
	public ResponseEntity<String> deleteAutor(Autor autor) {
		this.service.delete(autor);
		return ResponseEntity.ok().body("Autor excluded ID: " + autor.getId());
	}
	

	@DeleteMapping("/api/autor/{id}")
	public ResponseEntity<String> deleteAutorById(@PathVariable("id") Long id) {
        Autor autorDelete = service.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Autor", "id", id.toString()));
        service.deleteById(id);
		return ResponseEntity.ok().body("Autor excluded ID: " + id);
	}
}
