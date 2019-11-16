package ca.mcgill.ecse321.tutoringapp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

import ca.mcgill.ecse321.tutoringapp.Database.src.Course;
import ca.mcgill.ecse321.tutoringapp.Database.src.Person;
import ca.mcgill.ecse321.tutoringapp.Database.src.Room;
import ca.mcgill.ecse321.tutoringapp.Database.src.RoomType;
import ca.mcgill.ecse321.tutoringapp.Database.src.Session;
import ca.mcgill.ecse321.tutoringapp.Database.src.SessionType;
import ca.mcgill.ecse321.tutoringapp.Database.src.Student;
import ca.mcgill.ecse321.tutoringapp.Database.src.Tutor;
import ca.mcgill.ecse321.tutoringapp.dao.CourseRepository;
import ca.mcgill.ecse321.tutoringapp.dao.PersonRepository;
import ca.mcgill.ecse321.tutoringapp.dao.RoomRepository;
import ca.mcgill.ecse321.tutoringapp.dao.SessionRepository;
import ca.mcgill.ecse321.tutoringapp.dao.StudentRepository;
import ca.mcgill.ecse321.tutoringapp.dao.TutorRepository;
import ca.mcgill.ecse321.tutoringapp.service.CourseService;
import ca.mcgill.ecse321.tutoringapp.service.PersonService;
import ca.mcgill.ecse321.tutoringapp.service.RoomService;
import ca.mcgill.ecse321.tutoringapp.service.SessionService;
import ca.mcgill.ecse321.tutoringapp.service.StudentService;
import ca.mcgill.ecse321.tutoringapp.service.TutorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupSessionMockTests {

	@Mock
	private RoomRepository roomRepository;
	@Mock
	private TutorRepository tutorRepository;
	@Mock
	private SessionRepository sessionRepository;
	@Mock
	private StudentRepository studentRepository;
	@Mock
	private PersonRepository personRepository;
	@Mock
	private CourseRepository courseRepository;

	@InjectMocks
	private RoomService roomService;
	@InjectMocks
	private TutorService tutorService;
	@InjectMocks
	private SessionService sessionService;
	@InjectMocks
	private StudentService studentService;
	@InjectMocks
	private PersonService personService;
	@InjectMocks
	private CourseService courseService;

	private Room room1;
	private static final String ROOM_NAME = "TR5090";
	private static final String NON_EXISTING_ROOM = "NotARoom";



	@Before
	public void setMockOutput() {
		when(roomRepository.findRoomByName(anyString())).thenAnswer((InvocationOnMock invocation) -> {
			if(invocation.getArgument(0).equals(ROOM_NAME)) {
				Room room = new Room();
				room.setName(ROOM_NAME);
				room.setType(RoomType.largeRoom);
				return room;
			}
			else {
				return null;
			}
		});
	}

	/*@Test
	public void testAssignRoomToGroupSession() {
		assertEquals(0, roomService.getRoomsByType(RoomType.largeRoom).size());

		String name = "CommonRoom";
		RoomType type = RoomType.largeRoom;
		Room room = roomService.createRoom(name, type);

		Calendar c = Calendar.getInstance();
		c.set(2019, Calendar.OCTOBER, 31, 9, 00, 0);
		Date sessionDate = new Date(c.getTimeInMillis());
		Time startTime = new Time(c.getTimeInMillis());
		c.set(2019, Calendar.OCTOBER, 31, 10, 30, 0);
		Time endTime = new Time(c.getTimeInMillis());
		SessionType sessionType = SessionType.groupSession;

		Set<Student> groupSession = new HashSet<>();
		String password1 = "123";
		String firstName1 = "Maxime";
		String lastName1 = "Buteau";
		String userName1 = "mbutea";
		Integer studentid1 = 1;
		Person person1 = personService.createPerson(firstName1, lastName1, userName1);
		Student student1 = studentService.addStudent(password1, person1, studentid1);

		/*String password2 = "qwerty";
		String firstName2 = "John";
		String lastName2 = "Doe";
		String userName2 = "jdoe";
		Integer studentid2 = 2;
		Person person2 = personService.createPerson(firstName2, lastName2, userName2);
		Student student2 = studentService.addStudent(password2, person2, studentid2);*/

		/*groupSession.add(student1);
		//groupSession.add(student2);

		String courseName = "ECSE321";
		String description = "Cool class";
		Course course = courseService.addCourse(courseName, description);

		String tutorFirst = "Marton";
		String tutorLast = "Bur";
		String tutorUserName = "mbur";
		String tutorpassword = "12345";
		Integer tutorId = 1;
		Person person3 = personService.createPerson(tutorFirst, tutorLast, tutorUserName);

		float hourlyRate = 15;
		Tutor tutor = tutorService.createTutor(hourlyRate, true, tutorpassword, person3, tutorId);
		
		

		String error;
		
		assertEquals(1, groupSession.size());

		@SuppressWarnings("unchecked")
		Session session = sessionService.createSession(sessionDate, startTime, endTime, sessionType, course, tutor, groupSession);

		try {
			session.setRoom(room);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals(room, session.getRoom());
	}*/

}
