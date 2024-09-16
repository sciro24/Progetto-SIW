package it.uniroma3.siw.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Ingrediente;
import it.uniroma3.siw.model.Ricetta;
import it.uniroma3.siw.repository.RicettaRepository;

@Service
public class RicettaService {

	@Autowired
	protected RicettaRepository ricettaRepository;

	public Ricetta findByNome(String nome) {
		Optional<Ricetta> ricetta = this.ricettaRepository.findByNome(nome);
		return ricetta.orElse(null);

	}

	public Ricetta findById(Long id) {
		Optional<Ricetta> ricetta = this.ricettaRepository.findById(id);
		return ricetta.orElse(null);

	}
	
	public List<Ricetta> findByTempoPreparazione(int minuti) {
		return  ricettaRepository.findByTempoPreparazione(minuti);
	}
	
	public List<Ricetta> findAll() {
		return  ricettaRepository.findAll();
	}
	
	public List<Ricetta> findVegane() {
	    List<Ricetta> tutteLeRicette = ricettaRepository.findAll();
	    List<Ricetta> ricetteVegane = new ArrayList<>();

	    for (Ricetta ricetta : tutteLeRicette) {
	        boolean tuttiIngredientiVegani = true;
	        for (Ingrediente ingrediente : ricetta.getIngredienti()) {
	            if (!ingrediente.isVegano()) {
	                tuttiIngredientiVegani = false;
	                break; // Esce dal ciclo se trova un ingrediente non vegano
	            }
	        }

	        if (tuttiIngredientiVegani) {
	            ricetteVegane.add(ricetta);
	        }
	    }

	    return ricetteVegane;
	}

	public Ricetta save(Ricetta ricetta) {
		return this.ricettaRepository.save(ricetta);
	}
	
}
