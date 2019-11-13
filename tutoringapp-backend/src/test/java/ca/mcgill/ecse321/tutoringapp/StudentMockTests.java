package ca.mcgill.ecse321.tutoringapp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.invocation.InvocationOnMock;
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
import ca.mcgill.ecse321.tutoringapp.service.StudentService;
import ca.mcgill.ecse321.tutoringapp.service.SubjectService;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentMockTests {

	@Mock
	private StudentRepository studentDao;
	
	@InjectMocks
	private StudentService studentService;

	private Student student;

	private Person person;
	private String testPassword = "password1";
	private Integer studentId = 1;
	private Integer fakeStudentId = 3;
	private int roleId = 10;
	
	private List<Student> studentList = new ArrayList<Student>();

@Before
public void setMockOutput() { //method from tutorial
	when(studentDao.findById(anyInt())).thenAnswer((InvocationOnMock invocation) -> {
		if(invocation.getArgument(0).equals(studentId)) {
			Student student = new Student();
			student.setStudentId(studentId);
			return student;
		} else {
			return null;
		}
	});
}

/**
 * set up the mock
 */
@Before
public void setUp() {
	student = mock(Student.class);
	person = mock(Person.class);
	student = studentService.addStudent(testPassword, person, studentId);
	studentList.add(student);
}

//@Test
//public void testCreateStudent() {
//	assertNotNull(student); //check if it can create an student
//}

@Test
public void testStudentNotFound() {
	assertNull(studentService.getStudent(fakeStudentId)); 
}
	
//@Test
//public void testStudentFound() {
//	assertEquals(studentId, studentService.getStudent(studentId).getStudentId());
//}
	
//@Test
//public void testStudentRemove() {
//	assertEquals(true, studentService.removeStudent(studentId));
//}
	
}
