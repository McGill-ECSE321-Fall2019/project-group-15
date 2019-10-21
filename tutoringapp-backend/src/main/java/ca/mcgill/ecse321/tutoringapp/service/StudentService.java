package ca.mcgill.ecse321.tutoringapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.tutoringapp.Database.src.Student;
import ca.mcgill.ecse321.tutoringapp.Database.src.Tutor;
import ca.mcgill.ecse321.tutoringapp.dao.StudentRepository;
import ca.mcgill.ecse321.tutoringapp.dao.TutorRepository;


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
	public boolean removeTutor(int ID) {
		Student student = studentRepository.findStudentByStudentID(ID);

		if(student == null) {
			throw new NullPointerException("No such student exist");
		}
		removedStudents(student);
		student.deleteById(ID); //implement
		return true;
	}
	
	public <Student> List<Student> removedStudents(Student student){
		List<Student> removedStudentList = new ArrayList<Student>();
		removedStudentList.add(student);
		
		return removedStudentList;
		
	}	

}
