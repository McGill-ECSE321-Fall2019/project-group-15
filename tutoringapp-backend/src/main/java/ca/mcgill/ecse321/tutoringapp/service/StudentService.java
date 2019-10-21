package ca.mcgill.ecse321.tutoringapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.tutoringapp.Database.src.Student;
import ca.mcgill.ecse321.tutoringapp.dao.StudentRepository;


@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;
	
	@Transactional
	public Student addStudent(int id) {
		Student student = new Student();
		student.setStudentID(id);
		studentRepository.save(student);
		return null;
	}
	
	
	@Transactional
	public Student getStudent(int ID) {
		Student student = studentRepository.findStudentByStudentID(ID);
		return student;
	}
	
	@Transactional
	public boolean removeStudent(int ID) {
		Student student = studentRepository.findStudentByStudentID(ID);

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

}
