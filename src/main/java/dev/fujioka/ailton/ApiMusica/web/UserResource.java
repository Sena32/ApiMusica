package dev.fujioka.ailton.ApiMusica.web;

import java.util.List;
import java.util.Optional;

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
import dev.fujioka.ailton.ApiMusica.model.User;
import dev.fujioka.ailton.ApiMusica.service.UserService;

@RestController
public class UserResource {
	@Autowired
	private UserService userService;

	@GetMapping("/api/user")
	public List<User> getAllUser() {
		return this.userService.findAll();
	}

	@GetMapping("/api/user/{id}")
	public User getUserById(@PathVariable("id") Long id) {
		return this.userService.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Person", "id", id.toString()));
	}

	@PostMapping("/api/user")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
		this.userService.save(user);
		return ResponseEntity.ok(user);
	}

	@PutMapping("/api/user")
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user) {
		this.userService.save(user);
		return ResponseEntity.ok().body(user);
	}

	@DeleteMapping("/api/user")
	public ResponseEntity<String> deleteUser(User user) {
		this.userService.delete(user);
		return ResponseEntity.ok().body("User excluded ID: " + user.getId());
	}
	

	@DeleteMapping("/api/user/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id) {
        User userDelete = userService.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Person", "id", id.toString()));
        userService.deleteById(id);
		return ResponseEntity.ok().body("User excluded ID: " + id);
	}
}
