package it.uniroma3.siw.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Ingrediente;
import it.uniroma3.siw.repository.IngredienteRepository;

@Service
public class IngredienteService {

	@Autowired
	protected IngredienteRepository ingredienteRepository;

	public Ingrediente findByNome(String nome) {
		Optional<Ingrediente> ingrediente = this.ingredienteRepository.findByNome(nome);
		return ingrediente.orElse(null);

	}

	public Ingrediente findById(Long id) {
		Optional<Ingrediente> ingrediente = this.ingredienteRepository.findById(id);
		return ingrediente.orElse(null);

	}


	public List<Ingrediente> findAll() {
		return  ingredienteRepository.findAll();
	}

	public List<Ingrediente> findVegani() {
		List<Ingrediente> tutteIngredienti = ingredienteRepository.findAll();
		List<Ingrediente> ingVegani = new ArrayList<>();

		for (Ingrediente ingrediente : tutteIngredienti) {
			if(ingrediente.isVegano()) {
				ingVegani.add(ingrediente);
			}
		}

		return ingVegani;
	}

	public Ingrediente save(Ingrediente ingrediente) {
		return this.ingredienteRepository.save(ingrediente);
	}
}
