package ca.mcgill.ecse321.tutoringapp.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ca.mcgill.ecse321.tutoringapp.Database.src.Course;
import ca.mcgill.ecse321.tutoringapp.Database.src.Evaluation;
import ca.mcgill.ecse321.tutoringapp.Database.src.EvaluationType;
import ca.mcgill.ecse321.tutoringapp.Database.src.Manager;
import ca.mcgill.ecse321.tutoringapp.Database.src.Person;
import ca.mcgill.ecse321.tutoringapp.Database.src.Student;
import ca.mcgill.ecse321.tutoringapp.Database.src.Tutor;
import ca.mcgill.ecse321.tutoringapp.dao.EvaluationRepository;

@Service
public class EvaluationService {
	
	@Autowired
	EvaluationRepository evaluationRepository;

	@Transactional
    public Evaluation createEvaluation(int rating, String comment, EvaluationType type, Student student, Tutor tutor, Manager manager) {
        Evaluation evaluation = new Evaluation();
        int evaluationID = 0;
		while(evaluationRepository.findByEvaluationID(evaluationID) != null) {
			evaluationID++;
		}
        evaluation.setType(type);
        evaluation.setRating(rating);
        evaluation.setComment(comment);
        evaluation.setStudent(student);
        evaluation.setTutor(tutor);
        evaluation.setManager(manager);
        evaluation.setEvaluationID(evaluationID);
        //Evaluation is NOT flagged when created
        evaluation.setIsFlagged(false);
        evaluationRepository.save(evaluation);
        
        if ( rating < 0) {
          throw new IllegalArgumentException("Rating needs to be between 0 and 5");
        }
        
        if (rating > 5) {
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
	@Transactional
    public boolean removeEvaluation(Integer ID) {
        Evaluation eval = evaluationRepository.findByEvaluationID(ID);
        
        if(eval == null) {
            throw new NullPointerException("No such Evaluation.");
        }
        
        evaluationRepository.deleteEvalByEvaluationID(ID);
        return true;
    }
	@Transactional
    public void flagEvaluation(int ID) {
		Evaluation evaluation = evaluationRepository.findByEvaluationID(ID);
		evaluation.setIsFlagged(true);
		evaluationRepository.save(evaluation);
    }
	
	
	
}
