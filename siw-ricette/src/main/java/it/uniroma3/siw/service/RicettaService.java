package it.uniroma3.siw.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
	        return ricettaRepository.findAll().stream()
	                .filter(ricetta -> ricetta.getIngredienti().stream().allMatch(Ingrediente::isVegano))
	                .collect(Collectors.toList());
	    }

	public Ricetta save(Ricetta ricetta) {
		return this.ricettaRepository.save(ricetta);
	}
}
