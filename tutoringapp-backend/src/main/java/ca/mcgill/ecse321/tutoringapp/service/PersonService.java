package ca.mcgill.ecse321.tutoringapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.tutoringapp.Database.src.Course;
import ca.mcgill.ecse321.tutoringapp.Database.src.Person;
import ca.mcgill.ecse321.tutoringapp.dao.CourseRepository;
import ca.mcgill.ecse321.tutoringapp.dao.PersonRepository;
import ca.mcgill.ecse321.tutoringapp.dao.PersonRoleRepository;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository personRepository;
	@Autowired
	PersonRoleRepository personRoleRepository;
	
	@Transactional
	public Person createPerson(Integer personID, String firstname, String lastname, String username) {
		Person person = new Person();
		person.setPersonID(personID);
		person.setUserName(username);
		person.setFirstName(firstname);
		person.setLastName(lastname);
		personRepository.save(person);
		
		return person;
	}
	
	@Transactional
	public List<Person> getAllPersons(){
		return toList(personRepository.findAll());
	}
	
	@Transactional
	public Person getPersonByPersonID(Integer personID) {
		return personRepository.findPersonByPersonID(personID);
	}
	
	@Transactional
	public Person getPersonByUsername(String username) {
		return personRepository.findPersonByUserName(username);
	}
	
	private <T> List<T> toList(Iterable<T> iterable){
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}

}
