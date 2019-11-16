package ca.mcgill.ecse321.tutoringapp.service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.tutoringapp.Database.src.Course;
import ca.mcgill.ecse321.tutoringapp.Database.src.Manager;
import ca.mcgill.ecse321.tutoringapp.Database.src.Session;
import ca.mcgill.ecse321.tutoringapp.Database.src.SessionType;
import ca.mcgill.ecse321.tutoringapp.Database.src.Student;
import ca.mcgill.ecse321.tutoringapp.Database.src.Tutor;
import ca.mcgill.ecse321.tutoringapp.dao.SessionRepository;

@Service
public class SessionService {
	
	@Autowired
	SessionRepository sessionRepository;
	
	@Transactional
	public Session createSession(Date date, Time time, Time time2, SessionType type, Course course, Tutor tutor, Set<Student> students, Manager manager) {
		Session session = new Session();
		session.setDate(date);
		session.setStartTime(time);
		session.setEndTime(time2);
		session.setType(type);
		session.setCourse(course);
		session.setRoom(null);
		session.setManager(manager);
		session.setStudent(students);
		sessionRepository.save(session);
		return session;
	}
	
	@Transactional
	public Session getSession(Integer ID) {
		Session session = sessionRepository.findSessionBySessionID(ID);
		return session;
	}
	
	@Transactional
	public List<Session> getAllSessions() {
		return toList(sessionRepository.findAll());
	}
	
	@Transactional
	public List<Session> getGroupSessionsforADay(Date date){
		List<Session> groupSessions = new ArrayList<>();
		for (Session s : sessionRepository.findByDate(date)) {
			if (s.getType() == SessionType.groupSession) {
				groupSessions.add(s);
			}
		}
		return groupSessions;
	}
	
	private <T> List<T> toList(Iterable<T> iterable){
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}
}
