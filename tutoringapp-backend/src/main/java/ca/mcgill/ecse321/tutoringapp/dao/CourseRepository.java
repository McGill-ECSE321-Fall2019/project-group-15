package ca.mcgill.ecse321.tutoringapp.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoringapp.Database.src.Course;

public interface CourseRepository extends CrudRepository<Course, String> {
	Course findCourseByName(String name);
	Course findCourseByDescription(String description);
	void deleteCourseByName(String name);
	

}
