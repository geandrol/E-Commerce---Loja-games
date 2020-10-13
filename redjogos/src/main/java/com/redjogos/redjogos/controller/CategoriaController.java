package com.redjogos.redjogos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redjogos.redjogos.model.Categoria;
import com.redjogos.redjogos.repository.CategoriaRepository;

@RestController
@RequestMapping("/Categoria")
@CrossOrigin("*")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repository;

	@GetMapping
	public ResponseEntity<List<Categoria>> Getall() {
		return ResponseEntity.ok(repository.findAll());
	}

	@RequestMapping("/{id}")
	public ResponseEntity<Categoria> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());

	}

	@GetMapping("/console/{console}")
	public ResponseEntity<List<Categoria>> GetByNome(@PathVariable String console) {
		return ResponseEntity.ok(repository.findAllByConsolesContainingIgnoreCase(console));
	}

	@PostMapping
	public ResponseEntity<Categoria> Post(@RequestBody Categoria categoria) {
		return ResponseEntity.ok(repository.save(categoria));
	}
	@PutMapping
	public ResponseEntity<Categoria> Put (@RequestBody Categoria categoria) {
		return ResponseEntity.ok(repository.save(categoria));
	}
	@DeleteMapping("/{id}")
	public void Delete(@PathVariable long id) {
	repository.deleteById(id);
	}
}
