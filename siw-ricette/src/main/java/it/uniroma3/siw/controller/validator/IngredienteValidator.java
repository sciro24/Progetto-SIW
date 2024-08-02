package it.uniroma3.siw.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.siw.model.Ingrediente;
import it.uniroma3.siw.repository.IngredienteRepository;

@Component
public class IngredienteValidator implements Validator {
	
	@Autowired
	private IngredienteRepository ingredienteRepository;
	
	@Override
	public boolean supports(Class<?> aClass) {
		return Ingrediente.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		
		Ingrediente ingrediente = (Ingrediente)o;
		String nome = ingrediente.getNome().trim();
		
		if(nome.isEmpty()) {
			errors.reject("NotBlank.ingrediente.nome");
		}


//		if(ingrediente.isVegano() == null) {
//			errors.reject("NotNull.ricetta.tempoPreparazione");
//		}
		
		
		if (ingrediente.getNome()!=null && ingredienteRepository.existsByNome(ingrediente.getNome())) {
			errors.reject("ingrediente.duplicate");
		}
	}
	
}