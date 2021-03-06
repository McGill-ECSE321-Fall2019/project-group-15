package ca.mcgill.ecse321.tutoringapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.tutoringapp.Database.src.Course;
import ca.mcgill.ecse321.tutoringapp.Database.src.School;
import ca.mcgill.ecse321.tutoringapp.Database.src.SchoolType;
import ca.mcgill.ecse321.tutoringapp.dao.SchoolRepository;


@Service
public class SchoolService {

	@Autowired
	SchoolRepository schoolRepository;
	
	@Transactional
	public School addSchool(String name, SchoolType schoolType) {
		School school = new School();
		school.setName(name);
		school.setType(schoolType);
		schoolRepository.save(school);
		return school;

	}
	
	public School getSchool(String name) {
		School school = schoolRepository.findSchoolByName(name);
		return school;
	}

	public List<School> getAllSchool() {

		return toList(schoolRepository.findAll());
	}
	
	@Transactional
	 public School getSchoolBySchoolName(String name) {
	        return schoolRepository.findSchoolByName(name);
	 }
	
	@Transactional
	public boolean removeSchool(String name) {
		School school = schoolRepository.findSchoolByName(name);
		
		if(school == null) {
			throw new NullPointerException("No such school.");
		}
		
		schoolRepository.deleteByName(name);
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
