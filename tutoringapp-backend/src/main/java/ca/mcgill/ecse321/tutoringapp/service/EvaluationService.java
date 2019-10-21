package ca.mcgill.ecse321.tutoringapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ca.mcgill.ecse321.tutoringapp.Database.src.Evaluation;

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
	
        //Might need to select evaluation type
        return evaluation;
}
	@Transactional
	public Evaluation getEvaluation(Integer ID) {
	  Evaluation evaluation = evaluationRepository.findByEvaluationID(ID);
	  return evaluation;
	}
	
	@Transactional
    public void flagEvaluation(Integer ID) {
	  Evaluation evaluation = evaluationRepository.findByEvaluationID(ID);
      evaluationRepository.flagEvalByEvaluationID(ID);
	  evaluation.setIsFlagged(true);
    }
	
	
	
}
