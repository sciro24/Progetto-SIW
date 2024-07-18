package it.uniroma3.siw.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Ricetta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(initialValue = 1, allocationSize = 1, name = "id")
	public Long id;
	
	@Column(unique=true, nullable=false, length=20)
	@NotBlank(message = "Il nome non può essere vuoto")
	private String nome;
	
	@NotBlank(message = "La descrizione non può essere vuota")
	private String descrizione;
	
//	@OneToOne
//	private Utente utente;
//	
	
	@ManyToMany
	private Set<Ingrediente> ingredienti;
	
	@OneToMany(mappedBy = "ricetta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Recensione> recensioni = new ArrayList<>();


	@Column(nullable = false)
	@Min(value = 1, message = "Il tempo di preparazione deve essere almeno 1")
	@NotNull(message = "Il tempo di preparazione non può essere nullo")
	private Integer tempoPreparazione;
	
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
	
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Integer getTempoPreparazione() {
		return tempoPreparazione;
	}
	public void setTempoPreparazione(Integer tempoPreparazione) {
		this.tempoPreparazione = tempoPreparazione;
	}
	
	 public Set<Ingrediente> getIngredienti() {
         return ingredienti;
     }
 
     public void setIngredienti(Set<Ingrediente> ingredienti) {
         this.ingredienti = ingredienti;
     }
     
     public List<Recensione> getRecensioni() {
         return recensioni;
     }
 
     public void setRecensioni(List<Recensione> recensioni) {
         this.recensioni = recensioni;
     }
     
     public void addRecensione(Recensione recensione) {
         recensioni.add(recensione);
         recensione.setRicetta(this);
     }

     public void removeRecensione(Recensione recensione) {
         recensioni.remove(recensione);
         recensione.setRicetta(null);
     }
     
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ricetta other = (Ricetta) obj;
		return Objects.equals(nome, other.nome);
	}
	
	
//	public Utente getUtente() {
//		return utente;
//	}
//	public void setUtente(Utente utente) {
//		this.utente = utente;
//	}
//	
	
	




}
