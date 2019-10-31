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

import ca.mcgill.ecse321.tutoringapp.Database.src.Person;
import ca.mcgill.ecse321.tutoringapp.Database.src.PersonRole;
import ca.mcgill.ecse321.tutoringapp.Database.src.Tutor;
import ca.mcgill.ecse321.tutoringapp.dao.CourseRepository;
import ca.mcgill.ecse321.tutoringapp.dao.EvaluationRepository;
import ca.mcgill.ecse321.tutoringapp.dao.PersonRepository;
import ca.mcgill.ecse321.tutoringapp.dao.RoomRepository;
import ca.mcgill.ecse321.tutoringapp.dao.SchoolRepository;
import ca.mcgill.ecse321.tutoringapp.dao.SessionRepository;
import ca.mcgill.ecse321.tutoringapp.dao.StudentRepository;
import ca.mcgill.ecse321.tutoringapp.dao.SubjectRepository;
import ca.mcgill.ecse321.tutoringapp.dao.TutorRepository;
import ca.mcgill.ecse321.tutoringapp.service.PersonService;
import ca.mcgill.ecse321.tutoringapp.service.TutorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApproveTutor {
	
	@Autowired
	PersonRepository personRepository;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	TutorRepository tutorRepository; 
	@Autowired
	EvaluationRepository evaluationRepository; 
	@Autowired
	RoomRepository roomRepository; 
	@Autowired
	SessionRepository sessionRepository;
	@Autowired
	CourseRepository courseRepository; 
	@Autowired
	SubjectRepository subjectRepository;
	@Autowired
	SchoolRepository schoolRepository; 
	@Autowired
	private PersonService personService;
	@Autowired
	private PersonRole personRole;
	@Autowired
	private TutorService tutorService;
	
	@After
	public void clearDatabase() {
		personRepository.deleteAll();
		studentRepository.deleteAll();
		tutorRepository.deleteAll();
		evaluationRepository.deleteAll();
		roomRepository.deleteAll();
		sessionRepository.deleteAll();
		courseRepository.deleteAll();
		subjectRepository.deleteAll();
		schoolRepository.deleteAll();
	}
	
	@Test
	public void testCreatePerson() {
		assertEquals(0, personService.getAllPersons().size());
		
		//Integer personID = 260779779;
		String firstName = "John";
		String lastName = "Doe";
		String userName = "JohnDoe";
		
		try {
			personService.createPerson(firstName, lastName, userName);
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		List<Person> allPersons = personService.getAllPersons();
		
		assertEquals( 1, allPersons.size() );
		//assertEquals( personID.intValue(), allPersons.get(0).getPersonID() );
		assertEquals( firstName , allPersons.get(0).getFirstName() );
		assertEquals( lastName , allPersons.get(0).getLastName() );
		assertEquals( userName, allPersons.get(0).getUserName() );
		
	}
		
	@Test
    public void testAddTutor() {
		assertEquals(0, tutorService.getAllTutors().size());
		
		Integer tutorID = 260797797;
		Float hourlyRate = 20.0f;
		Boolean isVerified = false;
		String password = "1234";
		Person person = personService.getAllPersons().get(0);
		
		try {
			tutorService.createTutor(hourlyRate, isVerified, password, person);
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		List<Tutor> allTutors = tutorService.getAllTutors();
		
		assertEquals( 1, allTutors.size() );
		assertEquals( tutorID.intValue(), allTutors.get(0).getTutorId() );
		assertEquals( hourlyRate.doubleValue(), allTutors.get(0).getHourlyRate(), 0.001f );
		assertEquals( password, allTutors.get(0).getPassword() );
		assertEquals( person, allTutors.get(0).getPerson() );
		assertEquals( isVerified, allTutors.get(0).isIsVerified() );
		
	}
	
	@Test
	public void testGetAllUnverifiedTutors() {
		assertEquals(1, tutorService.getAllTutors().size());
		assertEquals(1, tutorService.getAllUnverifiedTutors().size());
		
	}
	
	@Test
	public void testApproveTutor() {
		assertEquals(1, tutorService.getAllTutors().size());
		assertEquals(1, tutorService.getAllUnverifiedTutors().size());
		
		Tutor t = tutorService.getAllTutors().get(0);
		Integer id = t.getTutorId();
		
		assertEquals(false, tutorService.getTutor(id).isIsVerified());
		
		tutorService.approveTutor(id);
		
		assertEquals(true, tutorService.getAllTutors().get(0).isIsVerified());
		assertEquals(0, tutorService.getAllUnverifiedTutors().size());
	}
}
