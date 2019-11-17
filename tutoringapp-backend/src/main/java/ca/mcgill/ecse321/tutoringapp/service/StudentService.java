package ca.mcgill.ecse321.tutoringapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.tutoringapp.Database.src.Person;
import ca.mcgill.ecse321.tutoringapp.Database.src.Student;
import ca.mcgill.ecse321.tutoringapp.dao.StudentRepository;
import net.bytebuddy.description.ByteCodeElement.Token.TokenList;


@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;
	
	public List<Student> removedStudentList = new ArrayList<Student>();

	@Transactional
	public Student addStudent(String password, Person person, Integer studentID) {
		Student student = new Student();
		student.setPerson(person);
		student.setPassword(password);
		student.setStudentId(studentID);
		studentRepository.save(student);
		return student;
	}
	
	
	@Transactional
	public Student getStudent(int ID) {
		Student student = studentRepository.findStudentByStudentId(ID);
		return student;
	}
	
	@Transactional
	public List<Student> getAllStudents(){
		return toList(studentRepository.findAll());
	}
	
	@Transactional
	public boolean removeStudent(int ID) {
		Student student = studentRepository.findStudentByStudentId(ID);

		if(student == null) {
			throw new NullPointerException("No such student exists");
		}
		removedStudents(student);
		studentRepository.delete(student); 
		return true;
	}
	

	public <T> void removedStudents(Student student){
		//List<T> removedStudentList = new ArrayList<T>();

		removedStudentList.add(student);
	}
	
	public List<Student> getRemovedStudents() {
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
