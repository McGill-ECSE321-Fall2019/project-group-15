package ca.mcgill.ecse321.tutoringapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.tutoringapp.Database.src.Person;
import ca.mcgill.ecse321.tutoringapp.Database.src.Student;
import ca.mcgill.ecse321.tutoringapp.dao.PersonRoleRepository;
import ca.mcgill.ecse321.tutoringapp.dao.StudentRepository;


@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	PersonRoleRepository personRoleRepository;
	
	@Transactional
	public Student addStudent(String password, Person person) {
		Student student = new Student();
		student.setPerson(person);
		student.setPassword(password);
		personRoleRepository.save(student);
		return null;
	}
	
	
	@Transactional
	public Student getStudent(int ID) {
		Student student = studentRepository.findStudentByRoleID(ID);
		return student;
	}
	
	@Transactional
	public List<Student> getAllStudents(){
		return toList(studentRepository.findAll());
	}
	
	@Transactional
	public boolean removeStudent(int ID) {
		Student student = studentRepository.findStudentByRoleID(ID);

		if(student == null) {
			throw new NullPointerException("No such student exist");
		}
		removedStudents(student);
		studentRepository.deleteById(ID); 
		return true;
	}
	
	public <Student> List<Student> removedStudents(Student student){
		List<Student> removedStudentList = new ArrayList<Student>();
		removedStudentList.add(student);
		
		return removedStudentList;
		
	}
	
	private <T> List<T> toList(Iterable<T> iterable){
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}

}
