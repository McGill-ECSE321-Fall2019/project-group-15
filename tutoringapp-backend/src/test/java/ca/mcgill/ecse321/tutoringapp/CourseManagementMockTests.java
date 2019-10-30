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
	@Mock
	private SubjectRepository subjectDao;
	@Mock
	private SchoolRepository schoolDao;
	
	@InjectMocks
	private CourseService courseService;
	@InjectMocks
	private SubjectService subjectService;
	@InjectMocks
	private SchoolService schoolService;
	
	private Course course;
	private Course course2;
	private static final String COURSE_NAME1="ECSE 321";
	private static final String COURSE_NAME2="COMP 251";
	private static final String NONEXISTING_COURSE="NotACourse";
	private static final String COURSE_DESC1="alot of work";
	private static final String COURSE_DESC2="tough course";
	private List<Course> courseExpectedList = new ArrayList<Course>();
	
//	private Subject subject1;
//	private Subject subject2;
//	private static final String SUBJECT_NAME1="Chemistry";
//	private static final String SUBJECT_NAME2="Biology";
//	private static final String SUBJECT_DESC1="chemical bonds";
//	private static final String SUBJECT_DESC2="learn plants";
//	private static final String NONEXISTING_SUBJECT="NotASubject";
	
	private School school;
	private School school1;
	private static final String SCHOOL_NAME="Manarat";
	private static final String SCHOOL_NAME1="Shawnigan";
	private static final String NONEXISTING_SCHOOL="NotASchool";
	private static final SchoolType schoolType = SchoolType.highSchool;
	private static final SchoolType schoolType1 = SchoolType.CEGEP;
	private List<School> schoolExpectedList = new ArrayList<School>();
	
	
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
		
		when(schoolDao.findSchoolByName(anyString())).thenAnswer((InvocationOnMock invocation) -> {
			if(invocation.getArgument(0).equals(SCHOOL_NAME)) {
				return school;
			}else if(invocation.getArgument(0).equals(SCHOOL_NAME1)){
				return school1;
			}
			return null;
		
		});
		
//		when(subjectDao.findSubjectByName(anyString())).thenAnswer((InvocationOnMock invocation) -> {
//			if(invocation.getArgument(0).equals(SUBJECT_NAME1)) {
//				return subject1;
//			}else if(invocation.getArgument(0).equals(SUBJECT_NAME2)){
//				return subject2;
//			}
//			return null;
//		
//		});
		
		
	}	
	
	@Before
	public void setUpMocks() {
		course = mock(Course.class);
		course = courseService.addCourse(COURSE_NAME1, COURSE_DESC1);
		courseExpectedList.add(course);
		
		course2 = mock(Course.class);
		course2 = courseService.addCourse(COURSE_NAME2, COURSE_DESC2);
		courseExpectedList.add(course2);
		
		school =mock(School.class);
		school = schoolService.addSchool(SCHOOL_NAME, schoolType);
		schoolExpectedList.add(school);
		
		school1 =mock(School.class);
		school1 = schoolService.addSchool(SCHOOL_NAME1, schoolType1);
		schoolExpectedList.add(school1);
				
	}
	
	@Test
	public void testCourseAddition() {
		assertNotNull(course);
		assertNotNull(course2);
		
	}
	
	@Test
	public void testSchoolAddition() {
		assertNotNull(school);
		assertNotNull(school1);
		
	}
	
	@Test
	public void testCourseQueryFound() {
		assertEquals(COURSE_NAME1, courseService.getCourseByCourseName(COURSE_NAME1).getName());
		assertEquals(COURSE_NAME2, courseService.getCourseByCourseName(COURSE_NAME2).getName());
	}
	
	@Test
	public void testSchoolQueryFound() {
		assertEquals(SCHOOL_NAME, schoolService.getSchoolBySchoolName(SCHOOL_NAME).getName());
		assertEquals(SCHOOL_NAME1, schoolService.getSchoolBySchoolName(SCHOOL_NAME1).getName());
		
	}
	
	@Test
	public void testCourseNotFound() {
		assertNull(courseService.getCourseByCourseName(NONEXISTING_COURSE));
	}
	
	@Test
	public void testSchoolNotFound() {
		assertNull(schoolService.getSchoolBySchoolName(NONEXISTING_SCHOOL));
		
	}
	
	@Test
	public void testCourseDeletion() {
		assertEquals(true, courseService.removeCourse(COURSE_NAME1));
	}
	
	@Test
	public void testSchoolDeletion() {
		assertEquals(true, schoolService.removeSchool(SCHOOL_NAME));
	}
	

}
