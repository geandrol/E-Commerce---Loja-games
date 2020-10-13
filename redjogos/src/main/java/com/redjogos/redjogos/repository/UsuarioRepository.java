package com.redjogos.redjogos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redjogos.redjogos.model.Usuario;


	@Repository
	public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
		public List<Usuario> findAllByNomecompletoContainingIgnoreCase(String nomecompleto);
}