package ca.mcgill.ecse321.tutoringapp;

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
import ca.mcgill.ecse321.tutoringapp.service.CourseService;
import ca.mcgill.ecse321.tutoringapp.service.PersonService;
import ca.mcgill.ecse321.tutoringapp.service.SchoolService;
import ca.mcgill.ecse321.tutoringapp.service.SessionService;
import ca.mcgill.ecse321.tutoringapp.service.SubjectService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestManageCoursesService {
	
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
	private CourseService courseService;
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private SchoolService schoolService;
	
	
	@After
	public void clearDatabase() {
		// Fisrt, we clear to avoid exceptions due to inconsistencies
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
		
		assertEquals(0, courseService.getAllCourses().size());
		
		String name="Intro to software engineering";
		//String id = "ecse321";
		String description= "learn build systems and inetgration";
		
		try {
			courseService.addCourse(name,description);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		List<Course> allCourses = courseService.getAllCourses();

		assertEquals(1, allCourses.size());
		assertEquals(name, allCourses.get(0).getName());
		//assertEquals(name, allCourses.get(0).getCourseID());
		assertEquals(description, allCourses.get(0).getDescription());

	}
	
	@Test
	public void testAddSubject() {
		assertEquals(0, subjectService.getAllSubject().size());
		
		String name="Chemistry";
		School school = new School();
		school.setName("schoolX");
		String description= "learn chemical reactions";
		
		try {
			subjectService.addSubject(name,school,description);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		List<Subject> allSubjects = subjectService.getAllSubject();

		assertEquals(1, allSubjects.size());
		assertEquals(name, allSubjects.get(0).getName());
		assertEquals(school, allSubjects.get(0).getSchool());
		assertEquals(description, allSubjects.get(0).getDescription());
		
	}
	
	@Test
	public void testAddSchool() {
		assertEquals(0, schoolService.getAllSchool().size());
		
		String name="schoolX";
		SchoolType schoolType= SchoolType.highSchool;
		
		
		try {
			schoolService.addSchool(name,schoolType);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		List<School> allSchool = schoolService.getAllSchool();

		assertEquals(1, allSchool.size());
		assertEquals(name, allSchool.get(0).getName());
		assertEquals(schoolType, allSchool.get(0).getType());
	}
	
	@Test
	public void testAddCourseNull() {
		assertEquals(0, courseService.getAllCourses().size());
		
		String name = null;
		//String id = null;
		String description= null;
		String error = null;

		try {
			courseService.addCourse(name,description);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Course name/description cannot be empty!", error);
		

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
	

}
