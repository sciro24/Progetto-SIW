package it.uniroma3.siw.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Ricetta;

public interface RicettaRepository extends CrudRepository<Ricetta, Long> {

	public Optional<Ricetta> findByNome(String nome);
	
	public Optional<Ricetta> findById(Long id);
	
	public List<Ricetta> findByTempoPreparazione(int minuti);
	
	public List<Ricetta> findAll();

	public boolean existsByNome(String nome);
	
	public Set<Ricetta> findByIngredienti_Id(Long ingrdienteId);
	
}
