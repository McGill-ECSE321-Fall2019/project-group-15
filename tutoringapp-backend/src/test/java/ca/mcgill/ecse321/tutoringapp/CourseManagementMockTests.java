package ca.mcgill.ecse321.tutoringapp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.invocation.InvocationOnMock;
import org.springframework.test.context.junit4.SpringRunner;
import ca.mcgill.ecse321.tutoringapp.controller.*;
import ca.mcgill.ecse321.tutoringapp.Database.src.*;
import ca.mcgill.ecse321.tutoringapp.service.*;
import ca.mcgill.ecse321.tutoringapp.dao.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseManagementMockTests {
	
	@Mock
	private CourseRepository courseDao;
	
	@InjectMocks
	private CourseService courseService;
	
	private Course course;
	private Course course2;
	private static final String COURSE_NAME1="ECSE 321";
	private static final String COURSE_NAME2="COMP 251";
	private static final String NONEXISTING_COURSE="NotACourse";
	private static final String COURSE_DESC1="alot of work";
	private static final String COURSE_DESC2="tough course";
	private List<Course> expectedList = new ArrayList<Course>();
	
	private Subject subject1;
	private Subject subject2;
	private static final String SUBJECT_NAME1="Chemistry";
	private static final String SUBJECT_NAME2="Biology";
	private static final String NONEXISTING_SUBJECT="NotASubject";
	//private static final School SUBJECT_SCHOOL1="Chemistry";
	
	@Before
	public void setMockOutput() {
		when(courseDao.findCourseByName(anyString())).thenAnswer((InvocationOnMock invocation) -> {
			if(invocation.getArgument(0).equals(COURSE_NAME1)) {
				return course;
			}else if(invocation.getArgument(0).equals(COURSE_NAME2)){
				return course2;
			}
			return null;
		
		});
		
		when(courseDao.findCourseByDescription(anyString())).thenAnswer((InvocationOnMock invocation) -> {
			if(invocation.getArgument(0).equals(COURSE_DESC1)) {
				return course;
			}else if(invocation.getArgument(0).equals(COURSE_DESC2)){
				return course2;
			}
			return null;
		
		});
		
		
	}	
	
	@Before
	public void setUpMocks() {
		course = mock(Course.class);
		course = courseService.addCourse(COURSE_NAME1, COURSE_DESC1);
		//course.setDescription(COURSE_DESC1);
		expectedList.add(course);
		
		course2 = mock(Course.class);
		course2 = courseService.addCourse(COURSE_NAME2, COURSE_DESC2);
		//course2.setDescription(COURSE_DESC2);
		expectedList.add(course2);
	}
	
	@Test
	public void testCourseAddition() {
		assertNotNull(course);
		assertNotNull(course2);
		
	}
	
	@Test
	public void testCourseQueryFound() {
		assertEquals(COURSE_NAME1, courseService.getCourseByCourseName(COURSE_NAME1).getName());
		assertEquals(COURSE_NAME2, courseService.getCourseByCourseName(COURSE_NAME2).getName());
	}
	
	@Test
	public void testCourseNotFound() {
		assertNull(courseService.getCourseByCourseName(NONEXISTING_COURSE));
	}
	
	@Test
	public void testCourseDeletion() {
		assertEquals(true, courseService.removeCourse(COURSE_NAME1));
	}
	

}
