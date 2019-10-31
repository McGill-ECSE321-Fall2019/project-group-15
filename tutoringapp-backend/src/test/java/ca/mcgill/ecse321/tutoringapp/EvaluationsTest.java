package ca.mcgill.ecse321.tutoringapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
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
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EvaluationsTest {

  @Mock
  private PersonRepository personDao;
  @Mock
  private StudentRepository studentDao;
  @Mock
  private TutorRepository tutorDao; 
  @Mock
  private EvaluationRepository evaluationDao; 
  
  @InjectMocks
  private EvaluationService evaluationService;
  
  
  private Evaluation evaluation1;
  private Evaluation evaluation2;
  private static final String EVAL_COMMENT1="This is a great tutor!";
  private static final String EVAL_COMMENT2="This is a bad tutor!";
  private static final int RATING_1 = 5;
  private static final int RATING_2 = 2;
  private static final int ID_1 = 1;
  private static final int ID_2 = 2;
  private static final int NON_Existing_ID = 4;
  private List<Evaluation> evaluationList = new ArrayList<Evaluation>();
  
  
  @Before
  public void setMockOutput() {
    /**
     * Placing Ids to each evaluation
     */
    when(evaluationDao.findByEvaluationID(anyInt())).thenAnswer((InvocationOnMock invocation) -> {
      if(invocation.getArgument(0).equals(ID_1)) {
          return evaluation1;
      }else if(invocation.getArgument(0).equals(ID_2)){
          return evaluation2;
      }
      return null;
  
  });
  }
  
  
  @Before
  public void setUpMocks() {
    /**
     * Setting up first evaluation1
     */
    evaluation1 = mock(Evaluation.class);
    evaluation1 = evaluationService.createEvaluation(RATING_1, EVAL_COMMENT1);
    evaluationList.add(evaluation1);
    
    /**
     * Setting up second evaluation2
     */
    evaluation2 = mock(Evaluation.class);
    evaluation2 = evaluationService.createEvaluation(RATING_2, EVAL_COMMENT2);
    evaluationList.add(evaluation2);
    
  }
  
  /**
   * Testing existence of the evaluation objects
   */
  @Test
  public void testEvalAddition() {
    assertNotNull(evaluation1);
    assertNotNull(evaluation2);
  }
  
  @Test
  public void testEvalQueryFound() {
    assertEquals(EVAL_COMMENT1, evaluationService.getEvaluation(ID_1).getComment());
    assertEquals(EVAL_COMMENT1, evaluationService.getEvaluation(ID_1).getComment());
  }
  
  @Test
  public void testEvalNotFound() {
    assertNull(evaluationService.getEvaluation(NON_Existing_ID));
  }
  
  @Test
  public void testEvalDeletion() {
    assertEquals(true, evaluationService.removeEvaluation(ID_1));
  }
  
  /*
  @After
  public void clearDatabase() {
      // Fisrt, we clear to avoid exceptions due to inconsistencies
      personRepository.deleteAll();
      // Then we can clear the other tables
      studentRepository.deleteAll();
      tutorRepository.deleteAll();
      evaluationRepository.deleteAll();
      
  }
  
  */
  
  
}
