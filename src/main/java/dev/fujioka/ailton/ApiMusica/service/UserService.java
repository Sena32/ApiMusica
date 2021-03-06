package dev.fujioka.ailton.ApiMusica.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.fujioka.ailton.ApiMusica.model.User;
import dev.fujioka.ailton.ApiMusica.repository.UserRepository;

@Service
public class UserService implements IService<User> {

    @Autowired
    private UserRepository repository;

	@Override
	public List<User> findAll() {
		
		return repository.findAll();
	}

	@Override
	public Optional<User> findById(Long id) {
		
		return repository.findById(id);
	}

	@Override
	public User save(User entity) {

		return repository.save(entity);
		
	}

	@Override
	public User delete(User entity) {
		repository.delete(entity);
		return entity;		
		
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
		
	}

	

}
