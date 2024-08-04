package it.uniroma3.siw.service;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.controller.validator.ValidatoreRuolo;
import it.uniroma3.siw.model.Recensione;
import it.uniroma3.siw.model.Ricetta;
import it.uniroma3.siw.model.Utente;
import it.uniroma3.siw.repository.RecensioneRepository;

@Service
public class RecensioneService {
	
	@Autowired
	protected RecensioneRepository recensioneRepository;

	 public Recensione createRecensione(Recensione recensione, Utente utente) throws AccessDeniedException {
	        if (!ValidatoreRuolo.utenteDefault(utente)) {
	            throw new AccessDeniedException("Gli amministratori non possono lasciare recensioni");
	        }
	        
	     // Controlla se l'utente ha già scritto una recensione per questa ricetta
	        if (recensioneRepository.existsByUtenteAndRicetta(utente, recensione.getRicetta())) {
	            throw new IllegalArgumentException("Hai già scritto una recensione per questa ricetta.");
	        }
	        
	        recensione.setUtente(utente);
	        return recensioneRepository.save(recensione);
	    }

	public Recensione findById(Long id) {
		Optional<Recensione> recensione = this.recensioneRepository.findById(id);
		return recensione.orElse(null);

	}
	public List<Recensione> findByUtente(Utente utente) {
		return recensioneRepository.findByUtente(utente);
	}

	public List<Recensione> findByRicetta(Ricetta ricetta) {
		return recensioneRepository.findByRicetta(ricetta);
	}

	public List<Recensione> findAll() {
		return recensioneRepository.findAll();
	}

}
