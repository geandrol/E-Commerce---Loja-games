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

import com.redjogos.redjogos.model.Jogos;
import com.redjogos.redjogos.repository.JogosRepository;


@RestController
@RequestMapping("/Jogos")
@CrossOrigin("*")
public class JogosController {
  
	@Autowired
	 private JogosRepository repository;
	
	 @GetMapping
	 public ResponseEntity<List<Jogos>> Getall(){
		 return ResponseEntity.ok(repository.findAll());
        }
	 @RequestMapping("/{id}")
		public ResponseEntity<Jogos> GetById(@PathVariable long id){
			return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());

		 }

    @GetMapping("/nome/{nome}")
        public ResponseEntity<List<Jogos>> GetByNome(@PathVariable String nome){
           return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
        }
    @PostMapping
	 public ResponseEntity<Jogos> Post(@RequestBody Jogos jogos){
	 return ResponseEntity.ok(repository.save(jogos));
	 }
    @PutMapping
    public ResponseEntity<Jogos> Put (@RequestBody Jogos jogos){
   	 return ResponseEntity.ok(repository.save(jogos));
   	 }
    @DeleteMapping("/{id}")
    public void Delete(@PathVariable long id) {
    repository.deleteById(id);
    }
	 
}
	 
