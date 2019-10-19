package ca.mcgill.ecse321.tutoringapp.service;

import org.springframework.beans.factory.annotation.Autowired;

import ca.mcgill.ecse321.tutoringapp.dao.CourseRepository;
import ca.mcgill.ecse321.tutoringapp.dao.EvaluationRepository;
import ca.mcgill.ecse321.tutoringapp.dao.PersonRepository;
import ca.mcgill.ecse321.tutoringapp.dao.RoomRepository;
import ca.mcgill.ecse321.tutoringapp.dao.SchoolRepository;
import ca.mcgill.ecse321.tutoringapp.dao.SessionRepository;
import ca.mcgill.ecse321.tutoringapp.dao.StudentRepository;
import ca.mcgill.ecse321.tutoringapp.dao.SubjectRepository;
import ca.mcgill.ecse321.tutoringapp.dao.TutorRepository;

public class TutoringAppService {
	
	@Autowired
	PersonRepository personRepository;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	TutorRepository tutorRepository; 
	@Autowired
	EvaluationRepository evaluationRepository; 
	@Autowired
	RoomRepository roomRepository; 
	@Autowired
	SessionRepository sessionRepository;
	@Autowired
	CourseRepository courseRepository; 
	@Autowired
	SubjectRepository subjectRepository;
	@Autowired
	SchoolRepository schoolRepository; 

}
