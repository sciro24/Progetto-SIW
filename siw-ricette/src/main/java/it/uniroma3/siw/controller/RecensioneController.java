package it.uniroma3.siw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.model.Recensione;
import it.uniroma3.siw.model.Ricetta;
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
	public String salvaRecensione(@RequestParam Long ricettaId, @RequestParam int voto, @RequestParam String commento, UserDetails userDetails,Model model) {
		// Recupera l'utente attualmente loggato
		Utente utente = utenteService.findByUsername(userDetails.getUsername());

		// Crea una nuova recensione
		Recensione recensione = new Recensione();
		recensione.setUtente(utente);
		recensione.setRicetta(ricettaService.findById(ricettaId));
		recensione.setVoto(voto);
		recensione.setCommento(commento);

		// Salva la recensione
		model.addAttribute("recensione", recensione);
		recensioneService.save(recensione);

		return "recensione.html";
	}

	
	@GetMapping(value="/admin/indexRecensione")
	public String indexRecensione() {
		return "admin/indexRecensione.html";
	}


	@GetMapping("/recensioni/ricetta")
	public String trovaRecensionePerRicetta(@RequestParam Long ricettaId, Model model) {
		Ricetta ricetta = ricettaService.findById(ricettaId);
		List<Recensione> recensioni = recensioneService.findByRicetta(ricetta);
		model.addAttribute("recensioni", recensioni);
		return "recensioni.html";
	}
	
	@GetMapping("/recensioni/utente")
	public String trovaRecensionePerUtente(@RequestParam Long utenteId, Model model) {
		Utente utente = utenteService.getUser(utenteId);
		List<Recensione> recensioni = recensioneService.findByUtente(utente);
		model.addAttribute("recensioni", recensioni);
		return "recensioni.html";
	}


}
