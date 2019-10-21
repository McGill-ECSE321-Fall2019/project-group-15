package ca.mcgill.ecse321.tutoringapp.service;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.tutoringapp.Database.src.Session;
import ca.mcgill.ecse321.tutoringapp.Database.src.SessionType;
import ca.mcgill.ecse321.tutoringapp.dao.SessionRepository;

@Service
public class SessionService {
	
	@Autowired
	SessionRepository sessionRepository;
	
	@Transactional
	public Session createSession(Date date, Time startTime, Time endTime, SessionType type) {
		Session session = new Session();
		session.setDate(date);
		session.setStartTime(startTime);
		session.setEndTime(endTime);
		session.setType(type);
		session.setRoom(null);
		sessionRepository.save(session);
		return session;
	}
	
	@Transactional
	public Session getSession(Integer ID) {
		Session session = sessionRepository.findSessionByID(ID);
		return session;
	}
	
	@Transactional
	public List<Session> getGroupSessionsforADay(String date){
		List<Session> groupSessions = new ArrayList<>();
		for (Session s : sessionRepository.findByDate(date)) {
			if (s.getType() == SessionType.groupSession) {
				groupSessions.add(s);
			}
		}
		return groupSessions;
	}
}
