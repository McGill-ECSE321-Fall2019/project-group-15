package ca.mcgill.ecse321.tutoringapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.tutoringapp.Database.src.School;
import ca.mcgill.ecse321.tutoringapp.Database.src.Subject;
import ca.mcgill.ecse321.tutoringapp.dao.SubjectRepository;

@Service
public class SubjectService {
	
	@Autowired
	SubjectRepository subjectRepository;
	
	@Transactional
	public Subject addSubject(String name, School school, String description) {

		Subject subject = new Subject();
		subject.setName(name);
		subject.setSchool(school);
		subject.setDescription(description);
		subjectRepository.save(subject);
		return subject;
	}
	
	@Transactional
	public Subject getSubject(String name) {
		Subject subject = subjectRepository.findSubjectByName(name);
		return subject;
	}
	
	@Transactional
	public List<Subject> getAllSubject() {

		return toList(subjectRepository.findAll());
	}
	
	@Transactional
	public boolean removeSubject(String name) {
		Subject subject = subjectRepository.findSubjectByName(name);
		
		if(subject == null) {
			throw new NullPointerException("No such subject.");
		}
		
		subjectRepository.deleteByName(name);
		return true;
	}
	
	
	private <T> List<T> toList(Iterable<T> iterable){
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}
	
}
