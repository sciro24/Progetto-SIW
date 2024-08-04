package it.uniroma3.siw.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Recensione;
import it.uniroma3.siw.model.Ricetta;
import it.uniroma3.siw.model.Utente;

public interface RecensioneRepository extends CrudRepository<Recensione, Long> {
	
	public List<Recensione> findByUtente(Utente utente);
    public List<Recensione> findByRicetta(Ricetta ricetta);
	public Optional<Recensione> findById(Long id);
    public List<Recensione> findAll();
	public boolean existsByUtenteAndRicetta(Utente utente, Ricetta ricetta);
    
}
