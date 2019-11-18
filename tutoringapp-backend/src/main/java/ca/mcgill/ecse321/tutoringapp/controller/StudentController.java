
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
	@Autowired
	PersonService personService;
	
	@PostMapping(value =  { "/createStudent/", "/createStudent" })
	public StudentDto createStudent(@RequestParam("password") String password,
			@RequestParam("userName") String userName)
					throws IllegalArgumentException {
		Person person = personService.getPersonByUsername(userName);
		if (person == null) {
			throw new IllegalArgumentException("This person does not exist");
		}
		try {
			Student student = studentService.addStudent(password, person);
			personService.addPersonRole(person, student);
			return DtoConverters.convertToDto(student); 
		}
		catch (Exception e) {
			throw new IllegalArgumentException("Could not create student");
		}

	}
	/**
	 * Delete a student with its ID
	 * @param studentId
	 * @returns
	 * @throws IllegalArgumentException
	 */
	@PostMapping(value = { "/deleteStudent", "/deleteStudent/" })
	public void deleteStudent(@RequestParam("studentId") int studentId) throws IllegalArgumentException {
		
		Student student = studentService.getStudent(studentId);
		if (student == null) {
			throw new IllegalArgumentException("This student does not exist");
		}
		try {
			studentService.removeStudent(studentId); 
		}
		catch(Exception e) {
			throw new IllegalArgumentException("Please enter valid information");
		}
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
		List<StudentDto> studentDto = new ArrayList<>();
		List<Student> studentList = studentService.getAllStudents();
		if(studentList.size() == 0) {
			throw new IllegalArgumentException("There are no students");
		}
		try {
			for (Student s : studentList) {
				studentDto.add(DtoConverters.convertToDto(s)); 
			}
			return studentDto;
		}
		catch(Exception e) {
			throw new IllegalArgumentException("Please enter valid information");
		}
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
