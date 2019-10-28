package ca.mcgill.ecse321.tutoringapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.List;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.mcgill.ecse321.tutoringapp.Database.src.Evaluation;
import ca.mcgill.ecse321.tutoringapp.Database.src.Person;
import ca.mcgill.ecse321.tutoringapp.dao.EvaluationRepository;
import ca.mcgill.ecse321.tutoringapp.dao.PersonRepository;
import ca.mcgill.ecse321.tutoringapp.dao.StudentRepository;
import ca.mcgill.ecse321.tutoringapp.dao.TutorRepository;
import ca.mcgill.ecse321.tutoringapp.service.EvaluationService;
import ca.mcgill.ecse321.tutoringapp.service.SubjectService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EvaluationsTest {

  @Autowired
  PersonRepository personRepository;
  @Autowired
  StudentRepository studentRepository;
  @Autowired
  TutorRepository tutorRepository; 
  @Autowired
  EvaluationRepository evaluationRepository; 
  @Autowired
  private EvaluationService evaluationService;
  
  
  
  @After
  public void clearDatabase() {
      // Fisrt, we clear to avoid exceptions due to inconsistencies
      personRepository.deleteAll();
      // Then we can clear the other tables
      studentRepository.deleteAll();
      tutorRepository.deleteAll();
      evaluationRepository.deleteAll();
      
  }
  
  @Test
  public void testAddEvalStudent() {
 
    String comment1 = "This tutor is amazing!";
    int rating1 = 5;
    

    try {
      evaluationService.createEvaluation(rating1, comment1);
  } catch (IllegalArgumentException e) {
      fail();
  }
    
  List<Evaluation> allEvals= evaluationService.getAllEvaluations();
  assertEquals(1, allEvals.size());
  assertEquals(comment1, allEvals.get(0).getComment());
  assertEquals(rating1, allEvals.get(0).getRating());
    
}
  
  
}
