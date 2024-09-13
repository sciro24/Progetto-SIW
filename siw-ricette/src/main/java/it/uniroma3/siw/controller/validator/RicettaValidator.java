package it.uniroma3.siw.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.siw.model.Ricetta;
import it.uniroma3.siw.repository.RicettaRepository;

@Component
public class RicettaValidator implements Validator {
	
	@Autowired
	private RicettaRepository ricettaRepository;
	
	@Override
	public boolean supports(Class<?> aClass) {
		return Ricetta.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		
		Ricetta ricetta = (Ricetta)o;
		String nome = ricetta.getNome().trim();
		String descrizione = ricetta.getDescrizione().trim();
		
		if(nome.isEmpty()) {
			errors.reject("NotBlank.ricetta.nome");
		}

		if(descrizione.isEmpty()) {
			errors.reject("NotBlank.ricetta.descrizione");
		}

		if(ricetta.getTempoPreparazione() == null) {
			errors.reject("NotNull.ricetta.tempoPreparazione");
		}
		
		
		if (ricetta.getNome()!=null && ricetta.getTempoPreparazione()!=null 
				&& ricettaRepository.existsByNome(ricetta.getNome())) {
			errors.reject("ricetta.duplicate");
		}
	}
	
}