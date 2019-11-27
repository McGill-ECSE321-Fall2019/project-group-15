package ca.mcgill.ecse321.tutoringapp.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.tutoringapp.Database.src.Person;
import ca.mcgill.ecse321.tutoringapp.Database.src.Session;

import ca.mcgill.ecse321.tutoringapp.Database.src.Tutor;
import ca.mcgill.ecse321.tutoringapp.dao.TutorRepository;

@Service
public class TutorService {
	
	@Autowired
	TutorRepository tutorRepository;
	
	public List<Tutor> removedTutorList = new ArrayList<Tutor>();

	@Transactional
	public Tutor createTutor(float hourlyRate, String password, Person person) {
		Tutor tutor = new Tutor();
		int tutorID = 0;
		while(tutorRepository.findTutorByTutorId(tutorID) != null) {
			tutorID++;
		}
		tutor.setTutorId(tutorID);
		tutor.setHourlyRate(hourlyRate);
		tutor.setIsVerified(false);
		tutor.setPassword(password);
		tutor.setPerson(person);
		tutorRepository.save(tutor);
		return tutor;
	}
	
	
	@Transactional
	public Tutor getTutor(Integer ID) {
		return tutorRepository.findTutorByTutorId(ID);
	}
	
	@Transactional
	public void assignTutorToGroupSession(Tutor tutor, Session session) {
		session.setTutor(tutor);
	}
	
	@Transactional
	public boolean removeTutor(int ID) {
		Tutor tutor = tutorRepository.findTutorByTutorId(ID);

		if(tutor == null) {
			throw new NullPointerException("No such tutor exist");
		}
		removedTutors(tutor);
		tutorRepository.delete(tutor);
		return true;
	}
	
	//Darien
	@Transactional
	public List<Tutor> getAllTutors() {
		return toList(tutorRepository.findAll());
	}
	
	//Darien
	@Transactional
	public List<Tutor> getAllUnverifiedTutors() {
		return tutorRepository.findByIsVerified(false);		
	}
	
	//Darien
	@Transactional
	public void approveTutor(int ID) {
		Tutor tutor = tutorRepository.findTutorByTutorId(ID);
		
		if(tutor == null) {
			throw new NullPointerException("No such tutor exists");
		}
		
		tutor.setIsVerified(true);
		tutorRepository.save(tutor);
	}
		
	public <T> void removedTutors(Tutor tutor){
		removedTutorList.add(tutor);
	
	}
	
	public List<Tutor> getRemovedTutors() {
		return removedTutorList;
	}
	
	//Darien
	private <T> List<T> toList(Iterable<T> iterable){
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}
	
}
