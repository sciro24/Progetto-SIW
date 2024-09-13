package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.model.Ingrediente;
import it.uniroma3.siw.repository.IngredienteRepository;

@Controller
public class IngredienteController {

	@Autowired
	private IngredienteRepository ingredienteRepository;

	@GetMapping(value="/admin/formNewIngrediente")
	public String formNewIngrediente(Model model) {
		model.addAttribute("ingrediente", new Ingrediente());
		return "admin/formNewIngrediente.html";
	}

	@GetMapping(value="/admin/indexIngrediente")
	public String indexIngrediente() {
		return "admin/indexIngrediente.html";
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
