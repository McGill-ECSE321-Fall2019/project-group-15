package ca.mcgill.ecse321.tutoringapp.service;

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
	public Tutor createTutor(int hourlyRate) {
		Tutor tutor = new Tutor();
		tutor.setHourlyRate(hourlyRate);
		tutor.setIsVerified(false);
		tutorRepository.save(tutor);
		return tutor;
	}
	
	@Transactional
	public Tutor getTutor(int id) {
		Tutor tutor = tutorRepository.findTutorByTutorID(id);
		return tutor;
	}
	
	
}
