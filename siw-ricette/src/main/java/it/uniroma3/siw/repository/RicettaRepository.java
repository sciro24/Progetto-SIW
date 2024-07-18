package it.uniroma3.siw.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Ricetta;

public interface RicettaRepository extends CrudRepository<Ricetta, Long> {

	public Optional<Ricetta> findByNome(String nome);
	
	public Optional<Ricetta> findById(Long id);
	
	
	public List<Ricetta> findByTempoPreparazione(int minuti);
	
	public List<Ricetta> findAll();

	public boolean existsByNome(String nome);
	
	@SuppressWarnings("unchecked")
	public Ricetta save(Ricetta ricetta);
}
