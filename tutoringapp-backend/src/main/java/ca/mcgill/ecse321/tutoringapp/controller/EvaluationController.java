package ca.mcgill.ecse321.tutoringapp.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ca.mcgill.ecse321.tutoringapp.Database.src.Course;
import ca.mcgill.ecse321.tutoringapp.Database.src.Evaluation;
import ca.mcgill.ecse321.tutoringapp.dto.CourseDto;
import ca.mcgill.ecse321.tutoringapp.dto.EvaluationDto;
import ca.mcgill.ecse321.tutoringapp.service.EvaluationService;

@CrossOrigin(origins = "*")
@RestController
public class EvaluationController {

  @Autowired
  EvaluationService evalutionService;
  
  /**
   * Creating Evaluation
   * @param comment
   * @param rating
   * @return
   * @throws IllegalArgumentException
   */
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
  
  @GetMapping(value = { "/allEvaluations", "/allEvaluations/" })
  public List<EvaluationDto> getAllEvaluations() {
      try {
          List<EvaluationDto> evaluationDto = new ArrayList<>();
          for (Evaluation evaluation: evalutionService.getAllEvaluations()) {
            evaluationDto.add(DtoConverters.convertToDto(evaluation));
            // courseDto.add(DtoConverters.convertToDto(course));
          }
          return evaluationDto;
      }
      catch(Exception e) {
          throw new IllegalArgumentException("Could not retrieve information from service");
      }
  }
  /**
   * Deleting Evaluation
   * @param ID
   * @return
   */
  @PostMapping(value = { "/deleteCourse", "/deleteCourse/" })
  public boolean deleteEvaluation(@RequestParam(name = "ID") int ID) {
      evalutionService.removeEvaluation(ID);
      return true;
  }
}
