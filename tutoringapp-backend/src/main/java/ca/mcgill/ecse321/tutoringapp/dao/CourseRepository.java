package ca.mcgill.ecse321.tutoringapp.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoringapp.Database.src.Course;

public interface CourseRepository extends CrudRepository<Course, String> {
	Course findCourseByCourseName(String courseName);
	void deleteByCourseName(String name);
	

}
