package it.uniroma3.siw.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Entity
public class Recensione {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recensione_generator")
	@SequenceGenerator(name = "recensione_generator", sequenceName = "recensione_seq", allocationSize = 1)
	public Long id;
	
	@ManyToOne
    @JoinColumn(name = "ricetta_id", nullable = false)
    private Ricetta ricetta;
	
	@ManyToOne
	@JoinColumn(name = "utente_id", nullable = false)
	private Utente utente;
	
	@Min(value = 1, message = "Il voto deve essere compreso tra 1 e 5")
    @Max(value = 5, message = "Il voto deve essere compreso tra 1 e 5")
	@Column(nullable = false)
	public Integer voto; 
	
    @Size(max = 1000, message = "Il commento non può superare i 1000 caratteri")
    public String commento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ricetta getRicetta() {
		return ricetta;
	}

	public void setRicetta(Ricetta ricetta) {
		this.ricetta = ricetta;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Integer getVoto() {
		return voto;
	}

	public void setVoto(Integer voto) {
		this.voto = voto;
	}

	public String getCommento() {
		return commento;
	}

	public void setCommento(String commento) {
		this.commento = commento;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(ricetta, utente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recensione other = (Recensione) obj;
		return Objects.equals(ricetta, other.ricetta) && Objects.equals(utente, other.utente);
	}

}
