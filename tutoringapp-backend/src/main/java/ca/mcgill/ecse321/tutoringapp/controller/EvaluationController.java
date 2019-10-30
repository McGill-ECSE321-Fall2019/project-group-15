package ca.mcgill.ecse321.tutoringapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ca.mcgill.ecse321.tutoringapp.Database.src.Course;
import ca.mcgill.ecse321.tutoringapp.Database.src.Evaluation;
import ca.mcgill.ecse321.tutoringapp.dto.EvaluationDto;
import ca.mcgill.ecse321.tutoringapp.service.EvaluationService;

@CrossOrigin(origins = "*")
@RestController
public class EvaluationController {

  @Autowired
  EvaluationService evalutionService;
  
  @PostMapping(value = { "/createEvaluation", "/createEvaluation/" })
  public EvaluationDto createEvaluation(@RequestParam("comment") String comment, 
      @RequestParam("rating") int rating) throws IllegalArgumentException {
    try{
      Evaluation evaluation = evalutionService.createEvaluation(rating, comment);
      return DtoConverters.convertToDto(evaluation);
  }
  catch(Exception e){
      throw new IllegalArgumentException("Could not create course");
  }
   
    
  }
}
