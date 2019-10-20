package ca.mcgill.ecse321.tutoringapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.tutoringapp.Database.src.Course;
import ca.mcgill.ecse321.tutoringapp.Database.src.Person;
import ca.mcgill.ecse321.tutoringapp.dao.CourseRepository;
import ca.mcgill.ecse321.tutoringapp.dao.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository personRepository;
	
	@Transactional
	public Person createPerson(String firstname, String lastname) {
		Person person = new Person();
		person.setFirstName(firstname);
		person.setLastName(lastname);
		personRepository.save(person);
		return person;
	}
	
	@Transactional
	public Course getCourse(String name) {
		Course course = courseRepository.findCourseByCourseName(name);
		return course;
	}
	
	@Transactional
	public List<Course> getAllCourses(){
		return toList(courseRepository.findAll());
	}
	
	private <T> List<T> toList(Iterable<T> iterable){
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}

}
