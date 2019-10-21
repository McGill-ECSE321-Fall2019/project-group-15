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
		Tutor tutor = new Tutor();
		tutor.setTutorID(id);
		tutorRepository.save(tutor);
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
	
	public <Tutor> List<Tutor> removedTutors(Tutor tutor){
		List<Tutor> removedTutorList = new ArrayList<Tutor>();
		removedTutorList.add(tutor);
		
		return removedTutorList;
		
	}	
}
