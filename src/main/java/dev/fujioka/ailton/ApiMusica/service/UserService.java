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
public class UserService {

    @Autowired
    private UserRepository userRepository;

	@Transactional(readOnly=true)
    public List<User> findAll() {
    	
        return userRepository.findAll();
        
    }
	@Transactional(readOnly=true)
	public Optional<User> findById(Long id) {
		
		return userRepository.findById(id);
	}
	
	@Transactional(readOnly=true)
	public void save(User user) {
		
		userRepository.save(user);
	}
	
	@Transactional(readOnly=true)
    public void delete(User user) {
        userRepository.delete(user);
    }
	
	@Transactional(readOnly = true)
	public void deleteById(Long id) {
		userRepository.deleteById(id);
		
	}

}
