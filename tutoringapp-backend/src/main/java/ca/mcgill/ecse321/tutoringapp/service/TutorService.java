package ca.mcgill.ecse321.tutoringapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.tutoringapp.Database.src.Tutor;
import ca.mcgill.ecse321.tutoringapp.dao.TutorRepository;

@Service
public class TutorService {
	
	@Autowired
	TutorRepository tutorRepository;
	
	@Transactional
	public Tutor addTutor(int id) {
		
		
		return null;
		
	}
	
	@Transactional
	public Tutor getTutor(int ID) {
		Tutor tutor = tutorRepository.findTutorByTutorID(ID);
		return tutor;
	}
	
	@Transactional
	public boolean removeTutor(int ID) {
		Tutor tutor = tutorRepository.findTutorByTutorID(ID);

		if(tutor == null) {
			throw new NullPointerException("No such tutor exist");
		}
		removedTutors(tutor);
		tutorRepository.deleteById(ID);
		return true;
	}
	
	private <T> List<T> removedTutors(Iterable<T> iterable){
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}	
}
