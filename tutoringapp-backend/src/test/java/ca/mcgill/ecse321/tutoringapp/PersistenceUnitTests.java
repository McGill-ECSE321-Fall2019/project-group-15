package ca.mcgill.ecse321.tutoringapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.tutoringapp.Database.src.Course;
import ca.mcgill.ecse321.tutoringapp.Database.src.Person;
import ca.mcgill.ecse321.tutoringapp.Database.src.Room;
import ca.mcgill.ecse321.tutoringapp.Database.src.RoomType;
import ca.mcgill.ecse321.tutoringapp.Database.src.School;
import ca.mcgill.ecse321.tutoringapp.Database.src.SchoolType;
import ca.mcgill.ecse321.tutoringapp.Database.src.SessionType;
import ca.mcgill.ecse321.tutoringapp.Database.src.Student;
import ca.mcgill.ecse321.tutoringapp.Database.src.Subject;
import ca.mcgill.ecse321.tutoringapp.dao.CourseRepository;
import ca.mcgill.ecse321.tutoringapp.dao.EvaluationRepository;
import ca.mcgill.ecse321.tutoringapp.dao.PersonRepository;
import ca.mcgill.ecse321.tutoringapp.dao.PersonRoleRepository;
import ca.mcgill.ecse321.tutoringapp.dao.RoomRepository;
import ca.mcgill.ecse321.tutoringapp.dao.SchoolRepository;
import ca.mcgill.ecse321.tutoringapp.dao.SessionRepository;
import ca.mcgill.ecse321.tutoringapp.dao.StudentRepository;
import ca.mcgill.ecse321.tutoringapp.dao.SubjectRepository;
import ca.mcgill.ecse321.tutoringapp.dao.TutorRepository;
import ca.mcgill.ecse321.tutoringapp.service.CourseService;
import ca.mcgill.ecse321.tutoringapp.service.EvaluationService;
//import ca.mcgill.ecse321.tutoringapp.service.PersonRoleService;
import ca.mcgill.ecse321.tutoringapp.service.PersonService;
import ca.mcgill.ecse321.tutoringapp.service.RoomService;
import ca.mcgill.ecse321.tutoringapp.service.SchoolService;
import ca.mcgill.ecse321.tutoringapp.service.SessionService;
import ca.mcgill.ecse321.tutoringapp.service.StudentService;
import ca.mcgill.ecse321.tutoringapp.service.SubjectService;
import ca.mcgill.ecse321.tutoringapp.service.TutorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersistenceUnitTests {
	
	@Autowired
	private CourseService courseService;
	@Autowired
	private EvaluationService evaluationService;
	/*@Autowired
	private PersonRoleService personRoleService;
	*/@Autowired
	private PersonService personService;
	@Autowired
	private RoomService roomService;
	@Autowired
	private SchoolService schoolService;
	@Autowired
	private SessionService sessionService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private TutorService tutorService;
	
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private EvaluationRepository evaluationRepository;
	@Autowired
	private PersonRoleRepository personRoleRepository;
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private SchoolRepository schoolRepository;
	@Autowired
	private SessionRepository sessionRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private SubjectRepository subjectRepository;
	@Autowired
	private TutorRepository tutorRepository;
	
	@Before
	public void clearDatabase() {
		
		personRoleRepository.deleteAll();
		studentRepository.deleteAll();
		tutorRepository.deleteAll();
		sessionRepository.deleteAll();
		courseRepository.deleteAll();
		evaluationRepository.deleteAll();
		roomRepository.deleteAll();
		subjectRepository.deleteAll();
		schoolRepository.deleteAll();
		personRepository.deleteAll();
	}
	@Test
	public void testCreatePerson() {
		assertEquals(0, personService.getAllPersons().size());
		
		String firstName = "Maxime";
		String lastName = "Buteau";
		String userName = "mbuteau";
		
		try {
			personService.createPerson(userName, firstName, lastName);
		} catch (IllegalArgumentException e) {
			fail();
		}
		List<Person> allPersons = personService.getAllPersons();
		assertEquals(1, allPersons.size());
	}
	
	@Test
	public void testReadPerson() {
		
		String username1 = "a";
		String firstname1 = "Max";
		String lastname1 = "Cool";
		
		String username2 = "b";
		String firstname2 = "John";
		String lastname2 = "Doe";
		
		personService.createPerson(username1, firstname1, lastname1);
		personService.createPerson(username2, firstname2, lastname2);
		
		List<Person> allPersons = personService.getAllPersons();
		
		assertEquals(2, allPersons.size());
		
		assertEquals(firstname1, allPersons.get(0).getFirstName());
		assertEquals(lastname1, allPersons.get(0).getLastName());
		assertEquals(username1, allPersons.get(0).getUserName());
		
		assertEquals(firstname1, personService.getByUsername(username1).getFirstName());
		
		assertEquals(firstname2, allPersons.get(1).getFirstName());
		assertEquals(lastname2, allPersons.get(1).getLastName());
		assertEquals(username2, allPersons.get(1).getUserName());
		
		assertEquals(firstname2, personService.getByUsername(username2).getFirstName());
	}
	
	/*@Test
	public void testModifyPersonName() {
		String firstName = "Maxime";
		String lastName = "Buteau";
		String userName = "mbuteau";
		Person person = personService.createPerson(userName, firstName, lastName);
		
		List<Person> allPersons = personService.getAllPersons();
		assertEquals(1, allPersons.size());
		assertEquals(firstName, allPersons.get(0).getFirstName());
		
		String firstName2 = "George";
		person.setFirstName(firstName2);
		assertEquals(firstName2, allPersons.get(0).getFirstName());
	}*/
	
	@Test
	public void testAddStudent() {
		String firstName = "Maxime";
		String lastName = "Buteau";
		String userName = "maxbuteau";
		Person person = personService.createPerson(userName, firstName, lastName);
		String password = "123";
		
		try {
			studentService.addStudent(password, person);
		} catch(IllegalArgumentException e) {
			fail();
		}
		List<Student> allStudents = studentService.getAllStudents();
		assertEquals(1, allStudents.size());
	}
	
	/*@Test
	public void testCreateRoom() {
		assertEquals(0, roomService.getAllRooms().size());
		
		String name1 = "Room1";
		String name2 = "Room2";
		
		try {
			roomService.createRoom(name1, RoomType.smallRoom);
			roomService.createRoom(name2, RoomType.largeRoom);
		} catch (IllegalArgumentException e) {
			fail();
		}
		List<Room> allRooms = roomService.getAllRooms();
		List<Room> largeRooms = roomService.getRoomsByType(RoomType.largeRoom);
		List<Room> smallRooms = roomService.getRoomsByType(RoomType.smallRoom);
		
		assertEquals(2, allRooms.size());
		assertEquals(name1, allRooms.get(0).getName());
		assertEquals(RoomType.smallRoom, allRooms.get(0).getType());
		assertEquals(name2, allRooms.get(1).getName());
		assertEquals(RoomType.largeRoom, allRooms.get(1).getType());
		assertEquals(1, smallRooms.size());
		assertEquals(1, largeRooms.size());
	}
	@Test
	public void testCreateGroupSession() {
		assertEquals(0, sessionService.getAllSessions().size());
		
		Calendar c = Calendar.getInstance();
		c.set(2019, Calendar.OCTOBER, 16, 9, 0, 0);
		Date sessionDate = new Date(c.getTimeInMillis());
		LocalTime startTime = LocalTime.parse("09:00");
		c.set(2019, Calendar.OCTOBER, 16, 10, 30, 0);
		LocalTime endTime = LocalTime.parse("10:30");
		SessionType type = SessionType.groupSession;
		String courseName = "ECSE321";
		Course course = courseService.addCourse(courseName);
		
		try {
			sessionService.createSession(sessionDate, Time.valueOf(startTime), Time.valueOf(endTime), type, course);
		}catch (IllegalArgumentException e) {
			fail();
		}
		
		assertEquals(1, sessionService.getAllSessions().size());
		assertEquals(1, sessionService.getGroupSessionsforADay(sessionDate).size());
		
	}
	
	@Test
	public void testAddCourse() {
		
		assertEquals(0, courseService.getAllCourses().size());
		
		String name="Intro to software engineering";
		//String id = "ecse321";
		//String description= "learn build systems and inetgration";
		
		try {
<<<<<<< HEAD:tutoringapp-backend/src/test/java/ca/mcgill/ecse321/tutoringapp/PersistenceUnitTests.java
			//courseService.addCourse(name,id,description);
=======
			courseService.addCourse(name);
>>>>>>> origin/master:tutoringapp-backend/src/test/java/ca/mcgill/ecse321/tutoringapp/TestManageCoursesService.java
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		List<Course> allCourses = courseService.getAllCourses();

		assertEquals(1, allCourses.size());
		assertEquals(name, allCourses.get(0).getName());
		//assertEquals(name, allCourses.get(0).getCourseID());
		//assertEquals(description, allCourses.get(0).getDescription());

	}
	
//	@Test
//	public void testAddSubject() {
//		assertEquals(0, subjectService.getAllSubject().size());
//		
//		String name="Chemistry";
//		School school = new School();
//		school.setName("schoolX");
//		String description= "learn chemical reactions";
//		
//		try {
//			subjectService.addSubject(name,school,description);
//		} catch (IllegalArgumentException e) {
//			// Check that no error occurred
//			fail();
//		}
//
//		List<Subject> allSubjects = subjectService.getAllSubject();
//
//		assertEquals(1, allSubjects.size());
//		assertEquals(name, allSubjects.get(0).getName());
//		assertEquals(name, allSubjects.get(0).getSchool());
//		assertEquals(name, allSubjects.get(0).getDescription());
//		
//	}
//	
//	@Test
//	public void testAddSchool() {
//		assertEquals(0, schoolService.getAllSchool().size());
//		
//		String name="schoolX";
//		SchoolType schoolType= SchoolType.highSchool;
//		
//		
//		try {
//			schoolService.addSchool(name,schoolType);
//		} catch (IllegalArgumentException e) {
//			// Check that no error occurred
//			fail();
//		}
//
//		List<School> allSchool = schoolService.getAllSchool();
//
//		assertEquals(1, allSchool.size());
//		assertEquals(name, allSchool.get(0).getName());
//		assertEquals(name, allSchool.get(0).getType());
//	}
//	
//	@Test
//	public void testAddCourseNull() {
//		assertEquals(0, courseService.getAllCourses().size());
//		
//		String name = null;
//		//String id = null;
//		String description= null;
//		String error = null;
//
//		try {
//			courseService.addCourse(name,description);
//		} catch (IllegalArgumentException e) {
//			error = e.getMessage();
//		}
//
//		// check error
//		assertEquals("Course name/ID/description cannot be empty!", error);
//		
//
//		// check no change in memory
//		assertEquals(0, courseService.getAllCourses().size());
//
//	}
//	
//	@Test
//	public void testAddSubjectNull() {
//		assertEquals(0, subjectService.getAllSubject().size());
//		
//		String name = null;
//		School school = null;
//		String description= null;
//		String error = null;
//
//		try {
//			subjectService.addSubject(name,school,description);
//		} catch (IllegalArgumentException e) {
//			error = e.getMessage();
//		}
//
//		// check error
//		assertEquals("Subject name/School/description cannot be empty!", error);
//		
//
//		// check no change in memory
//		assertEquals(0, subjectService.getAllSubject().size());
//
//	}
//	
//	@Test
//	public void testAddSchoolNull() {
//		assertEquals(0, schoolService.getAllSchool().size());
//		
//		String name = null;
//		SchoolType schoolType;
//		schoolType= null;
//		String error = null;
//
//		try {
//			schoolService.addSchool(name,schoolType);
//		} catch (IllegalArgumentException e) {
//			error = e.getMessage();
//		}
//
//		// check error
//		assertEquals("School name/ID/school type/description cannot be empty!", error);
//		
//
//		// check no change in memory
//		assertEquals(0, schoolService.getAllSchool().size());
//
//	}
	
<<<<<<< HEAD:tutoringapp-backend/src/test/java/ca/mcgill/ecse321/tutoringapp/PersistenceUnitTests.java
	@Test
	public void testAddCourseNull() {
		assertEquals(0, courseService.getAllCourses().size());
		
		String name = null;
		String id = null;
		String description= null;
		String error = null;

		try {
			//courseService.addCourse(name,id,description);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Course name/ID/description cannot be empty!", error);
		

		// check no change in memory
		assertEquals(0, courseService.getAllCourses().size());

	}
	
	@Test
	public void testAddSubjectNull() {
		assertEquals(0, subjectService.getAllSubject().size());
		
		String name = null;
		School school = null;
		String description= null;
		String error = null;

		try {
			subjectService.addSubject(name,school,description);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Subject name/School/description cannot be empty!", error);
		

		// check no change in memory
		assertEquals(0, subjectService.getAllSubject().size());

	}
	
	@Test
	public void testAddSchoolNull() {
		assertEquals(0, schoolService.getAllSchool().size());
		
		String name = null;
		SchoolType schoolType;
		schoolType= null;
		String error = null;

		try {
			schoolService.addSchool(name,schoolType);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("School name/ID/school type/description cannot be empty!", error);
		

		// check no change in memory
		assertEquals(0, schoolService.getAllSchool().size());

	}
	
	@Test
	public void testRemoveCourse() {
		assertEquals(true, courseService.removeCourse("ecse321"));
	}
	
	@Test
	public void testRemoveSubject() {
		assertEquals(true, subjectService.removeSubject("Chemistry"));
	}
	
	@Test
	public void testSchoolSubject() {
		assertEquals(true, schoolService.removeSchool("schoolX"));
	}
=======
//		@Test
//		public void testRemoveCourse() {
//			assertEquals(true, courseService.removeCourse("ecse321"));
//		}
//		
//		@Test
//		public void testRemoveSubject() {
//			assertEquals(true, subjectService.removeSubject("Chemistry"));
//		}
//		
//		@Test
//		public void testSchoolSubject() {
//			assertEquals(true, schoolService.removeSchool("schoolX"));
//		}
>>>>>>> origin/master:tutoringapp-backend/src/test/java/ca/mcgill/ecse321/tutoringapp/TestManageCoursesService.java
	
	*/
}
