package dev.fujioka.ailton.ApiMusica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.fujioka.ailton.ApiMusica.model.Musica;
import dev.fujioka.ailton.ApiMusica.repository.MusicaRepository;

@Service
public class MusicaService implements IService<Musica> {
	@Autowired
	private MusicaRepository repository;

	@Override
	public List<Musica> findAll() {
		
		return repository.findAll();
	}

	@Override
	public Optional<Musica> findById(Long id) {
		
		return repository.findById(id);
	}

	@Override
	public Musica save(Musica entity) {
		
		return repository.save(entity);
	}

	@Override
	public Musica delete(Musica entity) {
		repository.delete(entity);
		return entity;
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
		
	}

}
