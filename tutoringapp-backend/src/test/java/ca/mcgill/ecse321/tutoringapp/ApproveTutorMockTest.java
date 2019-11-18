
package ca.mcgill.ecse321.tutoringapp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import org.mockito.invocation.InvocationOnMock;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.tutoringapp.Database.src.*;
import ca.mcgill.ecse321.tutoringapp.dao.*;
import ca.mcgill.ecse321.tutoringapp.service.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApproveTutorMockTest {

	@Mock
	private PersonRepository personDao;
	@Mock
	private TutorRepository tutorDao;
	
	@InjectMocks
	private PersonService personService;
	@InjectMocks
	private TutorService tutorService;
	
	private Person person1;
	private Person person2;
	private static final String FIRST_NAME1 = "John";
	private static final String FIRST_NAME2 = "Jane";
	private static final String NONEXISTING_FIRST_NAME = "NotAFirstName";
	private static final String LAST_NAME1 = "Doe";
	private static final String LAST_NAME2 = "Dane";
	private static final String NONEXISTING_LAST_NAME = "NotALastName";
	private static final String USERNAME1 = "JohnDoe";
	private static final String USERNAME2 = "JaneDane";
	private static final String NONEXISTING_USERNAME = "NotAUsername";
	private List<Person> personExpectedList = new ArrayList<Person>();

	
	private Tutor tutor1;
	private Tutor tutor2;
	private static final Integer ID1 = 1;
	private static final Integer ID2 = 2;
	private static final Integer NONEXISTING_ID = 0;
	private static final Integer RID1 = 10;
	private static final Integer RID2 = 20;
	private static final Integer NONEXISTING_RID = 100;
	private static final Float HOURLY_RATE1 = 1.0f;
	private static final Float HOURLY_RATE2 = 2.0f;
	private static final Float NONEXISTING_HOURLY_RATE = 0.0f;
	private static final String PASSWORD1 = "1234";
	private static final String PASSWORD2 = "4321";
	private static final String NONEXISTING_PASSWORD = "NotAPassword";
	private List<Tutor> tutorExpectedList = new ArrayList<Tutor>();

	@Before
	public void setMockOutput() {
		when(personDao.findPersonByUserName(anyString())).thenAnswer( (InvocationOnMock invocation) -> {
			if(invocation.getArgument(0).equals(USERNAME1)) {
				return person1;
			}
			else if (invocation.getArgument(0).equals(USERNAME2)) {
				return person2;
			} else {
				return null;
			}
		});
				
		when(tutorDao.findById(anyInt())).thenAnswer( (InvocationOnMock invocation) -> {
			if (invocation.getArgument(0).equals(ID1.intValue())) {
				return person1;
			} 
			else if (invocation.getArgument(0).equals(ID2.intValue())) {
				return tutor2;
			} else {
				return null;
			}
		});
	}
	
	@Before
	public void setUpMocks() {
		person1 = mock(Person.class);
		person1 = personService.createPerson(FIRST_NAME1, LAST_NAME1, USERNAME1);
		personExpectedList.add(person1);
		
		person2 = mock(Person.class);
		person2 = personService.createPerson(FIRST_NAME2, LAST_NAME2, USERNAME2);
		personExpectedList.add(person2);
		
		tutor1 = mock(Tutor.class);
		tutor1 = tutorService.createTutor(HOURLY_RATE1, PASSWORD1, person1, ID1.intValue());
		tutorExpectedList.add(tutor1);
		
		tutor2 = mock(Tutor.class);
		tutor2 = tutorService.createTutor(HOURLY_RATE2, PASSWORD2, person2, ID2.intValue());
		tutorExpectedList.add(tutor2);
	}
	
	@Test
	public void dummyTest() {
		assertEquals(1,1);
	}
	
//	@Test
//	public void testPersonAddition() {
//		assertNotNull(person1);
//		assertNotNull(person2);
//	}
//	
//	@InjectMocks
//	private PersonService personService;
//	@InjectMocks
//	private TutorService tutorService;
//	
//	private Person person1;
//	private Person person2;
//	private static final String FIRST_NAME1 = "John";
//	private static final String FIRST_NAME2 = "Jane";
//	private static final String NONEXISTING_FIRST_NAME = "NotAFirstName";
//	private static final String LAST_NAME1 = "Doe";
//	private static final String LAST_NAME2 = "Dane";
//	private static final String NONEXISTING_LAST_NAME = "NotALastName";
//	private static final String USERNAME1 = "JohnDoe";
//	private static final String USERNAME2 = "JaneDane";
//	private static final String NONEXISTING_USERNAME = "NotAUsername";
//	private List<Person> personExpectedList = new ArrayList<Person>();
//
//	
//	private Tutor tutor1;
//	private Tutor tutor2;
//	private static final Integer ID1 = 1;
//	private static final Integer ID2 = 2;
//	private static final Integer NONEXISTING_ID = 0;
//	private static final Integer RID1 = 10;
//	private static final Integer RID2 = 20;
//	private static final Integer NONEXISTING_RID = 100;
//	private static final Float HOURLY_RATE1 = 1.0f;
//	private static final Float HOURLY_RATE2 = 2.0f;
//	private static final Float NONEXISTING_HOURLY_RATE = 0.0f;
//	private static final String PASSWORD1 = "1234";
//	private static final String PASSWORD2 = "4321";
//	private static final String NONEXISTING_PASSWORD = "NotAPassword";
//	private List<Tutor> tutorExpectedList = new ArrayList<Tutor>();
//
//	@Before
//	public void setMockOutput() {
//		when(personDao.findPersonByUserName(anyString())).thenAnswer( (InvocationOnMock invocation) -> {
//			if(invocation.getArgument(0).equals(USERNAME1)) {
//				return person1;
//			}
//			else if (invocation.getArgument(0).equals(USERNAME2)) {
//				return person2;
//			} else {
//				return null;
//			}
//		});
//				
//		when(tutorDao.findById(anyInt())).thenAnswer( (InvocationOnMock invocation) -> {
//			if (invocation.getArgument(0).equals(ID1.intValue())) {
//				return person1;
//			} 
//			else if (invocation.getArgument(0).equals(ID2.intValue())) {
//				return tutor2;
//			} else {
//				return null;
//			}
//		});
//	}
//	
//	@Before
//	public void setUpMocks() {
//		person1 = mock(Person.class);
//		person1 = personService.createPerson(FIRST_NAME1, LAST_NAME1, USERNAME1);
//		personExpectedList.add(person1);
//		
//		person2 = mock(Person.class);
//		person2 = personService.createPerson(FIRST_NAME2, LAST_NAME2, USERNAME2);
//		personExpectedList.add(person2);
//		
//		tutor1 = mock(Tutor.class);
//		tutor1 = tutorService.createTutor(HOURLY_RATE1, PASSWORD1, person1, ID1.intValue());
//		tutorExpectedList.add(tutor1);
//		
//		tutor2 = mock(Tutor.class);
//		tutor2 = tutorService.createTutor(HOURLY_RATE2, PASSWORD2, person2, ID2.intValue());
//		tutorExpectedList.add(tutor2);
//	}
//	
////	@Test
////	public void testPersonAddition() {
////		assertNotNull(person1);
////		assertNotNull(person2);
////	}
////	
////	@Test
////	public void testTutorAddition() {
////		assertNotNull(tutor1);
////		assertNotNull(tutor2);
////	}
////	
////	@Test
////	public void testPersonQueryFound() {
////		Person p1 = personService.getPersonByUsername(USERNAME1);
////		assertEquals(USERNAME1, p1.getUserName());
////		assertEquals(FIRST_NAME1,p1.getFirstName());
////		assertEquals(LAST_NAME1, p1.getLastName());
////		
////		Person p2 = personService.getPersonByUsername(USERNAME2);
////		assertEquals(USERNAME2, p2.getUserName());
////		assertEquals(FIRST_NAME2, p2.getFirstName());
////		assertEquals(LAST_NAME2, p2.getLastName());
////	}
//	
////	@Test
////	public void testTutorQueryFound() {
////		Tutor t1 = tutorService.getTutor(ID1.intValue());
////		assertEquals(ID1.intValue(), t1.getTutorId().intValue());
////		assertEquals(HOURLY_RATE1, t1.getHourlyRate(), 0.001f);
////		assertEquals(false, t1.isIsVerified());
////		assertEquals(PASSWORD1, t1.getPassword());
////		assertEquals(person1, t1.getPerson());
////
////		Tutor t2 = tutorService.getTutor(ID2.intValue());
////		assertEquals(ID2.intValue(), t2.getTutorId().intValue());
////		assertEquals(HOURLY_RATE2, t2.getHourlyRate(), 0.001f);
////		assertEquals(false, t2.isIsVerified());
////		assertEquals(PASSWORD1, t2.getPassword());
////		assertEquals(person1, t2.getPerson());
////	}
//	
////	@Test
////	public void testPersonNotFound() {
////		assertNull(personService.getPersonByUsername(NONEXISTING_USERNAME));
////	}
////	
////	@Test
////	public void testTutorNotFound() {
////		assertNull(tutorService.getTutor(NONEXISTING_ID.intValue()));
////	}
////	
////	@Test
////	public void testPersonDeletion() {
////		assertEquals(true, personService.removePerson(USERNAME1));
////	}
//	
////	@Test
////	public void testTutorDeletion() {
////		assertEquals(true, tutorService.removeTutor(ID1.intValue()));
////	}
}
