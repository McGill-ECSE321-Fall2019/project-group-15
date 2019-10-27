package ca.mcgill.ecse321.tutoringapp.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ca.mcgill.ecse321.tutoringapp.Database.src.Evaluation;
import ca.mcgill.ecse321.tutoringapp.Database.src.Person;
import ca.mcgill.ecse321.tutoringapp.dao.EvaluationRepository;

@Service
public class EvaluationService {
	
	@Autowired
	EvaluationRepository evaluationRepository;

	@Transactional
    public Evaluation createEvaluation(int rating, String comment) {
        Evaluation evaluation = new Evaluation();
        evaluation.setRating(rating);
        evaluation.setComment(comment);
        //Evaluation is NOT flagged when created
        evaluation.setIsFlagged(false);
        evaluationRepository.save(evaluation);
        
        if ( !(rating > 0 && rating <6)) {
          throw new IllegalArgumentException("Rating needs to be between 0 and 5");
        }
        
	
        //Might need to select evaluation type
        return evaluation;
}
	@Transactional
	public Evaluation getEvaluation(Integer ID) {
	  Evaluation evaluation = evaluationRepository.findByEvaluationID(ID);
	  return evaluation;
	}
	
	@Transactional
    public List<Evaluation> getAllEvaluations(){
        return toList(evaluationRepository.findAll());
    }
	
	private <T> List<T> toList(Iterable<T> iterable){
      List<T> resultList = new ArrayList<T>();
      for (T t : iterable) {
          resultList.add(t);
      }
      return resultList;
  }
	
	/*@Transactional
    public void flagEvaluation(Integer ID) {
	  Evaluation evaluation = evaluationRepository.findByEvaluationID(ID);
      evaluationRepository.flagEvalByEvaluationID(ID);
	  evaluation.setIsFlagged(true);
    }*/
	
	
	
}
