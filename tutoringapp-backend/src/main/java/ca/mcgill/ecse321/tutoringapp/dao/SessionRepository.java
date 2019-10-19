package ca.mcgill.ecse321.tutoringapp.dao;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoringapp.Database.src.Session;
import ca.mcgill.ecse321.tutoringapp.Database.src.Student;
import ca.mcgill.ecse321.tutoringapp.Database.src.Tutor;

public interface SessionRepository extends CrudRepository<Session, Integer> {
	Session findBySessionID(Integer ID);
	List<Session> findByStudent(Student studentId);
	List<Session> findByDateAndTime(Date date, Time time);
	List<Session> findByTutor(Tutor tutorId);

}
