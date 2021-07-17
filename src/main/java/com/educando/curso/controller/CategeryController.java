package com.educando.curso.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.educando.curso.model.Category;
import com.educando.curso.repository.CategoryRepository;

@Controller
@RequestMapping("/categoria")
public class CategeryController {

	@Autowired
	private CategoryRepository repositoryC;
	
	@GetMapping
	public ResponseEntity<List<Category>> buscarTodos() {
		return ResponseEntity.ok(repositoryC.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Category> buscarPorId(@PathVariable Long id) {
		return repositoryC.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/nome/{name}")
	public ResponseEntity<Category> buscarPorTipo(@Valid @PathVariable String name) {
		return ResponseEntity.ok(repositoryC.findAllByName(name));
	}

	@PostMapping
	public ResponseEntity<Category> cadastrarCategoria(@Valid @RequestBody Category categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoryC.save(categoria));
	}

	@PutMapping
	public ResponseEntity<Category> atualizarCategoria(@Valid @RequestBody Category categoria) {
		return ResponseEntity.status(HttpStatus.OK).body(repositoryC.save(categoria));
	}

	@DeleteMapping("/{id}")
	public void deletarCategoria(@PathVariable Long id) {
		repositoryC.deleteById(id);
	}
}
