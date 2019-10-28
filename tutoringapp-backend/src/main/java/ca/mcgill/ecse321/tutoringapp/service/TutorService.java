package ca.mcgill.ecse321.tutoringapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.tutoringapp.Database.src.Tutor;
import ca.mcgill.ecse321.tutoringapp.dao.PersonRepository;
import ca.mcgill.ecse321.tutoringapp.dao.PersonRoleRepository;
import ca.mcgill.ecse321.tutoringapp.dao.TutorRepository;

@Service
public class TutorService {
	
	@Autowired
	TutorRepository tutorRepository;
	
	@Transactional
	public Tutor addTutor(int id) {
		Tutor tutor = new Tutor();
		//tutor.setTutorID(id);
		tutor.setIsVerified(false);
		tutorRepository.save(tutor);
		return null;
	}
	
	
	@Transactional
	public Tutor getTutor(int ID) {
		Tutor tutor = tutorRepository.findTutorByTutorId(ID);
		return tutor;
	}
	
	@Transactional
	public boolean removeTutor(int ID) {
		Tutor tutor = tutorRepository.findTutorByTutorId(ID);

		if(tutor == null) {
			throw new NullPointerException("No such tutor exist");
		}
		removedTutors(tutor);
		tutorRepository.deleteById(ID);
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
		
	public <Tutor> List<Tutor> removedTutors(Tutor tutor){
		List<Tutor> removedTutorList = new ArrayList<Tutor>();
		removedTutorList.add(tutor);
		
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
