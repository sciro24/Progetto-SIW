package it.uniroma3.siw.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.model.Credenziali;
import it.uniroma3.siw.model.Utente;
import it.uniroma3.siw.repository.UtenteRepository;

/**
 * The UserService handles logic for Users.
 */
@Service
public class UtenteService {

	@Autowired
	protected UtenteRepository utenteRepository;

	@Autowired
	protected CredenzialiService credenzialiService;



	public Utente findByEmail(String email) {
		Optional<Utente> user = this.utenteRepository.findByEmail(email);
		return user.orElse(null);

	}

	public Utente findByUsername(String username) {
		Credenziali credenziali = this.credenzialiService.findByUsername(username);
		if (credenziali != null) { 
			return credenziali.getUtente();
		}

		return null;
	}


	@Transactional
	public Utente getUser(Long id) {
		Optional<Utente> result = this.utenteRepository.findById(id);
		return result.orElse(null);
	}

	@Transactional
	public Utente saveUser(Utente user) {
		return this.utenteRepository.save(user);
	}

	@Transactional
	public List<Utente> getAllUsers() {
		List<Utente> result = new ArrayList<>();
		Iterable<Utente> iterable = this.utenteRepository.findAll();
		for(Utente user : iterable)
			result.add(user);
		return result;
	}
}
