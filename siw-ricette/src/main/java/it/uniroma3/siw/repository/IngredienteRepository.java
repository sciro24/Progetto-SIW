package it.uniroma3.siw.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.uniroma3.siw.model.Ingrediente;

public interface IngredienteRepository extends CrudRepository<Ingrediente, Long>{
	
	public boolean existsByNome(String nome);
	
	@Query(value="select * "
			+ "from ingrediente i "
			+ "where i.id not in "
			+ "(select ingredienti_id "
			+ "from ricetta_ingredienti "
			+ "where ricetta_ingredienti.composizioni_id = :ricettaId)", nativeQuery=true)
	public Iterable<Ingrediente> findIngredientiLiberi(@Param("ricettaId") Long id);
	
	public List<Ingrediente> findAll();
	
	public Optional<Ingrediente> findByNome(String nome);
	
	public Optional<Ingrediente> findById(Long id);

}
