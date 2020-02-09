package dev.fujioka.ailton.ApiMusica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.fujioka.ailton.ApiMusica.model.Comentario;
import dev.fujioka.ailton.ApiMusica.repository.ComentarioRepository;

@Service
public class ComentarioService implements IService<Comentario> {
	
	@Autowired
	private ComentarioRepository repository;

	@Override
	public List<Comentario> findAll() {

		return repository.findAll();
	}

	@Override
	public Optional<Comentario> findById(Long id) {

		return repository.findById(id);
	}

	@Override
	public Comentario save(Comentario entity) {

		return repository.save(entity);
	}

	@Override
	public Comentario delete(Comentario entity) {
		repository.delete(entity);
		return entity;
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);

	}

}
