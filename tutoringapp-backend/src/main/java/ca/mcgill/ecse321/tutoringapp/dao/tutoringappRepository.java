package ca.mcgill.ecse321.tutoringapp.dao;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.tutoringapp.Database.src.Course;
import ca.mcgill.ecse321.tutoringapp.Database.src.Evaluation;
import ca.mcgill.ecse321.tutoringapp.Database.src.Manager;
import ca.mcgill.ecse321.tutoringapp.Database.src.Person;
import ca.mcgill.ecse321.tutoringapp.Database.src.PersonRole;
import ca.mcgill.ecse321.tutoringapp.Database.src.Room;
import ca.mcgill.ecse321.tutoringapp.Database.src.RoomType;
import ca.mcgill.ecse321.tutoringapp.Database.src.School;
import ca.mcgill.ecse321.tutoringapp.Database.src.SchoolType;
import ca.mcgill.ecse321.tutoringapp.Database.src.Session;
import ca.mcgill.ecse321.tutoringapp.Database.src.SessionType;
import ca.mcgill.ecse321.tutoringapp.Database.src.Student;
import ca.mcgill.ecse321.tutoringapp.Database.src.Subject;
import ca.mcgill.ecse321.tutoringapp.Database.src.Tutor;


@Repository
public class tutoringappRepository {
	
	@Autowired
	EntityManager entityManager;
	
	@Transactional
	public Person createPerson(String firstname, String lastname) {
		Person p = new Person();
		p.setFirstName(firstname);
		p.setLastName(lastname);
		entityManager.persist(p);
		return p;
		
	}
	
	@Transactional
	public Person getPerson(String firstname) {
		Person p = entityManager.find(Person.class, firstname);
		return p;
	}
	
	@Transactional
	public Student createStudent(int studentID) {
		Student s = new Student();
		s.setStudentID(studentID);
		return s;
	}
	
	@Transactional
	public Student getStudent(int studentID) {
		Student s = entityManager.find(Student.class, studentID);
		return s;
	}

}
