package it.uniroma3.siw.controller;

import java.nio.file.AccessDeniedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.controller.validator.ValidatoreRuolo;
import it.uniroma3.siw.model.Recensione;
import it.uniroma3.siw.model.Utente;
import it.uniroma3.siw.service.RecensioneService;
import it.uniroma3.siw.service.RicettaService;
import it.uniroma3.siw.service.UtenteService;

@Controller
public class RecensioneController {


	@Autowired
	private RecensioneService recensioneService;

	@Autowired
	private RicettaService ricettaService;

	@Autowired
	private UtenteService utenteService;

	@GetMapping("/formNewRecensione") 
	public String formNewRecensione(Model model) {
		model.addAttribute("recensione", new Recensione());
		model.addAttribute("ricette", this.ricettaService.findAll());

		return "formNewRecensione.html";
	}
	
	
	@PostMapping("/recensioni")
	public String salvaRecensione(@RequestParam Long ricettaId, @RequestParam int voto, @RequestParam String commento, UserDetails userDetails, Model model) throws AccessDeniedException {
		
		// Recupera l'utente attualmente loggato
		Utente utente = utenteService.findByUsername(userDetails.getUsername());

		// Verifica il ruolo dell'utente
		if (!ValidatoreRuolo.utenteDefault(utente)) {
			throw new AccessDeniedException("Gli amministratori non possono lasciare recensioni");
		}

		// Crea una nuova recensione
		Recensione recensione = new Recensione();
		recensione.setUtente(utente);
		recensione.setRicetta(ricettaService.findById(ricettaId));
		recensione.setVoto(voto);
		recensione.setCommento(commento);

		// Salva la recensione
		model.addAttribute("recensione", recensione);
		recensioneService.createRecensione(recensione, utente);

		return "recensione.html";
	}


	@GetMapping(value="/admin/indexRecensione")
	public String indexRecensione() {
		return "admin/indexRecensione.html";
	}

	@GetMapping("/recensione/{id}")
	public String getRecensione(@PathVariable("id") Long id, Model model) {
		model.addAttribute("recensione", this.recensioneService.findById(id));
		return "recensione.html";
	}

	@GetMapping("/recensione")
	public String getRecensioni(Model model) {
		model.addAttribute("recensioni", this.recensioneService.findAll());
		return "recensioni.html";
	}


}
