package ca.mcgill.ecse321.tutoringapp.service;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.fail;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.tutoringapp.dao.CourseRepository;
import ca.mcgill.ecse321.tutoringapp.dao.EvaluationRepository;
import ca.mcgill.ecse321.tutoringapp.dao.PersonRepository;
import ca.mcgill.ecse321.tutoringapp.dao.RoomRepository;
import ca.mcgill.ecse321.tutoringapp.dao.SchoolRepository;
import ca.mcgill.ecse321.tutoringapp.dao.SessionRepository;
import ca.mcgill.ecse321.tutoringapp.dao.StudentRepository;
import ca.mcgill.ecse321.tutoringapp.dao.SubjectRepository;
import ca.mcgill.ecse321.tutoringapp.dao.TutorRepository;

import ca.mcgill.ecse321.tutoringapp.Database.src.Course;
import ca.mcgill.ecse321.tutoringapp.Database.src.Evaluation;
import ca.mcgill.ecse321.tutoringapp.Database.src.Manager;
import ca.mcgill.ecse321.tutoringapp.Database.src.Person;
import ca.mcgill.ecse321.tutoringapp.Database.src.PersonRole;
import ca.mcgill.ecse321.tutoringapp.Database.src.Room;
import ca.mcgill.ecse321.tutoringapp.Database.src.RoomType;
import ca.mcgill.ecse321.tutoringapp.Database.src.School;
import ca.mcgill.ecse321.tutoringapp.Database.src.SchoolType;
import ca.mcgill.ecse321.tutoringapp.Database.src.Session;
import ca.mcgill.ecse321.tutoringapp.Database.src.SessionType;
import ca.mcgill.ecse321.tutoringapp.Database.src.Student;
import ca.mcgill.ecse321.tutoringapp.Database.src.Subject;
import ca.mcgill.ecse321.tutoringapp.Database.src.Tutor;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTutoringAppService {
	
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
	private TutoringAppService service;
	
	
	@After
	public void clearDatabase() {
		// Fisrt, we clear registrations to avoid exceptions due to inconsistencies
		personRepository.deleteAll();
		// Then we can clear the other tables
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
	public void testAddCourse() {
		
		assertEquals(0, service.getAllCourses().size());
		
		String name="Intro to software engineering";
		String id = "ecse321";
		
		try {
			service.addCourse(name,id);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		List<Course> allCourses = service.getAllCourses();

		assertEquals(1, allCourses.size());
		assertEquals(name, allCourses.get(0).getName());
		assertEquals(name, allCourses.get(0).getCourseID());

	}
	
	@Test
	public void testAddSubject() {
		assertEquals(0, service.getAllSubject().size());
		
		String name="Chemistry";
		School school = new School();
		school.setName("schoolX");
		
		try {
			service.addSubject(name,school);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		List<Subject> allSubjects = service.getAllSubject();

		assertEquals(1, allSubjects.size());
		assertEquals(name, allSubjects.get(0).getName());
		assertEquals(name, allSubjects.get(0).getSchool());
		
	}
	
	@Test
	public void testAddSchool() {
		assertEquals(0, service.getAllSchool().size());
		
		String name="schoolX";
		int id = 021;
		SchoolType schoolType= SchoolType.highSchool;
		
		
		try {
			service.addSchool(name,id,schoolType);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		List<School> allSchool = service.getAllSchool();

		assertEquals(1, allSchool.size());
		assertEquals(name, allSchool.get(0).getName());
		assertEquals(name, allSchool.get(0).getSchoolID());
		assertEquals(name, allSchool.get(0).getType());
		
	}
	
	@Test
	public void testAddCourseNull() {
		assertEquals(0, service.getAllCourses().size());
		
		String name = null;
		String id = null;
		String error = null;

		try {
			service.addCourse(name,id);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Course name/ID cannot be empty!", error);
		

		// check no change in memory
		assertEquals(0, service.getAllCourses().size());

	}
	
	@Test
	public void testAddSubjectNull() {
		assertEquals(0, service.getAllSubject().size());
		
		String name = null;
		School school = null;
		String error = null;

		try {
			service.addSubject(name,school);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Subject name/School cannot be empty!", error);
		

		// check no change in memory
		assertEquals(0, service.getAllSubject().size());

	}
	
	@Test
	public void testAddSchoolNull() {
		assertEquals(0, service.getAllSubject().size());
		
		String name = null;
		int id = 0;
		SchoolType schoolType;
		String error = null;

		try {
			service.addSchool(name,id,schoolType);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("School name/ID/school type cannot be empty!", error);
		

		// check no change in memory
		assertEquals(0, service.getAllSchool().size());

	}
	
	@Test
	public void testRemoveCourse() {
		assertEquals(0, service.getAllCourses().size());
		String error = null;
		
		try {
			service.removeCourse("ecse321");
		}catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		
		assertEquals("Course not removed!", error);
	}
	
	@Test
	public void testRemoveSubject() {
		assertEquals(0, service.getAllSubject().size());
		String error=null;
		
		try {
			service.removeSubject("chemistry");
		}catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		
		assertEquals("Subject not removed!", error);
	}
	
	@Test
	public void testSchoolSubject() {
		assertEquals(0, service.getAllSchool().size());
		String error=null;
		
		try {
			service.removeSchool(021);
		}catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		
		assertEquals("School not removed!", error);
	}
	

}
