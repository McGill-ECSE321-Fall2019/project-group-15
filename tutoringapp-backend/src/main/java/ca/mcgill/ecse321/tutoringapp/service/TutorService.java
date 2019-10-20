package ca.mcgill.ecse321.tutoringapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.tutoringapp.dao.TutorRepository;

@Service
public class TutorService {
	
	@Autowired
	TutorRepository tutorRepository;
}
