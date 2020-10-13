package com.redjogos.redjogos.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "categoria")
public class Categoria {
      
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long id;
	  
	  @NotNull
	  @Size(min = 2, max = 30)
	  private String consoles;
	  
	  @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	  @JsonIgnoreProperties("categoria")
	  private List<Jogos>jogos;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getConsoles() {
		return consoles;
	}

	public void setConsoles(String consoles) {
		this.consoles = consoles;
	}

	public List<Jogos> getJogos() {
		return jogos;
	}

	public void setJogos(List<Jogos> jogos) {
		this.jogos = jogos;
	}
	  
	  }

