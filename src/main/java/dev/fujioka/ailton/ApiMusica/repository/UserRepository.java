package dev.fujioka.ailton.ApiMusica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.fujioka.ailton.ApiMusica.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
