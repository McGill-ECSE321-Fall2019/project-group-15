package ca.mcgill.ecse321.tutoringapp.controller;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.tutoringapp.Database.src.Course;
import ca.mcgill.ecse321.tutoringapp.Database.src.Manager;
import ca.mcgill.ecse321.tutoringapp.Database.src.Session;
import ca.mcgill.ecse321.tutoringapp.Database.src.SessionType;
import ca.mcgill.ecse321.tutoringapp.dto.SessionDto;
import ca.mcgill.ecse321.tutoringapp.service.CourseService;
import ca.mcgill.ecse321.tutoringapp.service.ManagerService;
import ca.mcgill.ecse321.tutoringapp.service.SessionService;
import ca.mcgill.ecse321.tutoringapp.service.StudentService;

@CrossOrigin(origins = "*")
@RestController
public class SessionController {
	
	@Autowired
	SessionService sessionService;
	@Autowired 
	CourseService courseService;
	@Autowired 
	ManagerService managerService;
	
	@PostMapping(value = { "/createSession", "/createSession/" })
	public SessionDto createSession(@RequestParam(name = "date") String date, 
									@RequestParam(name = "startTime") String startTime, 
									@RequestParam(name = "endTime") String endTime, 
									@RequestParam(name = "type") SessionType type, 
									@RequestParam(name = "course") String courseName, 
									@RequestParam(name = "managerId") Integer managerId) throws IllegalArgumentException {
		Course course = courseService.getCourseByCourseName(courseName);
		if (course == null) {
			throw new IllegalArgumentException("This course does not exist");
		}
		Manager manager = managerService.getManager(managerId);
		if (manager == null) {
			throw new IllegalArgumentException("This manager does not exist");
		}
		try {
			Session session = sessionService.createSession(Date.valueOf(date), Time.valueOf(startTime), Time.valueOf(endTime), type, course, null, null, manager);
			return DtoConverters.convertToDto(session, course);
		}
		catch(Exception e) {
			throw new IllegalArgumentException("Please enter valid information");
		}
	}

}
