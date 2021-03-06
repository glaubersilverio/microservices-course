package com.gsr.hruser.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gsr.hruser.entities.User;
import com.gsr.hruser.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = this.userRepository.findById(id).get();
		return ResponseEntity.ok().body(obj);		
	}

	@GetMapping("/search")
	public ResponseEntity<User> findById(@RequestParam String email) {
		User obj = this.userRepository.findByEmail(email);
		return ResponseEntity.ok().body(obj);		
	}
	
	
}
