package ca.mcgill.ecse321.tutoringapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.mcgill.ecse321.tutoringapp.dto.*;
import ca.mcgill.ecse321.tutoringapp.service.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ca.mcgill.ecse321.tutoringapp.Database.src.*;

@CrossOrigin(origins = "*")
@RestController
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	
	@PostMapping(value = { "/createCourse/{courseName}/{description}", "/createCourse/{courseName}/{description}" })
	public CourseDto createCourse(@PathVariable("courseName") String courseName,
			@PathVariable("description") String description) throws IllegalArgumentException {
		try{
			Course course = courseService.addCourse(courseName,description);
			return DtoConverters.convertToDto(course);
		}
		catch(Exception e){
			throw new IllegalArgumentException("Could not create course");
		}
	}
	
	@GetMapping(value = { "/allCourses", "/allCourses/" })
	public List<CourseDto> getAllCourses() {
		try {
			List<CourseDto> courseDto = new ArrayList<>();
			for (Course course : courseService.getAllCourses()) {
				courseDto.add(DtoConverters.convertToDto(course));
			}
			return courseDto;
		}
		catch(Exception e) {
			throw new IllegalArgumentException("Could not retrieve information from service");
		}
	}
	
	@PostMapping(value = { "/deleteCourse", "/deleteCourse/" })
	public boolean deleteCourse(@RequestParam(name = "courseName") String courseName) {
		courseService.removeCourse(courseName);
		return true;
	}

}
