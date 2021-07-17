package com.educando.curso.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.educando.curso.model.User;
import com.educando.curso.repository.UserRepository;
import com.educando.curso.services.UserServices;

@Controller
@RequestMapping("/usuario")
public class UserController {

	@Autowired
	private UserRepository repositoryUser;

	@Autowired
	private UserServices servicesUser;

	@GetMapping
	public ResponseEntity<List<User>> buscarTodos() {
		return ResponseEntity.ok(repositoryUser.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<User>> buscarUser(@PathVariable Long id) {
		return ResponseEntity.ok(repositoryUser.findById(id));
	}

	@DeleteMapping("/{id}")
	public void deletarUser(@PathVariable Long id) {
		repositoryUser.deleteById(id);
	}
}
