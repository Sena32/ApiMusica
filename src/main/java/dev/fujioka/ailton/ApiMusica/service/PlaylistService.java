package dev.fujioka.ailton.ApiMusica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.fujioka.ailton.ApiMusica.model.Playlist;
import dev.fujioka.ailton.ApiMusica.repository.PlaylistRepository;

@Service
public class PlaylistService implements IService<Playlist>{
	
	@Autowired
	private PlaylistRepository repository;

	@Override
	public List<Playlist> findAll() {
		
		return repository.findAll();
	}

	@Override
	public Optional<Playlist> findById(Long id) {
		
		return repository.findById(id);
	}

	@Override
	public Playlist save(Playlist entity) {
		return repository.save(entity);
		
	}

	@Override
	public Playlist delete(Playlist entity) {
		repository.delete(entity);
		return entity;
		
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
		
	}

	


}
