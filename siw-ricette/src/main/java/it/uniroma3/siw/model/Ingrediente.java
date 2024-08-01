package it.uniroma3.siw.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Ingrediente {
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingrediente_generator")
	@SequenceGenerator(name = "ingrediente_generator", sequenceName = "ingrediente_seq", allocationSize = 1)
	public Long id;
	
	@Column(unique=true, nullable=false, length=20)
	@NotBlank(message = "Il nome non può essere vuoto")
	private String nome;
	
	@ManyToMany(mappedBy = "ingredienti")
	private Set<Ricetta> composizioni;
	
	private boolean vegano;
	
	public Ingrediente() {
		this.composizioni = new HashSet<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Set<Ricetta> getIngredienteOf(){
		return composizioni;
	}
	
	public void setIngredienteOf(Set<Ricetta> composizioni) {
		this.composizioni = composizioni;
	}
	
	public boolean isVegano() {
		return vegano;
	}

	public void setVegano(boolean vegano) {
		this.vegano = vegano;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingrediente other = (Ingrediente) obj;
		return Objects.equals(nome, other.nome);
	}

	
}
