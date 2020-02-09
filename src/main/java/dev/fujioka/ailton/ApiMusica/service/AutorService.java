package dev.fujioka.ailton.ApiMusica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.fujioka.ailton.ApiMusica.model.Autor;
import dev.fujioka.ailton.ApiMusica.repository.AutorRepository;

@Service
public class AutorService implements IService<Autor> {

	@Autowired
	private AutorRepository repository;

	@Override
	public List<Autor> findAll() {
		
		return repository.findAll();
	}

	@Override
	public Optional<Autor> findById(Long id) {
		
		return repository.findById(id);
	}

	@Override
	public Autor save(Autor entity) {
		
		return repository.save(entity);
	}

	@Override
	public Autor delete(Autor entity) {
		repository.delete(entity);
		return entity;
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);

	}

}
