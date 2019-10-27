package ca.mcgill.ecse321.tutoringapp.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoringapp.Database.src.Evaluation;
import ca.mcgill.ecse321.tutoringapp.Database.src.Person;

public interface EvaluationRepository extends CrudRepository<Evaluation, Integer> {
	Evaluation findByEvaluationID(Integer ID);
	//void flagEvalByEvaluationID(Integer ID);
	void deleteEvalByEvaluationID(Integer ID);
	
}
