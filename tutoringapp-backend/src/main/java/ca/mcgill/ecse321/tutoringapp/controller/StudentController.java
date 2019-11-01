
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
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@PostMapping(value =  { "/createStudent", "/createStudent/" })
	public StudentDto createStudent(@RequestParam("password") String password,
			@RequestParam("person") Person person, @RequestParam("studentId") int studentId, @RequestParam("roleId") int roleId)
					throws IllegalArgumentException {
		try {
		Student student = studentService.addStudent(password, person, studentId, roleId);
		return DtoConverters.convertToDto(student); 
		}
		catch (Exception e) {
			throw new IllegalArgumentException("Could not create student");
		}

	}
	/**
	 * Delete a student with its ID
	 * @param studentId
	 * @return
	 * @throws IllegalArgumentException
	 */
	@PostMapping(value = { "/deleteStudent", "/deleteStudent/" })
	public boolean deleteStudent(@RequestParam("studentId") int studentId) throws IllegalArgumentException {
		studentService.removeStudent(studentId);
		return true; 

	}
	/**
	 * Gets a student with its ID
	 * @param studentId
	 * @return
	 * @throws IllegalArgumentException
	 */
	@GetMapping(value = { "/student", "/student/" })
	public StudentDto getStudent(@RequestParam("studentId")int studentId) throws IllegalArgumentException {
		try {
			Student student = studentService.getStudent(studentId);
			return DtoConverters.convertToDto(student);
		}
		catch(Exception e) {
			throw new IllegalArgumentException("Could not retrieve information from service");
		}
	}	

	/**
	 * Lists all current students 
	 * @return
	 * @throws IllegalArgumentException
	 */
	@GetMapping(value = { "/allStudents", "/allStudents/" })
	public List<StudentDto> getAllStudents() throws IllegalArgumentException {
		List<Student> studentList = studentService.getAllStudents();
		List<StudentDto> stDtio = new ArrayList<>();
		for (Student s : studentList) {
			stDtio.add(DtoConverters.convertToDto(s));
		}
		return stDtio;

	}
	/**
	 * List of all removed students
	 * @return
	 * @throws IllegalArgumentException
	 */
	@GetMapping(value = { "/removedStudents", "/removedStudents/" })
	public List<StudentDto> getRemovedStudents() throws IllegalArgumentException {
		List<Student> studentList = studentService.getRemovedStudents();
		List<StudentDto> stDtio = new ArrayList<>();
		for (Student s : studentList) {
			stDtio.add(DtoConverters.convertToDto(s));
		}
		return stDtio;

	}
	
}
