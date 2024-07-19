package it.uniroma3.siw.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Recensione;
import it.uniroma3.siw.model.Ricetta;
import it.uniroma3.siw.model.Utente;
import it.uniroma3.siw.repository.RecensioneRepository;

@Service
public class RecensioneService {

	@Autowired
	protected RecensioneRepository recensioneRepository;

	public Recensione save(Recensione recensione) {
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
