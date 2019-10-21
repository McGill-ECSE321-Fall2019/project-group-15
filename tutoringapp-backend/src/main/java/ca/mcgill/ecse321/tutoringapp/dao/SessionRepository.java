package ca.mcgill.ecse321.tutoringapp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoringapp.Database.src.Session;
import ca.mcgill.ecse321.tutoringapp.Database.src.Student;
import ca.mcgill.ecse321.tutoringapp.Database.src.Tutor;

public interface SessionRepository extends CrudRepository<Session, Integer> {
	Session findSessionByID(Integer ID);
	List<Session> findByStudent(Student studentId);
	List<Session> findByDateAndTime(String date, String time);
	List<Session> findByDate(String date);
	List<Session> findByTutor(Tutor tutorId);

}
