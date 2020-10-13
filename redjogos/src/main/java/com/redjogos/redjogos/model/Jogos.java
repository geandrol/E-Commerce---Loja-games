package com.redjogos.redjogos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "jogos")
public class Jogos {
	      
		  @Id
		  @GeneratedValue(strategy = GenerationType.IDENTITY)
		  private long id;
		  
		  @NotNull
		  @Size(min = 2, max = 30)
		  private String nome;
		  
		  @NotNull
		  @Size(min = 2, max = 1000)
		  private String descricao;
		  
		  @ManyToOne
		  @JsonIgnoreProperties("jogos")
		  private Categoria categoria;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public Categoria getCategoria() {
			return categoria;
		}

		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}
		
		  
		  }
