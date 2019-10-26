package ca.mcgill.ecse321.tutoringapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.tutoringapp.Database.src.Course;
import ca.mcgill.ecse321.tutoringapp.Database.src.Subject;
import ca.mcgill.ecse321.tutoringapp.dao.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	CourseRepository courseRepository;
	
	@Transactional
	public Course addCourse(String name, String description) {
		Course course = new Course();
		course.setName(name);
		//course.setCourseID(id);
		course.setDescription(description);
		courseRepository.save(course);
		return course;
	}
	
	@Transactional
	public Course getCourse(String name, String description) {
		Course course = courseRepository.findCourseByName(name);
		return course;
	}
	
	@Transactional
	public List<Course> getAllCourses(){
		return toList(courseRepository.findAll());
	}
	
	@Transactional
	public boolean removeCourse(String name) {
		Course course = courseRepository.findCourseByName(name);
		
		if(course == null) {
			throw new NullPointerException("No such course.");
		}
		
		courseRepository.deleteCourseByName(name);
		return true;
	}
	
	private <T> List<T> toList(Iterable<T> iterable){
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}

}
