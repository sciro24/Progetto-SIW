package it.uniroma3.siw.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.siw.model.Recensione;
import it.uniroma3.siw.model.Ricetta;
import it.uniroma3.siw.model.Utente;
import it.uniroma3.siw.repository.RecensioneRepository;

@Component
public class RecensioneValidator implements Validator {
	
	@Autowired
	private RecensioneRepository recensioneRepository;
	
	@Override
	public boolean supports(Class<?> aClass) {
		return Recensione.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		
		Recensione recensione = (Recensione)o;
		Ricetta ricetta = recensione.getRicetta();
		Utente utente = recensione.getUtente();
		
		
		if(ricetta == null) {
			errors.reject("NotBlank.recensione.ricetta");
		}

		if(utente == null) {
			errors.reject("NotBlank.recensione.utente");
		}

		if(recensione.getVoto() == null) {
			errors.reject("NotNull.recensione.voto");
		}
		
		
//		if (recensione.getRicetta()!=null && recensione.getUtente()!=null 
//				&& recensioneRepository.existsByNome(recensione.getNome())) {
//			errors.reject("recensione.duplicate");
//		}
	}
	
}