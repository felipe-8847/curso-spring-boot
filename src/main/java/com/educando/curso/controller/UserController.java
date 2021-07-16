package com.educando.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.educando.curso.model.User;
import com.educando.curso.repository.UserRepository;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository repositoryUser;
	
	@GetMapping
	public ResponseEntity<List<User>> buscarTodos() {
		return ResponseEntity.ok(repositoryUser.findAll());
	}
}
