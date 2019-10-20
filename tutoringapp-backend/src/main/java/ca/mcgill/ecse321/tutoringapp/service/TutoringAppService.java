package ca.mcgill.ecse321.tutoringapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



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

@Service
public class TutoringAppService {
	
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
	
	
	@Transactional
	public Course addCourse(String name, String id) {
	
		Course course = new Course();
		course.setName(name);
		course.setCourseID(id);
		courseRepository.save(course);
		return course;
	}
	
	@Transactional
	public Subject addSubject(String name, School school) {
	
		Subject subject = new Subject();
		subject.setName(name);
		subject.setSchool(school);
		subjectRepository.save(subject);
		return subject;
	}
	
	@Transactional
	public School addSchool(String name, int id, SchoolType schoolType) {
		School school = new School();
		school.setName(name);
		school.setSchoolID(id);
		school.setType(schoolType);
		schoolRepository.save(school);
		return school;
		
	}
	
	public Course getCourse(String name) {
		Course course = courseRepository.findCourseByCourseName(name);
		return course;
	}
	
	public List<Course> getAllCourses(String name) {
		
		return toList(courseRepository.findAll());
	}
	
	public Subject getSubject(String name) {
		Subject subject = subjectRepository.findByName(name);
		return subject;
	}
	
	public List<Subject> getAllSubject(String name) {
		
		return toList(subjectRepository.findAll());
	}
	
	public School getSchool(String name) {
		School school = schoolRepository.findByName(name);
		return school;
	}
	
	public List<School> getAllSchool(String name) {
		
		return toList(schoolRepository.findAll());
	}
	
	public void removeCourse(Course course) {
		courseRepository.delete(course);;
	}
	
	public void removeSubject(Subject subject) {
		subjectRepository.delete(subject);;
	}
	
	public void removeSchool(School school) {
		schoolRepository.delete(school);
	}

	private <T> List<T> toList(Iterable<T> iterable){
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}
	
	
	
}
