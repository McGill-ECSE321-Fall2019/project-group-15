package ca.mcgill.ecse321.tutoringapp.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoringapp.Database.src.Evaluation;

public interface EvaluationRepository extends CrudRepository<Evaluation, Integer> {
	Evaluation findByEvaluationID(Integer ID);
}
