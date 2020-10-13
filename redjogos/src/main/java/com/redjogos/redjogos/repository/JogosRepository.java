package com.redjogos.redjogos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redjogos.redjogos.model.Jogos;

@Repository
public interface JogosRepository extends JpaRepository<Jogos, Long> {
	public List<Jogos> findAllByNomeContainingIgnoreCase(String nome);

}
