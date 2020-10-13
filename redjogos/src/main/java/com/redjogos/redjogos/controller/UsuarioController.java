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

import com.redjogos.redjogos.model.Usuario;
import com.redjogos.redjogos.repository.UsuarioRepository;


@RestController
@RequestMapping("/Usuario")
@CrossOrigin("*")
public class UsuarioController {
     
	 @Autowired
	 private UsuarioRepository repository;
	 
	 @GetMapping
	 public ResponseEntity<List<Usuario>> Getall(){
		 return ResponseEntity.ok(repository.findAll());
	 }
	 
	 @RequestMapping("/{id}")
	public ResponseEntity<Usuario> GetById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());

	 }
	 @GetMapping("/nome/{nomecompleto}")
	 public ResponseEntity<List<Usuario>> GetByNome(@PathVariable String nomecompleto){
	 return ResponseEntity.ok(repository.findAllByNomecompletoContainingIgnoreCase(nomecompleto));
	 }
	 
	 @PostMapping
	 public ResponseEntity<Usuario> Post(@RequestBody Usuario usuario){
	 return ResponseEntity.ok(repository.save(usuario));
	 }
	 @PutMapping
	 public ResponseEntity<Usuario> Put(@RequestBody Usuario usuario){
		 return ResponseEntity.ok(repository.save(usuario));
		 }
	 @DeleteMapping("/{id}")
	 public void Delete(@PathVariable long id) {
	 repository.deleteById(id);
	 }

}
