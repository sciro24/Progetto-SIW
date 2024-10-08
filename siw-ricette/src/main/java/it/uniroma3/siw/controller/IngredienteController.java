package it.uniroma3.siw.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.model.Ingrediente;
import it.uniroma3.siw.model.Ricetta;
import it.uniroma3.siw.repository.IngredienteRepository;
import it.uniroma3.siw.repository.RicettaRepository;
import it.uniroma3.siw.service.IngredienteService;
import jakarta.validation.Valid;

@Controller
public class IngredienteController {

	@Autowired IngredienteRepository ingredienteRepository;
	@Autowired IngredienteService ingredienteService;
	@Autowired RicettaRepository ricettaRepository;


	@GetMapping(value="/admin/formNewIngrediente")
	public String formNewIngrediente(Model model) {
		model.addAttribute("ingrediente", new Ingrediente());
		return "admin/formNewIngrediente.html";
	}
	

	@PostMapping("/admin/ingrediente")
	public String newIngrediente(@ModelAttribute("ingrediente") Ingrediente ingrediente, Model model) {
		
		if (!ingredienteRepository.existsByNome(ingrediente.getNome())) {
			this.ingredienteRepository.save(ingrediente); 
			model.addAttribute("ingrediente", ingrediente);
			return "ingrediente.html";
		} else {
			model.addAttribute("messaggioErrore", "Questo ingrediente esiste già");
			return "admin/formNewIngrediente.html"; 
		}
	}
	
	@GetMapping(value="/admin/formModificaIngrediente")
	public String formModificaIngrediente(@RequestParam(value = "id", required = false) Long id, Model model) {
		
		List<Ingrediente> ingredienti = ingredienteService.findAll();
		
		Ingrediente ingrediente;
		if(id != null) {
			ingrediente = this.ingredienteRepository.findById(id).orElse(new Ingrediente());
		}else {
			ingrediente = new Ingrediente();
		}
		
		model.addAttribute("ingrediente",ingrediente);
		model.addAttribute("ingredienti",ingredienti);
	
		return "admin/formModificaIngrediente.html";
	}

	

	
	@PostMapping("/admin/modificaIngrediente")
	public String modIngrediente(@Valid @ModelAttribute("ingrediente") Ingrediente ingrediente, BindingResult result ,Model model) {
		
		if (result.hasErrors()) {
			List<Ingrediente> ingredienti = ingredienteRepository.findAll();
			model.addAttribute("ingredienti", ingredienti);
			return "admin/formModificaIngrediente.html"; 
		}

		ingredienteRepository.save(ingrediente);
		model.addAttribute("ingrediente", ingrediente);

		return "ingrediente.html"; 
	}
	
	@GetMapping(value="/admin/formEliminaIngrediente")
	public String formEliminaIngrediente(@RequestParam(value = "id", required = false) Long id, Model model) {
		
		List<Ingrediente> ingredienti = ingredienteService.findAll();
		
		Ingrediente ingrediente;
		if(id != null) {
			ingrediente = this.ingredienteRepository.findById(id).orElse(new Ingrediente());
		}else {
			ingrediente = new Ingrediente();
		}
		
		model.addAttribute("ingrediente",ingrediente);
		model.addAttribute("ingredienti",ingredienti);
	
		return "admin/formEliminaIngrediente.html";
	}
	
	@PostMapping("/admin/eliminaIngrediente")
	public String deleteIngrediente(@RequestParam("id") Long id, Model model) {
	    
	    Ingrediente ingrediente = this.ingredienteRepository.findById(id).orElse(null);
	    
	    if (ingrediente == null) {
	        // Se l'ingrediente non esiste, torna alla pagina di eliminazione o visualizza un messaggio
	        model.addAttribute("errorMessage", "Ingrediente non trovato.");
	        List<Ingrediente> ingredienti = ingredienteRepository.findAll();
	        model.addAttribute("ingredienti", ingredienti);
	        return "admin/formEliminaIngrediente.html"; 
	    }
	    
	    Set<Ricetta> ricette = ricettaRepository.findByIngredienti_Id(id);
	    if (!ricette.isEmpty()) {
	        model.addAttribute("errorMessage", "Non puoi eliminare l'ingrediente perché è utilizzato in una o più ricette.");
	        List<Ingrediente> ingredienti = ingredienteRepository.findAll();
	        model.addAttribute("ingredienti", ingredienti);
	        return "admin/formEliminaIngrediente.html";
	    }


	    ingredienteRepository.delete(ingrediente); 

	    return "eliminato.html"; 
	}
	
	
	
	
	@GetMapping(value="/admin/indexIngrediente")
	public String indexIngrediente() {
		return "admin/indexIngrediente.html";
	}

	@GetMapping("/ingrediente/{id}")
	public String getIngrediente(@PathVariable("id") Long id, Model model) {
		model.addAttribute("ingrediente", this.ingredienteRepository.findById(id).get());
		return "ingrediente.html";
	}

	@GetMapping("/ingrediente")
	public String getIngredienti(Model model) {
		model.addAttribute("ingredienti", this.ingredienteRepository.findAll());
		return "ingredienti.html";
	}

}
